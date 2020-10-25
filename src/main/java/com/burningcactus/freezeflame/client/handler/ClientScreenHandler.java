package com.burningcactus.freezeflame.client.handler;

import com.burningcactus.freezeflame.FreezeFlameMod;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FreezeFlameMod.MODID, value = Dist.CLIENT)
public class ClientScreenHandler {
    private static final ResourceLocation TEMPERATURE_GAUGE = new ResourceLocation(FreezeFlameMod.MODID, "textures/gui/temperature_gauge");
    private static final ResourceLocation TEMPERATURE= new ResourceLocation(FreezeFlameMod.MODID, "textures");
    /*@SubscribeEvent TODO: Make the temperature meter render
    public static void renderOverlay(RenderGameOverlayEvent.Post event) {
        if(event.getType() == RenderGameOverlayEvent.ElementType.HEALTH) {
            Minecraft mc = Minecraft.getInstance();
            mc.textureManager.bindTexture(TEMPERATURE_GAUGE);
        }
    }*/
}
