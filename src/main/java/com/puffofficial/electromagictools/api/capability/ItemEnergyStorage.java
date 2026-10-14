package com.puffofficial.electromagictools.api.capability;

import com.puffofficial.electromagictools.api.EMTDataComponents;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class ItemEnergyStorage implements IEnergyStorage {
    private final ItemStack stack;
    public final int capacity;

    public ItemEnergyStorage(ItemStack stack, int capacity) {
        this.stack = stack;
        this.capacity = capacity;
    }

    @Override
    public int receiveEnergy(int toReceive, boolean sim) {
        int stored = getEnergyStored();
        int received = Math.min(this.capacity - stored, toReceive);

        if (!sim && received > 0 ) {
            stack.set(EMTDataComponents.ENERGY, stored + received);
        }

        return received;
    }

    @Override
    public int extractEnergy(int toExtract, boolean sim) {
        int stored = getEnergyStored();
        int extracted = Math.min(stored, toExtract);

        if (!sim && extracted > 0) {
            stack.set(EMTDataComponents.ENERGY, stored - extracted);
        }

        return extracted;
    }

    @Override
    public int getEnergyStored() {
        return stack.getOrDefault(EMTDataComponents.ENERGY, 0);
    }

    @Override
    public int getMaxEnergyStored() {
        return this.capacity;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
