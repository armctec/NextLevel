package com.armctec.nl.machines.item;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.armctec.nl.general.item.ItemBasic;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.reference.ModConfig;

public class ToolGrindstone extends ItemBasic
{
	public ToolGrindstone() 
	{
		super();
		setItemName(ModConfig.MOD_ID, Names.Items.TOOLGRINDER);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		hasSubtypes = false;
		setMaxDamage(64);
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
	{
		stack.damageItem(1, playerIn);
		return true;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{
		if(repair.getItem()!=Items.flint)
			return false;
		
		return true;
	}
}
