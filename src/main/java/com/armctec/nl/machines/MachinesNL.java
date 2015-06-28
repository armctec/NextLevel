package com.armctec.nl.machines;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.machines.handler.ConfigurationHandler;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.init.ModBlocksClient;
import com.armctec.nl.machines.init.ModRecipes;
import com.armctec.nl.machines.init.ModTileEntity;
import com.armctec.nl.machines.init.ModNetwork;
import com.armctec.nl.machines.proxy.CommonProxy;
import com.armctec.nl.machines.reference.ModConfig;

@Mod(modid = ModConfig.MOD_ID, name = ModConfig.MOD_NAME, version = ModConfig.MOD_VERSION, guiFactory = ModConfig.GUI_FACTORY_CLASS, dependencies=ModConfig.DEPENDENCIES)
public class MachinesNL 
{
	LogHelper Log = ModConfig.Log;
	
	@Mod.Instance(value = ModConfig.MOD_ID)
    public static MachinesNL instance;
	
	@SidedProxy(clientSide = ModConfig.CLIENT_PROXY_CLASS, serverSide = ModConfig.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
        //ModItems.init();
		ModBlocks.init();
		ModTileEntity.init();
		ModNetwork.init();

		proxy.preInit();

		//GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
		
		Log.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
	{
        if(event.getSide().isClient() == true)
        {
        	//ModItemsClient.init();
        	ModBlocksClient.init();
        }
        
        ModRecipes.init();
        
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
