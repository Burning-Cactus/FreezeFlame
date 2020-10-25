package com.burningcactus.freezeflame.capability;

import com.burningcactus.freezeflame.capability.temperature.ITemperatureCapability;
import com.burningcactus.freezeflame.capability.temperature.TemperatureCapability;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class FFCapabilities {
    @CapabilityInject(ITemperatureCapability.class)
    public static final Capability<ITemperatureCapability> TEMPERATURE_CAPABILITY = null;

    static {
        CapabilityManager.INSTANCE.register(ITemperatureCapability.class, new Capability.IStorage<ITemperatureCapability>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<ITemperatureCapability> capability, ITemperatureCapability instance, Direction side) {
                return null;
            }

            @Override
            public void readNBT(Capability<ITemperatureCapability> capability, ITemperatureCapability instance, Direction side, INBT nbt) {

            }
        }, TemperatureCapability::new);
    }
}
