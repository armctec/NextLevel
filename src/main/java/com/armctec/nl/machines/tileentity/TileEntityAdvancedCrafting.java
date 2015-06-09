package com.armctec.nl.machines.tileentity;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;

import com.armctec.nl.general.tileentity.TileEntityBasicInventory;
import com.armctec.nl.machines.inventory.container.ContainerAdvancedCrafting;
import com.armctec.nl.machines.reference.ModConfig;

public class TileEntityAdvancedCrafting extends TileEntityBasicInventory implements ISidedInventory
{
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
		//ModConfig.Log.info("writeToNBT");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.readFromNBT(parentNBTTagCompound);
		//ModConfig.Log.info("readFromNBT");
	}

	@Override
	public Packet getDescriptionPacket() 
	{
		//ModConfig.Log.info("getDescriptionPacket");
		return super.getDescriptionPacket();
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) 
	{
		//ModConfig.Log.info("onDataPacket");
		super.onDataPacket(net, pkt);
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
		{
			//System.out.println("Container null:setInventorySlotContents");
			return;    	
		}
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
		return super.getStackInSlot(index);
	}    
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		ItemStack item = super.decrStackSize(index, count);
		container.onCraftMatrixChanged(this);
		
		return item;
	}
    
	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return new int[]{};
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return false;
	}    
}
