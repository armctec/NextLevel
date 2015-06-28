package com.armctec.nl.tools.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.tools.item.Pickaxe;
import com.armctec.nl.tools.item.Tools;
import com.armctec.nl.tools.reference.Names;

public class ModItems 
{
	public final static Pickaxe CopperPickaxe = new Pickaxe(Names.Items.COPPER_PICKAXE, Tools.COPPER);
	
	public static void init()
	{
		GameRegistry.registerItem(CopperPickaxe, Names.Items.COPPER_PICKAXE);	// Register Minecraft
	}
}
