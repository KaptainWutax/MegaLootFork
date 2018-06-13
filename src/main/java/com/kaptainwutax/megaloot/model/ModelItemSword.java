package com.kaptainwutax.megaloot.model;

import com.kaptainwutax.megaloot.init.ModelInit;
import com.kaptainwutax.megaloot.item.ItemSword;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ModelItemSword implements ItemMeshDefinition {

	public ModelItemSword(Item item) {
		if(item instanceof ItemSword) {
			ModelBakery.registerItemVariants(item, ModelInit.itemSwordResourceLocation);
		}
	}
	
	@Override
	public ModelResourceLocation getModelLocation(ItemStack stack) {
		Item item = stack.getItem();
		if(item instanceof ItemSword) {			
			int model = getSwordModel(stack);				
			return new ModelResourceLocation(ModelInit.itemSwordResourceLocation[model].getResourceDomain() + ":" + ModelInit.itemSwordResourceLocation[model].getResourcePath(), "inventory");
		}		
		return null;	
	}
	
	private int getSwordModel(ItemStack stack) {
		int model = 0;
		if(stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt.hasKey("model")) {model = nbt.getInteger("model");}
		} else {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setInteger("model", 0);
		}
		return model;
	}
	
}
