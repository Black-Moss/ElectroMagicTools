package com.puffofficial.electromagictools.api.item;

import com.puffofficial.electromagictools.api.EMTValues;
import com.puffofficial.electromagictools.api.helpers.ColorHelper;
import com.puffofficial.electromagictools.api.helpers.TooltipHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;
import com.puffofficial.electromagictools.api.EMTValues.EnergyColors;

import java.util.List;

public class EnergyToolItem extends DiggerItem {
    public EnergyToolItem(Tier tier, TagKey<Block> blocks, Properties properties) {
        super(tier, blocks, properties);
    }

    @Override
    public boolean isBarVisible(@NotNull ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        assert capabilityStack != null;
        if (capabilityStack.getEnergyStored() > 0) {
            return true;
        } else return stack.getDamageValue() > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);
        assert capabilityStack != null;
        if (capabilityStack.getEnergyStored() > 0) {
            return Math.round((float) capabilityStack.getEnergyStored() * 13.0F / (float) capabilityStack.getMaxEnergyStored());
        } else if (stack.getDamageValue() > 0) {
            return super.getBarWidth(stack);
        }
        return 0;
    }

    @Override
    public int getBarColor(ItemStack stack) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

        assert capabilityStack != null;
        if (capabilityStack.getEnergyStored() > 0) {
            return ColorHelper.lerpColor(
                    EnergyColors.DISCHARGED,
                    EnergyColors.CHARGED,
                    (float) capabilityStack.getEnergyStored() / capabilityStack.getMaxEnergyStored()
            );
        } else if (stack.getDamageValue() > 0) {
            return super.getBarColor(stack);
        }
        return super.getBarColor(stack);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

        assert capabilityStack != null;
        if (capabilityStack.getEnergyStored() > 0) {
            TooltipHelper.energyTooltip(stack, tooltipComponents, getBarColor(stack), 1);
        } else {
            TooltipHelper.energyTooltip(stack, tooltipComponents, EnergyColors.DISCHARGED, 1);
        }
        TooltipHelper.energyConsumptionPerOperationTooltip(tooltipComponents, (int) (EMTValues.ENERGY_PER_BLOCK), 2);
    }
}
