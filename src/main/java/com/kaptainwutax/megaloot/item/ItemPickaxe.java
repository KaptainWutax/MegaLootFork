package com.kaptainwutax.megaloot.item;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;
import com.kaptainwutax.megaloot.helper.IMegaLoot;
import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.init.ModelInit;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;
import com.kaptainwutax.megaloot.nbt.NBTLoot;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.util.Random;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe implements IMegaLoot {

	public ItemPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
	}
		
	//Apply modifiers
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {		
        return false;
    }
	
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        for (String type : getToolClasses(stack)) {
            if (state.getBlock().isToolEffective(type, state)) {return NBTItemPickaxe.getEfficiencyNBT(stack);}
        }
        return 1.0F;
    }
	
    //Generate tooltips
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
			tooltip.add(TextFormatting.RESET + "" + "Pickaxe");
			
			tooltip.add(TextFormatting.GRAY + "" + ItemStack.DECIMALFORMAT.format(NBTItemPickaxe.getEfficiencyNBT(stack)) + " Mining Speed");
			
			tooltip.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "Shift" + TextFormatting.DARK_GRAY + " for more...");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		Random random = new Random();
		int randomName = random.nextInt(NBTItemPickaxe.numberOfPickaxeDisplayNames);
		
		if(NBTItemPickaxe.getDisplayNameNBT(stack).equals(NBTItemPickaxe.defaultDisplayName)) {
			NBTItemPickaxe.setDisplayNameNBT(stack, NBTItemPickaxe.pickaxeDisplayNames[randomName]);
		}
		
		return NBTLoot.rarityColor[NBTItemPickaxe.getRarityNBT(stack)] + NBTItemPickaxe.getDisplayNameNBT(stack);
	}

}
