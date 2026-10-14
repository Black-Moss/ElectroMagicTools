package com.puffofficial.electromagictools.data;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.data.provider.EMTLangProvider;
import com.puffofficial.electromagictools.data.provider.EMTItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ElectroMagicTools.MODID)
public class EMTDataGen {
    private EMTDataGen() {}

    @SubscribeEvent
    public static void onGatherDataEvent(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        event.createProvider(EMTLangProvider::new);

        generator.addProvider(event.includeClient(), new EMTItemModelProvider(output, existingFileHelper));
    }
}
