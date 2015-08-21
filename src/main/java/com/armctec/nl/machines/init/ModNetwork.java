package com.armctec.nl.machines.init;

import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.armctec.nl.general.gui.GuiHandlerRegistry;
import com.armctec.nl.machines.MachinesNL;
import com.armctec.nl.machines.handler.GuiHandlerAdvancedCrafting;
import com.armctec.nl.machines.handler.GuiHandlerGrindstone;

public class ModNetwork 
{
	public static void init()
	{
		// Master Register
		NetworkRegistry.INSTANCE.registerGuiHandler(MachinesNL.instance, GuiHandlerRegistry.getInstance());
		GuiHandlerRegistry register = GuiHandlerRegistry.getInstance();
		// Guis Register
		register.registerGuiHandler(new GuiHandlerAdvancedCrafting(), GuiHandlerAdvancedCrafting.getGuiID());
		register.registerGuiHandler(new GuiHandlerGrindstone(), GuiHandlerGrindstone.getGuiID());
	}
}
