package com.burningcactus.freezeflame.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.world.World;

public class FireElementalEntity extends AbstractElementalEntity {
    public FireElementalEntity(EntityType<? extends AbstractElementalEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
