package com.burningcactus.freezeflame.client;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.client.entity.models.ElementalModel;
import com.burningcactus.freezeflame.client.entity.renderer.FireElementalRenderer;
import com.burningcactus.freezeflame.client.entity.renderer.IceElementalRenderer;
import com.burningcactus.freezeflame.entity.FFEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FreezeFlameMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FFClientRegistry {
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(FFEntities.ICE_ELEMENTAL.get(), m -> new IceElementalRenderer(m, new ElementalModel<>(), 0.0F));
        RenderingRegistry.registerEntityRenderingHandler(FFEntities.FIRE_ELEMENTAL.get(), m -> new FireElementalRenderer(m, new ElementalModel<>(), 0.0F));
    }
}
