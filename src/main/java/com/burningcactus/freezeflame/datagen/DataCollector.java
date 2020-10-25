package com.burningcactus.freezeflame.datagen;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.datagen.advancements.FFAdvancementProvider;
import com.burningcactus.freezeflame.datagen.lang.FFEnUSProvider;
import com.burningcactus.freezeflame.datagen.loot.FFLootTableProvider;
import com.burningcactus.freezeflame.datagen.models.FFBlockStateProvider;
import com.burningcactus.freezeflame.datagen.models.FFItemModelProvider;
import com.burningcactus.freezeflame.datagen.recipes.FFCraftingRecipeProvider;
import com.burningcactus.freezeflame.datagen.tags.FFBlockTags;
import com.burningcactus.freezeflame.datagen.tags.FFItemTags;
import com.burningcactus.freezeflame.datagen.worldgen.FFBiomeGenerator;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = FreezeFlameMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataCollector {
    @SubscribeEvent
    public static void collectData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new FFAdvancementProvider(generator));
        generator.addProvider(new FFCraftingRecipeProvider(generator));
        generator.addProvider(new FFLootTableProvider(generator));
        generator.addProvider(new FFEnUSProvider(generator));
        generator.addProvider(new FFBlockStateProvider(generator, event.getExistingFileHelper()));
        generator.addProvider(new FFItemModelProvider(generator, event.getExistingFileHelper()));
        FFBlockTags blockTags = new FFBlockTags(generator);
        generator.addProvider(blockTags);
        generator.addProvider(new FFItemTags(generator, blockTags));
        generator.addProvider(new FFBiomeGenerator(generator));
    }
}
