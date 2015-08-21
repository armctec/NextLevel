package com.armctec.nl.machines.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.armctec.nl.machines.gui.GuiAdvancedCrafting;
import com.armctec.nl.machines.inventory.container.ContainerAdvancedCrafting;
import com.armctec.nl.machines.reference.Names;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;

public class GuiHandlerAdvancedCrafting implements IGuiHandler
{
	public static int getGuiID() 
	{
		return Names.GuiID.GUI_ADVANCED_CRAFTING;
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
		if (tileEntity instanceof TileEntityAdvancedCrafting) 
		{
			TileEntityAdvancedCrafting tileEntityInventoryBasic = (TileEntityAdvancedCrafting) tileEntity;
			return new ContainerAdvancedCrafting(player.inventory, world, xyz, tileEntityInventoryBasic);
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
		if (tileEntity instanceof TileEntityAdvancedCrafting) 
		{
			TileEntityAdvancedCrafting tileEntityInventoryBasic = (TileEntityAdvancedCrafting) tileEntity;
			return new GuiAdvancedCrafting(player.inventory, world, xyz, tileEntityInventoryBasic);
		}
		return null;
	}
}
