package com.burningcactus.freezeflame.datagen.advancements;

import com.burningcactus.freezeflame.block.FFBlocks;
import com.burningcactus.freezeflame.world.FFDimensions;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.ChangeDimensionTrigger;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.function.Consumer;

public class FFAdvancements implements Consumer<Consumer<Advancement>> {
    /**
     * Performs this operation on the given argument.
     *
     * @param consumer the input argument
     */
    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement firstSteps = Advancement.Builder.builder().withDisplay(FFBlocks.MAGMICE.get(), new TranslationTextComponent("advancements.freezeflame.enterportal.title"), new TranslationTextComponent("advancements.freezeflame.enterportal.description"), null, FrameType.TASK, true, true, false).withCriterion("entered_freezeflame", ChangeDimensionTrigger.Instance.func_233552_a_(FFDimensions.FF_WORLD)).register(consumer, "freezeflame/first_steps");
    }
}
