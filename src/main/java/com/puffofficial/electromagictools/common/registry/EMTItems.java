package com.puffofficial.electromagictools.common.registry;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.puffofficial.electromagictools.ElectroMagicTools.ITEMS;

public class EMTItems {
    public static final DeferredItem<Item> PLACEHOLDER_BATTERY = ITEMS.registerSimpleItem("placeholder_battery");
    public static final DeferredItem<Item> PLACEHOLDER_ITEM = ITEMS.registerSimpleItem("placeholder_item");

    public static void init() {}
}
