package com.undefinedbhvr.CustomerNPCs;

import com.undefinedbhvr.CustomerNPCs.behaviors.AbstractBehavior;
import com.undefinedbhvr.CustomerNPCs.behaviors.SequenceBehavior;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.function.Supplier;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CustomerNPCs.MODID)
public class CustomerNPCs
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "customernpcs";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ResourceKey<Registry<Class<? extends AbstractBehavior>>> BEHAVIOR_REGISTRY_KEY = ResourceKey.createRegistryKey(new ResourceLocation(MODID, "behaviors"));

    public static final Registry<Class<? extends AbstractBehavior>> BEHAVIOR_REGISTRY = new RegistryBuilder<>(BEHAVIOR_REGISTRY_KEY)
            .sync(true)
            .maxId(2048)
            .create();

    public static final DeferredRegister<Class<? extends AbstractBehavior>> BEHAVIORS = DeferredRegister.create(BEHAVIOR_REGISTRY, MODID);

    public static final Supplier<Class<? extends AbstractBehavior>> SEQUENCE = BEHAVIORS.register("sequence", () -> SequenceBehavior.class);


    @SubscribeEvent
    static void registerRegistries(NewRegistryEvent event) {
        event.register(BEHAVIOR_REGISTRY);
    }

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CustomerNPCs(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (customernpcs) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
