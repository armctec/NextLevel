package com.armctec.nl.machines.handler;

import com.armctec.nl.general.tileentity.TileEntityBasicInventory;
import com.armctec.nl.machines.gui.GuiAdvancedCrafting;
import com.armctec.nl.machines.gui.GuiGrindstone;
import com.armctec.nl.machines.inventory.ContainerAdvancedCrafting;
import com.armctec.nl.machines.inventory.ContainerGrindstone;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerGrindstone implements IGuiHandler
{
	public static int getGuiID() 
	{
		return Names.GuiID.GUI_GRINDSTONE;
	}

	// Gets the server side element for the given gui id- this should return a container
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID != getGuiID()) 
		{
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityGrindstone) 
		{
			TileEntityGrindstone tileEntityInventoryBasic = (TileEntityGrindstone) tileEntity;
			return new ContainerGrindstone(player.inventory, world, xyz, tileEntityInventoryBasic);
		}
		return null;
	}

	// Gets the client side element for the given gui id- this should return a gui
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID != getGuiID()) 
		{
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityGrindstone) 
		{
			TileEntityGrindstone tileEntityInventoryBasic = (TileEntityGrindstone) tileEntity;
			return new GuiGrindstone(player.inventory, world, xyz, tileEntityInventoryBasic);
		}
		return null;
	}
}
