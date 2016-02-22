package com.armctec.nl.test.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.reference.Names;

public class ModItemsClient 
{
	public static void init()
	{
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.OIL_BUCKET);
	}
}