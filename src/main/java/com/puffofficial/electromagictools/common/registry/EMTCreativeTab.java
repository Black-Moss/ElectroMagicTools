package com.puffofficial.electromagictools.common.registry;

import com.leclowndu93150.thaumaturge.api.items.InfusionEnchantment;
import com.leclowndu93150.thaumaturge.registry.TTItems;
import com.puffofficial.electromagictools.ElectroMagicTools;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import com.leclowndu93150.thaumaturge.content.equipment.InfusionEnchantmentHelper;

public class EMTCreativeTab {
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DEFAULT_TAB = ElectroMagicTools.CREATIVE_MODE_TABS.register("electromagic_tools", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.electromagictools"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(EMTItems.PLACEHOLDER_BATTERY.asItem()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(EMTItems.PLACEHOLDER_ITEM);
                output.accept(EMTItems.PLACEHOLDER_BATTERY);
                output.accept(EMTItems.ELECTRIC_DRILL);
                output.accept(EMTItems.ELECTRIC_SAW);

                ItemStack elementalDrill = new ItemStack(EMTItems.ELEMENTAL_DRILL.get());
                InfusionEnchantmentHelper.add(elementalDrill, InfusionEnchantment.REFINING, 1);
                InfusionEnchantmentHelper.add(elementalDrill, InfusionEnchantment.SOUNDING, 2);
                output.accept(elementalDrill);

                ItemStack elementalSaw = new ItemStack(EMTItems.ELEMENTAL_SAW.get());
                InfusionEnchantmentHelper.add(elementalSaw, InfusionEnchantment.BURROWING, 1);
                InfusionEnchantmentHelper.add(elementalSaw, InfusionEnchantment.COLLECTOR, 1);
                output.accept(elementalSaw);
            }).build());

    public static void init() {}
}
