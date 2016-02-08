package com.armctec.nl.machines.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockBasicContainer;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.handler.GuiHandlerGrindstone;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

public class BlockGrindstone extends BlockBasicContainer 
{
	public static final PropertyInteger POSICAO = PropertyInteger.create("posicao", 0, 4);

	public BlockGrindstone() 
	{
		super();
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.GRINDSTONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(POSICAO, 0));
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
		//ModConfig.Log.info("getStateFromMeta");
		//return this.getDefaultState().withProperty(POSICAO, Integer.valueOf(meta & 3));
		return this.getDefaultState();
    }	
	
	@SideOnly(Side.CLIENT)
	@Override
    public IBlockState getStateForEntityRender(IBlockState state)
    {
		//ModConfig.Log.info("getStateForEntityRender");
		//return this.getDefaultState().withProperty(POSICAO, 0);
		return this.getDefaultState();
    }
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity != null)
		{
			if(tileentity instanceof TileEntityGrindstone)
			{
				TileEntityGrindstone tilegrid = (TileEntityGrindstone)tileentity;
				if(tilegrid.getItemGrinder() == false)
				{
					return this.getDefaultState().withProperty(POSICAO, 4);
				}
				//ModConfig.Log.info("getActualState:"+tilegrid.getPosicao());
				return this.getDefaultState().withProperty(POSICAO, tilegrid.getPosicao());
			}
		}
		
		ModConfig.Log.info("getActualState: failed entity");
		//return this.getDefaultState().withProperty(POSICAO, getMetaFromState(state));
		return this.getDefaultState();
	}
	/**
     * Convert the BlockState into the correct metadata value
     */
	@Override
    public int getMetaFromState(IBlockState state)
    {
		//ModConfig.Log.info("getMetaFromState");
    	return ((Integer)state.getValue(POSICAO)).intValue() & 3;
    }

	@Override
    protected BlockState createBlockState()
    {
		//ModConfig.Log.info("createBlockState");
		return new BlockState(this, new IProperty[] {POSICAO});
    }	
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
		setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
	
	@Override
    public boolean isOpaqueCube() 
    {
    	return false;
    }	
    
    @Override
    public boolean isFullCube()
    {
        return false;
    }    
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }	
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	// Update client
    	if(playerIn.isSneaking())
    	{
    		if(!worldIn.isRemote)
    		{
    			int posicao_ang = 0;
    		
    			TileEntity tileentity = worldIn.getTileEntity(pos);
    			if(tileentity != null && tileentity instanceof TileEntityGrindstone)
    			{
    				TileEntityGrindstone tilegrid = (TileEntityGrindstone)tileentity;
    				posicao_ang = tilegrid.getPosicao();
    		
    				if(posicao_ang<3)
    					posicao_ang++;
    				else
    					posicao_ang = 0;
    				//ModConfig.Log.info("?:"+posicao_ang);
    				tilegrid.setPosicao(posicao_ang);
    			}
    			worldIn.markBlockForUpdate(pos);
    			//worldIn.scheduleUpdate(pos, this, 0);
    		}
    		else
    		{
        		//worldIn.markBlockForUpdate(pos);
    			//worldIn.markBlockRangeForRenderUpdate(pos, pos);
    		}
    	}
    	
    	
    	if(!worldIn.isRemote) 
    	{
    		if(!playerIn.isSneaking()) 
    		{
    			playerIn.openGui(MachinesNL.instance, GuiHandlerGrindstone.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
    		}
    	}

    	
    	//worldIn.markBlockForUpdate(pos);
    	
    	return true;
    }
    
    // Called when the block is placed or loaded client side to get the tile entity for the block
 	// Should return a new instance of the tile entity for the block
 	@Override
 	public TileEntity createNewTileEntity(World worldIn, int meta) 
 	{
 		return new TileEntityGrindstone(Names.Entities.ENTITY_GRINDSTONE);
 	}
 	
 	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
 		TileEntity inventory = null;
 		
		inventory =  worldIn.getTileEntity(pos);
 		if(inventory instanceof IInventory)
 		{
 			ModConfig.Log.info("Inventorio encontrado");
 			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) inventory);
 		}
 		else
 			ModConfig.Log.info("Inventorio nao encontrado");

 		super.breakBlock(worldIn, pos, state);
	}   
 	
 	public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.Grindstone);
    }    
}
