package com.armctec.nl.ores.item;

import net.minecraft.item.ItemStack;

import com.armctec.nl.general.item.ItemBasic;
import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;

public class ItemIngot extends ItemBasic
{
	public ItemIngot(String name, int StackSize) 
	{
		super();
		setItemName(ModConfig.MOD_ID, name);
		this.setMaxStackSize(StackSize);
		this.setCreativeTab(CreativeTabOres.ORES_TAB);
	}
	
	@Override
	public boolean isBeaconPayment(ItemStack stack) 
	{
		return true;
	}	
}
