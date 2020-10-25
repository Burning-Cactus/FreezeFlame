package com.burningcactus.freezeflame.handler;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.capability.temperature.ITemperatureCapability;
import com.burningcactus.freezeflame.capability.temperature.TemperatureCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class CapabilityEventHandler {
    public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(ITemperatureCapability.ID,
                    new TemperatureCapability.CapProvider()
            );
        }
    }
}
