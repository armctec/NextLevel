package com.armctec.nl.tools.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes 
{
	public static void init()
	{
		makePickaxe(ModItems.CopperPickaxe, 	"ingotCopper");
		makePickaxe(ModItems.TinPickaxe, 		"ingotTin");
		makePickaxe(ModItems.LeadPickaxe, 		"ingotLead");
		makePickaxe(ModItems.AluminiumPickaxe, 	"ingotAluminium");
		makePickaxe(ModItems.ZincPickaxe, 		"ingotZinc");
		makePickaxe(ModItems.TitaniumPickaxe, 	"ingotTitanium");
		makePickaxe(ModItems.SilverPickaxe, 	"ingotSilver");
		makePickaxe(ModItems.NickelPickaxe, 	"ingotNickel");
		makePickaxe(ModItems.TungstenPickaxe, 	"ingotTungsten");
		makePickaxe(ModItems.SiliconPickaxe, 	"ingotSilicon");
		
		makePickaxe(ModItems.RubyPickaxe, 		"gemRuby");
		makePickaxe(ModItems.SapphirePickaxe, 	"gemSapphire");
		makePickaxe(ModItems.BlackonyxPickaxe, 	"gemBlackonyx");
		makePickaxe(ModItems.RedonyxPickaxe, 	"gemRedonyx");
		makePickaxe(ModItems.AmethystPickaxe, 	"gemAmethyst");
		
		makePickaxe(ModItems.BronzePickaxe, 	"ingotBronze");
		makePickaxe(ModItems.BrassPickaxe, 		"ingotBrass");
		makePickaxe(ModItems.ZamakPickaxe, 		"ingotZamak");
		makePickaxe(ModItems.SterlingPickaxe, 	"ingotSterling");
		makePickaxe(ModItems.CuproPickaxe, 		"ingotCupro");
		makePickaxe(ModItems.InvarPickaxe, 		"ingotInvar");
		makePickaxe(ModItems.SteelPickaxe, 		"ingotSteel");
		makePickaxe(ModItems.FersiliconPickaxe, "ingotFersilicon");
		makePickaxe(ModItems.ElectrumPickaxe, 	"ingotElectrum");
		makePickaxe(ModItems.HSSPickaxe, 		"ingotHSS");
		makePickaxe(ModItems.BabbittPickaxe, 	"ingotBabbitt");
		makePickaxe(ModItems.GradePickaxe, 		"ingotGrade");
		makePickaxe(ModItems.CarbonPickaxe, 	"ingotCarbon");
	}
	
	private static void makePickaxe(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CCC"," S "," S ",'C',material,'S',"stickWood"}));
	}
}
