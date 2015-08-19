package com.armctec.nl.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.tools.handler.ConfigurationHandler;
import com.armctec.nl.tools.init.ModItems;
import com.armctec.nl.tools.init.ModItemsClient;
import com.armctec.nl.tools.init.ModRecipes;
import com.armctec.nl.tools.item.material.Tools;
import com.armctec.nl.tools.proxy.CommonProxy;
import com.armctec.nl.tools.reference.ModConfig;

@Mod(modid = ModConfig.MOD_ID, name = ModConfig.MOD_NAME, version = ModConfig.MOD_VERSION, guiFactory = ModConfig.GUI_FACTORY_CLASS, dependencies=ModConfig.DEPENDENCIES)
public class ToolsNL 
{
	LogHelper Log = ModConfig.Log;
	
	@Mod.Instance(value = ModConfig.MOD_ID)
    public static ToolsNL instance;
	
	@SidedProxy(clientSide = ModConfig.CLIENT_PROXY_CLASS, serverSide = ModConfig.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		
        ModItems.init();
        Tools.init();
		//ModBlocks.init();

		proxy.preInit();

		//GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
		
		Log.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
	{
        if(event.getSide().isClient() == true)
        {
        	ModItemsClient.init();
        	//ModBlocksClient.init();
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
