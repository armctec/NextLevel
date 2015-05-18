package com.armctec.nl.ores.block;

import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;

public class BlockOre extends BlockBasic
{
	public BlockOre(String NameBlock, int ToolLevel)
	{
		super();
		this.setCreativeTab(CreativeTabOres.ORES_TAB);
		setBlockName(ModConfig.MOD_ID, NameBlock);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", ToolLevel);
	}
	
	public BlockOre(String NameBlock, String NameTool, int ToolLevel)
	{
		super();
		this.setCreativeTab(CreativeTabOres.ORES_TAB);
		setBlockName(ModConfig.MOD_ID, NameBlock);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel(NameTool, ToolLevel);
	}	
}
