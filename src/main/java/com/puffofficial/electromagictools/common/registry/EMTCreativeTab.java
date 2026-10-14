package com.puffofficial.electromagictools.common.registry;

import com.puffofficial.electromagictools.ElectroMagicTools;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;

public class EMTCreativeTab {
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEFAULT_TAB = ElectroMagicTools.CREATIVE_MODE_TABS.register("electromagic_tools", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.electromagictools"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(EMTItems.PLACEHOLDER_BATTERY.asItem()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(EMTItems.PLACEHOLDER_ITEM);
                output.accept(EMTItems.PLACEHOLDER_BATTERY);
            }).build());

    public static void init() {}
}
