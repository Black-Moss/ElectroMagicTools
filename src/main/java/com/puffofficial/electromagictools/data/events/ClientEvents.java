package com.puffofficial.electromagictools.data.events;

import com.puffofficial.electromagictools.ElectroMagicTools;
import com.puffofficial.electromagictools.api.helpers.ItemHelper;
import com.puffofficial.electromagictools.data.handler.TooltipHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = ElectroMagicTools.MODID, value = Dist.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onTooltipEvent(ItemTooltipEvent event) {
        if (ItemHelper.getItemNamespace(event.getItemStack()).equals(ElectroMagicTools.MODID)) {
            TooltipHandler.appendTooltips(event.getItemStack(), event.getToolTip());
        }
    }
}
