package com.armctec.nl.test.init;

import com.armctec.nl.test.events.Event_onBucketFill;

import net.minecraftforge.common.MinecraftForge;

public class ModEvents 
{
	public static void init()
	{
		//MinecraftForge.EVENT_BUS.register(new Event_onBucketEmpty());
		MinecraftForge.EVENT_BUS.register(new Event_onBucketFill());
	}
}
