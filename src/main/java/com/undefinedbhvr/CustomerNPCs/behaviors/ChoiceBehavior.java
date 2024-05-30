package com.undefinedbhvr.CustomerNPCs.behaviors;

import java.util.Map;

/**
 * Represents a choice of actions, executing a single child behavior at random.
 */
public class ChoiceBehavior extends AbstractBehavior {
    @Override
    public AbstractBehavior create(String... args) {
        return new ChoiceBehavior();
    }

    public BehaviorStatus tick(Map<String, Object> blackboard) {
        // Tick our children until we get a success or failure, repeating the same child if it's running.

        return BehaviorStatus.SUCCESS;
    }
}
