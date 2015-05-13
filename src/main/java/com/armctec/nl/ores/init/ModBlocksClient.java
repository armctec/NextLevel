package com.armctec.nl.ores.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.general.utility.RegisterBlockItem;
import com.armctec.nl.ores.reference.Names;
import com.armctec.nl.ores.reference.ModConfig;

public class ModBlocksClient 
{
	public static void init()
	{
		// Blocks
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.COPPER_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.TIN_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.LEAD_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.ALUMINIUM_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.ZINC_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.TITANIUM_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.SILVER_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.NICKEL_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.TUNGSTEN_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.SILICON_ORE);
		// Gemstone
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.RUBY_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.SAPPHIRE_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.MOONSTONE_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.BLACKONYX_ORE);
		RegisterBlockItem.Register(ModConfig.MOD_ID, Names.Blocks.REDONYX_ORE);
		
	}
}
