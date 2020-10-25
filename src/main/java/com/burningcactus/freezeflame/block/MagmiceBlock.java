package com.burningcactus.freezeflame.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MagmiceBlock extends Block {
    public MagmiceBlock() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .hardnessAndResistance(0.5F)
                .sound(SoundType.GLASS)
                .setLightLevel((state) -> {
                    return 2;
                })
        );
    }

    /*@Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if(worldIn.func_234923_W_() == World.field_234918_g_ || worldIn.func_234923_W_() == FFDimensions.FF_WORLD) {
            if(player.getHeldItem(handIn).getItem() == Items.LAPIS_LAZULI) {
                FFPortalBlock.Size portalSize = FFPortalBlock.Size.createPortal(worldIn, pos);
                if(portalSize.isValid()) {
                    portalSize.placePortalBlocks();
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.FAIL;
    }*/
}
