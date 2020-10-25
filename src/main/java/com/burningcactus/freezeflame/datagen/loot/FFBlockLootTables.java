package com.burningcactus.freezeflame.datagen.loot;

import com.burningcactus.freezeflame.block.FFBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

public class FFBlockLootTables extends BlockLootTables {
    private final Set<Block> blocks = new HashSet<>();

    @Override
    protected void registerLootTable(Block blockIn, LootTable.Builder table) {
        super.registerLootTable(blockIn, table);
        this.blocks.add(blockIn);
    }

    @Override
    protected void addTables() {
        registerDropSelfLootTable(FFBlocks.MAGMICE.get());
        registerDropSelfLootTable(FFBlocks.ICE_COBBLESTONE.get());
        registerDropSelfLootTable(FFBlocks.ICE_DIRT.get());
        registerDropSelfLootTable(FFBlocks.ICE_GRASS.get());
        registerDropSelfLootTable(FFBlocks.ICE_LOG.get());
        registerDropSelfLootTable(FFBlocks.ICE_PLANKS.get());
        registerDropSelfLootTable(FFBlocks.FIRE_COBBLESTONE.get());
        registerDropSelfLootTable(FFBlocks.FIRE_DIRT.get());
        registerDropSelfLootTable(FFBlocks.FIRE_GRASS.get());
        registerDropSelfLootTable(FFBlocks.FIRE_LOG.get());
        registerDropSelfLootTable(FFBlocks.FIRE_PLANKS.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return blocks;
    }
}
