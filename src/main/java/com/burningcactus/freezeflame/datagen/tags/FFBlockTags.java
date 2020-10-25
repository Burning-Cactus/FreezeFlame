package com.burningcactus.freezeflame.datagen.tags;

import com.burningcactus.freezeflame.block.FFBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;

public class FFBlockTags extends BlockTagsProvider {
    public FFBlockTags(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        this.func_240522_a_(BlockTags.PLANKS).func_240534_a_(FFBlocks.ICE_PLANKS.get(), FFBlocks.FIRE_PLANKS.get());
        this.func_240522_a_(BlockTags.LOGS).func_240534_a_(FFBlocks.ICE_LOG.get(), FFBlocks.FIRE_LOG.get());
    }
}
