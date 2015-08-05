package com.armctec.nl.tools.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes 
{
	private static ItemStack PickaxeCopperStatck = new ItemStack(ModItems.CopperPickaxe);
	
	public static void init()
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(PickaxeCopperStatck, new Object[]{"CCC"," S "," S ",'C',"ingotCopper",'S',"stickWood"}));
	}
}
