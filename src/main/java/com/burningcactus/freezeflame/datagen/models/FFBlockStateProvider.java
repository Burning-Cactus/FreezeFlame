package com.burningcactus.freezeflame.datagen.models;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.block.FFPortalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class FFBlockStateProvider extends BlockStateProvider {
    public FFBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, FreezeFlameMod.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        easySimpleBlock(FFBlocks.MAGMICE);
        easySimpleBlock(FFBlocks.ICE_COBBLESTONE);
        easySimpleBlock(FFBlocks.ICE_DIRT);
        easySimpleBlock(FFBlocks.ICE_PLANKS);
        easySimpleBlock(FFBlocks.FIRE_COBBLESTONE);
        easySimpleBlock(FFBlocks.FIRE_DIRT);
//        easySimpleBlock(FFBlocks.FIRE_PLANKS.get());
        logBlock((RotatedPillarBlock) FFBlocks.ICE_LOG.get());
//        logBlock((RotatedPillarBlock) FFBlocks.FIRE_LOG.get());

        getVariantBuilder(FFBlocks.FREEZEFLAME_PORTAL.get())
                .partialState().with(FFPortalBlock.AXIS, Direction.Axis.X).setModels(
                        new ConfiguredModel(models().getBuilder(FFBlocks.FREEZEFLAME_PORTAL.getId().getPath() + "_ns")
                                .element()
                                .from(0, 0, 6)
                                .to(16, 16, 10)
                                .face(Direction.NORTH)
                                .texture("#portal")
                                .end()
                                .face(Direction.SOUTH)
                                .texture("#portal")
                                .end()
                                .end()
                                .texture("portal", new ResourceLocation("minecraft", "block/nether_portal"))
                                .texture("particle", new ResourceLocation("minecraft", "block/nether_portal"))))
                .partialState().with(FFPortalBlock.AXIS, Direction.Axis.Z).setModels(
                        new ConfiguredModel(models().getBuilder(FFBlocks.FREEZEFLAME_PORTAL.getId().getPath() + "_ew")
                                .element()
                                .from(6, 0, 0)
                                .to(10, 16, 16)
                                .face(Direction.EAST)
                                .texture("#portal")
                                .end()
                                .face(Direction.WEST)
                                .texture("#portal")
                                .end()
                                .end()
                                .texture("portal", new ResourceLocation("minecraft", "block/nether_portal"))
                                .texture("particle", new ResourceLocation("minecraft", "block/nether_portal"))));

        easyBlockItem(FFBlocks.ICE_LOG);
//        easyBlockItem(FFBlocks.FIRE_LOG);
    }

    private void easySimpleBlock(RegistryObject<Block> object) {
        simpleBlock(object.get());
        easyBlockItem(object);
    }

    private void easyBlockItem(RegistryObject<Block> object) {
        simpleBlockItem(object.get(), models().getExistingFile(object.getId()));
    }
}
