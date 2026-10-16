package com.puffofficial.electromagictools.api.item.tool.electric;

import com.puffofficial.electromagictools.api.EMTValues;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;

public class ElectricDrillItem extends ElectricToolItem {
    public ElectricDrillItem(Tier tier) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE);
    }

    @Override
    public boolean mineBlock(ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity miningEntity) {
        Tool tool = stack.get(DataComponents.TOOL);

        if ((stack.getCapability(Capabilities.EnergyStorage.ITEM) != null) && (tool != null)) {
            IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);
            if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F && tool.damagePerBlock() > 0) {
                assert capabilityStack != null;
                if (capabilityStack.getEnergyStored() >= EMTValues.ENERGY_PER_BLOCK) {
                    capabilityStack.extractEnergy(EMTValues.ENERGY_PER_BLOCK, false);
                } else {
                    stack.hurtAndBreak(tool.damagePerBlock(), miningEntity, EquipmentSlot.MAINHAND);
                }
                return true;
            }
        }
        return false;
    }
}
