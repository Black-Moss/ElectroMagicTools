package com.puffofficial.electromagictools.api.helpers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class TooltipHelper {
    public static void energyTooltip(ItemStack stack, List<Component> tooltips, int color, int index) {
        if (stack.getCapability(Capabilities.EnergyStorage.ITEM) != null) {
            IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

            assert capabilityStack != null;
            tooltips.add(index, Component.translatable("electromagictools.energy_stored",
                        FormattingHelper.formatEnergy(capabilityStack.getEnergyStored()),
                        FormattingHelper.formatEnergy(capabilityStack.getMaxEnergyStored())
                ).withColor(color));
        }
    }

    public static void energyConsumptionPerOperationTooltip(List<Component> tooltips, int energy, int index) {
        tooltips.add(index, Component.translatable("electromagictools.energy_per_operation",
                        FormattingHelper.formatEnergy(energy)));
    }
}
