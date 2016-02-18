package com.armctec.nl.machines.block;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityDropParticleFX.WaterFactory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockAdvanced;
import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.general.utility.UtilityFunctions;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityBarril;
import com.armctec.nl.machines.tileentity.TileEntityBomba;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

public class BlockBarril extends BlockAdvanced implements ITileEntityProvider, IFluidBlock
{
	public static final int capacity = FluidContainerRegistry.BUCKET_VOLUME * 2;
	
	public BlockBarril()
	{
		super();
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		setBlockName(ModConfig.MOD_ID, Names.Blocks.BARRIL);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		ItemStack current = playerIn.inventory.getCurrentItem();
		FluidStack liquid = null;
		
		if(!worldIn.isRemote)
    	{
			TileEntityBarril tilebarril = getTileEntity(worldIn, pos);
			if(tilebarril != null)
			{		
				// Handle FluidContainerRegistry
		        if (FluidContainerRegistry.isContainer(current))
		        {
		            liquid = FluidContainerRegistry.getFluidForFilledItem(current);
		            // Handle filled containers
		            if (liquid == null)
		            {
		            	ItemStack filled = FluidContainerRegistry.fillFluidContainer(tilebarril.getFluid(), current);
		            	liquid = FluidContainerRegistry.getFluidForFilledItem(filled);
		            	if(liquid != null)
		            	{
		            		playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, filled);
		            		tilebarril.drain(null, liquid.amount, true);
			            	ModConfig.Log.info("Quant:"+ liquid.amount);
		            	}
		            }
		            else
		            {
						int quant = tilebarril.fill(null, liquid, true);
						if(quant != 0)
						{
							if(!playerIn.capabilities.isCreativeMode)
							{
								ItemStack newitem = FluidContainerRegistry.drainFluidContainer(current);
								playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, newitem);
							}
						}
						ModConfig.Log.info("Quant:"+ quant);
		            }
		        }
		        //tilebarril.updateComparator();
		        
		        /** Garante atualizacao do comparator */
		        worldIn.markBlockForUpdate(pos);
		        worldIn.updateComparatorOutputLevel(pos, this);
    		}
    	}

		return true;
	}	
	
	public TileEntityBarril getTileEntity(IBlockAccess worldIn, BlockPos pos)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity != null)
		{
			if(tileentity instanceof TileEntityBarril)
			{
				return (TileEntityBarril)tileentity;
			}
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT_MIPPED;
    }
	
	public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
    	TileEntityBarril tilebarril = getTileEntity(worldIn, pos);
    	if(tilebarril!=null)
    	{
    		//ModConfig.Log.info("getComparator()");
    		return tilebarril.getComparator();
    	}
    	return 0; 
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    	super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    	
    	TileEntityBarril tilebarril = getTileEntity(worldIn, pos);
    	if(tilebarril != null)
    	{
    		NBTTagCompound nbt = stack.getTagCompound();
    		
    		if(nbt!=null)
    		{
    			int amount = nbt.getInteger("Amount");
    			String fluidName = nbt.getString("FluidName");
    			if(fluidName!=null && amount>0)
    			{
    				Fluid fluid_item = FluidRegistry.getFluid(fluidName);
    				if(fluid_item != null)
    				{
    					FluidStack flstack = new FluidStack(fluid_item, amount);
    					tilebarril.fill(null, flstack, true);
    				}
    			}
    		}
    	}
    	
    }
    
	@Override
	public void fillWithRain(World worldIn, BlockPos pos) 
	{
		super.fillWithRain(worldIn, pos);
	}
 
    // Called when the block is placed or loaded client side to get the tile entity for the block
 	public TileEntity createNewTileEntity(World worldIn, int meta) 
 	{
 		ModConfig.Log.info("createNewTileEntity");
 		return new TileEntityBarril(Names.Entities.ENTITY_BARRIL, capacity);
 	}
 	
 	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
 		TileEntityBarril fluidsblock = getTileEntity(worldIn, pos);

 		if(!worldIn.isRemote)
 		{
 			if(fluidsblock!=null)
 			{
 				ItemStack itembarril = new ItemStack(ModBlocks.Barril);
 		
 				ModConfig.Log.info("Barril encontrado");
 			
 				NBTTagCompound nbttank = new NBTTagCompound();
 				NBTTagCompound nbtstack = new NBTTagCompound();
 				
 				fluidsblock.writeToNBT(nbttank);
 				
 				String nomeFluid = nbttank.getString("FluidName");
 				int quantFluid = nbttank.getInteger("Amount");
 				
 				nbtstack.setString("FluidName",nomeFluid);
 				nbtstack.setInteger("Amount",quantFluid);
 				
 				if(!nomeFluid.isEmpty())
 				{
 	 				itembarril.setTagCompound(nbtstack); 					
 				}
 			
 				UtilityFunctions.spawnItemStack(worldIn, pos, itembarril);
 			}
 			else
 				ModConfig.Log.info("Barril nao encontrado");
 		}
 		
 		super.breakBlock(worldIn, pos, state);
	}
 	
 	@Override
 	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
 	{
 		return null;
 	}
 	
	@Override
	public Fluid getFluid()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FluidStack drain(World world, BlockPos pos, boolean doDrain)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canDrain(World world, BlockPos pos)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getFilledPercentage(World world, BlockPos pos) 
	{
		// TODO Auto-generated method stub
		return 0;
	} 
}
