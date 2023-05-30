package com.github.eterdelta.crittersandcompanions.registry;

import com.github.eterdelta.crittersandcompanions.CrittersAndCompanions;
import com.github.eterdelta.crittersandcompanions.item.PearlNecklaceItem;
import com.github.eterdelta.crittersandcompanions.platform.DeferredRegister;
import com.github.eterdelta.crittersandcompanions.platform.RegistryObject;
import net.minecraft.core.Registry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.material.Fluids;

public class CACItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM, CrittersAndCompanions.MODID);

    public static final RegistryObject<Item> CLAM = ITEMS.register("clam", () -> new Item(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> KOI_FISH = ITEMS.register("koi_fish", () -> new Item(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB).food(Foods.TROPICAL_FISH)));
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new Item(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB)));

    public static final RegistryObject<Item> PEARL_NECKLACE_1 = ITEMS.register("pearl_necklace_1", () -> new PearlNecklaceItem(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB).stacksTo(1), 1));
    public static final RegistryObject<Item> PEARL_NECKLACE_2 = ITEMS.register("pearl_necklace_2", () -> new PearlNecklaceItem(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB).stacksTo(1), 2));
    public static final RegistryObject<Item> PEARL_NECKLACE_3 = ITEMS.register("pearl_necklace_3", () -> new PearlNecklaceItem(new Item.Properties().tab(CrittersAndCompanions.CREATIVE_TAB).stacksTo(1), 3));

    public static final RegistryObject<Item> DUMBO_OCTOPUS_BUCKET = ITEMS.register("dumbo_octopus_bucket", () -> new MobBucketItem(CACEntities.DUMBO_OCTOPUS.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> KOI_FISH_BUCKET = ITEMS.register("koi_fish_bucket", () -> new MobBucketItem(CACEntities.KOI_FISH.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> SEA_BUNNY_BUCKET = ITEMS.register("sea_bunny_bucket", () -> new MobBucketItem(CACEntities.SEA_BUNNY.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).stacksTo(1).tab(CrittersAndCompanions.CREATIVE_TAB)));

    // TODO spawn eggs
    public static final RegistryObject<Item> DRAGONFLY_SPAWN_EGG = ITEMS.register("dragonfly_spawn_egg", () -> new SpawnEggItem(CACEntities.DRAGONFLY.get(), 0x08EECF, 0xD3FF96, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> FERRET_SPAWN_EGG = ITEMS.register("ferret_spawn_egg", () -> new SpawnEggItem(CACEntities.FERRET.get(), 0xC5AC88, 0x37212D, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> DUMBO_OCTOPUS_SPAWN_EGG = ITEMS.register("dumbo_octopus_spawn_egg", () -> new SpawnEggItem(CACEntities.DUMBO_OCTOPUS.get(), 0xFCDC4C, 0x162630, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> KOI_FISH_SPAWN_EGG = ITEMS.register("koi_fish_spawn_egg", () -> new SpawnEggItem(CACEntities.KOI_FISH.get(), 0xF3ECED, 0xFB5321, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> LEAF_INSECT_SPAWN_EGG = ITEMS.register("leaf_insect_spawn_egg", () -> new SpawnEggItem(CACEntities.LEAF_INSECT.get(), 0xDAD475, 0x3C6C34, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> OTTER_SPAWN_EGG = ITEMS.register("otter_spawn_egg", () -> new SpawnEggItem(CACEntities.OTTER.get(), 0x352C34, 0xB49494, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> RED_PANDA_SPAWN_EGG = ITEMS.register("red_panda_spawn_egg", () -> new SpawnEggItem(CACEntities.RED_PANDA.get(), 0xF4943C, 0x13131B, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
    public static final RegistryObject<Item> SEA_BUNNY_SPAWN_EGG = ITEMS.register("sea_bunny_spawn_egg", () -> new SpawnEggItem(CACEntities.SEA_BUNNY.get(), 0xF4ECE4, 0x453337, (new Item.Properties()).tab(CrittersAndCompanions.CREATIVE_TAB)));
}