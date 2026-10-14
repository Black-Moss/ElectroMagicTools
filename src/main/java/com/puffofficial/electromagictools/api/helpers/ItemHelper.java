package com.puffofficial.electromagictools.api.helpers;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ItemHelper {
    public static String getItemNamespace(ItemStack stack) {
        ResourceLocation registryName = BuiltInRegistries.ITEM.getKey(stack.getItem());

        return registryName.getNamespace();
    }
}
