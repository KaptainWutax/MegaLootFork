package com.kaptainwutax.megaloot.init;

import java.util.ArrayList;

import com.kaptainwutax.megaloot.item.ItemCase;
import com.kaptainwutax.megaloot.item.ItemPickaxe;
import com.kaptainwutax.megaloot.item.ItemSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemInit {
	
	public static ArrayList<Item> TOOLS = new ArrayList<Item>();
	
	public static ItemPickaxe PICKAXE = new ItemPickaxe("pickaxe", ToolMaterial.DIAMOND);
	public static ItemSword SWORD = new ItemSword("sword", ToolMaterial.DIAMOND);
	
	public static ItemCase COMMON_CASE = new ItemCase("common_case", 0);
	public static ItemCase RARE_CASE = new ItemCase("rare_case", 1);
	public static ItemCase EPIC_CASE = new ItemCase("epic_case", 2);
	
	public static void register(IForgeRegistry<Item> registry) {   	
		registry.registerAll(PICKAXE, SWORD, COMMON_CASE, RARE_CASE, EPIC_CASE);
		TOOLS.add(PICKAXE); TOOLS.add(SWORD);
	}
	
}
