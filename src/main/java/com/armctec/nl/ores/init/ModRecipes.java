package com.armctec.nl.ores.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.CopperIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.TinIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.LeadOre, new ItemStack(ModItems.LeadIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.AluminiumOre, new ItemStack(ModItems.AluminiumIngot), 0.5F);
	}
}
