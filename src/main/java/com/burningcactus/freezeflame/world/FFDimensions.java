package com.burningcactus.freezeflame.world;

import com.burningcactus.freezeflame.FreezeFlameMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;

public class FFDimensions {
    public static final RegistryKey<DimensionType> FF_DIMENSION_TYPE = RegistryKey.func_240903_a_(Registry.DIMENSION_TYPE_KEY, new ResourceLocation(FreezeFlameMod.MODID, "freezeflame"));
    public static final RegistryKey<World> FF_WORLD = RegistryKey.func_240903_a_(Registry.WORLD_KEY, new ResourceLocation(FreezeFlameMod.MODID, "freezeflame"));

    /*public static final DeferredRegister<ModDimension> DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, FreezeFlameMod.MODID);

    public static final RegistryObject<ModDimension> FREEZEFLAME = DIMENSIONS.register("freezeflame", () -> new ModDimension() {
        @Override
        public BiFunction<World, DimensionType, ? extends Dimension> getFactory() {
            return FreezeFlameDimension::new;
        }
    });

    public static DimensionType getDimension() {
        return DimensionType.byName(FF_ID);
    }

    private static final ResourceLocation FF_ID = new ResourceLocation(FreezeFlameMod.MODID, "freezeflame");

    @Mod.EventBusSubscriber(modid = FreezeFlameMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class DimensionHandler {
        @SubscribeEvent
        public static void registerDimensions(RegisterDimensionsEvent event) {
            if(DimensionType.byName(FF_ID)==null) {
                DimensionManager.registerDimension(FF_ID, FREEZEFLAME.get(), null, false);
            }
        }
    }*/
}
