package com.armctec.nl.general.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterClient 
{
	private static String getName(String ModName, String BlockName)
    {
		return String.format("%s:%s", ModName, BlockName);
    }
	
	public static void registerBlock(String ModName, String BlockName)
	{
		registerItem(ModName, BlockName, 0);
	}
	
	public static void registerItem(String ModName, String ItemName, int metadata)
	{
		Item itemBlockSimple = GameRegistry.findItem(ModName, ItemName);
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(getName(ModName, ItemName), "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, metadata, itemModelResourceLocation);
	}
}
