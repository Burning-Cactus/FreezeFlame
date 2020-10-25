package com.burningcactus.freezeflame.datagen.recipes;

import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.item.FFItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class FFCraftingRecipeProvider extends RecipeProvider {
    public FFCraftingRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(FFBlocks.MAGMICE.get(), 1).addIngredient(Blocks.MAGMA_BLOCK).addIngredient(Blocks.SNOW_BLOCK).addCriterion("has_magma", hasItem(Blocks.MAGMA_BLOCK)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(FFItems.FIRE_SNOW.get()).addIngredient(Items.FIRE_CHARGE).addIngredient(Items.SNOWBALL).addCriterion("has_fire_charge", hasItem(Items.FIRE_CHARGE)).build(consumer);
//        ShapelessRecipeBuilder.shapelessRecipe(FFBlocks.MAGMICE.get(), 1).addIngredient(Blocks.MAGMA_BLOCK).addIngredient(Items.SNOWBALL, 4).addCriterion("has_magma", hasItem(Blocks.MAGMA_BLOCK)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(FFBlocks.ICE_PLANKS.get(), 4).addIngredient(FFBlocks.ICE_LOG.get()).addCriterion("has_logs", hasItem(FFBlocks.ICE_LOG.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(FFBlocks.FIRE_PLANKS.get(), 4).addIngredient(FFBlocks.FIRE_LOG.get()).addCriterion("has_logs", hasItem(FFBlocks.FIRE_LOG.get())).build(consumer);
    }
}
