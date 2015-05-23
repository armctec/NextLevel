package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.machines.entities.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.reference.Names;

public class ModEntities 
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityAdvancedCrafting.class, Names.Entites.ENTITY_ADVANCED_CRAFTING);
	}

}
