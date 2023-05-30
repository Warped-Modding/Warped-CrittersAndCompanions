@file:Suppress("UnstableApiUsage")

plugins {
    java
    idea
    `maven-publish`
    id("fabric-loom") version "1.0-SNAPSHOT"
}

val license: String by project
val minecraftVersion: String by project
val modId: String by project
val modVersion: String by project
val modName: String by project
val modAuthor: String by project
val modDescription: String by project
val fabricVersion: String by project
val fabricLoaderVersion: String by project
val mappingsChannel: String by project
val mappingsVersion: String by project
val githubUser: String by project
val githubRepo: String by project

base.archivesName.set(modId)
version = "$minecraftVersion-$modVersion"

extensions.configure<JavaPluginExtension> {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
}

loom {
    runs {
        onEach {
            it.configName = "Fabric ${it.environment.capitalize()}"
            it.ideConfigGenerated(true)
            it.runDir("run")
            it.vmArgs("-XX:+IgnoreUnrecognizedVMOptions", "-XX:+AllowEnhancedClassRedefinition")
        }
    }

    mixin {
        defaultRefmapName.set("$modId.refmap.json")
    }
}


dependencies {
    /**
     * Core Mod Loader dependencies
     */
    minecraft("com.mojang:minecraft:$minecraftVersion")
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modApi("net.fabricmc.fabric-api:fabric-api:$fabricVersion")
    mappings(loom.layered {
        officialMojangMappings()
        mappings(rootProject.file("gecko.tiny"))
    })

    /**
     * Mod dependencies
     */
    modImplementation("software.bernie.geckolib:geckolib-fabric-1.18:3.0.76") { isTransitive = false }
}

tasks {
    withType<GenerateModuleMetadata> {
        enabled = false
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(17)
    }

    processResources {
        val resourceTargets = listOf("META-INF/mods.toml", "pack.mcmeta", "fabric.mod.json")

        val replaceProperties = mapOf(
            "version" to project.version as String,
            "license" to license,
            "modId" to modId,
            "modName" to modName,
            "minecraftVersion" to minecraftVersion,
            "modAuthor" to modAuthor,
            "modDescription" to modDescription,
            "githubUser" to githubUser,
            "githubRepo" to githubRepo
        )

        inputs.properties(replaceProperties)
        filesMatching(resourceTargets) {
            expand(replaceProperties)
        }
    }
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            artifactId = base.archivesName.get()
            from(components["java"])
        }
    }

    repositories {
        maven("file://${System.getenv("local_maven")}")
    }
}