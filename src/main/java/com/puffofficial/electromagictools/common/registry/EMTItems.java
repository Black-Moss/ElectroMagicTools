package com.puffofficial.electromagictools.common.registry;

import com.puffofficial.electromagictools.api.EMTTiers;
import com.puffofficial.electromagictools.api.item.tool.electric.ElectricSawItem;
import com.puffofficial.electromagictools.api.item.tool.electric.ElectricDrillItem;
import com.puffofficial.electromagictools.api.item.EnergyStorageItem;
import com.puffofficial.electromagictools.api.item.tool.elemental.ElementalElectricSawItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.puffofficial.electromagictools.ElectroMagicTools.ITEMS;

public class EMTItems {
    public static final DeferredItem<Item> PLACEHOLDER_ITEM = ITEMS.registerSimpleItem("placeholder_item");

    public static final DeferredItem<EnergyStorageItem> PLACEHOLDER_BATTERY = ITEMS.registerItem("placeholder_battery", EnergyStorageItem::new);

    public static final DeferredItem<ElectricDrillItem> ELECTRIC_DRILL = ITEMS.register("electric_drill",
            p -> new ElectricDrillItem(
                    EMTTiers.ELECTRIC_TIER
            ));
    public static final DeferredItem<ElectricSawItem> ELECTRIC_SAW = ITEMS.register("electric_saw",
            p -> new ElectricSawItem(
                    EMTTiers.ELECTRIC_TIER
            ));

    public static final DeferredItem<ElectricDrillItem> ELEMENTAL_DRILL = ITEMS.register("elemental_drill",
            p -> new ElectricDrillItem(
                    EMTTiers.MAGICAL_TIER
            ));
    public static final DeferredItem<ElementalElectricSawItem> ELEMENTAL_SAW = ITEMS.register("elemental_saw",
            p -> new ElementalElectricSawItem(
                    EMTTiers.MAGICAL_TIER
            ));

    public static void init() {}
}
