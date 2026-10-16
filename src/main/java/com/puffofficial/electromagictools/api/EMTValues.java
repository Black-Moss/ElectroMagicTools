package com.puffofficial.electromagictools.api;

import com.puffofficial.electromagictools.Config;

public class EMTValues {
    public static class EnergyColors {
        public static final int CHARGED = 0x6ed3ff;
        public static final int DISCHARGED = 0xd41717;
    }

    public static final int DEFAULT_ENERGY_PER_BLOCK = 50;
    public static final int ENERGY_PER_BLOCK = Math.toIntExact(Math.round(DEFAULT_ENERGY_PER_BLOCK * Config.ENERGY_TOOL_CONSUMPTION.getAsDouble()));
}
