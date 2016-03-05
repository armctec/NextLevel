package com.armctec.nl.machines.reference;

import com.armctec.nl.general.utility.LogHelper;

public class ModConfig 
{
	public final static String MOD_ID = "NextLevelMachines";
	public final static String MOD_VERSION = "0.2.5";
	public final static String MOD_NAME = "Next Level Machines";
	public final static String CLIENT_PROXY_CLASS = "com.armctec.nl.machines.proxy.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.armctec.nl.machines.proxy.ServerProxy";
	public final static String GUI_FACTORY_CLASS = "com.armctec.nl.machines.gui.GuiModConfig";
	public final static String DEPENDENCIES = "required-after:NextLevelOres";
	public final static LogHelper Log = new LogHelper(ModConfig.MOD_ID);
}
