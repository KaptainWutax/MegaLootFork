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
			int tooltipListStartSize = event.getToolTip().size();
			
			for(int i = 0 ; i < event.getToolTip().size() - 1 ; i++) {
				if(event.getToolTip().get(i).contains("for more...")) {
					int indexEndOfTooltip = i + 1;					
					for(int ii = 0 ; ii < tooltipListStartSize - 1 ; ii++) {
						if(!(event.getToolTip().size() - 1 < indexEndOfTooltip))
							event.getToolTip().remove(indexEndOfTooltip);
					}
				}
			}			
		}	
		
	}
	
}
