package com.burningcactus.freezeflame.item;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.block.FFPortalBlock;
import com.burningcactus.freezeflame.world.FFDimensions;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireSnowItem extends Item {
    public FireSnowItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(FreezeFlameMod.ITEM_GROUP)
        );
    }

    /**
     * Called when this item is used when targetting a Block
     *
     * @param context
     */
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        if(player != null) {
            if (world.func_234923_W_() == World.field_234918_g_ || world.func_234923_W_() == FFDimensions.FF_WORLD) {
                if(world.getBlockState(pos).isIn(FFBlocks.MAGMICE.get())) {
                    FFPortalBlock.Size portalSize = FFPortalBlock.Size.createPortal(world, pos);
                    if (portalSize.isValid()) {
                        portalSize.placePortalBlocks();
                        world.playSound(player, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                        return ActionResultType.SUCCESS;
                    }
                }
            }
        }
        return ActionResultType.FAIL;
    }
}
