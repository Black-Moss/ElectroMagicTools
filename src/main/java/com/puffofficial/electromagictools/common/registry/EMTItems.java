package com.puffofficial.electromagictools.common.registry;

import com.puffofficial.electromagictools.api.EMTTiers;
import com.puffofficial.electromagictools.api.item.EnergyAxeItem;
import com.puffofficial.electromagictools.api.item.EnergyPickaxeItem;
import com.puffofficial.electromagictools.api.item.EnergyStorageItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.puffofficial.electromagictools.ElectroMagicTools.ITEMS;

public class EMTItems {
    public static final DeferredItem<Item> PLACEHOLDER_ITEM = ITEMS.registerSimpleItem("placeholder_item");

    public static final DeferredItem<EnergyStorageItem> PLACEHOLDER_BATTERY = ITEMS.registerItem("placeholder_battery", EnergyStorageItem::new);

    public static final DeferredItem<EnergyPickaxeItem> ELECTRIC_DRILL = ITEMS.register("electric_drill",
            p -> new EnergyPickaxeItem(
                    EMTTiers.ELECTRIC_TIER,
                    new Item.Properties().attributes(
                            EnergyPickaxeItem.createAttributes(
                                    EMTTiers.ELECTRIC_TIER,
                                    1,
                                    -2.8f
                            )
                    )
            ));
    public static final DeferredItem<EnergyAxeItem> ELECTRIC_SAW = ITEMS.register("electric_saw",
            p -> new EnergyAxeItem(
                    EMTTiers.ELECTRIC_TIER,
                    new Item.Properties().attributes(
                            EnergyAxeItem.createAttributes(
                                    EMTTiers.ELECTRIC_TIER,
                                    1,
                                    -2.8f
                            )
                    )
            ));

    public static void init() {}
}
