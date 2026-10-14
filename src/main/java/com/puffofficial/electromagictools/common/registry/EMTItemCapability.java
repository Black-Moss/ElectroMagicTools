package com.puffofficial.electromagictools.common.registry;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.api.capability.ItemEnergyStorage;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = ElectroMagicTools.MODID)
public class EMTItemCapability {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
                Capabilities.EnergyStorage.ITEM,
                (stack, context) -> new ItemEnergyStorage(stack, 1250000),
                EMTItems.PLACEHOLDER_BATTERY.get()
        );
    }
}
