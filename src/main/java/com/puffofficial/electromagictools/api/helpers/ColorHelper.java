package com.puffofficial.electromagictools.api.helpers;

import net.minecraft.client.color.item.ItemColor;

import java.util.function.Supplier;

public class ColorHelper {
    public static int lerpColor(int color1, int color2, float t) {
        t = Math.max(0.0f, Math.min(1.0f, t));

        int r1 = (color1 >> 16) & 0xFF;
        int g1 = (color1 >> 8) & 0xFF;
        int b1 = color1 & 0xFF;

        int r2 = (color2 >> 16) & 0xFF;
        int g2 = (color2 >> 8) & 0xFF;
        int b2 = color2 & 0xFF;

        int r = Math.round(r1 + (r2 - r1) * t);
        int g = Math.round(g1 + (g2 - g1) * t);
        int b = Math.round(b1 + (b2 - b1) * t);

        return (r << 16) | (g << 8) | b;
    }

    public static ItemColor itemTintFromHex(int hex, int tint) {
        return (stack, tintIndex) -> {
            if (tintIndex == tint) {
                return hex;
            }
            return 0xFFFFFFFF;
        };
    }
}
