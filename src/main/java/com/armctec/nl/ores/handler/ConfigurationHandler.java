package com.armctec.nl.ores.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.armctec.nl.ores.reference.ModConfig;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static int proxyccmfr_id  = 1500;
    public static boolean vanillarecipe = false;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Property lido;
        lido = configuration.get("proxyccmfr_id", Configuration.CATEGORY_GENERAL, 1501, "ID para o bloco proxyccmfr");
        proxyccmfr_id = lido.getInt(1500);

        lido = configuration.get("recipe", Configuration.CATEGORY_GENERAL, false, "Utilizar Vanilla recipe?");
        vanillarecipe = lido.getBoolean(false);

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }
    
    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(ModConfig.MOD_ID))
        {
            loadConfiguration();
        }
    }    
}

