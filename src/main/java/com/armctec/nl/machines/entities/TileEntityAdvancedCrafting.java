package com.armctec.nl.machines.entities;

import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.reference.ModConfig;

public class TileEntityAdvancedCrafting extends TileEntityBasicInventory 
{
	Container container = null;
	
	public TileEntityAdvancedCrafting(String NameEntity, int num_slots, Container container) 
	{
		super(NameEntity, num_slots);
		// TODO Auto-generated constructor stub
		ModConfig.Log.info("TileEntity Created: Name:"+NameEntity+", NumSlots:"+num_slots);
		this.container = container;
	}
	
	public TileEntityAdvancedCrafting()
	{
		super();
	}
	
	@Override
	public void writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound);
		ModConfig.Log.info("writeToNBT");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.readFromNBT(parentNBTTagCompound);
		ModConfig.Log.info("readFromNBT");
	}
	
    /**
     * Returns the itemstack in the slot specified (Top left is 0, 0). Args: row, column
     */
    public ItemStack getStackInRowAndColumn(int row, int column)
    {
        return row >= 0 && row < 3 && column >= 0 && column <= 3 ? this.getStackInSlot(row + column * 3) : null;
    }
	
    @Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
    	super.setInventorySlotContents(index, stack);
    	container.onCraftMatrixChanged(this);
	}
	
}
