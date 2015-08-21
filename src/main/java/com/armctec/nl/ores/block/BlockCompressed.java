package com.armctec.nl.ores.block;

import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;

public class BlockCompressed extends BlockBasic 
{
	public BlockCompressed(String NameBlock, int ToolLevel)
	{
		this(NameBlock, "pickaxe", ToolLevel);
	}
	
	public BlockCompressed(String NameBlock, String NameTool, int ToolLevel)
	{
		super();
		
		this.setCreativeTab(CreativeTabOres.ORES_TAB);
		setBlockName(ModConfig.MOD_ID, NameBlock);
		setHardness(5.0F);
		setResistance(10.0F);
		setStepSound(soundTypeMetal);
		setHarvestLevel(NameTool, ToolLevel);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		// TODO Auto-generated method stub
		return true;
	}
	
}
