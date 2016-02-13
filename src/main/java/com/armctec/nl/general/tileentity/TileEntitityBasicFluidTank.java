package com.armctec.nl.general.tileentity;

import com.armctec.nl.machines.reference.ModConfig;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntitityBasicFluidTank extends TileEntity implements IFluidHandler 
{
	protected FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME);
	protected String NameEntity = null;
	protected int comparator = 0;
	
	public TileEntitityBasicFluidTank(int capacity, String NameEntity) 
	{
		super();
		tank.setCapacity(capacity);
		this.NameEntity = NameEntity;
	}
	
	public TileEntitityBasicFluidTank(String NameEntity) 
	{
		super();
		this.NameEntity = NameEntity;
	}

	public TileEntitityBasicFluidTank(int capacity) 
	{
		super();
		tank.setCapacity(capacity);
	}
	
	public TileEntitityBasicFluidTank() 
	{
		super();
	}

	@Override
	public int fill(EnumFacing from, FluidStack resource, boolean doFill) 
	{
		int val = tank.fill(resource, doFill);
		updateComparator();
		return val;
	}

	@Override
	public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain) 
	{
		FluidStack ret;
		
		if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
        
		ret = tank.drain(resource.amount, doDrain);
		updateComparator();
		
		return ret;
	}

	@Override
	public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain) 
	{
		FluidStack ret;
		
		ret = tank.drain(maxDrain, doDrain);
		updateComparator();
		return ret;
	}

	@Override
	public boolean canFill(EnumFacing from, Fluid fluid)
	{
		return true;
	}

	@Override
	public boolean canDrain(EnumFacing from, Fluid fluid)
	{
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(EnumFacing from) 
	{
		return new FluidTankInfo[] { tank.getInfo() };
	}

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        tank.readFromNBT(tag);
        updateComparator();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tank.writeToNBT(tag);
    }
    
    @Override
	public Packet getDescriptionPacket() 
	{
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		return new S35PacketUpdateTileEntity(this.pos, 0, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) 
	{
		readFromNBT(pkt.getNbtCompound());
	}    
    
    public int getCapacity()
    {
    	return tank.getCapacity();
    }
    
    public int getAmount()
    {
    	return tank.getFluidAmount();
    }
    
    public FluidStack getFluid()
    {
    	return tank.getFluid();
    }
    
	public void updateComparator()
	{
		int amount = tank.getFluidAmount();
		if(amount>0)
			comparator = (int)(((float)(amount) / (float)(tank.getCapacity())) * 15.0f);
		else
			comparator = 0;
	}
    
    public int getComparator()
    {
    	return comparator;
    }
}
