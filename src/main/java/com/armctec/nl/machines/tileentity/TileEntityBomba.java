package com.armctec.nl.machines.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.EnumFacing;

import com.armctec.nl.general.tileentity.TileEntityBasicInventory;
import com.armctec.nl.machines.crafting.GrindestoneRecipes;
import com.armctec.nl.machines.crafting.RecipesAnexo;
import com.armctec.nl.machines.inventory.container.ContainerAdvancedCrafting;
import com.armctec.nl.machines.inventory.container.ContainerGrindstone;
import com.armctec.nl.machines.reference.ModConfig;

public class TileEntityBomba extends TileEntityBasicInventory implements IUpdatePlayerListBox, ISidedInventory
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
	
	public void update()
    {
		if (!this.worldObj.isRemote)
        {
			GrinderItem();
			markDirty();
        }
    }

	/**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canGrinder()
    {
        if (this.itemStacks[3] == null)
        {
            return false;
        }
        else
        {
            RecipesAnexo items = GrindestoneRecipes.instance().getGrinderResult(itemStacks[3]);
            if(items == null)
            	return false;
            
            ItemStack itemstack = items.getStack1();
            
            if (itemstack == null)
            	return false;
            if (itemStacks[0] == null)
            	return true;
            if (!itemStacks[0].isItemEqual(itemstack))
            	return false;
            int result = itemStacks[0].stackSize + itemstack.stackSize;
            
            boolean isfull = result <= getInventoryStackLimit();
            
            if(!isfull)
            	trabalho = 0;
            
            return  isfull && result <= this.itemStacks[0].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    private void GrinderItem()
    {
    	if (canGrinder()&&trabalho>3)
        {
    		ModConfig.Log.info("trabalho:"+trabalho);
        	
    		trabalho-=4;
        	
    		RecipesAnexo items = GrindestoneRecipes.instance().getGrinderResult(itemStacks[3]);
            if(items == null)
            	return;
            
            ItemStack itemstack = items.getStack1();

            if (itemStacks[0] == null)
            {
            	itemStacks[0] = itemstack.copy();
            }
            else if (itemStacks[0].getItem() == itemstack.getItem())
            {
            	itemStacks[0].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.itemStacks[3].stackSize;

            if (this.itemStacks[3].stackSize <= 0)
            {
                this.itemStacks[3] = null;
            }
        }
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
}