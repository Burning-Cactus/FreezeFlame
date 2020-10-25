package com.burningcactus.freezeflame.entity;

import com.burningcactus.freezeflame.entity.FFEntities;
import com.burningcactus.freezeflame.entity.monster.AbstractElementalEntity;
import com.burningcactus.freezeflame.entity.monster.EskimoEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;

public class FFEntityAttributes {
    public static void registerAttributes() {
        GlobalEntityTypeAttributes.put(FFEntities.FIRE_ELEMENTAL.get(), AbstractElementalEntity.registerAttributes().func_233813_a_());
        GlobalEntityTypeAttributes.put(FFEntities.ICE_ELEMENTAL.get(), AbstractElementalEntity.registerAttributes().func_233813_a_());
        GlobalEntityTypeAttributes.put(FFEntities.ESKIMO.get(), EskimoEntity.registerAttributes().func_233813_a_());
    }
}
