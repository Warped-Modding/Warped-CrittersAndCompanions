package com.github.eterdelta.crittersandcompanions.handler;

import com.github.eterdelta.crittersandcompanions.entity.*;
import com.github.eterdelta.crittersandcompanions.registry.CACEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.mixin.object.builder.SpawnRestrictionAccessor;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;

public class SpawnHandler {

    public static void onLivingCheckSpawn() {
        // handled in DrownedMixin
    }

    public static void registerBiomeModifications() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.RIVER), MobCategory.WATER_CREATURE, CACEntities.OTTER.get(), 2, 3, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.RIVER), MobCategory.WATER_CREATURE, CACEntities.KOI_FISH.get(), 4, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.RIVER), MobCategory.AMBIENT, CACEntities.DRAGONFLY.get(), 6, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OCEAN, Biomes.DEEP_OCEAN), MobCategory.WATER_CREATURE, CACEntities.SEA_BUNNY.get(), 32, 1, 2);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.OCEAN, Biomes.DEEP_OCEAN), MobCategory.WATER_CREATURE, CACEntities.DUMBO_OCTOPUS.get(), 4, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), MobCategory.WATER_CREATURE, CACEntities.SEA_BUNNY.get(), 32, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN), MobCategory.WATER_CREATURE, CACEntities.DUMBO_OCTOPUS.get(), 4, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARM_OCEAN), MobCategory.WATER_CREATURE, CACEntities.SEA_BUNNY.get(), 64, 1, 4);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.WARM_OCEAN), MobCategory.WATER_CREATURE, CACEntities.DUMBO_OCTOPUS.get(), 4, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(Biomes.BIRCH_FOREST, Biomes.FOREST), MobCategory.CREATURE, CACEntities.FERRET.get(), 3, 2, 3);

        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.BiomeCategory.FOREST), MobCategory.AMBIENT, CACEntities.LEAF_INSECT.get(), 10, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.BiomeCategory.JUNGLE), MobCategory.AMBIENT, CACEntities.LEAF_INSECT.get(), 8, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.BiomeCategory.JUNGLE), MobCategory.CREATURE, CACEntities.RED_PANDA.get(), 6, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.categories(Biome.BiomeCategory.PLAINS), MobCategory.CREATURE, CACEntities.FERRET.get(), 3, 2, 3);
//
//        if (event.getName() != null) {
//            ResourceKey<Biome> biome = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
//
//            if (biome == Biomes.RIVER) {
//                event.getSpawns().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(CACEntities.OTTER.get(), 2, 3, 5));
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.KOI_FISH.get(), 4, 2, 5));
//                event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.DRAGONFLY.get(), 6, 1, 1));
//            } else if (biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN) {
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.SEA_BUNNY.get(), 32, 1, 2));
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.DUMBO_OCTOPUS.get(), 4, 1, 1));
//            } else if (biome == Biomes.LUKEWARM_OCEAN || biome == Biomes.DEEP_LUKEWARM_OCEAN) {
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.SEA_BUNNY.get(), 32, 1, 3));
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.DUMBO_OCTOPUS.get(), 4, 1, 1));
//            } else if (biome == Biomes.WARM_OCEAN) {
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.SEA_BUNNY.get(), 64, 1, 4));
//                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.DUMBO_OCTOPUS.get(), 6, 1, 1));
//            } else if (biome == Biomes.BIRCH_FOREST || biome == Biomes.FOREST) {
//                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(CACEntities.FERRET.get(), 3, 2, 3));
//            }
//
//            if (event.getCategory() == Biome.BiomeCategory.FOREST) {
//                event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.LEAF_INSECT.get(), 10, 1, 1));
//            } else if (event.getCategory() == Biome.BiomeCategory.JUNGLE) {
//                event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(CACEntities.LEAF_INSECT.get(), 8, 1, 1));
//                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(CACEntities.RED_PANDA.get(), 6, 1, 2));
//            } else if (event.getCategory() == Biome.BiomeCategory.PLAINS) {
//                event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(CACEntities.FERRET.get(), 3, 2, 3));
//            }
//        }
    }

    public static void registerSpawnPlacements() {
        SpawnRestrictionAccessor.callRegister(CACEntities.OTTER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, OtterEntity::checkOtterSpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.KOI_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.DRAGONFLY.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING, DragonflyEntity::checkDragonflySpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.SEA_BUNNY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.OCEAN_FLOOR, SeaBunnyEntity::checkSeaBunnySpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.FERRET.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.DUMBO_OCTOPUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DumboOctopusEntity::checkDumboOctopusSpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.LEAF_INSECT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, LeafInsectEntity::checkLeafInsectSpawnRules);
        SpawnRestrictionAccessor.callRegister(CACEntities.RED_PANDA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
    }
}
