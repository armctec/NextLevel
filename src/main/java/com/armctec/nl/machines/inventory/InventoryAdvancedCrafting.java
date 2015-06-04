package com.armctec.nl.machines.inventory;

import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class InventoryAdvancedCrafting extends InventoryCrafting 
{
	TileEntityAdvancedCrafting tileentity = null;
	
	public InventoryAdvancedCrafting(TileEntityAdvancedCrafting tileentity, Container container, int width, int height) 
	{
		super(null, 0, 0);
		this.tileentity = tileentity;
	}
	
    /**
     * Returns the number of slots in the inventory.
     */
	@Override
    public int getSizeInventory()
    {
        return tileentity.getSizeInventory();
    }

    /**
     * Returns the stack in slot i
     */
	@Override
    public ItemStack getStackInSlot(int index)
    {
        return tileentity.getStackInSlot(index);
    }

    /**
     * Returns the itemstack in the slot specified (Top left is 0, 0). Args: row, column
     */
	@Override
    public ItemStack getStackInRowAndColumn(int row, int column)
    {
        return tileentity.getStackInRowAndColumn(row, column);
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
	@Override
    public String getName()
    {
        return tileentity.getName();
    }

    /**
     * Returns true if this thing is named
     */
	@Override
    public boolean hasCustomName()
    {
		return tileentity.hasCustomName();
    }

	@Override
    public IChatComponent getDisplayName()
    {
        return tileentity.getDisplayName();
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
	@Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        return tileentity.getStackInSlotOnClosing(index);
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
	@Override
    public ItemStack decrStackSize(int index, int count)
    {
		return tileentity.decrStackSize(index, count);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
	@Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
		tileentity.setInventorySlotContents(index, stack);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
	@Override
    public int getInventoryStackLimit()
    {
        return tileentity.getInventoryStackLimit();
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
	@Override
    public void markDirty() 
	{
		tileentity.markDirty();
	}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
	@Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return tileentity.isUseableByPlayer(player);
    }

	@Override
    public void openInventory(EntityPlayer player)
	{
		tileentity.openInventory(player);
	}

	@Override
    public void closeInventory(EntityPlayer player)
	{
		tileentity.closeInventory(player);
	}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
	@Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return tileentity.isItemValidForSlot(index, stack);
    }

	@Override
    public int getField(int id)
    {
        return tileentity.getField(id);
    }

	@Override
    public void setField(int id, int value) 
	{
		tileentity.setField(id, value);
	}

	@Override
    public int getFieldCount()
    {
        return tileentity.getFieldCount();
    }

	@Override
    public void clear()
    {
		tileentity.clear();
    }

	@Override
    public int getHeight()
    {
        return tileentity.getHeight();
    }

	@Override
    public int getWidth()
    {
        return tileentity.getWidth();
    }
	
}
