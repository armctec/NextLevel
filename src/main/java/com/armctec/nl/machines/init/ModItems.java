package com.armctec.nl.machines.init;

import com.armctec.nl.machines.item.ToolGrindstone;
import com.armctec.nl.machines.reference.Names;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
	public final static ToolGrindstone ToolGrind = new ToolGrindstone();
	//public final static ItemBarril BarrilItem = new ItemBarril(); 
	
	public static void init()
	{
		GameRegistry.registerItem(ToolGrind, Names.Items.TOOLGRINDER);
		//GameRegistry.registerItem(BarrilItem, Names.Items.ITEMBARRIL);
	}
}
