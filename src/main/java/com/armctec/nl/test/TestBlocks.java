package com.armctec.nl.test;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.general.utility.UtilityFunctions;
import com.armctec.nl.test.events.Event_onBucketEmpty;
import com.armctec.nl.test.init.ModBlocks;
import com.armctec.nl.test.init.ModEvents;
import com.armctec.nl.test.init.ModFluids;
import com.armctec.nl.test.init.ModItems;
import com.armctec.nl.test.init.ModItemsClient;
import com.armctec.nl.test.proxy.CommonProxy;
import com.armctec.nl.test.reference.ModConfig;

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
		ModFluids.preinit();
		ModEvents.init();

		if(event.getSide().isClient() == true)
        {
			ModFluids.preinitclient();
        }
		
		proxy.preInit();
		Log.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
    public void init(FMLInitializationEvent event)
	{
		if(event.getSide().isClient() == true)
        {
			ModItemsClient.init();
        }
		
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