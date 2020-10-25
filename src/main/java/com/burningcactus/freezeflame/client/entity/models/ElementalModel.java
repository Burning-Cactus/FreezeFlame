package com.burningcactus.freezeflame.client.entity.models;

import com.burningcactus.freezeflame.entity.monster.AbstractElementalEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ElementalModel<T extends AbstractElementalEntity> extends EntityModel<T> {
    private final ModelRenderer core;

    public ElementalModel() {
        textureWidth = 16;
        textureHeight = 16;

        core = new ModelRenderer(this);
        core.setRotationPoint(0.6667F, 17.5F, 0.3333F);
        core.setTextureOffset(0, 0).addBox(1.3333F, -2.5F, -4.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 0).addBox(-3.6667F, -0.5F, 3.6667F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 0).addBox(-0.6667F, -6.5F, -0.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 0).addBox(-4.6667F, -0.5F, -5.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 0).addBox(3.3333F, 0.5F, 1.6667F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        core.setTextureOffset(0, 0).addBox(-1.6667F, 3.5F, -1.3333F, 2.0F, 2.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        core.rotateAngleX = ageInTicks * ((float)Math.PI/180F);
        core.rotateAngleY = ageInTicks * ((float)Math.PI/180F);
        core.rotateAngleZ = ageInTicks * ((float)Math.PI/180F);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        core.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
