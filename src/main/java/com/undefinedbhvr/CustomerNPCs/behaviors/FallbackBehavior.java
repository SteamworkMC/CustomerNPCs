package com.undefinedbhvr.CustomerNPCs.behaviors;

import java.util.Map;

/**
 * Represents a sequence of actions, executing each child behavior in order until one returns success.
 *
 * Example:
 * Consider a robot designed to perform a series of tasks within a building.
 * The robot is programmed to execute tasks A, B, and C sequentially.
 * However, if the robot detects a fire, it must escape the building immediately.
 *
 * Behavior Tree:
 * [RootNode]
 *  - [FallbackBehavior]
 *    - [IsRoomSafe]
 *    - [EscapeRoom]
 *  - [SequenceBehavior]
 *    - [DoTaskA]
 *    - [DoTaskB]
 *    - [DoTaskC]
 *
 * Process:
 * The tree initiates with the FallbackBehavior node.
 * If IsRoomSafe returns SUCCESS, it indicates the room is not on fire.
 * The tree then proceeds to the SequenceBehavior node to execute tasks A, B, and C.
 * If IsRoomSafe returns FAILURE, it indicates the room is on fire.
 * The tree then proceeds to the EscapeRoom behavior.
 * his process repeats until the EscapeRoom behavior returns SUCCESS, indicating the robot has escaped the room.
 */

public class FallbackBehavior extends AbstractBehavior {

    @Override
    public AbstractBehavior create(Object... args) {
        return new FallbackBehavior();
    }

    public BehaviorStatus tick(Map<String, Object> blackboard) {
        for (AbstractBehavior child : children) {
            BehaviorStatus status = child.tick(blackboard);
            // We want to return the first SUCCESS or RUNNING we find.
            if (status != BehaviorStatus.FAILURE) {
                return status;
            }
        }

        return BehaviorStatus.SUCCESS;
    }
}
