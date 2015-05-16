package com.armctec.nl.ores.block;

import java.util.Collection;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockAdvanced;
import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.general.reference.ToolRef;
import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.ores.reference.Names;
import com.google.common.collect.ImmutableMap;

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
