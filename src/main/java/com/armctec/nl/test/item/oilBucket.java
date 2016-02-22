package com.armctec.nl.test.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.armctec.nl.general.item.ItemBasic;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.test.gui.CreativeTabTest;
import com.armctec.nl.test.reference.Names;

public class oilBucket extends ItemBasic 
{
	public oilBucket() 
	{
		setItemName(ModConfig.MOD_ID, Names.Items.OIL_BUCKET);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabTest.TEST_TAB);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		return true;
	}
}
