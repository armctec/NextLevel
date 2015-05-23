package com.armctec.nl.machines.entities;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

import com.armctec.nl.general.entities.TileEntityBasicInventory;
import com.armctec.nl.machines.inventory.ContainerAdvancedCrafting;
import com.armctec.nl.machines.reference.ModConfig;

public class TileEntityAdvancedCrafting extends TileEntityBasicInventory implements ISidedInventory
{
    private static final int[] slotsBottom = new int[] {9};
    private static final int[] slotsSides = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};	
    ContainerAdvancedCrafting container = null;
	
	public TileEntityAdvancedCrafting(String NameEntity) 
	{
		super(NameEntity, 9);
		// TODO Auto-generated constructor stub
		ModConfig.Log.info("TileEntity Created: Name:"+NameEntity);
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
	
    public void setContainer(ContainerAdvancedCrafting container)
    {
    	this.container = container;
    }
    
    @Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
    	super.setInventorySlotContents(index, stack);
		if(container == null)
			return;    	
    	container.onCraftMatrixChanged(this);
	}
	
    public int getHeight()
    {
        return 3;
    }

    public int getWidth()
    {
        return 3;
    }

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index==9)
		{
			if(container == null)
			{
				System.out.println("Container null:getStackInSlot");
				return null;
			}
			ItemStack item = container.getCraftingResultItemStack();
			container.detectAndSendChanges();
			return item;
		}
		return super.getStackInSlot(index);
	}    
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if(index==9)
		{
			if(container == null)
			{
				System.out.println("Container null:decrStackSize");
				return null;
			}
			ItemStack item = container.getCraftingResultItemStack(count);
			container.detectAndSendChanges();
			return item;
		}
		
		return super.decrStackSize(index, count);
	}
    
	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		if(side == EnumFacing.DOWN)
			return slotsBottom;
		
		return slotsSides;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		if (direction == EnumFacing.DOWN && index == 9)
        {
			if(container == null)
				return false;			
			return container.getCraftingResult();
        }
		return true;
	}    
}
