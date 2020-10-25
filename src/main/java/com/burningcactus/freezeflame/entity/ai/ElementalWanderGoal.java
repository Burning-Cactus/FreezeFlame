package com.burningcactus.freezeflame.entity.ai;

import com.burningcactus.freezeflame.entity.monster.AbstractElementalEntity;
import net.minecraft.entity.ai.goal.Goal;

public class ElementalWanderGoal extends Goal {
    private final AbstractElementalEntity entity;
    public ElementalWanderGoal(AbstractElementalEntity entityIn) {
        entity = entityIn;
    }
    /**
     * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
     * method as well.
     */
    @Override
    public boolean shouldExecute() {
        return false;
    }
}
