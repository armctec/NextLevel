package com.armctec.nl.machines.reference;

import com.armctec.nl.general.utility.LogHelper;

public class ModConfig 
{
	public final static String MOD_ID = "NextLevelMachines";
	public final static String MOD_VERSION = "0.0.1";
	public final static String MOD_NAME = "Next Level Machines";
	public final static String CLIENT_PROXY_CLASS = "com.armctec.nl.machines.proxy.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.armctec.nl.machines.proxy.ServerProxy";
	public final static String GUI_FACTORY_CLASS = "com.armctec.nl.machines.gui.ModConfigGui";
	public final static LogHelper Log = new LogHelper(ModConfig.MOD_ID);
}
