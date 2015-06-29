package com.armctec.nl.machines.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes 
{
	private static ItemStack AdvancedCraftingStatck = new ItemStack(ModBlocks.AdvancedCraftingTable);
	private static ItemStack ToolGrindStack = new ItemStack(ModItems.ToolGrind);
	private static ItemStack GrindstoneStack = new ItemStack(ModBlocks.Grindstone);
	
	public static void init()
	{
		GameRegistry.addShapelessRecipe(AdvancedCraftingStatck, new ItemStack(Blocks.crafting_table), new ItemStack(Blocks.chest));
		GameRegistry.addRecipe(new ShapedOreRecipe(ToolGrindStack, new Object[]{"CCC","FFF","CCC", 'F',new ItemStack(Items.flint),'C',"cobblestone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(GrindstoneStack, new Object[]{"WWW","CIC","CCC",'W',"plankWood",'I',"ingotIron",'C',"cobblestone"}));
	}
}
