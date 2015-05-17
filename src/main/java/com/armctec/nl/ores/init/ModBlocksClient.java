package com.armctec.nl.ores.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.general.utility.RegisterClient;
import com.armctec.nl.ores.reference.Names;
import com.armctec.nl.ores.reference.ModConfig;

public class ModBlocksClient 
{
	public static void init()
	{
		// Blocks
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.COPPER_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.TIN_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.LEAD_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.ALUMINIUM_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.ZINC_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.TITANIUM_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.SILVER_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.NICKEL_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.TUNGSTEN_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.SILICON_ORE);
		// Gemstone
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.RUBY_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.SAPPHIRE_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.MOONSTONE_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.BLACKONYX_ORE);
		RegisterClient.registerBlock(ModConfig.MOD_ID, Names.Blocks.REDONYX_ORE);
		
	}
}
