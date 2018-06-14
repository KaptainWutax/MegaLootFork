package com.kaptainwutax.megaloot.item;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;
import com.kaptainwutax.megaloot.helper.IMegaLoot;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;
import com.kaptainwutax.megaloot.nbt.NBTItemSword;
import com.kaptainwutax.megaloot.nbt.NBTLoot;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.util.Random;

public class ItemSword extends net.minecraft.item.ItemSword implements IMegaLoot {

	public ItemSword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setNoRepair();
	}
	
	//Apply modifiers
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {		
        return false;
    }
	
    //Generate tooltips
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(TextFormatting.RESET + "" + "Sword");
		
		tooltip.add(TextFormatting.GRAY + "" + NBTItemSword.getDamageNBT(stack) + " Damage");
		
		tooltip.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "Shift" + TextFormatting.DARK_GRAY + " for more...");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		Random random = new Random();
		int randomName = random.nextInt(NBTItemSword.numberOfSwordDisplayNames);
		
		if(NBTItemSword.getDisplayNameNBT(stack).equals(NBTItemSword.defaultDisplayName)) {
			NBTItemSword.setDisplayNameNBT(stack, NBTItemSword.swordDisplayNames[randomName]);
		}
		
		return NBTLoot.rarityColor[NBTItemSword.getRarityNBT(stack)] + NBTItemSword.getDisplayNameNBT(stack);
	}
	
}
