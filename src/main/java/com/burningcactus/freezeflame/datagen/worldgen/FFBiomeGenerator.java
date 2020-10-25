package com.burningcactus.freezeflame.datagen.worldgen;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.world.FFBiomes;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.data.BiomeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class FFBiomeGenerator extends BiomeProvider {
    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    private final DataGenerator generator;

    private final Map<RegistryKey<Biome>, Biome> biomes;

    public FFBiomeGenerator(DataGenerator generator) {
        super(generator);
        this.generator = generator;
        biomes = fillBiomes();
    }

    private Map<RegistryKey<Biome>, Biome> fillBiomes() {
        ImmutableMap.Builder<RegistryKey<Biome>, Biome> builder = ImmutableMap.builder();
        builder.put(FFBiomes.ICE_FOREST,
                new Biome.Builder()
                .precipitation(Biome.RainType.SNOW)
                .category(Biome.Category.NONE)
                .depth(5)
                .scale(1)
                .temperature(0.2F)
                .func_242456_a(Biome.TemperatureModifier.NONE)
                .downfall(0.5F)
                .func_235097_a_(ambience(10263807, 255, 329011, 16724735))
                .func_242457_a(generationSettings())
                .func_242458_a(MobSpawnInfo.field_242551_b)
                .func_242455_a()
        );
        builder.put(FFBiomes.FIRE_FOREST,
                new Biome.Builder()
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.NONE)
                        .depth(5)
                        .scale(1)
                        .temperature(0.8F)
                        .func_242456_a(Biome.TemperatureModifier.NONE)
                        .downfall(0.5F)
                        .func_235097_a_(ambience(10263807, 255, 329011, 16724735))
                        .func_242457_a(generationSettings())
                        .func_242458_a(MobSpawnInfo.field_242551_b)
                        .func_242455_a()
        );
        return builder.build();
    }

    private BiomeGenerationSettings generationSettings() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder()
                .func_242517_a(ConfiguredSurfaceBuilders.field_244178_j);
        return builder.func_242508_a();
    }

    private BiomeAmbience ambience(int fogColor, int waterColor, int waterFogColor, int skyColor) {
        return new BiomeAmbience.Builder()
                .func_235239_a_(fogColor)
                .func_235246_b_(waterColor)
                .func_235248_c_(waterColor)
                .func_242539_d(skyColor)
                .func_235238_a_();
    }


    /**
     * Copied from vanilla, modified to use the biomes list from this class and save to the directory data/worldgen/biome.
     */
    @Override
    public void act(DirectoryCache cache) {
        Path path = this.generator.getOutputFolder();

        for(Map.Entry<RegistryKey<Biome>, Biome> entry : biomes.entrySet()) {
            Path path1 = path.resolve("data/worldgen/biome/" + entry.getKey().func_240901_a_().getPath() + ".json");
            Biome biome = entry.getValue();
            Function<Supplier<Biome>, DataResult<JsonElement>> function = JsonOps.INSTANCE.withEncoder(Biome.field_235051_b_);
            try {
                Optional<JsonElement> optional = function.apply(() -> {
                    return biome;
                }).result();
                if (optional.isPresent()) {
                    IDataProvider.save(GSON, cache, optional.get(), path1);
                } else {
                    FreezeFlameMod.LOGGER.error("Couldn't serialize biome {}", (Object)path1);
                }
            } catch (IOException ioexception) {
                FreezeFlameMod.LOGGER.error("Couldn't save biome {}", path1, ioexception);
            }
        }
    }

}
