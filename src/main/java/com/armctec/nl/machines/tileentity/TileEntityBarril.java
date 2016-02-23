package com.armctec.nl.machines.tileentity;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IInteractionObject;
import net.minecraftforge.fluids.FluidContainerRegistry;

import com.armctec.nl.general.tileentity.TileEntitityBasicFluidTank;
import com.armctec.nl.machines.init.ModBlocks;
import com.armctec.nl.machines.init.ModBlocksClient;

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
