package com.kaptainwutax.megaloot.item;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;
import com.kaptainwutax.megaloot.helper.IMegaLoot;
import com.kaptainwutax.megaloot.nbt.NBTItemPickaxe;
import com.kaptainwutax.megaloot.nbt.NBTLoot;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.util.Random;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe implements IMegaLoot {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(
			Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, 
			Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, 
			Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, 
			Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, 
			Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, 
			Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, 
			Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, 
			Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, 
			Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE
	);
	
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
	
	@Override
    public int getMaxDamage(ItemStack stack) {
		return NBTItemPickaxe.getDurabilityNBT(stack);   	
    }
    
	@Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? getDestroySpeedTool(stack, state) : NBTItemPickaxe.getEfficiencyNBT(stack);
    }
    
    public float getDestroySpeedTool(ItemStack stack, IBlockState state) {
        for (String type : getToolClasses(stack)) {
            if (state.getBlock().isToolEffective(type, state)) {return NBTItemPickaxe.getEfficiencyNBT(stack);}
        }
        return this.EFFECTIVE_ON.contains(state.getBlock()) ? NBTItemPickaxe.getEfficiencyNBT(stack) : 1.0F;
    }
	
    //Generate tooltips
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn) {		
		if(GuiScreen.isShiftKeyDown()) {

		} else {
			tooltip.add(TextFormatting.RESET + "" + "Pickaxe");		
			tooltip.add(TextFormatting.GRAY + "" + ItemStack.DECIMALFORMAT.format(NBTItemPickaxe.getEfficiencyNBT(stack)) + " Mining Speed");		
			tooltip.add(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "Shift" + TextFormatting.DARK_GRAY + " for more...");
		}
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
