package com.kaptainwutax.megaloot.nbt;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTItemPickaxe {
	
	//NBT DisplayName
	public static String defaultDisplayName = "MegaLoot Pickaxe";
	
	public static String[] pickaxeDisplayNames = {
			"The Pawpaw",
			"The Single Wing",
			"The Godzilla",
			"The Picker",
			"The Little Green",
			"The Big Buddy",
			"The Guzzler",
			"The Wiggle Stick",
			"The Kicker",
			"The Ground Crusher",
			"The Slacker",
			"The Kicker",
			"The Sludge",
			"The Commander",
			"The Flat Nose",
			"The Toothpick",
			"The Measurer",
			"The Belly",
			"The Clicker",
			"The Parrot",
			"The Bigwig",
			"The Drag Bag",
			"The Chicken Beak",
			"The Whiskers",
			"The Fury",
			"The Pokey",
			"The Wedger",
			"The Friendly One",
			"The Goofy Hook",
			"The Gobbler",
			"The Dislocator",
			"The Winger",
			"The Knockout",
			"The Pully",
			"The Prickle",
			"The Killer",
			"The Band Aid",
			"The Punisher",
			"The Spiker",
			"The Weeping Bell"
	};
	
	public static int numberOfPickaxeDisplayNames = pickaxeDisplayNames.length;
	
	//NBT Model
	public static int defaultModel = 0;
	
	//NBT Rarity
	public static int defaultRarity = 0;
	
	//NBT Durability
	public static int defaultDurability = ToolMaterial.DIAMOND.getMaxUses();
	
	public static int minDurabilityCommon = 100;
	public static int maxDurabilityCommon = 550;
	
	public static int minDurabilityRare = 350;
	public static int maxDurabilityRare = 1450;
	
	public static int minDurabilityEpic = 850;
	public static int maxDurabilityEpic = 2500;
	
	//NBT Efficiency
	public static int defaultEfficiency = (int)ToolMaterial.DIAMOND.getEfficiency();
	
	public static int minEfficiencyCommon = 5;
	public static int maxEfficiencyCommon = 12;
	
	public static int minEfficiencyRare = 10;
	public static int maxEfficiencyRare = 25;
	
	public static int minEfficiencyEpic = 15;
	public static int maxEfficiencyEpic = 40;


	//Set NBT compound
	public static void setNBT(ItemStack stack, String displayName, int model, int rarity, int durability, int efficiency) {
		if(stack.hasTagCompound()) {			
			setDisplayNameNBT(stack, displayName);
			setModelNBT(stack, model);
			setRarityNBT(stack, rarity);
			setDurabilityNBT(stack, durability);
			setEfficiencyNBT(stack, efficiency);} 
		else {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			setDisplayNameNBT(stack, displayName);
			setModelNBT(stack, model);
			setRarityNBT(stack, rarity);
			setDurabilityNBT(stack, durability);
			setEfficiencyNBT(stack, efficiency);
		}
	}
	
	//Set NBT values
	public static void setDisplayNameNBT(ItemStack stack, String value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setString("displayName", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
	}
	
	public static void setModelNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("model", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
	}
	
	public static void setRarityNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("rarity", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
	}
	
	public static void setDurabilityNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("durability", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
	}
	
	public static void setEfficiencyNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("efficiency", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
	}
	
	//Get NBT values
	public static String getDisplayNameNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getString("displayName");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
		return stack.getTagCompound().getString("displayName");
	}
	
	public static int getModelNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("model");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
		return stack.getTagCompound().getInteger("model");
	}
	
	public static int getRarityNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("rarity");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
		return stack.getTagCompound().getInteger("rarity");
	}
	
	public static int getDurabilityNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("durability");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
		return stack.getTagCompound().getInteger("durability");
	}
	
	public static int getEfficiencyNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("efficiency");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultEfficiency);}
		return stack.getTagCompound().getInteger("efficiency");
	}
	
}
