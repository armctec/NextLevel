package com.armctec.nl.test.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.test.reference.Names;
import com.armctec.nl.test.item.oilBucket;

public class ModItems 
{
	public final static oilBucket oil_bucket = new oilBucket();
	
	public static void init()
	{
		GameRegistry.registerItem(oil_bucket, Names.Items.OIL_BUCKET);
	}
}
