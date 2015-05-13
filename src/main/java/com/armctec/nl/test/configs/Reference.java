package com.armctec.nl.test.configs;

import com.armctec.nl.general.utility.LogHelper;

public class Reference 
{
	public final static String MOD_ID = "NextLevelTest";
	public final static String MOD_VERSION = "0.0.1";
	public final static String MOD_NAME = "Next Level Test";
	public final static String CLIENT_PROXY_CLASS = "com.armctec.nl.test.proxy.ClientProxy";
	public final static String SERVER_PROXY_CLASS = "com.armctec.nl.test.proxy.ServerProxy";
	public final static LogHelper Log = new LogHelper(Reference.MOD_ID);
}
