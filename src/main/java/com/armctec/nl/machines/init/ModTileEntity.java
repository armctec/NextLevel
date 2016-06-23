package com.armctec.nl.machines.init;

import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.tileentity.TileEntityBarril;
import com.armctec.nl.machines.tileentity.TileEntityBomba;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModTileEntity 
{
	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityAdvancedCrafting.class, Names.Entities.ENTITY_ADVANCED_CRAFTING);
		GameRegistry.registerTileEntity(TileEntityGrindstone.class, Names.Entities.ENTITY_GRINDSTONE);
		GameRegistry.registerTileEntity(TileEntityBomba.class, Names.Entities.ENTITY_BOMBA);
		GameRegistry.registerTileEntity(TileEntityBarril.class, Names.Entities.ENTITY_BARRIL);
	}

}
