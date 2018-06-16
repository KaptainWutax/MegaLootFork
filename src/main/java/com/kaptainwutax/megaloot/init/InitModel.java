package com.kaptainwutax.megaloot.init;

import com.kaptainwutax.megaloot.model.ModelItemPickaxe;
import com.kaptainwutax.megaloot.model.ModelItemSword;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class InitModel {
	
	public static int numberOfPickaxeVariants = 16;
	public static final ModelResourceLocation[] itemPickaxeResourceLocation = new ModelResourceLocation[numberOfPickaxeVariants];	

	public static int numberOfSwordVariants = 76;
	public static final ModelResourceLocation[] itemSwordResourceLocation = new ModelResourceLocation[numberOfSwordVariants];	
	
	public static final ModelResourceLocation[] itemCaseResourceLocation = {
			new ModelResourceLocation(Reference.MOD_ID + ":cases/common", "inventory"),
			new ModelResourceLocation(Reference.MOD_ID + ":cases/rare", "inventory"),
			new ModelResourceLocation(Reference.MOD_ID + ":cases/epic", "inventory")	
	};
	public static int numberOfCaseVariants = itemCaseResourceLocation.length;
	
	public static void initializeModels() {
		for(int i = 0 ; i < numberOfPickaxeVariants ; i++) {
			itemPickaxeResourceLocation[i] = new ModelResourceLocation(Reference.MOD_ID + ":" + "pickaxe/" + (i + 1), "inventory");
		}
		
		for(int i = 0 ; i < numberOfSwordVariants ; i++) {
			itemSwordResourceLocation[i] = new ModelResourceLocation(Reference.MOD_ID + ":" + "sword/" + (i + 1), "inventory");
		}
	}
	
	public static void registerModels() {
		initializeModels();
		ModelLoader.setCustomMeshDefinition(InitItem.PICKAXE, new ModelItemPickaxe(InitItem.PICKAXE));
		ModelLoader.setCustomMeshDefinition(InitItem.SWORD, new ModelItemSword(InitItem.SWORD));
		registerCase(InitItem.COMMON_CASE, 0, "inventory", 0);
		registerCase(InitItem.RARE_CASE, 0, "inventory", 1);
		registerCase(InitItem.EPIC_CASE, 0, "inventory", 2);
	}
	
	private static void registerCase(Item item, int meta, String type, int rarity) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemCaseResourceLocation[rarity].getResourceDomain() + ":" + itemCaseResourceLocation[rarity].getResourcePath(), type));
	}
}
