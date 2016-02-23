package com.armctec.nl.test.events;

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
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;

import com.armctec.nl.general.utility.UtilityFunctions;
import com.armctec.nl.test.init.ModItems;
import com.armctec.nl.test.reference.ModConfig;

public class Event_onBucketEmpty
{
    @SubscribeEvent
    public void onBucketEmpty(PlayerUseItemEvent.Start event)
    {
    	if(!event.entityPlayer.worldObj.isRemote)
    		return;
    	
    	ItemStack current = event.entityPlayer.inventory.getCurrentItem();
    	if(current != null)
    	{
    		ModConfig.Log.info("onBucketEmpty");
    		
    		if(current.getItem() == Items.milk_bucket || current.getItem() == ModItems.oil_bucket)
    		{
    			ModConfig.Log.info("onBucketEmpty");
    			
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
    	            			
    		            		//if (!worldIn.isRemote && !material.isSolid() && !material.isLiquid())
    		            		//	worldIn.destroyBlock(pos, true);
    		            			
    		            		IBlockState state = fluid.getDefaultState();

    		            		worldIn.setBlockState(pos, state, 3);

    		            		// Nao sei como atualizar a nao ser assim
    		            		if (fluid instanceof BlockLiquid)
    		            			((BlockLiquid)fluid).onNeighborBlockChange(worldIn, pos, state, null);
    		            			
    		            		if (fluid instanceof BlockFluidBase)
    		            			((BlockFluidBase)fluid).onNeighborBlockChange(worldIn, pos, state, null);
    		            		
        		            	if(!worldIn.isRemote)
        		            	{
        		            		ItemStack newitem = FluidContainerRegistry.drainFluidContainer(current);
        		            		playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, newitem);
        		            		playerIn.inventory.markDirty();
        		            	}
    		            		
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
