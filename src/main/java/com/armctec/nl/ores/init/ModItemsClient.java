package com.armctec.nl.ores.init;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.ores.reference.Names;

public class ModItemsClient 
{
	public static void init()
	{
		// Ingots
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.COPPER_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TIN_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.LEAD_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.ALUMINIUM_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.ZINC_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TITANIUM_INGOT);	
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.SILVER_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.NICKEL_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.TUNGSTEN_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID,  Names.Items.SILICON_INGOT);
		// Gems
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.RUBY_GEM);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.SAPPHIRE_GEM);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.MOONSTONE_GEM);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BLACKONYX_GEM);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.REDONYX_GEM);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.AMETHYST_GEM);
		// Alloys
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRONZE_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRASS_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ZAMAK_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STERLING_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CUPRO_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.INVAR_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STEEL_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.FERSILICON_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ELECTRUM_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.HSS_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BABBITT_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.GRADE_INGOT);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CARBON_INGOT);
		// Dust
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ALUMINIUM_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.AMETHYST_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BABBITT_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BLACKONYX_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRASS_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.BRONZE_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CARBON_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.COPPER_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.CUPRO_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ELECTRUM_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.FERSILICON_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.GRADE_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.HSS_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.INVAR_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.LEAD_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.MOONSTONE_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.NICKEL_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.REDONYX_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.RUBY_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.SAPPHIRE_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.SILICON_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.SILVER_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STEEL_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.STERLING_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.TIN_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.TITANIUM_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.TUNGSTEN_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ZAMAK_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ZINC_DUST);
		// Vanilla Dust
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.DIAMOND_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.EMERALD_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.ENDER_PEARL_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.GOLD_DUST);
		RegisterClient.registerItem(ModConfig.MOD_ID, Names.Items.IRON_DUST);
	}
}
