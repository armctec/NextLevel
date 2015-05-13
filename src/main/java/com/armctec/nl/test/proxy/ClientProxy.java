package com.armctec.nl.test.proxy;

import com.armctec.nl.test.init.ModBlocksClient;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() 
	{

	}

	@Override
	public void init() 
	{
		ModBlocksClient.init();
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
