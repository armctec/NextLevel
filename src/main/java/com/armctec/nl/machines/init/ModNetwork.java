package com.armctec.nl.machines.init;

import com.armctec.nl.general.gui.GuiHandlerRegistry;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.gui.GuiHandlerAdvancedCrafting;

import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ModNetwork 
{
	public static void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(MachinesNL.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandlerAdvancedCrafting(), GuiHandlerAdvancedCrafting.getGuiID());
	}
}
