package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.machines.block.BlockAdvancedCraftingTable;
import com.armctec.nl.machines.block.BlockBomba;
import com.armctec.nl.machines.block.BlockGrindstone;
import com.armctec.nl.machines.reference.Names;


public class ModBlocks 
{
	public final static BlockAdvancedCraftingTable AdvancedCraftingTable = new BlockAdvancedCraftingTable();
	public final static BlockGrindstone Grindstone = new BlockGrindstone();
	public final static BlockBomba Bomba = new BlockBomba();
	
	public static void init()
	{
		// Machines
        GameRegistry.registerBlock(AdvancedCraftingTable, Names.Blocks.ADVANCED_CRAFTING_TABLE);
        GameRegistry.registerBlock(Grindstone, Names.Blocks.GRINDSTONE);
        GameRegistry.registerBlock(Bomba, Names.Blocks.BOMBA);
	}
}
