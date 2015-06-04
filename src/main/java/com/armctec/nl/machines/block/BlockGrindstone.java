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
import net.minecraft.inventory.IInventory;
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
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

public class BlockGrindstone extends BlockBasicContainer 
{
	public static final PropertyInteger POSICAO = PropertyInteger.create("posicao", 0, 3);
	
	public BlockGrindstone() 
	{
		super();
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.GRINDSTONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(POSICAO, 0));
		setHarvestLevel("pickaxe", 0);	// Stone Pickaxe
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	{
		return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(POSICAO, 0);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POSICAO, Integer.valueOf(meta & 3));
    }	
	
	@SideOnly(Side.CLIENT)
	@Override
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(POSICAO, 0);
    }
	
	/**
     * Convert the BlockState into the correct metadata value
     */
	@Override
    public int getMetaFromState(IBlockState state)
    {
    	return ((Integer)state.getValue(POSICAO)).intValue() & 3;
    }

	@Override
    protected BlockState createBlockState()
    {
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
    	if(!worldIn.isRemote) 
    	{
    		if(playerIn.isSneaking()) 
    		{
    			int posicao =  (((Integer)state.getValue(POSICAO)).intValue() + 1) & 3;
    			worldIn.setBlockState(pos, state.withProperty(POSICAO, Integer.valueOf(MathHelper.clamp_int(posicao, 0, 3))), 2);
    		}
    		else
    		{
    			playerIn.openGui(MachinesNL.instance, GuiHandlerGrindstone.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
    		}
    	}
    	return true;
    }
    
 // Called when the block is placed or loaded client side to get the tile entity for the block
 	// Should return a new instance of the tile entity for the block
 	@Override
 	public TileEntity createNewTileEntity(World worldIn, int meta) 
 	{
 		return new TileEntityGrindstone(Names.Entites.ENTITY_GRINDSTONE);
 	}
 	
 	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
     {
 		IInventory inventory = null;
 		
 		
 		if(worldIn.getTileEntity(pos) instanceof IInventory)
 		{
 			ModConfig.Log.info("Inventorio encontrado");
 			inventory =  (IInventory)worldIn.getTileEntity(pos);
 		}
 		else
 			ModConfig.Log.info("Inventorio nao encontrado");

 		if (inventory != null)
 		{
 			// For each slot in the inventory
 			
 			ModConfig.Log.info("Inventorio tamanho:"+inventory.getSizeInventory());
 			
 			for (int i = 0; i < inventory.getSizeInventory(); i++)
 			{
 				// If the slot is not empty
 				if (inventory.getStackInSlot(i) != null)
 				{
 					ModConfig.Log.info("Inventorio item "+i+":"+inventory.getStackInSlot(i).toString());
 					
 					// Create a new entity item with the item stack in the slot
 					EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

 					// Apply some random motion to the item
 					float multiplier = 0.1f;
 					float motionX = worldIn.rand.nextFloat() - 0.5f;
 					float motionY = worldIn.rand.nextFloat() - 0.5f;
 					float motionZ = worldIn.rand.nextFloat() - 0.5f;

 					item.motionX = motionX * multiplier;
 					item.motionY = motionY * multiplier;
 					item.motionZ = motionZ * multiplier;

 					// Spawn the item in the world
 					worldIn.spawnEntityInWorld(item);
 				}
 			}

 			// Clear the inventory so nothing else (such as another mod) can do anything with the items
 			inventory.clear();
 		}
 		
 		super.breakBlock(worldIn, pos, state);
     }    
}
