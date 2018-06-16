package com.kaptainwutax.megaloot.handler;

import com.kaptainwutax.megaloot.init.InitBlock;
import com.kaptainwutax.megaloot.init.InitItem;
import com.kaptainwutax.megaloot.init.InitKeyBinding;
import com.kaptainwutax.megaloot.init.InitModel;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
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

	}
	
	public static void initRegistries(FMLInitializationEvent event) {
		onKeyBindingRegister();
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {	    	
		InitItem.registerItems(event.getRegistry());
		InitBlock.registerItemBlocks(event.getRegistry());	        
	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {	    	
		InitBlock.registerBlocks(event.getRegistry());	        
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {	    	
		InitModel.registerModels();
	}
	
	public static void onKeyBindingRegister() {	    	
		InitKeyBinding.registerKeyBindings();	        
	}
	
}
