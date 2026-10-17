package com.puffofficial.electromagictools.data.provider;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.common.registry.EMTItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EMTLangProvider extends LanguageProvider {
    public EMTLangProvider(PackOutput output) {
        super(output, ElectroMagicTools.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.electromagictools", "ElectroMagic Tools");
        addItem(EMTItems.PLACEHOLDER_ITEM, "Placeholder Item");
        addItem(EMTItems.PLACEHOLDER_BATTERY,  "Placeholder Battery");

        addItem(EMTItems.ELECTRIC_DRILL,  "Electric Drill");
        addItem(EMTItems.ELECTRIC_SAW,  "Electric Saw");

        add("electromagictools.energy_stored", "§7Energy Stored: %s/%s");
        add("electromagictools.energy_per_operation", "§7Energy Per Operation: %s");
    }
}
