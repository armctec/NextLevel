package com.armctec.nl.test;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.test.command.server.CommandTeleportDimension;
import com.armctec.nl.test.events.Event_InitBiomeGens;
import com.armctec.nl.test.events.Event_PopulateEventChunk;
import com.armctec.nl.test.init.ModBlocks;
import com.armctec.nl.test.init.ModBlocksClient;
import com.armctec.nl.test.init.ModEvents;
import com.armctec.nl.test.init.ModFluids;
import com.armctec.nl.test.init.ModItems;
import com.armctec.nl.test.init.ModItemsClient;
import com.armctec.nl.test.init.ModWorld;
import com.armctec.nl.test.proxy.CommonProxy;
import com.armctec.nl.test.reference.ModConfig;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ModConfig.MOD_ID, name = ModConfig.MOD_NAME, version = ModConfig.MOD_VERSION)
public class TestBlocks 
{
	// Static Calls
	//{
	//	FluidRegistry.enableUniversalBucket();
	//}
	
	LogHelper Log = ModConfig.Log;
	
	@Mod.Instance(ModConfig.MOD_ID)
    public static TestBlocks instance;
	
	@SidedProxy(clientSide = ModConfig.CLIENT_PROXY_CLASS, serverSide = ModConfig.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModBlocks.init();
		ModFluids.init();
		
		ModEvents.init();

		if(event.getSide().isClient() == true)
        {
			// Precisa estar no preinit
			ModFluids.initclient();
        }
		
		ModWorld.init();
		
		//ServerCommandManager mananger = (ServerCommandManager) MinecraftServer.getServer().getCommandManager();
		//mananger.registerCommand(new CommandTeleportDimension());
		
		proxy.preInit();
		Log.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandTeleportDimension());
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
	{
		if(event.getSide().isClient() == true)
        {
			ModItemsClient.init();
			ModBlocksClient.init();
        }
		
        proxy.init();
        Log.info("Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		MinecraftForge.TERRAIN_GEN_BUS.register(new Event_InitBiomeGens());
		MinecraftForge.EVENT_BUS.register(new Event_PopulateEventChunk());
		
		proxy.postInit();
        Log.info("Post Initialization Complete!");
    }
	
}