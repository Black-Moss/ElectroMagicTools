package com.puffofficial.electromagictools.data.provider;

import com.puffofficial.electromagictools.ElectroMagicTools;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EMTLangProvider extends LanguageProvider {
    public EMTLangProvider(PackOutput output) {
        super(output, ElectroMagicTools.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.electromagictools", "ElectroMagic Tools");
        add("item.electromagictools.placeholder_item", "Placeholder Item");
        add("item.electromagictools.placeholder_battery", "Placeholder Battery");

        add("item.electromagictools.electric_drill", "Electric Drill");
        add("item.electromagictools.electric_sawS", "Electric Saw");

        add("electromagictools.energy_stored", "§7Energy Stored: %s/%s");
        add("electromagictools.energy_per_operation", "§7Energy Per Operation: %s");
    }
}
