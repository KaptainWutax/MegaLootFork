package com.kaptainwutax.megaloot.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockInit {
	
	public static void register(IForgeRegistry<Block> registry) {	    	
		registry.registerAll();	        
	}

	public static void registerModels() {

	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {	    	
		registry.registerAll();	        
	}
	
}