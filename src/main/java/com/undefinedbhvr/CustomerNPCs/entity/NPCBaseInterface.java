package com.undefinedbhvr.CustomerNPCs.entity;

/**
 * An interface that provides functions and data to the future scripting language about the NPC.
 */
public interface NPCBaseInterface {
    void setNPCName(String name);
    String getNPCName();
    // We use longs for health, rather than floats like MC does.
    void setNPCHealth(long health);
    long getNPCHealth();
}
