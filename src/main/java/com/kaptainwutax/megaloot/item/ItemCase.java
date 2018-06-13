package com.kaptainwutax.megaloot.item;

import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.init.ModelInit;
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
		System.out.println(randomTool);
		return randomTool;
    }
	
	private void generateCaseLoot(EntityPlayer player, int randomTool) {		
		if(ItemInit.TOOLS.get(randomTool) instanceof ItemPickaxe) {generatePickaxe(player);}
		if(ItemInit.TOOLS.get(randomTool) instanceof ItemSword) {generateSword(player);}
	}
	
	private void generatePickaxe(EntityPlayer player) {	
		ItemStack stack = new ItemStack(ItemInit.PICKAXE);
		
    	if(!stack.hasTagCompound()) {
    		NBTTagCompound nbt = new NBTTagCompound();
    		stack.setTagCompound(nbt);
    		Random random = new Random();
    		int randomModel = random.nextInt(ModelInit.numberOfPickaxeVariants);
        	nbt.setInteger("model", randomModel);
    	}
    	
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
    	}
    	
    	player.inventory.addItemStackToInventory(stack);    	
	}
	
}
