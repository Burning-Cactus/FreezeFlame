package com.burningcactus.freezeflame.block;

import com.burningcactus.freezeflame.FreezeFlameMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FreezeFlameMod.MODID);

    public static final RegistryObject<Block> MAGMICE = BLOCKS.register("magmice", MagmiceBlock::new);
    public static final RegistryObject<Block> FREEZEFLAME_PORTAL = BLOCKS.register("freezeflame_portal", FFPortalBlock::new);

    public static final RegistryObject<Block> ICE_COBBLESTONE = BLOCKS.register("ice_cobblestone", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> FIRE_COBBLESTONE = BLOCKS.register("fire_cobblestone", () -> new Block(Block.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).hardnessAndResistance(2.0F, 6.0F)));
    public static final RegistryObject<Block> ICE_DIRT = BLOCKS.register("ice_dirt", () -> new Block(Block.Properties.create(Material.EARTH).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> FIRE_DIRT = BLOCKS.register("fire_dirt", () -> new Block(Block.Properties.create(Material.EARTH).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> ICE_GRASS = BLOCKS.register("ice_grass", () -> new Block(Block.Properties.create(Material.ORGANIC).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> FIRE_GRASS = BLOCKS.register("fire_grass", () -> new Block(Block.Properties.create(Material.ORGANIC).harvestTool(ToolType.SHOVEL)));
    public static final RegistryObject<Block> ICE_LOG = BLOCKS.register("ice_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FIRE_LOG = BLOCKS.register("fire_log", () -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ICE_PLANKS = BLOCKS.register("ice_planks", () -> new Block(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> FIRE_PLANKS = BLOCKS.register("fire_planks", () -> new Block(Block.Properties.create(Material.WOOD).harvestTool(ToolType.AXE)));

}
