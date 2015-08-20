package com.armctec.nl.general.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterClient 
{
	private static String getName(String ModName, String BlockName)
    {
		return String.format("%s:%s", ModName.toLowerCase(), BlockName);
    }
	
	public static void registerBlock(String ModName, String BlockName)
	{
		registerItem(ModName.toLowerCase(), BlockName, 0);
	}
	
	public static void registerItem(String ModName, String ItemName)
	{
		registerItem(ModName.toLowerCase(), ItemName, 0);
	}
	
	public static void registerItem(String ModName, String ItemName, Item itemSimple)
	{
		registerItem(ModName.toLowerCase(), ItemName, 0, itemSimple);
	}
	
	public static void registerItem(String ModName, String ItemName, int metadata)
	{
		Item itemBlockSimple = GameRegistry.findItem(ModName.toLowerCase(), ItemName);
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(getName(ModName, ItemName), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, metadata, itemModelResourceLocation);
	}
	
	public static void registerItem(String ModName, String ItemName, int metadata, Item itemSimple)
	{
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(getName(ModName, ItemName), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemSimple, metadata, itemModelResourceLocation);
	}	
}
