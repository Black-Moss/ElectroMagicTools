package com.puffofficial.electromagictools.data.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

@SuppressWarnings("unused")
public class EMTBlockLootTableProvider extends BlockLootSubProvider {
    public EMTBlockLootTableProvider(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {}
}
