package com.puffofficial.electromagictools.mixin;

import com.leclowndu93150.thaumaturge.api.items.InfusionEnchantment;
import com.leclowndu93150.thaumaturge.content.equipment.EnchantMining;
import com.leclowndu93150.thaumaturge.content.equipment.InfusionEnchantmentEvents;
import com.leclowndu93150.thaumaturge.content.equipment.InfusionEnchantmentHelper;
import com.puffofficial.electromagictools.api.EMTValues;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InfusionEnchantmentEvents.class)
public class InfusionEnchantmentsMixin {

    @Overwrite
    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (event.getLevel().isClientSide() || EnchantMining.isHarvestingFurthest()) {
            return;
        }
        Player player = event.getPlayer();
        ItemStack held = player.getMainHandItem();
        if (!InfusionEnchantmentHelper.has(held, InfusionEnchantment.BURROWING) || player.isShiftKeyDown()) {
            return;
        }
        ServerLevel level = (ServerLevel) event.getLevel();
        BlockPos pos = event.getPos();
        BlockState state = event.getState();
        if (!held.isCorrectToolForDrops(state)) {
            return;
        }
        if (!(EnchantMining.isLog(level, pos) || EnchantMining.isOre(level, pos))) {
            return;
        }
        event.setCanceled(true);
        if ((held.getCapability(Capabilities.EnergyStorage.ITEM) != null) && (held.getCapability(Capabilities.EnergyStorage.ITEM).getEnergyStored() > EMTValues.ENERGY_PER_BLOCK)) {
            held.getCapability(Capabilities.EnergyStorage.ITEM).extractEnergy(EMTValues.ENERGY_PER_BLOCK, false);
        } else {
            held.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        }
        EnchantMining.breakFurthest(level, pos, state, player);
    }
}
