package com.undefinedbhvr.CustomerNPCs.behaviors;

import java.util.Map;

/**
 * Represents a sequence of actions, executing each child behavior in order.
 * Continues execution until a child behavior returns FAILURE or RUNNING.
 *
 * Example:
 * Consider a robot designed to perform a series of tasks within a building.
 * The robot is programmed to execute tasks A, B, and C sequentially.
 *
 * Behavior Tree:
 * [RootNode]
 *  - [SequenceBehavior]
 *    - [DoTaskA]
 *    - [DoTaskB]
 *    - [DoTaskC]
 *
 * Process:
 * The tree initiates with DoTaskA. If DoTaskA is in progress, it returns RUNNING,
 * causing the SequenceBehavior node to also return a RUNNING status.
 * Upon the next tick, the tree resumes with DoTaskA. This process repeats until
 * DoTaskA returns SUCCESS, at which point the tree proceeds to DoTaskB, and
 * subsequently to DoTaskC.
 */


public class SequenceBehavior extends AbstractBehavior {

    @Override
    public AbstractBehavior create(Object... args) {
        return new SequenceBehavior();
    }

    public BehaviorStatus tick(Map<String, Object> blackboard) {
        // Tick our children until we don't get a success, returning the first different status.
        for (AbstractBehavior child : children) {
            BehaviorStatus status = child.tick(blackboard);
            // If the child is running or failed, return that status.
            if (status != BehaviorStatus.SUCCESS) {
                return status;
            }
        }
        return BehaviorStatus.SUCCESS;
    }
}
