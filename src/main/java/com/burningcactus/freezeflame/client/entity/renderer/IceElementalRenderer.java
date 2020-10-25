package com.burningcactus.freezeflame.client.entity.renderer;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.client.entity.models.ElementalModel;
import com.burningcactus.freezeflame.entity.monster.IceElementalEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class IceElementalRenderer extends MobRenderer<IceElementalEntity, ElementalModel<IceElementalEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(FreezeFlameMod.MODID, "entity/ice_elemental");
    public IceElementalRenderer(EntityRendererManager renderManagerIn, ElementalModel<IceElementalEntity> entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(IceElementalEntity entity) {
        return TEXTURE;
    }
}
