package com.armctec.nl.tools.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.tools.item.Pickaxe;
import com.armctec.nl.tools.item.Tools;
import com.armctec.nl.tools.reference.Names;

public class ModItems 
{
	public final static Pickaxe CopperPickaxe = new Pickaxe(Names.Items.COPPER_PICKAXE, Tools.COPPER);
	public final static Pickaxe TinPickaxe = new Pickaxe(Names.Items.TIN_PICKAXE, Tools.TIN);
	
	public static void init()
	{
		GameRegistry.registerItem(CopperPickaxe, Names.Items.COPPER_PICKAXE);
		GameRegistry.registerItem(TinPickaxe, Names.Items.TIN_PICKAXE);

	}
}
