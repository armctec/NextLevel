package com.armctec.nl.machines.block;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.entities.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.gui.GuiHandlerAdvancedCrafting;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.reference.ModConfig;

public class BlockAdvancedCraftingTable extends BlockBasic implements ITileEntityProvider
{
	public BlockAdvancedCraftingTable() 
	{
		super();
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.ADVANCED_CRAFTING_TABLE);
		setResistance(2.0F);
		setHardness(2.5F);
		setStepSound(soundTypeWood);
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
		return new TileEntityAdvancedCrafting(Names.Entites.ENTITY_ADVANCED_CRAFTING, 9);
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
			for (int i = 0; i < inventory.getSizeInventory(); i++)
			{
				// If the slot is not empty
				if (inventory.getStackInSlot(i) != null)
				{
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
		// Linhas Abaixo sao Necessárias: BlockContainer
		super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }
	
    /**
     * Called on both Client and Server when World#addBlockEvent is called
     */
    public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam)
    {
        super.onBlockEventReceived(worldIn, pos, state, eventID, eventParam);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(eventID, eventParam);
    }	
}
