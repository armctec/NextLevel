package com.armctec.nl.test;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.test.configs.Reference;
import com.armctec.nl.test.init.ModBlocks;
import com.armctec.nl.test.init.ModBlocksClient;
import com.armctec.nl.test.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class TestBlocks 
{
	LogHelper Log = Reference.Log;
	
	@Mod.Instance(Reference.MOD_ID)
    public static TestBlocks instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.init();
		proxy.preInit();
		Log.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
	{
        proxy.init();
        Log.info("Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
        Log.info("Post Initialization Complete!");
    }
	
}