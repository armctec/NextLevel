package com.armctec.nl.machines.tileentity;

import com.armctec.nl.general.tileentity.TileEntitityBasicFluidTank;
import com.armctec.nl.machines.init.ModBlocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileEntityBarril extends TileEntitityBasicFluidTank implements ITickable
{
	public TileEntityBarril(String NameEntity, int Capacity) 
	{
		super(Capacity, NameEntity);
	}
	
	/** Precisa se nao o inutil do createAndLoadEntity da erro */
	/** Chamado quando cria entity pelo server */
	public TileEntityBarril()
	{
		super();
		// Bug quando iniciado por aqui
		tank.setCapacity(ModBlocks.Barril.capacity);
	}

	@Override
	public void update() 
	{
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) 
	{
		super.readFromNBT(tag);
		
		//Update posicao na visualizacao
		if(worldObj!=null)
		{
			if(worldObj.isRemote)
				worldObj.markBlockRangeForRenderUpdate(pos, pos);
		}		
	}
}
