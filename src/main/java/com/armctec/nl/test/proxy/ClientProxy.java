package com.armctec.nl.test.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import com.armctec.nl.test.init.ModBlocksClient;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() 
	{

	}

	@Override
	public void init() 
	{

	}

	@Override
	public void postInit() 
	{

	}

	@Override
	public EntityPlayer getClientPlayer() {
		return Minecraft.getMinecraft().thePlayer;
	}

}
