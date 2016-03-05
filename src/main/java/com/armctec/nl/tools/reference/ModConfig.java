package com.armctec.nl.tools.reference;

import com.armctec.nl.general.utility.LogHelper;

public class ModConfig 
{
	public final static String MOD_ID = "NextLevelTools";
	public final static String MOD_VERSION = "0.1.5";
	public final static String MOD_NAME = "Next Level Tools";
	public final static String CLIENT_PROXY_CLASS = "com.armctec.nl.tools.proxy.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.armctec.nl.tools.proxy.ServerProxy";
	public final static String GUI_FACTORY_CLASS = "com.armctec.nl.tools.gui.ModConfigGui";
	public final static String DEPENDENCIES = "required-after:NextLevelOres";
	public final static LogHelper Log = new LogHelper(ModConfig.MOD_ID);
}
