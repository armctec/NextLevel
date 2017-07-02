package com.armctec.nl.ores.init;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes 
{
	public static void init()
	{
		// Smelting Ore
		GameRegistry.addSmelting(ModBlocks.AluminiumOre, new ItemStack(ModItems.AluminiumIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.AmethystOre, new ItemStack(ModItems.AmethystGem), 0.5F);
		GameRegistry.addSmelting(ModBlocks.BlackonyxOre, new ItemStack(ModItems.BlackonyxGem), 0.7F);
		GameRegistry.addSmelting(ModBlocks.CopperOre, new ItemStack(ModItems.CopperIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.LeadOre, new ItemStack(ModItems.LeadIngot), 0.8F);
		GameRegistry.addSmelting(ModBlocks.MoonstoneOre, new ItemStack(ModItems.MoonstoneGem), 0.8F);
		GameRegistry.addSmelting(ModBlocks.NickelOre, new ItemStack(ModItems.NickelIngot), 0.9F);
		GameRegistry.addSmelting(ModBlocks.RedonyxOre, new ItemStack(ModItems.RedonyxGem), 0.7F);
		GameRegistry.addSmelting(ModBlocks.RubyOre, new ItemStack(ModItems.RubyGem), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SapphireOre, new ItemStack(ModItems.SapphireGem), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SiliconOre, new ItemStack(ModItems.SiliconIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.SilverOre, new ItemStack(ModItems.SilverIngot), 0.7F);
		GameRegistry.addSmelting(ModBlocks.TinOre, new ItemStack(ModItems.TinIngot), 0.5F);
		GameRegistry.addSmelting(ModBlocks.TitaniumOre, new ItemStack(ModItems.TitaniumIngot), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TungstenOre, new ItemStack(ModItems.TungstenIngot), 1.0F);
		GameRegistry.addSmelting(ModBlocks.ZincOre, new ItemStack(ModItems.ZincIngot), 0.8F);
		
		// Smelting Dust
		GameRegistry.addSmelting(ModItems.AluminiumDust, new ItemStack(ModItems.AluminiumIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.BabbittDust, new ItemStack(ModItems.BabbittIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.BrassDust, new ItemStack(ModItems.BrassIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.BronzeDust, new ItemStack(ModItems.BronzeIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.CarbonDust, new ItemStack(ModItems.CarbonIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.CopperDust, new ItemStack(ModItems.CopperIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.CuproDust, new ItemStack(ModItems.CuproIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.ElectrumDust, new ItemStack(ModItems.ElectrumIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.FersiliconDust, new ItemStack(ModItems.FersiliconIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.GradeDust, new ItemStack(ModItems.GradeIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.HssDust, new ItemStack(ModItems.HssIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.InvarDust, new ItemStack(ModItems.InvarIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.LeadDust, new ItemStack(ModItems.LeadIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.NickelDust, new ItemStack(ModItems.NickelIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.SiliconDust, new ItemStack(ModItems.SiliconIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.SilverDust, new ItemStack(ModItems.SilverIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.SteelDust, new ItemStack(ModItems.SteelIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.SterlingDust, new ItemStack(ModItems.SterlingIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.TinDust, new ItemStack(ModItems.TinIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.TitaniumDust, new ItemStack(ModItems.TitaniumIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.TungstenDust, new ItemStack(ModItems.TungstenIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.ZamakDust, new ItemStack(ModItems.ZamakIngot), 0.0F);
		GameRegistry.addSmelting(ModItems.ZincDust, new ItemStack(ModItems.ZincIngot), 0.0F);

		// Vanilla Smelting Dust
		GameRegistry.addSmelting(ModItems.IronDust, new ItemStack(Items.IRON_INGOT), 0.0F);
		GameRegistry.addSmelting(ModItems.GoldDust, new ItemStack(Items.GOLD_INGOT), 0.0F);
		
		// Block recipes
		makeBlock(ModBlocks.AluminiumBlock, "ingotAluminium");
		makeBlock(ModBlocks.AmethystBlock, "gemAmethyst");
		makeBlock(ModBlocks.BabbittBlock, "ingotBabbitt");
		makeBlock(ModBlocks.BlackonyxBlock, "gemBlackonyx");
		makeBlock(ModBlocks.BrassBlock, "ingotBrass");
		makeBlock(ModBlocks.BronzeBlock, "ingotBronze");
		makeBlock(ModBlocks.CarbonBlock, "ingotCarbon");
		makeBlock(ModBlocks.CopperBlock, "ingotCopper");
		makeBlock(ModBlocks.CuproBlock, "ingotCupro");
		makeBlock(ModBlocks.ElectrumBlock, "ingotElectrum");
		makeBlock(ModBlocks.FersiliconBlock, "ingotFersilicon");
		makeBlock(ModBlocks.GradeBlock, "ingotGrade");
		makeBlock(ModBlocks.HssBlock, "ingotHss");
		makeBlock(ModBlocks.InvarBlock, "ingotInvar");
		makeBlock(ModBlocks.LeadBlock, "ingotLead");
		makeBlock(ModBlocks.MoonstoneBlock, "gemMoonstone");
		makeBlock(ModBlocks.NickelBlock, "ingotNickel");
		makeBlock(ModBlocks.RedonyxBlock, "gemRedonyx");
		makeBlock(ModBlocks.RubyBlock, "gemRuby");
		makeBlock(ModBlocks.SapphireBlock, "gemSapphire");
		makeBlock(ModBlocks.SiliconBlock, "ingotSilicon");
		makeBlock(ModBlocks.SilverBlock, "ingotSilver");
		makeBlock(ModBlocks.SteelBlock, "ingotSteel");
		makeBlock(ModBlocks.SterlingBlock, "ingotSterling");
		makeBlock(ModBlocks.TinBlock, "ingotTin");
		makeBlock(ModBlocks.TitaniumBlock, "ingotTitanium");
		makeBlock(ModBlocks.TungstenBlock, "ingotTungsten");
		makeBlock(ModBlocks.ZamakBlock, "ingotZamak");
		makeBlock(ModBlocks.ZincBlock, "ingotZinc");
	}
	
	private static void makeBlock(Block item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CCC","CCC","CCC",'C',material}));
	}	
}
