package com.burningcactus.freezeflame.datagen.tags;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

public class FFItemTags extends ItemTagsProvider {
    public FFItemTags(DataGenerator generatorIn, FFBlockTags providerIn) {
        super(generatorIn, providerIn);
    }

    @Override
    protected void registerTags() {
        this.func_240521_a_(BlockTags.PLANKS, ItemTags.PLANKS);
        this.func_240521_a_(BlockTags.LOGS, ItemTags.LOGS);
    }
}
