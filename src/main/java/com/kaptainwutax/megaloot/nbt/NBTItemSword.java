package com.kaptainwutax.megaloot.nbt;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTItemSword {
	
	//NBT DisplayName
	public static String defaultDisplayName = "MegaLoot Sword";
	
	public static String[] swordDisplayNames = {
			"Balance Sword",
			"The Crusader",
			"Butcher Blade",
			"Mageblade",
			"Long Sword",
			"The Shadow",
			"Jade",
			"Blaze Guard",
			"Heart Spike",
			"Torment",
			"Phantom",
			"Gladius",	
			"Nat Blade",
			"Vine Sword",
			"Knight Blade",
			"Red",
			"Dog Bone",
			"Ice Blade",
			"Sabre",
			"Molten Sword",
			"Phase Blade",
			"Crystal Wing",
			"Wakizashi",
			"Wizard Spike",
			"Knightfall",
			"Catastrophe",
			"Ragespike",
			"Improved Reaver",
			"Mourning Etcher",
			"Dragonbreath Copper Greatsword",
			"Rusty Diamond Katna",
			"Heartstriker, Guardian of Grace",
			"The Black Blade, Cry of Pride",
			"Nethersbane, Reaper of the Lost",
			"Massacre",
			"Lightning",
			"Silencer",
			"Grieving Carver",
			"Renewed Scimitar",
			"Crazed Silver Slicer",
			"Annihilation Gold Claymore",
			"Stormcaller, Betrayer of Summoning",
			"Warmonger, Vengeance of the Dreadlord",
			"Rigormortis, Bond of Agony",
			"The Ambassador",
			"Endbringer",
			"Blight's Plight",
			"Rusty Guardian",
			"Stormfury Skewer",
			"Trainee's Iron Guardian",
			"Cataclysm Steel Doomblade",
			"Lightning, Hope of the Forsaken",
			"Suspension, Pact of Ashes",
			"The Black Blade, Warglaive of Anguish",
			"Hope's End",
			"Requiem",
			"Blight's Plight",
			"Tyrannical Protector",
			"Isolated Greatsword",
			"Heartless Glass Sculptor",
			"Exiled Adamantite Shortsword",
			"Massacre, Blessed Blade of Delusions",
			"Brutality, Longsword of Decay",
			"Toothpick, Skewer of the Incoming Storm"
	};
	
	public static int numberOfSwordDisplayNames = swordDisplayNames.length;
	
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
	
	//NBT Damage
	public static int defaultDamage = (int)ToolMaterial.DIAMOND.getAttackDamage() * 2;
	
	public static int minDamageCommon = 6;
	public static int maxDamageCommon = 11;
	
	public static int minDamageRare = 9;
	public static int maxDamageRare = 15;
	
	public static int minDamageEpic = 12;
	public static int maxDamageEpic = 28;


	//Set NBT compound
	public static void setNBT(ItemStack stack, String displayName, int model, int rarity, int durability, int damage) {
		if(stack.hasTagCompound()) {return;} 
		else {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			setDisplayNameNBT(stack, displayName);
			setModelNBT(stack, model);
			setRarityNBT(stack, rarity);
			setDurabilityNBT(stack, durability);
			setDamageNBT(stack, damage);
		}
	}
	
	//Set NBT values
	public static void setDisplayNameNBT(ItemStack stack, String value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setString("displayName", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
	}
	
	public static void setModelNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("model", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
	}
	
	public static void setRarityNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("rarity", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
	}
	
	public static void setDurabilityNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("durability", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
	}
	
	public static void setDamageNBT(ItemStack stack, int value) {
		if(stack.hasTagCompound()) {stack.getTagCompound().setInteger("damage", value);} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
	}
	
	//Get NBT values
	public static String getDisplayNameNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getString("displayName");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
		return stack.getTagCompound().getString("displayName");
	}
	
	public static int getModelNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("model");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
		return stack.getTagCompound().getInteger("model");
	}
	
	public static int getRarityNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("rarity");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
		return stack.getTagCompound().getInteger("rarity");
	}
	
	public static int getDurabilityNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("durability");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
		return stack.getTagCompound().getInteger("durability");
	}
	
	public static int getDamageNBT(ItemStack stack) {
		if(stack.hasTagCompound()) {return stack.getTagCompound().getInteger("damage");} 
		else {setNBT(stack, defaultDisplayName, defaultModel, defaultRarity, defaultDurability, defaultDamage);}
		return stack.getTagCompound().getInteger("damage");
	}
	
}
