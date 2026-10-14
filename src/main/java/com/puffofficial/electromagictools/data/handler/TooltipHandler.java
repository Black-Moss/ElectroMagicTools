package com.puffofficial.electromagictools.data.handler;

import com.puffofficial.electromagictools.api.helpers.FormattingHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class TooltipHandler {
    public static void appendTooltips(ItemStack stack, List<Component> tooltips) {
        if (stack.getCapability(Capabilities.EnergyStorage.ITEM) != null) {
            IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

            assert capabilityStack != null;
            if (capabilityStack.canExtract()) {
                tooltips.add(1, Component.translatable("electromagictools.energy_stored",
                        FormattingHelper.formatEnergy(capabilityStack.getEnergyStored()),
                        FormattingHelper.formatEnergy(capabilityStack.getMaxEnergyStored())
                ).withColor(0x91e7ff));
            }
        }
    }
}
