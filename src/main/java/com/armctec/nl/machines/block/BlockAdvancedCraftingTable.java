package com.armctec.nl.machines.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.armctec.nl.general.block.BlockBasicContainer;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.handler.GuiHandlerAdvancedCrafting;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;

public class BlockAdvancedCraftingTable extends BlockBasicContainer
{
	public BlockAdvancedCraftingTable() 
	{
		super(Material.wood);
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.ADVANCED_CRAFTING_TABLE);
		setStepSound(soundTypeWood);
		setHarvestLevel("pickaxe",-1);
		setHarvestLevel("axe", 0);
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	playerIn.openGui(MachinesNL.instance, GuiHandlerAdvancedCrafting.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }
	
	// Called when the block is placed or loaded client side to get the tile entity for the block
	// Should return a new instance of the tile entity for the block
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityAdvancedCrafting(Names.Entities.ENTITY_ADVANCED_CRAFTING);
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
