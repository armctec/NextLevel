package com.armctec.nl.ores.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.ores.reference.Names;

public class ModItemsClient 
{
	public static void init()
	{
		// Ingots
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.COPPER_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TIN_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.LEAD_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.ALUMINIUM_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.ZINC_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TITANIUM_INGOT, 0);	
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.SILVER_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.NICKEL_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TUNGSTEN_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.SILICON_INGOT, 0);
		//Gems
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.RUBY_GEM, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.SAPPHIRE_GEM, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.MOONSTONE_GEM, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BLACKONYX_GEM, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.REDONYX_GEM, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.AMETHYST_GEM, 0);
		//Alloys
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRONZE_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRASS_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ZAMAK_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STERLING_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CUPRO_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.INVAR_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STEEL_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.FERSILICON_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ELECTRUM_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.HSS_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BABBITT_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.GRADE_INGOT, 0);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CARBON_INGOT, 0);	
	}
}
