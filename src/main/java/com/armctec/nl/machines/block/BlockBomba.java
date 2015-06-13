package com.armctec.nl.machines.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.network.play.server.S22PacketMultiBlockChange.BlockUpdateData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockBasicContainer;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.handler.GuiHandlerAdvancedCrafting;
import com.armctec.nl.machines.handler.GuiHandlerGrindstone;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityBomba;


public class BlockBomba extends BlockBasicContainer 
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger POSICAO = PropertyInteger.create("posicao", 0, 1);
	
	public BlockBomba() 
	{
		super();
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.BOMBA);
		setHarvestLevel("pickaxe", 0);	// Stone Pickaxe
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(POSICAO, 0).withProperty(FACING, EnumFacing.NORTH));
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		EnumFacing enumfacing1 = placer.getHorizontalFacing().rotateY();
		
		System.out.println("Facing:"+enumfacing1.toString());
		
		return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(POSICAO, 0).withProperty(FACING, enumfacing1);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
		//ModConfig.Log.info("getStateFromMeta");
		//return this.getDefaultState().withProperty(POSICAO, Integer.valueOf(meta & 1)).withProperty(FACING, EnumFacing.getHorizontal(meta >> 1));
		
		return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3)).withProperty(POSICAO, Integer.valueOf(meta & 1)>>2);
    }	
	
	@SideOnly(Side.CLIENT)
	@Override
    public IBlockState getStateForEntityRender(IBlockState state)
    {
		//ModConfig.Log.info("getStateForEntityRender");
		return this.getDefaultState().withProperty(POSICAO, 0).withProperty(FACING, state.getValue(FACING));
    }
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if(tileentity != null)
		{
			if(tileentity instanceof TileEntityBomba)
			{
				TileEntityBomba tilegrid = (TileEntityBomba)tileentity;
			
				//ModConfig.Log.info("getActualState:"+tilegrid.getPosicao());
				return this.getDefaultState().withProperty(POSICAO, tilegrid.getPosicao()).withProperty(FACING, state.getValue(FACING));
						
						
			}
		}
		
		ModConfig.Log.info("getActualState: failed entity");
		return this.getDefaultState().withProperty(POSICAO, 0).withProperty(FACING, state.getValue(FACING));
	}
	/**
     * Convert the BlockState into the correct metadata value
     */
	@Override
    public int getMetaFromState(IBlockState state)
    {
    	byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        i |= ((Integer)state.getValue(POSICAO)).intValue() << 2;
        return i;
    }

	@Override
    protected BlockState createBlockState()
    {
		//ModConfig.Log.info("createBlockState");
		return new BlockState(this, new IProperty[] {POSICAO, FACING});
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
    			if(tileentity != null && tileentity instanceof TileEntityBomba)
    			{
    				TileEntityBomba tilegrid = (TileEntityBomba)tileentity;
    				posicao_ang = tilegrid.getPosicao();
    		
    				if(posicao_ang<1)
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
 		return new TileEntityBomba(Names.Entites.ENTITY_BOMBA);
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
        return Item.getItemFromBlock(ModBlocks.Bomba);
    }    
}
