package com.burningcactus.freezeflame.entity.monster;

import com.burningcactus.freezeflame.entity.ai.ElementalWanderGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public abstract class AbstractElementalEntity extends FlyingEntity {
    protected AbstractElementalEntity(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(7, new ElementalWanderGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true, false));
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return FlyingEntity.func_233666_p_().func_233815_a_(Attributes.MAX_HEALTH, 40.0D)
                .func_233815_a_(Attributes.MOVEMENT_SPEED, 0.4D);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
