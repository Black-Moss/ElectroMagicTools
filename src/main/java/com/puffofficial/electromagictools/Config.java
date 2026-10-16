package com.puffofficial.electromagictools;

import java.util.List;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue ENERGY_TOOL_CONSUMPTION = BUILDER
            .comment("Tool energy consumption per block, the result will be (50 * multiplier) FE")
            .defineInRange("multiplier", 1, 0.1, Double.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();
}
