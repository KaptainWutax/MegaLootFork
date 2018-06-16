package com.kaptainwutax.megaloot.model;

import com.kaptainwutax.megaloot.init.InitModel;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ModelItemPickaxe implements ItemMeshDefinition {

	public ModelItemPickaxe(Item item) {
		if(item instanceof ItemPickaxe) {
			ModelBakery.registerItemVariants(item, InitModel.itemPickaxeResourceLocation);
		}
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		Item item = stack.getItem();
		if(item instanceof ItemPickaxe) {			
			int model = getPickaxeModel(stack);				
			return new ModelResourceLocation(InitModel.itemPickaxeResourceLocation[model].getResourceDomain() + ":" + InitModel.itemPickaxeResourceLocation[model].getResourcePath(), "inventory");
		}		
		return null;	
	}
	
	private int getPickaxeModel(ItemStack stack) {
		int model = NBTItemPickaxe.getModelNBT(stack);
		return model;
	}

}
