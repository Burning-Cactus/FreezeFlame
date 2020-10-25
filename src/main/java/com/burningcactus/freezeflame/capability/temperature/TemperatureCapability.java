package com.burningcactus.freezeflame.capability.temperature;

import com.burningcactus.freezeflame.capability.FFCapabilities;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TemperatureCapability implements ITemperatureCapability {
    private float temperature = 0;
    private float restingPoint = 0;
    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public void addTemperature(float temperatureIn) {
        temperature += temperatureIn;
    }

    @Override
    public float getRestingPoint() {
        return restingPoint;
    }

    @Override
    public void setRestingPoint(float value) {
        restingPoint = value;
    }

    public static class CapProvider implements ICapabilityProvider {

        private final LazyOptional<ITemperatureCapability> optional = LazyOptional.of(() -> FFCapabilities.TEMPERATURE_CAPABILITY.getDefaultInstance());

        /**
         * Retrieves the Optional handler for the capability requested on the specific side.
         * The return value <strong>CAN</strong> be the same for multiple faces.
         * Modders are encouraged to cache this value, using the listener capabilities of the Optional to
         * be notified if the requested capability get lost.
         *
         * @param cap
         * @param side
         * @return The requested an optional holding the requested capability.
         */
        @Nonnull
        @Override
        public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
            return FFCapabilities.TEMPERATURE_CAPABILITY.orEmpty(cap, optional);
        }
    }
}
