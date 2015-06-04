package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

public class ModTileEntity 
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityAdvancedCrafting.class, Names.Entites.ENTITY_ADVANCED_CRAFTING);
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, Names.Entites.ENTITY_GRINDSTONE);
	}

}
