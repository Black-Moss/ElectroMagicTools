package com.puffofficial.electromagictools.api.item;

import com.puffofficial.electromagictools.api.helpers.ColorHelper;
import com.puffofficial.electromagictools.api.helpers.TooltipHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.puffofficial.electromagictools.api.EMTValues.*;

@SuppressWarnings("unused")
public class EnergyStorageItem extends Item {

    public EnergyStorageItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isBarVisible(@NotNull ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        return capabilityStack != null && capabilityStack.getEnergyStored() > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        if (capabilityStack == null) return 0;
        return Math.round((float) capabilityStack.getEnergyStored() * 13.0F / (float) capabilityStack.getMaxEnergyStored());
    }

    @Override
    public int getBarColor(ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

        assert capabilityStack != null;
        return ColorHelper.lerpColor(
                EnergyColors.DISCHARGED,
                EnergyColors.CHARGED,
                (float) capabilityStack.getEnergyStored() / capabilityStack.getMaxEnergyStored());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        TooltipHelper.energyTooltip(stack, tooltipComponents, getBarColor(stack), 1);
    }
}
