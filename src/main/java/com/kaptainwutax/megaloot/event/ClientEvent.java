package com.kaptainwutax.megaloot.event;

import java.util.List;

import com.kaptainwutax.megaloot.helper.IMegaLoot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value = Side.CLIENT)
@Mod.EventBusSubscriber
public class ClientEvent {

	@SubscribeEvent
	public static void onTooltipDrawn(ItemTooltipEvent event) {		
		if (event.getItemStack().getItem() instanceof IMegaLoot) {iterateVanillaTooltip(event);}		
	}
	
	public static void iterateVanillaTooltip(ItemTooltipEvent event) {
		for(int i = 0 ; i < event.getToolTip().size() - 1 ; i++) {
			if(event.getToolTip().get(i).contains("When in main hand:")) {removeVanillaTooltip(event, event.getToolTip().size(), i - 1);}
		}
	}
	
	public static void removeVanillaTooltip(ItemTooltipEvent event, int startSize, int end) {
		for(int ii = 0 ; ii < startSize - 1 ; ii++) {
			if(!(event.getToolTip().size() - 1 < end)) {event.getToolTip().remove(end);}
		}
	}
	
}
