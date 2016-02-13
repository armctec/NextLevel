package com.armctec.nl.machines.init;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.render.TileEntityRenderBarril;
import com.armctec.nl.machines.tileentity.TileEntityBarril;


public class ModBlocksRenderClient 
{
	public static void init()
	{
		// Todo
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarril.class, new TileEntityRenderBarril());
	}
}
