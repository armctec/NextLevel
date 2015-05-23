package com.armctec.nl.machines.inventory;

import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.entities.TileEntityAdvancedCrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ContainerAdvancedCrafting extends Container
{
	TileEntityAdvancedCrafting tileEntity = null;
    public IInventory craftResult = new InventoryCraftResult();
    private World worldObj;
    private BlockPos blockPosition;
    AdvancedInventoryCrafting advcrafting = null;
    
	public ContainerAdvancedCrafting(InventoryPlayer playerInventory, World worldIn, BlockPos blockPosition, TileEntityAdvancedCrafting tileEntity) 
	{
		this.worldObj = worldIn;
		this.tileEntity = tileEntity;
		this.blockPosition = blockPosition;
		
		tileEntity.setContainer(this);
		advcrafting = new AdvancedInventoryCrafting(tileEntity, null, 0, 0);
		setSlots(playerInventory);
	}
	
	private void setSlots(InventoryPlayer playerInventory)
	{
		this.addSlotToContainer(new SlotCrafting(playerInventory.player, advcrafting, craftResult, 0, 124, 35));
        int i;
        int j;

        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 3; ++j)
            {
                this.addSlotToContainer(new Slot(tileEntity, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        onCraftMatrixChanged(tileEntity);		
	}
	
    /**
     * Callback for when the crafting matrix is changed.
     */
	@Override
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(advcrafting, this.worldObj));
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
		super.onContainerClosed(playerIn);
		this.tileEntity.closeInventory(playerIn);
	}	
	
	public ItemStack getCraftingResultItemStack()
	{
		Slot slot = (Slot)inventorySlots.get(0);
		if(slot!=null && slot.getHasStack())
		{
			onCraftMatrixChanged(tileEntity);
			ItemStack item = slot.getStack();
			
			return item;
		}
		return null;
	}
	
	public ItemStack getCraftingResultItemStack(int size)
	{
		Slot slot = (Slot)inventorySlots.get(0);
		if(slot!=null && slot.getHasStack())
		{
			onCraftMatrixChanged(tileEntity);
			ItemStack item = slot.getStack();
			
			return item;
		}
		return null;
	}	
	
	public boolean getCraftingResult()
	{
		Slot slot = (Slot)inventorySlots.get(0);
		if(slot!=null && slot.getHasStack())
		{
			return true;
		}
		return false;
	}
	
	/**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 10 && index < 37)
            {
                if (!this.mergeItemStack(itemstack1, 37, 46, false))
                {
                    return null;
                }
            }
            else if (index >= 37 && index < 46)
            {
                if (!this.mergeItemStack(itemstack1, 10, 37, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 10, 46, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack item, Slot slot)
    {
        return slot.inventory != this.craftResult && super.canMergeSlot(item, slot);
    }	
}
