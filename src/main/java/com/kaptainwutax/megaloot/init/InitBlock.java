package com.kaptainwutax.megaloot.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class InitBlock {
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {	    	
		registry.registerAll();	        
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {	    	
		registry.registerAll();	        
	}
	
}
