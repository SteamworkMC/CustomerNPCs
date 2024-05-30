package com.undefinedbhvr.CustomerNPCs.behaviors;

import com.undefinedbhvr.CustomerNPCs.CustomerNPCs;
import com.undefinedbhvr.CustomerNPCs.util.Result;
import net.minecraft.resources.ResourceLocation;

import java.lang.reflect.InvocationTargetException;

/**
 * Behaviors are unused for now. V1 will operate on mob goals with a simple editor.
 */
public class BehaviorManager {
    public static AbstractBehavior createFromRegistry(ResourceLocation location, String... args) {
        Class<? extends AbstractBehavior> behaviorClass = CustomerNPCs.BEHAVIORS.getRegistry()
                .get()
                .getOptional(location)
                .orElseThrow(() -> new RuntimeException("Behavior not found in registry"))
        ;
        try {
            AbstractBehavior behavior = behaviorClass.getDeclaredConstructor().newInstance();
            return behavior.create(args);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException behaviorException) {
            throw new RuntimeException("Failed to create behavior from registry", behaviorException);
        }
    }
}
