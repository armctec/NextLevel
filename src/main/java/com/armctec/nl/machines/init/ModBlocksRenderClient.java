package com.armctec.nl.machines.init;

import com.armctec.nl.machines.render.TileEntityRenderBarril;
import com.armctec.nl.machines.tileentity.TileEntityBarril;

import net.minecraftforge.fml.client.registry.ClientRegistry;


public class ModBlocksRenderClient 
{
	public static void init()
	{
		// Todo
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarril.class, new TileEntityRenderBarril());
	}
}
