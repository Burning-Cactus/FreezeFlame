package com.burningcactus.freezeflame.datagen.advancements;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.AdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Pretty much a direct copy of the vanilla AdvancementProvider. I don't know why everything is private in that class.
 */
public class FFAdvancementProvider extends AdvancementProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final List<Consumer<Consumer<Advancement>>> advancements = ImmutableList.of(new FFAdvancements());
    private final DataGenerator generator;
    public FFAdvancementProvider(DataGenerator generatorIn) {
        super(generatorIn);
        generator = generatorIn;
    }

    /**
     * Performs this provider's action.
     *
     * @param cache
     */
    @Override
    public void act(DirectoryCache cache) throws IOException {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (p_204017_3_) -> {
            if (!set.add(p_204017_3_.getId())) {
                throw new IllegalStateException("Duplicate advancement " + p_204017_3_.getId());
            } else {
                Path path1 = getPath(path, p_204017_3_);

                try {
                    IDataProvider.save(GSON, cache, p_204017_3_.copy().serialize(), path1);
                } catch (IOException ioexception) {
                    FreezeFlameMod.LOGGER.error("Couldn't save advancement {}", path1, ioexception);
                }

            }
        };
        for(Consumer<Consumer<Advancement>> consumer1 : this.advancements) {
            consumer1.accept(consumer);
        }
    }

    private static Path getPath(Path pathIn, Advancement advancementIn) {
        return pathIn.resolve("data/freezeflame/advancements/" + advancementIn.getId().getPath() + ".json");
    }
}
