package com.armctec.nl.general.entities;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class TileEntityBasicInventory extends TileEntity implements IInventory 
{
	private ItemStack[] itemStacks = null;
	private int num_slots = 0;
	private String NameEntity = null;
			
	public TileEntityBasicInventory(String NameEntity, int num_slots) 
	{
		this.num_slots = num_slots;
		itemStacks = new ItemStack[num_slots];
		this.NameEntity = NameEntity;
	}

	@Override
	public String getName() 
	{
		return NameEntity;
	}

	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public IChatComponent getDisplayName() 
	{
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() 
	{
		return num_slots;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index<num_slots)
			return itemStacks[index];
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if (this.itemStacks[index] != null)
        {
            ItemStack itemStackInSlot ;

            if (itemStacks[index].stackSize <= count)
            {
            	itemStackInSlot  = itemStacks[index];
                itemStacks[index] = null;
                markDirty();
                return itemStackInSlot ;
            }
            else
            {
            	itemStackInSlot  = itemStacks[index].splitStack(count);

                if (itemStacks[index].stackSize == 0)
                {
                    itemStacks[index] = null;
                }

                markDirty();
                return itemStackInSlot;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) 
	{
        if (itemStacks[index] != null)
        {
            ItemStack itemStackInSlot = itemStacks[index];
            itemStacks[index] = null;
            return itemStackInSlot;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		itemStacks[index] = stack;

        if (stack != null && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = getInventoryStackLimit();
        }

        markDirty();
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		if (this.worldObj.getTileEntity(this.pos) != this) 
			return false;
		return player.getDistanceSq(pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f) < 64;
	}

	@Override
	public void openInventory(EntityPlayer player) 
	{
	
	}

	@Override
	public void closeInventory(EntityPlayer player) 
	{

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public void setField(int id, int value) 
	{
		
	}

	@Override
	public int getFieldCount() 
	{
		return 0;
	}

	@Override
	public void clear() 
	{
		Arrays.fill(itemStacks, null);
	}

}
