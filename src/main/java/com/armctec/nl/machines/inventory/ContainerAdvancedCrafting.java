package com.armctec.nl.machines.inventory;

import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.entities.TileEntityAdvancedCrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerAdvancedCrafting extends ContainerWorkbench 
{
	TileEntityAdvancedCrafting tileEntity	= null;
	
	public ContainerAdvancedCrafting(InventoryPlayer playerInventory, World worldIn, BlockPos blockPosition, TileEntityAdvancedCrafting tileEntity) 
	{
		super(playerInventory, worldIn, blockPosition);
		this.tileEntity = tileEntity;
	}

	// Vanilla calls this method every tick to make sure the player is still able to access the inventory, and if not closes the gui
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntity.isUseableByPlayer(player);
	}
	
	// pass the close container message to the tileEntityInventory (not strictly needed for this example)
	//  see ContainerChest and TileEntityChest
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
        InventoryPlayer inventoryplayer = playerIn.inventory;

        if (inventoryplayer.getItemStack() != null)
        {
            playerIn.dropPlayerItemWithRandomChoice(inventoryplayer.getItemStack(), false);
            inventoryplayer.setItemStack((ItemStack)null);
        }
        
		this.tileEntity.closeInventory(playerIn);
	}	
}
