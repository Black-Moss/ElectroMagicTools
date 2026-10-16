package com.puffofficial.electromagictools.api;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class EMTTiers {
    public static final Tier ELECTRIC_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            256,
            5.5f,
            2f,
            14,
            () -> Ingredient.of(Tags.Items.SLIME_BALLS)
    );
    public static final Tier MAGICAL_TIER = new SimpleTier(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            512,
            6.5f,
            2f,
            16,
            () -> Ingredient.of(Tags.Items.SLIME_BALLS)
    );
}
