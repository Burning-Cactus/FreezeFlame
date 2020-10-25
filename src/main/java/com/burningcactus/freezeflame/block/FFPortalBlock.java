package com.burningcactus.freezeflame.block;

import com.burningcactus.freezeflame.world.FFDimensions;
import com.burningcactus.freezeflame.world.FFTeleporter;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

/**
 * @see net.minecraft.block.NetherPortalBlock - Vanilla copy
 *
 */
public class FFPortalBlock extends Block {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    protected static final VoxelShape X_AABB = Block.makeCuboidShape(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    protected static final VoxelShape Z_AABB = Block.makeCuboidShape(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public FFPortalBlock() {
        super(Properties.create(Material.PORTAL)
                .doesNotBlockMovement()
                .hardnessAndResistance(-1.0F)
                .sound(SoundType.GLASS)
                .setLightLevel((state) -> {
                    return 11;
                })
        );
        this.setDefaultState(this.stateContainer.getBaseState().with(AXIS, Direction.Axis.X));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(AXIS)) {
            case Z:
                return Z_AABB;
            case X:
            default:
                return X_AABB;
        }
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        switch(rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch(state.get(AXIS)) {
                    case Z:
                        return state.with(AXIS, Direction.Axis.X);
                    case X:
                        return state.with(AXIS, Direction.Axis.Z);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        Direction.Axis direction$axis = facing.getAxis();
        Direction.Axis direction$axis1 = stateIn.get(AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && !facingState.isIn(this) && !(new Size(worldIn, currentPos, direction$axis1)).func_208508_f() ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == 0) {
            worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_PORTAL_AMBIENT, SoundCategory.BLOCKS, 0.5F, rand.nextFloat() * 0.4F + 0.8F, false);
        }

        for(int i = 0; i < 4; ++i) {
            double d0 = (double)pos.getX() + rand.nextDouble();
            double d1 = (double)pos.getY() + rand.nextDouble();
            double d2 = (double)pos.getZ() + rand.nextDouble();
            double d3 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double)rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).isIn(this) && !worldIn.getBlockState(pos.east()).isIn(this)) {
                d0 = (double)pos.getX() + 0.5D + 0.25D * (double)j;
                d3 = (double)(rand.nextFloat() * 2.0F * (float)j);
            } else {
                d2 = (double)pos.getZ() + 0.5D + 0.25D * (double)j;
                d5 = (double)(rand.nextFloat() * 2.0F * (float)j);
            }

            worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }

    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        if (entityIn.isAlive() && !entityIn.world.isRemote) {
            RegistryKey<World> destination = worldIn.func_234923_W_() == FFDimensions.FF_WORLD ? World.field_234918_g_ : FFDimensions.FF_WORLD;
            ServerWorld serverWorld = entityIn.getEntityWorld().getServer().getWorld(destination);
            if(serverWorld != null)
                entityIn.changeDimension(serverWorld, new FFTeleporter(serverWorld));
        }
    }

    /**
     * @see net.minecraft.block.PortalSize
     */
    public static class Size {
        private final IWorld world;
        private final Direction.Axis axis;
        private final Direction rightDir;
        private final Direction leftDir;
        private int portalBlockCount;
        private BlockPos bottomLeft;
        private int height;
        private int width;

        public static Size createPortal(IWorld worldIn, BlockPos pos) {
            Size portalSize = new Size(worldIn, pos, Direction.Axis.X);
            if(portalSize.isValid() && portalSize.portalBlockCount == 0) {
                return portalSize;
            }
            portalSize = new Size(worldIn, pos, Direction.Axis.Z);
            return portalSize;
        }

        //Changes from vanilla: Some methods are removed and typed out in the constructor instead.
        public Size(IWorld worldIn, BlockPos pos, Direction.Axis axisIn) {
            this.world = worldIn;
            this.axis = axisIn;
            this.rightDir = axisIn == Direction.Axis.X ? Direction.WEST : Direction.SOUTH;
            this.leftDir = rightDir.getOpposite();
            this.bottomLeft = getPosition(pos);
            if (this.bottomLeft == null) {
                this.bottomLeft = pos;
                this.width = 1;
                this.height = 1;
            } else {
                int tempWidth = this.getDistanceFromEdge(this.bottomLeft, this.rightDir);
                this.width = tempWidth >= 2 && tempWidth <= 21 ? tempWidth : 0;
                if (this.width > 0) {
                    this.height = this.func_242975_e();
                }
            }
        }

        private int func_242975_e() {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
            int i = this.getPortalHeight(blockpos$mutable);
            return i >= 3 && i <= 21 && this.func_242970_a(blockpos$mutable, i) ? i : 0;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        //Changes from vanilla: Replace IPositionPredicate call with this.world.getBlockState(blockPos).isIn(FFBlocks.MAGMICE.get())
        private int getPortalHeight(BlockPos.Mutable blockPos) {
            for(int i = 0; i < 21; ++i) {
                blockPos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, -1);

                if(!this.world.getBlockState(blockPos).isIn(FFBlocks.MAGMICE.get())) {
                    return i;
                }

                blockPos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, this.width);
                if (!this.world.getBlockState(blockPos).isIn(FFBlocks.MAGMICE.get())) {
                    return i;
                }

                for(int j = 0; j < this.width; ++j) {
                    blockPos.setPos(this.bottomLeft).move(Direction.UP, i).move(this.rightDir, j);
                    BlockState blockstate = this.world.getBlockState(blockPos);
                    if (!isNotConflictingBlock(blockstate)) {
                        return i;
                    }

                    if (blockstate.isIn(FFBlocks.FREEZEFLAME_PORTAL.get())) {
                        ++this.portalBlockCount;
                    }
                }
            }

            return 21;
        }

        private boolean func_242970_a(BlockPos.Mutable blockPos, int p_242970_2_) {
            for(int i = 0; i < this.width; ++i) {
                BlockPos.Mutable blockpos$mutable = blockPos.setPos(this.bottomLeft).move(Direction.UP, p_242970_2_).move(this.rightDir, i);
                if(!this.world.getBlockState(blockPos).isIn(FFBlocks.MAGMICE.get())) {
                    return false;
                }
            }

            return true;
        }

        public boolean isValid() {
            return this.bottomLeft != null && this.width >= 2 && this.width <= 21 && this.height >= 3 && this.height <= 21;
        }

        private BlockPos getPosition(BlockPos blockPos) {
            for(int i = Math.max(0, blockPos.getY() - 21); blockPos.getY() > i && isNotConflictingBlock(this.world.getBlockState(blockPos.down())); blockPos = blockPos.down()) {
            }
            Direction direction = rightDir.getOpposite();
            int j = this.getDistanceFromEdge(blockPos, direction) - 1;
            return j < 0 ? null : blockPos.offset(direction, j);
        }

        //Changes from vanilla: Skip the IPositionPredicate tests and just check the block and posMutable.down() for each loop.
        private int getDistanceFromEdge(BlockPos blockPos, Direction direction) {
            BlockPos.Mutable posMutable = new BlockPos.Mutable();

            for(int i = 0; i <= 21; ++i) {
                posMutable.setPos(blockPos).move(direction, i);
                BlockState blockstate = this.world.getBlockState(posMutable);
                if (!isNotConflictingBlock(blockstate) || !(world.getBlockState(posMutable.down()).getBlock() == FFBlocks.MAGMICE.get())) {
                    return i;
                }
            }
            return 0;
        }

        public void placePortalBlocks() {
            BlockState blockstate = FFBlocks.FREEZEFLAME_PORTAL.get().getDefaultState().with(FFPortalBlock.AXIS, this.axis);
            BlockPos.getAllInBoxMutable(this.bottomLeft, this.bottomLeft.offset(Direction.UP, this.height - 1).offset(this.rightDir, this.width - 1)).forEach((p_242967_2_) -> {
                this.world.setBlockState(p_242967_2_, blockstate, 18);
            });
        }

        private static boolean isNotConflictingBlock(BlockState state) {
            return state.isAir() || state.isIn(BlockTags.FIRE) || state.isIn(FFBlocks.FREEZEFLAME_PORTAL.get());
        }

        public boolean func_208508_f() {
            return this.isValid() && this.portalBlockCount == this.width * this.height;
        }
    }
}
