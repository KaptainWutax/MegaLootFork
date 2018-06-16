package com.kaptainwutax.megaloot.item;

import com.kaptainwutax.megaloot.init.InitItem;
import com.kaptainwutax.megaloot.init.InitModel;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;
import com.kaptainwutax.megaloot.nbt.NBTItemSword;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import scala.util.Random;

public class ItemCase extends Item {
	
	public int rarity;
	
	public ItemCase(String name, int rarity) {
		super();
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		
		this.rarity = rarity;
	}
    
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {      	
    	if(!worldIn.isRemote) {   	
    		if(!playerIn.isCreative()) {playerIn.getHeldItem(handIn).shrink(1);}
        	int randomTool = generateCaseTool();
        	generateCaseLoot(playerIn, randomTool);
    	}
    	
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
    
    private int generateCaseTool() {
		Random random = new Random();
		int randomTool = random.nextInt(InitItem.TOOLS.size());
		return randomTool;
    }
	
	private void generateCaseLoot(EntityPlayer player, int randomTool) {		
		if(InitItem.TOOLS.get(randomTool) instanceof ItemPickaxe) {generatePickaxe(player);}
		if(InitItem.TOOLS.get(randomTool) instanceof ItemSword) {generateSword(player);}
	}
	
	private void generatePickaxe(EntityPlayer player) {	
		ItemPickaxe pickaxe = InitItem.PICKAXE;
		NBTItemPickaxe nbt = new NBTItemPickaxe();
		ItemStack stack = new ItemStack(pickaxe);
		Random random = new Random();
				
		//NBT Model
		int randomModel = random.nextInt(InitModel.numberOfPickaxeVariants);
		
		//NBT Durability
		int randomDurability = nbt.defaultDurability;
		switch(this.rarity) {
			case 0 : randomDurability = random.nextInt(nbt.maxDurabilityCommon - nbt.minDurabilityCommon) + nbt.minDurabilityCommon;
				break;
			case 1 : randomDurability = random.nextInt(nbt.maxDurabilityRare - nbt.minDurabilityRare) + nbt.minDurabilityRare;
				break;
			case 2 : randomDurability = random.nextInt(nbt.maxDurabilityEpic - nbt.minDurabilityEpic) + nbt.minDurabilityEpic;
				break;
		}
		
		//NBT Efficiency
		int randomEfficiency = nbt.defaultEfficiency;
		switch(this.rarity) {
			case 0 : randomEfficiency = random.nextInt(nbt.maxEfficiencyCommon - nbt.minEfficiencyCommon) + nbt.minEfficiencyCommon;
				break;
			case 1 : randomEfficiency = random.nextInt(nbt.maxEfficiencyRare - nbt.minEfficiencyRare) + nbt.minEfficiencyRare;
				break;
			case 2 : randomEfficiency = random.nextInt(nbt.maxEfficiencyEpic - nbt.minEfficiencyEpic) + nbt.minEfficiencyEpic;
				break;
		}
		
		NBTItemPickaxe.setNBT(stack, NBTItemPickaxe.defaultDisplayName, randomModel, this.rarity, randomDurability, randomEfficiency);
    	
    	player.inventory.addItemStackToInventory(stack);    	
	}
	
	private void generateSword(EntityPlayer player) {	
		ItemSword sword = InitItem.SWORD;
		NBTItemSword nbt = new NBTItemSword();
		ItemStack stack = new ItemStack(sword);
		Random random = new Random();
				
		//NBT Model
		int randomModel = random.nextInt(InitModel.numberOfSwordVariants);
		
		//NBT Durability
		int randomDurability = nbt.defaultDurability;
		switch(this.rarity) {
			case 0 : randomDurability = random.nextInt(nbt.maxDurabilityCommon - nbt.minDurabilityCommon) + nbt.minDurabilityCommon;
				break;
			case 1 : randomDurability = random.nextInt(nbt.maxDurabilityRare - nbt.minDurabilityRare) + nbt.minDurabilityRare;
				break;
			case 2 : randomDurability = random.nextInt(nbt.maxDurabilityEpic - nbt.minDurabilityEpic) + nbt.minDurabilityEpic;
				break;
		}
		
		//NBT Damage 
		int randomDamage = nbt.defaultDamage;
		switch(this.rarity) {
			case 0 : randomDamage = random.nextInt(nbt.maxDamageCommon - nbt.minDamageCommon) + nbt.minDamageCommon;
				break;
			case 1 : randomDamage = random.nextInt(nbt.maxDamageRare - nbt.minDamageRare) + nbt.minDamageRare;
				break;
			case 2 : randomDamage = random.nextInt(nbt.maxDamageEpic - nbt.minDamageEpic) + nbt.minDamageEpic;
				break;
		}
		
		NBTItemSword.setNBT(stack, NBTItemSword.defaultDisplayName, randomModel, this.rarity, randomDurability, randomDamage);
    	
    	player.inventory.addItemStackToInventory(stack);    	
	}
	
}
