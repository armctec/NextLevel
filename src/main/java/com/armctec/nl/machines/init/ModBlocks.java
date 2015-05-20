package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.machines.block.BlockAdvancedCraftingTable;
import com.armctec.nl.machines.reference.Names;


public class ModBlocks 
{
	public final static BlockAdvancedCraftingTable AdvancedCraftingTable = new BlockAdvancedCraftingTable();
	
	public static void init()
	{
		// Ores
        GameRegistry.registerBlock(AdvancedCraftingTable, Names.Blocks.ADVANCED_CRAFTING_TABLE);
	}
}
