package com.kaptainwutax.megaloot.handler;

import com.kaptainwutax.megaloot.init.BlockInit;
import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.init.ModelInit;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class HandlerRegistry {

	public static void preInitRegistries(FMLPreInitializationEvent event) {
		disableVanillaTooltips();
	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) {		
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {	    	
		ItemInit.register(event.getRegistry());
		BlockInit.registerItemBlocks(event.getRegistry());	        
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {	    	
		BlockInit.register(event.getRegistry());	        
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {	    	
		ModelInit.registerItemModels();
	}
	
}
