package com.armctec.nl.machines.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;

public class ModItemsClient 
{
	public static void init()
	{
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.TOOLGRINDER, 0);
	}
}
