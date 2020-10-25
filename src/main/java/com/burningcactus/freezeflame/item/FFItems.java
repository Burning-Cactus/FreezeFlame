package com.burningcactus.freezeflame.item;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.block.FFBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FFItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FreezeFlameMod.MODID);
    //Blocks
    public static final RegistryObject<Item> MAGMICE = ITEMS.register("magmice", () -> new BlockItem(FFBlocks.MAGMICE.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> ICE_STONE = ITEMS.register("ice_cobblestone", () -> new BlockItem(FFBlocks.ICE_COBBLESTONE.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FIRE_STONE = ITEMS.register("fire_cobblestone", () -> new BlockItem(FFBlocks.FIRE_COBBLESTONE.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> ICE_DIRT = ITEMS.register("ice_dirt", () -> new BlockItem(FFBlocks.ICE_DIRT.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FIRE_DIRT = ITEMS.register("fire_dirt", () -> new BlockItem(FFBlocks.FIRE_DIRT.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> ICE_GRASS = ITEMS.register("ice_grass", () -> new BlockItem(FFBlocks.ICE_GRASS.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FIRE_GRASS = ITEMS.register("fire_grass", () -> new BlockItem(FFBlocks.FIRE_GRASS.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> ICE_LOG = ITEMS.register("ice_log", () -> new BlockItem(FFBlocks.ICE_LOG.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FIRE_LOG = ITEMS.register("fire_log", () -> new BlockItem(FFBlocks.FIRE_LOG.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> ICE_PLANKS = ITEMS.register("ice_planks", () -> new BlockItem(FFBlocks.ICE_PLANKS.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FIRE_PLANKS = ITEMS.register("fire_planks", () -> new BlockItem(FFBlocks.FIRE_PLANKS.get(), new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    //Items
    public static final RegistryObject<Item> FIRE_SNOW = ITEMS.register("fire_snow", FireSnowItem::new);
    public static final RegistryObject<Item> GELUM = ITEMS.register("gelum", () -> new Item(new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FROST_CRYSTAL = ITEMS.register("ice_crystal", () -> new Item(new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
    public static final RegistryObject<Item> FLAME_CRYSTAL = ITEMS.register("flame_crystal", () -> new Item(new Item.Properties().group(FreezeFlameMod.ITEM_GROUP)));
}
