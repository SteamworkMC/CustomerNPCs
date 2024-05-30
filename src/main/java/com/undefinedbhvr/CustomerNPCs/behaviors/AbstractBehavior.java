package com.undefinedbhvr.CustomerNPCs.behaviors;

import com.undefinedbhvr.CustomerNPCs.util.Result;

import java.util.ArrayList;
import java.util.Map;

/**
 * A generic abstract class for all behavior tree nodes.
 *
 * This class provides the basic structure for all behavior tree nodes.
 * Each node can have multiple children, and each node must implement the tick method.
 * The tick method is called every entity tick for the entity making use of it.
 *
 * We provide a "create" method in order to create the behavior after its added to the registry.
 * However, all the data passed into create is in the form of strings in an array. This is because
 * the system gets its creation data from a minecraft gui and I do not want to have to serialize.
 */

public abstract class AbstractBehavior {
    public abstract AbstractBehavior create(String... args);
    final ArrayList<AbstractBehavior> children = new ArrayList<>();
    // Ticks only care about the blackboard
    public BehaviorStatus tick(Map<String, Object> blackboard ) {
        return BehaviorStatus.SUCCESS;
    }
    // This should return self at the end, so you can chain .addChild().addChild().addChild() etc...
    public AbstractBehavior addChild(AbstractBehavior child) {
        children.add(child);
        return this;
    };
    // Remove child by position in the arraylist. Returns self, so you can chain .removeChild().removeChild() etc...
    public AbstractBehavior removeChild(int index) {
        children.remove(index);
        return this;
    };

    public AbstractBehavior getChild(int index) {
        return children.get(index);
    };

    public int getChildCount() {
        return children.size();
    };

    public ArrayList<AbstractBehavior> getChildren() {
        return children;
    };
}
