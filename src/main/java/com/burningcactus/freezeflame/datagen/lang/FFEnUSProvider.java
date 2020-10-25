package com.burningcactus.freezeflame.datagen.lang;

import com.burningcactus.freezeflame.FreezeFlameMod;
import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.entity.FFEntities;
import com.burningcactus.freezeflame.item.FFItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class FFEnUSProvider extends LanguageProvider {
    public FFEnUSProvider(DataGenerator gen) {
        super(gen, FreezeFlameMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //Blocks
        add(FFBlocks.MAGMICE.get(), "Magmice");
        add(FFBlocks.ICE_COBBLESTONE.get(), "Ice Cobblestone");
        add(FFBlocks.ICE_DIRT.get(), "Ice Dirt");
        add(FFBlocks.ICE_GRASS.get(), "Ice Grass");
        add(FFBlocks.ICE_LOG.get(), "Ice Log");
        add(FFBlocks.ICE_PLANKS.get(), "Ice Planks");
        add(FFBlocks.FIRE_COBBLESTONE.get(), "Fire Cobblestone");
        add(FFBlocks.FIRE_DIRT.get(), "Fire Dirt");
        add(FFBlocks.FIRE_GRASS.get(), "Fire Grass");
        add(FFBlocks.FIRE_LOG.get(), "Fire Log");
        add(FFBlocks.FIRE_PLANKS.get(), "Fire Planks");

        //Items
        add(FFItems.FIRE_SNOW.get(), "Fiery Snow");
        add(FFItems.GELUM.get(), "Gelum");
        add(FFEntities.ICE_ELEMENTAL_SPAWN_EGG.get(), "Ice Elemental Spawn Egg");
        add(FFItems.FLAME_CRYSTAL.get(), "Flame Crystal");
        add(FFItems.FROST_CRYSTAL.get(), "Frost Crystal");

        //Entities
        add(FFEntities.FIRE_ELEMENTAL.get(), "Fire Elemental");
        add(FFEntities.ICE_ELEMENTAL.get(), "Ice Elemental");
        add(FFEntities.ESKIMO.get(), "Eskimo");

        //Advancement Titles
        add("advancements.freezeflame.enterportal.title", "First Steps");
        //Advancement Descriptions
        add("advancements.freezeflame.enterportal.description", "What is this place?");

        //Item Group
        add(FreezeFlameMod.ITEM_GROUP.func_242392_c().getString(), "Freeze Flame");
    }
}
