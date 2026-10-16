package com.puffofficial.electromagictools.api.helpers;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.awt.*;
import java.text.DecimalFormat;

public class FormattingHelper {
    // Absolute HELL of formatting, don't ask why it looks like that.
    public static Component formatEnergy(double energy) {
        String intString = Integer.toString((int) energy);

        String unit = "FE";
        int unitDivision = 1;
        switch (intString.length()) {
            case 4, 5, 6 -> {
                unit = "kFE";
                unitDivision = 1000;
            }
            case 7, 8, 9 -> {
                unit = "MFE";
                unitDivision = 1000000;
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedNumber = df.format((energy / unitDivision));

        return Component.literal(formattedNumber+ " " + unit);
    }

}
