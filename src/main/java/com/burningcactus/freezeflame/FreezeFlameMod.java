package com.burningcactus.freezeflame;

import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.entity.FFEntities;
import com.burningcactus.freezeflame.entity.FFEntityAttributes;
import com.burningcactus.freezeflame.handler.CapabilityEventHandler;
import com.burningcactus.freezeflame.item.FFItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(FreezeFlameMod.MODID)
public class FreezeFlameMod {
    public static final String MODID = "freezeflame";
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final ItemGroup ITEM_GROUP = new ItemGroup("ffitemgroup") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(FFBlocks.ICE_COBBLESTONE.get());
        }
    };

    public FreezeFlameMod() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        FFBlocks.BLOCKS.register(modBus);
        FFItems.ITEMS.register(modBus);
        FFEntities.ENTITIES.register(modBus);
        FFEntities.SPAWN_EGGS.register(modBus);
//        FFBiomes.BIOMES.register(modBus);
//        FFDimensions.DIMENSIONS.register(modBus);
//        FFChunkGeneratorTypes.CHUNK_GENERATORS.register(modBus);
//        FFBiomeProviderTypes.BIOME_PROVIDERS.register(modBus);

        modBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, CapabilityEventHandler::attachCapabilities);
    }

    private void setup(FMLCommonSetupEvent event) {
        FFEntityAttributes.registerAttributes();
    }
}
