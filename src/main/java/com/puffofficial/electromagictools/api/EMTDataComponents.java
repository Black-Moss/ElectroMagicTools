package com.puffofficial.electromagictools.api;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.function.Supplier;

import static com.puffofficial.electromagictools.ElectroMagicTools.DATA_COMPONENT_TYPES;

public class EMTDataComponents {
    public static final Supplier<DataComponentType<Integer>> ENERGY = DATA_COMPONENT_TYPES.register("energy",
            () -> DataComponentType.<Integer>builder()
                    .persistent(Codec.intRange(0, Integer.MAX_VALUE))
                    .networkSynchronized(ByteBufCodecs.VAR_INT)
                    .build());

    public static void init() {}
}
