package com.puffofficial.electromagictools.data.provider;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.common.registry.EMTItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("unused")
public class EMTItemModelProvider extends ItemModelProvider {
    public EMTItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ElectroMagicTools.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(EMTItems.PLACEHOLDER_BATTERY.get());
        basicItem(EMTItems.PLACEHOLDER_ITEM.get());
    }
}
