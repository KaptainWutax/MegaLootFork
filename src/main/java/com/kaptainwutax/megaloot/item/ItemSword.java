package com.kaptainwutax.megaloot.item;

import com.kaptainwutax.megaloot.helper.IMegaLoot;
import com.kaptainwutax.megaloot.utility.Reference;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class ItemSword extends net.minecraft.item.ItemSword implements IMegaLoot {

	public ItemSword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(Reference.MOD_ID, name);
		this.setUnlocalizedName(name);
		this.setNoRepair();
	}
	
	@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {		
        return false;
    }

}
