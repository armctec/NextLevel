package com.armctec.nl.machines.entities;

import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.reference.ModConfig;

public class TileEntityAdvancedCrafting extends TileEntityBasicInventory 
{
	public TileEntityAdvancedCrafting(String NameEntity, int num_slots) 
	{
		super(NameEntity, num_slots);
		// TODO Auto-generated constructor stub
		ModConfig.Log.info("TileEntity Created: Name:"+NameEntity+", NumSlots:"+num_slots);
	}
	
	public TileEntityAdvancedCrafting()
	{
		super();
	}

}
