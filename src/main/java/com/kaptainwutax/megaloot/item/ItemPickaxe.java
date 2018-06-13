package com.kaptainwutax.megaloot.item;

import com.kaptainwutax.megaloot.helper.IMegaLoot;
import com.kaptainwutax.megaloot.init.ItemInit;
import com.kaptainwutax.megaloot.init.ModelInit;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import scala.util.Random;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe implements IMegaLoot {

	public ItemPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setNoRepair();
	}
    
}
