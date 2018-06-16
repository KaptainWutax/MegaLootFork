package com.kaptainwutax.megaloot.model;

import com.kaptainwutax.megaloot.init.InitModel;
import com.kaptainwutax.megaloot.item.ItemSword;
import com.kaptainwutax.megaloot.nbt.NBTItemSword;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModelItemSword implements ItemMeshDefinition {

	public ModelItemSword(Item item) {
		if(item instanceof ItemSword) {
			ModelBakery.registerItemVariants(item, InitModel.itemSwordResourceLocation);
		}
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		Item item = stack.getItem();
		if(item instanceof ItemSword) {			
			int model = getSwordModel(stack);				
			return new ModelResourceLocation(InitModel.itemSwordResourceLocation[model].getResourceDomain() + ":" + InitModel.itemSwordResourceLocation[model].getResourcePath(), "inventory");
		}		
		return null;	
	}
	
	private int getSwordModel(ItemStack stack) {
		int model = NBTItemSword.getModelNBT(stack);
		return model;
	}
	
}
