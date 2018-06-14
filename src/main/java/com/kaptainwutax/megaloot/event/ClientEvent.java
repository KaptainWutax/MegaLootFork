package com.kaptainwutax.megaloot.event;

import com.kaptainwutax.megaloot.helper.IMegaLoot;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientEvent {

	@SubscribeEvent
	public static void onTooltipDrawn(ItemTooltipEvent event) {
		if (event.getItemStack().getItem() instanceof IMegaLoot) {
			
			int deleteIndex = 10000;
			
			for(int i = 0 ; i < event.getToolTip().size() - 1 ; i++) {
				if(event.getToolTip().get(i).contains("When in main hand:")) {event.getToolTip().remove(i);}
				if(event.getToolTip().get(i).contains("Attack Damage")) {event.getToolTip().remove(i);}
				if(event.getToolTip().get(i).contains("Attack Speed")) {event.getToolTip().remove(i);}
			}
				
		}
		
	}
	
}
