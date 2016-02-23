package com.armctec.nl.test.init;

import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.test.reference.Names;
import com.armctec.nl.test.item.BucketOil;

public class ModItems 
{
	public final static BucketOil oil_bucket = new BucketOil();
	
	public static void init()
	{
		GameRegistry.registerItem(oil_bucket, Names.Items.OIL_BUCKET);
	}
}
