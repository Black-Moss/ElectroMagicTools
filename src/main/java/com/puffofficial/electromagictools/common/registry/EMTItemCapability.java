package com.puffofficial.electromagictools.common.registry;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.api.capability.ItemEnergyStorage;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = ElectroMagicTools.MODID)
public class EMTItemCapability {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        registerEnergyStorageItem(event, 100000, EMTItems.PLACEHOLDER_BATTERY.get());
        registerEnergyStorageItem(event, 50000, EMTItems.ELECTRIC_DRILL.get());
        registerEnergyStorageItem(event, 50000, EMTItems.ELECTRIC_SAW.get());

        registerEnergyStorageItem(event, 100000, EMTItems.ELEMENTAL_DRILL.get());
        registerEnergyStorageItem(event, 100000, EMTItems.ELEMENTAL_SAW.get());
    }


    private static void registerEnergyStorageItem (RegisterCapabilitiesEvent event, int capacity, Item... item) {
        event.registerItem(
                Capabilities.EnergyStorage.ITEM,
                (stack, context) -> new ItemEnergyStorage(stack, capacity),
                item
        );
    }
}
