package com.armctec.nl.machines.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;


public class ModBlocksClient 
{
	public static void init()
	{
		// Blocks
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.ADVANCED_CRAFTING_TABLE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.GRINDSTONE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.BOMBA);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.TANQUE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.BARRIL);
	}
}
