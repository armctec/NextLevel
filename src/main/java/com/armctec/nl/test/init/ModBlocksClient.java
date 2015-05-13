package com.armctec.nl.test.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.general.utility.LogHelper;
import com.armctec.nl.test.configs.Names;
import com.armctec.nl.test.configs.Reference;

public class ModBlocksClient 
{
	private static String getName(String ModName, String BlockName)
    {
		return String.format("%s:%s", ModName, BlockName);
    }
	
	public static void init()
	{
		Item itemBlockSimple = GameRegistry.findItem(Reference.MOD_ID, Names.Blocks.CANO);
	    ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(getName(Reference.MOD_ID, Names.Blocks.CANO), "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockSimple, 0, itemModelResourceLocation);
	}
}
