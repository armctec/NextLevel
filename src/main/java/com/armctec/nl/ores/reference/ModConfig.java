package com.armctec.nl.ores.reference;

import com.armctec.nl.general.utility.LogHelper;

public class ModConfig 
{
	public final static String MOD_ID = "NextLevelOres";
	public final static String MOD_VERSION = "0.2.5";
	public final static String MOD_NAME = "Next Level Ores";
	public final static String CLIENT_PROXY_CLASS = "com.armctec.nl.ores.proxy.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.armctec.nl.ores.proxy.ServerProxy";
	public final static String GUI_FACTORY_CLASS = "com.armctec.nl.ores.gui.ModConfigGui";
	public final static LogHelper Log = new LogHelper(ModConfig.MOD_ID);
}
