package com.armctec.nl.general.utility;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RegisterServer 
{
	public static void registerBlocks(Block block, String name, String ore)
	{
		//GameRegistry.registerBlock(block, name);	// Register Minecraft
		block.setRegistryName(name);
		GameRegistry.register(block);
		OreDictionary.registerOre(ore, block);		// Register Forge
	}
	
	public static void registerItems(Item item, String name, String ore)
	{
		//GameRegistry.registerItem(item, name);		// Register Minecraft
		item.setRegistryName(name);
		GameRegistry.register(item);
		OreDictionary.registerOre(ore, item);		// Register Forge
	}	
}
