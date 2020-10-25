package com.burningcactus.freezeflame.capability.temperature;

import com.burningcactus.freezeflame.FreezeFlameMod;
import net.minecraft.util.ResourceLocation;

public interface ITemperatureCapability {
    ResourceLocation ID = new ResourceLocation(FreezeFlameMod.MODID, "temperature");
    /**
     * Returns the current temperature stored in the capability.
     * @return - temperature
     */
    float getTemperature();

    /**
     * Changes the temperature by the specified amount.
     * @param temperatureIn - A positive value will make the entity warmer,
     *                      a negative value will make it colder.
     */
    void addTemperature(float temperatureIn);

    float getRestingPoint();
    void setRestingPoint(float value);
}
