package com.armctec.nl.tools.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.tools.reference.ModConfig;
import com.armctec.nl.tools.reference.Names;

public class ModItemsClient 
{
	public static void init()
	{
		// Ingots
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.COPPER_PICKAXE, 0);
	}
}
