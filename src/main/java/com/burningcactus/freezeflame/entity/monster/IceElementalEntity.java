package com.burningcactus.freezeflame.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class IceElementalEntity extends AbstractElementalEntity {
    public IceElementalEntity(EntityType<? extends AbstractElementalEntity> type, World worldIn) {
        super(type, worldIn);
    }

}
