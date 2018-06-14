package com.kaptainwutax.megaloot.event;

import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.nbt.NBTItemSword;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

@Mod.EventBusSubscriber
public class CommonEvent {

	@SubscribeEvent
	public void onEntityAttacked(LivingHurtEvent event) {		
		Entity source = event.getSource().getTrueSource();

		if (source instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)source;			
			if (player.getHeldItemMainhand().getItem() == ItemInit.SWORD) {					
					ItemStack stack = player.getHeldItem(player.getActiveHand());
					event.setAmount(NBTItemSword.getDamageNBT(stack));
					System.out.println(NBTItemSword.getDamageNBT(stack));
			}				
		}		
	}

}
