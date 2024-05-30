package com.undefinedbhvr.CustomerNPCs.entity;

import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NPC extends LivingEntity implements NPCBaseInterface {
    protected NPC(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    private String name;
    private long npcHealth;
    private long npcMaxHealth;

    public void setNPCName(String name) {
        this.name = name;
    }

    public String getNPCName() {
        return this.name;
    }

    public void setNPCHealth(long health) {
        this.npcHealth = health;
    }

    public long getNPCHealth() {
        return this.npcHealth;
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return null;
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        return null;
    }

    @Override
    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {

    }

    @Override
    public HumanoidArm getMainArm() {
        return null;
    }
}
