package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.machines.item.ToolGrindstone;
import com.armctec.nl.machines.reference.Names;

public class ModItems
{
	public final static ToolGrindstone ToolGrind = new ToolGrindstone();
	
	public static void init()
	{
		GameRegistry.registerItem(ToolGrind, Names.Items.TOOLGRINDER);
	}
}
