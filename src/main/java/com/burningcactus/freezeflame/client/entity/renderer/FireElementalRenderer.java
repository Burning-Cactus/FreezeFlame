package com.burningcactus.freezeflame.client.entity.renderer;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.client.entity.models.ElementalModel;
import com.burningcactus.freezeflame.entity.monster.FireElementalEntity;
import com.burningcactus.freezeflame.entity.monster.IceElementalEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class FireElementalRenderer extends MobRenderer<FireElementalEntity, ElementalModel<FireElementalEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FreezeFlameMod.MODID, "entity/fire_elemental");

    public FireElementalRenderer(EntityRendererManager renderManagerIn, ElementalModel<FireElementalEntity> entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(FireElementalEntity entity) {
        return TEXTURE;
    }
}
