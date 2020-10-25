package com.burningcactus.freezeflame.datagen.models;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.item.FFItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class FFItemModelProvider extends ItemModelProvider {
    public FFItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, FreezeFlameMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemModel(FFItems.GELUM.getId().getPath(), FFItems.GELUM.get());
        itemModel(FFItems.FIRE_SNOW.getId().getPath(), FFItems.FIRE_SNOW.get());
    }

    private void itemModel(String name, Item item) {
        singleTexture(name, new ResourceLocation("item/generated"), "layer0", new ResourceLocation(FreezeFlameMod.MODID, "item/" + item.getRegistryName().getPath()));
    }

    /**
     * Gets a name for this provider, to use in logging.
     */
    @Override
    public String getName() {
        return FreezeFlameMod.MODID + " Item Models";
    }
}
