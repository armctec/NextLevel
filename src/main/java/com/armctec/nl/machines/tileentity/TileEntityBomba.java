package com.armctec.nl.machines.tileentity;


import com.armctec.nl.general.tileentity.TileEntityBasicInventory;
import com.armctec.nl.machines.inventory.container.ContainerGrindstone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityBomba extends TileEntityBasicInventory implements ITickable , ISidedInventory
{
    ContainerGrindstone container = null;
    private static final int[] slotsBottom = new int[] {2, 1, 0};
    private static final int[] slotsSides = new int[] {3};
    private static final int[] slotsTop = new int[] {};
    private int posicao = 0;
    private int trabalho = 0;
    
	public TileEntityBomba(String NameEntity) 
	{
		super(NameEntity, 4);
		// TODO Auto-generated constructor stub
		//ModConfig.Log.info("TileEntity Created: Name:"+NameEntity);
	}
	
	public TileEntityBomba()
	{
		super();
	}
	
	public void setPosicao(int posicao)
	{
		if(this.posicao!=posicao)
			trabalho++;

		this.posicao = posicao;
	}
	
	public int getPosicao()
	{
		return posicao;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		if(parentNBTTagCompound == null)
			return;
		
		parentNBTTagCompound.setInteger("Posicao", posicao);
		super.writeToNBT(parentNBTTagCompound);
		
		//ModConfig.Log.info("writeToNBT");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound parentNBTTagCompound)
	{
		if(parentNBTTagCompound == null)
			return;
		
		posicao = parentNBTTagCompound.getInteger("Posicao");
		super.readFromNBT(parentNBTTagCompound);
		//ModConfig.Log.info("readFromNBT");
		//Update posicao na visualizacao
		if(worldObj!=null)
		{
			if(worldObj.isRemote)
				worldObj.markBlockRangeForRenderUpdate(pos, pos);
		}
	}

	/*
	@Override
	public Packet getDescriptionPacket() 
	{
		ModConfig.Log.info("getDescriptionPacket");
		return super.getDescriptionPacket();
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) 
	{
		ModConfig.Log.info("onDataPacket");
		super.onDataPacket(net, pkt);
	}
	*/
	
    public void setContainer(ContainerGrindstone container)
    {
    	this.container = container;
    }
    
    
    @Override
	public void closeInventory(EntityPlayer player) 
	{
    	this.container = null;
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

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return super.getStackInSlot(index);
	}    
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		ItemStack item = super.decrStackSize(index, count);
		
		if(container != null)
			container.onCraftMatrixChanged(this);
		
		return item;
	}
	
	/**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return index == 3 ? true : false;
    }	
    
	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) 
	{
		return true;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) 
	{
		return true;
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		if (!this.worldObj.isRemote)
        {
			//GrinderItem();
			//markDirty();
        }
	}    
}
