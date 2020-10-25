package com.burningcactus.freezeflame.world;

import net.minecraft.block.PortalInfo;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nullable;
import java.util.function.Function;

public class FFTeleporter implements ITeleporter {
    private final ServerWorld world;

    public FFTeleporter(ServerWorld world) {
        this.world = world;
    }

    /*public boolean findPortalPosition() {

    }

    public boolean placeInExistingPortal() {

    }*/

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        return repositionEntity.apply(true);
    }

    /**
     * Gets the PortalInfo. defaultPortalInfo references the
     * vanilla code and should not be used for your purposes.
     * Override this method to handle your own logic.
     * <p>
     * Return {@code null} to prevent teleporting.
     *
     * @param entity            The entity teleporting before the teleport
     * @param destWorld         The world the entity is teleporting to
     * @param defaultPortalInfo A reference to the vanilla method for getting portal info. You should implement your own logic instead of using this
     * @return The location, rotation, and motion of the entity in the destWorld after the teleport
     */
    @Nullable
    @Override
    public PortalInfo getPortalInfo(Entity entity, ServerWorld destWorld, Function<ServerWorld, PortalInfo> defaultPortalInfo) {
        return new PortalInfo(entity.getPositionVec(), Vector3d.ZERO, entity.rotationYaw, entity.rotationPitch);
    }
}
