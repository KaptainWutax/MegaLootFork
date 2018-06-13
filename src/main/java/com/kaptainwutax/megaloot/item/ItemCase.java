package com.kaptainwutax.megaloot.item;

import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.init.ModelInit;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
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
		int randomTool = random.nextInt(ItemInit.TOOLS.size());
		return randomTool;
    }
	
	private void generateCaseLoot(EntityPlayer player, int randomTool) {		
		if(ItemInit.TOOLS.get(randomTool) instanceof ItemPickaxe) {generatePickaxe(player);}
		if(ItemInit.TOOLS.get(randomTool) instanceof ItemSword) {generateSword(player);}
	}
	
	private void generatePickaxe(EntityPlayer player) {	
		ItemPickaxe pickaxe = ItemInit.PICKAXE;
		NBTItemPickaxe nbt = new NBTItemPickaxe();
		ItemStack stack = new ItemStack(pickaxe);
		Random random = new Random();
				
		//NBT Model
		int randomModel = random.nextInt(ModelInit.numberOfPickaxeVariants);
		
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
		
		NBTItemPickaxe.setNBT(stack, NBTItemPickaxe.defaultDisplayName, randomModel, this.rarity, randomEfficiency);
    	
    	player.inventory.addItemStackToInventory(stack);    	
	}
	
	private void generateSword(EntityPlayer player) {	
		ItemStack stack = new ItemStack(ItemInit.SWORD);
		
    	if(!stack.hasTagCompound()) {
    		NBTTagCompound nbt = new NBTTagCompound();
    		stack.setTagCompound(nbt);
    		Random random = new Random();
    		int randomModel = random.nextInt(ModelInit.numberOfSwordVariants);
        	nbt.setInteger("model", randomModel);
        	nbt.setInteger("efficiency", 4);
    	}
    	
    	player.inventory.addItemStackToInventory(stack);    	
	}
	
}
