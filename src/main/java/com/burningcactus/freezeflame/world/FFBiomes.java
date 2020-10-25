package com.burningcactus.freezeflame.world;

import com.burningcactus.freezeflame.FreezeFlameMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class FFBiomes {
    public static final RegistryKey<Biome> ICE_FOREST = RegistryKey.func_240903_a_(Registry.BIOME_KEY, new ResourceLocation(FreezeFlameMod.MODID, "ice_forest"));
    public static final RegistryKey<Biome> FIRE_FOREST = RegistryKey.func_240903_a_(Registry.BIOME_KEY, new ResourceLocation(FreezeFlameMod.MODID, "fire_forest"));
}
