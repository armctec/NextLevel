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
import com.armctec.nl.test.init.ModBlocks;
import com.armctec.nl.test.init.ModFluids;
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
		ModBlocks.init();
		ModFluids.preinit();
		
		if(event.getSide().isClient() == true)
        {
			ModFluids.preinitclient();	
        }
		
		
		MinecraftForge.EVENT_BUS.register(this);
		
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
	
    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        IBlockState state = event.world.getBlockState(event.target.getBlockPos());
        if (state.getBlock() instanceof IFluidBlock)
        {
            Fluid fluid = ((IFluidBlock) state.getBlock()).getFluid();
            FluidStack fs = new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME);

            ItemStack filled = FluidContainerRegistry.fillFluidContainer(fs, event.current);
            if (filled != null)
            {
                event.result = filled;
                event.world.setBlockToAir(event.target.getBlockPos());

                event.setResult(Result.ALLOW);
            }
        }
        
        //Log.info("onBucketFill");
    }
    
    @SubscribeEvent
    public void onBucketEmpty(PlayerUseItemEvent.Start event)
    {
    	ItemStack current = event.entityPlayer.inventory.getCurrentItem();
    	if(current != null)
    	{
    		if(current.getItem() == Items.milk_bucket)
    		{
    			EntityPlayer playerIn = event.entityPlayer;
    			World worldIn = playerIn.worldObj;
    			
    			if(playerIn.isSneaking())
    			{
    				MovingObjectPosition mop = UtilityFunctions.getMovingObjectPositionFromPlayer(worldIn, playerIn, false);
    				if (mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
    		        {
    					BlockPos pos = mop.getBlockPos().offset(mop.sideHit);
    					// can we place liquid there?
    		            if (worldIn.isBlockModifiable(playerIn, pos))
    		            {
    		            	Material material = worldIn.getBlockState(pos).getBlock().getMaterial();

    		            	if(material.isLiquid())
    		            	{
    		            		IBlockState stateWorld = worldIn.getBlockState(pos); 
    		            		Block blockWorld = stateWorld.getBlock();
    		            		
    		            		if(blockWorld instanceof BlockLiquid)
    		            		{
    		            			if(((Integer)stateWorld.getValue(BlockLiquid.LEVEL)).intValue() == 0)
    		            				return;
    		            		}
    	            			if (blockWorld instanceof BlockFluidBase)
    	            			{
    		            			if(((Integer)stateWorld.getValue(BlockFluidBase.LEVEL)).intValue() == 0)
    		            				return;
    	            			}
    		            	}
    		            	
    		            	FluidStack liquid_1 = FluidContainerRegistry.getFluidForFilledItem(current);
    	            	
    		            	if(liquid_1!=null)
    		            	{
    		            		Block fluid = liquid_1.getFluid().getBlock();
    	            			
    		            		if (!worldIn.isRemote && !material.isSolid() && !material.isLiquid())
    		            			worldIn.destroyBlock(pos, true);
    		            			
    		            		IBlockState state = fluid.getDefaultState();

    		            		worldIn.setBlockState(pos, state, 3);

    		            		// Nao sei como atualizar a nao ser assim
    		            		if (fluid instanceof BlockLiquid)
    		            			((BlockLiquid)fluid).onNeighborBlockChange(worldIn, pos, state, null);
    		            			
    		            		if (fluid instanceof BlockFluidBase)
    		            			((BlockFluidBase)fluid).onNeighborBlockChange(worldIn, pos, state, null);
    		            		
    		            		ItemStack newitem = FluidContainerRegistry.drainFluidContainer(current);
    		            		playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, newitem);

    		            		event.setResult(Result.ALLOW);
    		            		event.setCanceled(false);
    		            		// Prevent for duplications
    		            		event.duration = 10;
    		            		
    		            		return;
    		            	}
    		            }
    		        }
    				//Log.info("onBucketEmpty");
    			}
    		}
    	}
    }
}