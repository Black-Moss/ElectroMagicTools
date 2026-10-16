package com.puffofficial.electromagictools.api.item.tool.elemental;

import com.leclowndu93150.thaumaturge.api.items.IChanneledItem;
import com.leclowndu93150.thaumaturge.client.effect.ClientEffects;
import com.leclowndu93150.thaumaturge.content.equipment.ItemMagnet;
import com.puffofficial.electromagictools.api.EMTValues;
import com.puffofficial.electromagictools.api.item.tool.electric.ElectricSawItem;
import com.puffofficial.electromagictools.api.item.tool.electric.ElectricToolItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.NotNull;

public class ElementalElectricSawItem extends ElectricSawItem implements IChanneledItem {
    private static final int USE_DURATION_TICKS = 72000;
    private static final double MAGNET_RANGE = 10.0;

    public ElementalElectricSawItem(Tier tier) {
        super(tier);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity user) {
        return USE_DURATION_TICKS;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand hand) {
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(player.getItemInHand(hand));
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity user, @NotNull ItemStack stack, int remainingUseDuration) {
        IEnergyStorage capabilityStack = stack.getCapability(Capabilities.EnergyStorage.ITEM);

        assert capabilityStack != null;
        if (capabilityStack.getEnergyStored() > EMTValues.ENERGY_PEL_TICK_PULL) {
            capabilityStack.extractEnergy(EMTValues.ENERGY_PEL_TICK_PULL, false);

            Vec3 anchor = new Vec3(user.getX(), user.getY() - user.getBbHeight() / 2.0, user.getZ());
            for (ItemEntity item : level.getEntitiesOfClass(
                    ItemEntity.class, user.getBoundingBox().inflate(MAGNET_RANGE), ItemEntity::isAlive)) {
                Vec3 position = item.position();
                if (position.distanceToSqr(anchor) == 0.0) {
                    continue;
                }
                item.setDeltaMovement(ItemMagnet.pull(item.getDeltaMovement(), position, anchor));
                if (level.isClientSide()) {
                    double jitterX = level.getRandom().triangle(0.0, 0.2);
                    double jitterY = level.getRandom().triangle(0.0, 0.2);
                    double jitterZ = level.getRandom().triangle(0.0, 0.2);
                    ClientEffects.followingBubble(
                            level, position.x + jitterX, position.y + item.getBbHeight() + jitterY, position.z + jitterZ);
                }
            }
        }
    }
}
