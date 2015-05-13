package com.armctec.nl.general.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.ores.reference.Names;

public class RegisterBlockItem 
{
	private static String getName(String ModName, String BlockName)
    {
		return String.format("%s:%s", ModName, BlockName);
    }
	
	public static void Register(String ModName, String BlockName)
	{
		Item itemBlockSimple = GameRegistry.findItem(ModName, BlockName);
	    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(getName(ModName, BlockName), "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, 0, itemModelResourceLocation);
	}
}
