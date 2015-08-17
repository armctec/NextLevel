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
		// Pickaxe
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
		
		// Axe
		makeAxe(ModItems.CopperAxe, 	"ingotCopper");
		makeAxe(ModItems.TinAxe, 		"ingotTin");
		makeAxe(ModItems.LeadAxe, 		"ingotLead");
		makeAxe(ModItems.AluminiumAxe, 	"ingotAluminium");
		makeAxe(ModItems.ZincAxe, 		"ingotZinc");
		makeAxe(ModItems.TitaniumAxe, 	"ingotTitanium");
		makeAxe(ModItems.SilverAxe, 	"ingotSilver");
		makeAxe(ModItems.NickelAxe, 	"ingotNickel");
		makeAxe(ModItems.TungstenAxe, 	"ingotTungsten");
		makeAxe(ModItems.SiliconAxe, 	"ingotSilicon");
		
		makeAxe(ModItems.RubyAxe, 		"gemRuby");
		makeAxe(ModItems.SapphireAxe, 	"gemSapphire");
		makeAxe(ModItems.BlackonyxAxe, 	"gemBlackonyx");
		makeAxe(ModItems.RedonyxAxe, 	"gemRedonyx");
		makeAxe(ModItems.AmethystAxe, 	"gemAmethyst");
		
		makeAxe(ModItems.BronzeAxe, 	"ingotBronze");
		makeAxe(ModItems.BrassAxe, 		"ingotBrass");
		makeAxe(ModItems.ZamakAxe, 		"ingotZamak");
		makeAxe(ModItems.SterlingAxe, 	"ingotSterling");
		makeAxe(ModItems.CuproAxe, 		"ingotCupro");
		makeAxe(ModItems.InvarAxe, 		"ingotInvar");
		makeAxe(ModItems.SteelAxe, 		"ingotSteel");
		makeAxe(ModItems.FersiliconAxe, "ingotFersilicon");
		makeAxe(ModItems.ElectrumAxe, 	"ingotElectrum");
		makeAxe(ModItems.HSSAxe, 		"ingotHSS");
		makeAxe(ModItems.BabbittAxe, 	"ingotBabbitt");
		makeAxe(ModItems.GradeAxe, 		"ingotGrade");
		makeAxe(ModItems.CarbonAxe, 	"ingotCarbon");	
		
		// Hoe
		makeHoe(ModItems.CopperHoe, 	"ingotCopper");
		makeHoe(ModItems.TinHoe, 		"ingotTin");
		makeHoe(ModItems.LeadHoe, 		"ingotLead");
		makeHoe(ModItems.AluminiumHoe, 	"ingotAluminium");
		makeHoe(ModItems.ZincHoe, 		"ingotZinc");
		makeHoe(ModItems.TitaniumHoe, 	"ingotTitanium");
		makeHoe(ModItems.SilverHoe, 	"ingotSilver");
		makeHoe(ModItems.NickelHoe, 	"ingotNickel");
		makeHoe(ModItems.TungstenHoe, 	"ingotTungsten");
		makeHoe(ModItems.SiliconHoe, 	"ingotSilicon");
		
		makeHoe(ModItems.RubyHoe, 		"gemRuby");
		makeHoe(ModItems.SapphireHoe, 	"gemSapphire");
		makeHoe(ModItems.BlackonyxHoe, 	"gemBlackonyx");
		makeHoe(ModItems.RedonyxHoe, 	"gemRedonyx");
		makeHoe(ModItems.AmethystHoe, 	"gemAmethyst");
		
		makeHoe(ModItems.BronzeHoe, 	"ingotBronze");
		makeHoe(ModItems.BrassHoe, 		"ingotBrass");
		makeHoe(ModItems.ZamakHoe, 		"ingotZamak");
		makeHoe(ModItems.SterlingHoe, 	"ingotSterling");
		makeHoe(ModItems.CuproHoe, 		"ingotCupro");
		makeHoe(ModItems.InvarHoe, 		"ingotInvar");
		makeHoe(ModItems.SteelHoe, 		"ingotSteel");
		makeHoe(ModItems.FersiliconHoe, "ingotFersilicon");
		makeHoe(ModItems.ElectrumHoe, 	"ingotElectrum");
		makeHoe(ModItems.HSSHoe, 		"ingotHSS");
		makeHoe(ModItems.BabbittHoe, 	"ingotBabbitt");
		makeHoe(ModItems.GradeHoe, 		"ingotGrade");
		makeHoe(ModItems.CarbonHoe, 	"ingotCarbon");
		
		// Sword
		makeSword(ModItems.CopperSword, 	"ingotCopper");
		makeSword(ModItems.TinSword, 		"ingotTin");
		makeSword(ModItems.LeadSword, 		"ingotLead");
		makeSword(ModItems.AluminiumSword, 	"ingotAluminium");
		makeSword(ModItems.ZincSword, 		"ingotZinc");
		makeSword(ModItems.TitaniumSword, 	"ingotTitanium");
		makeSword(ModItems.SilverSword, 	"ingotSilver");
		makeSword(ModItems.NickelSword, 	"ingotNickel");
		makeSword(ModItems.TungstenSword, 	"ingotTungsten");
		makeSword(ModItems.SiliconSword, 	"ingotSilicon");
		
		makeSword(ModItems.RubySword, 		"gemRuby");
		makeSword(ModItems.SapphireSword, 	"gemSapphire");
		makeSword(ModItems.BlackonyxSword, 	"gemBlackonyx");
		makeSword(ModItems.RedonyxSword, 	"gemRedonyx");
		makeSword(ModItems.AmethystSword, 	"gemAmethyst");
		
		makeSword(ModItems.BronzeSword, 	"ingotBronze");
		makeSword(ModItems.BrassSword, 		"ingotBrass");
		makeSword(ModItems.ZamakSword, 		"ingotZamak");
		makeSword(ModItems.SterlingSword, 	"ingotSterling");
		makeSword(ModItems.CuproSword, 		"ingotCupro");
		makeSword(ModItems.InvarSword, 		"ingotInvar");
		makeSword(ModItems.SteelSword, 		"ingotSteel");
		makeSword(ModItems.FersiliconSword, "ingotFersilicon");
		makeSword(ModItems.ElectrumSword, 	"ingotElectrum");
		makeSword(ModItems.HSSSword, 		"ingotHSS");
		makeSword(ModItems.BabbittSword, 	"ingotBabbitt");
		makeSword(ModItems.GradeSword, 		"ingotGrade");
		makeSword(ModItems.CarbonSword, 	"ingotCarbon");
		
		// Shovel
		makeShovel(ModItems.CopperShovel, 	    "ingotCopper");
		makeShovel(ModItems.TinShovel, 		    "ingotTin");
		makeShovel(ModItems.LeadShovel, 		"ingotLead");
		makeShovel(ModItems.AluminiumShovel, 	"ingotAluminium");
		makeShovel(ModItems.ZincShovel, 		"ingotZinc");
		makeShovel(ModItems.TitaniumShovel, 	"ingotTitanium");
		makeShovel(ModItems.SilverShovel, 	    "ingotSilver");
		makeShovel(ModItems.NickelShovel, 	    "ingotNickel");
		makeShovel(ModItems.TungstenShovel, 	"ingotTungsten");
		makeShovel(ModItems.SiliconShovel, 	    "ingotSilicon");
		
		makeShovel(ModItems.RubyShovel, 		"gemRuby");
		makeShovel(ModItems.SapphireShovel, 	"gemSapphire");
		makeShovel(ModItems.BlackonyxShovel, 	"gemBlackonyx");
		makeShovel(ModItems.RedonyxShovel, 	    "gemRedonyx");
		makeShovel(ModItems.AmethystShovel, 	"gemAmethyst");
		
		makeShovel(ModItems.BronzeShovel, 	    "ingotBronze");
		makeShovel(ModItems.BrassShovel, 		"ingotBrass");
		makeShovel(ModItems.ZamakShovel, 		"ingotZamak");
		makeShovel(ModItems.SterlingShovel, 	"ingotSterling");
		makeShovel(ModItems.CuproShovel, 		"ingotCupro");
		makeShovel(ModItems.InvarShovel, 		"ingotInvar");
		makeShovel(ModItems.SteelShovel, 		"ingotSteel");
		makeShovel(ModItems.FersiliconShovel,   "ingotFersilicon");
		makeShovel(ModItems.ElectrumShovel, 	"ingotElectrum");
		makeShovel(ModItems.HSSShovel, 		    "ingotHSS");
		makeShovel(ModItems.BabbittShovel, 	    "ingotBabbitt");
		makeShovel(ModItems.GradeShovel, 		"ingotGrade");
		makeShovel(ModItems.CarbonShovel, 	    "ingotCarbon");

	}
	
	private static void makePickaxe(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CCC"," S "," S ",'C',material,'S',"stickWood"}));
	}
	
	private static void makeAxe(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CC ","CS "," S ",'C',material,'S',"stickWood"}));
	}	
	
	private static void makeHoe(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CC "," S "," S ",'C',material,'S',"stickWood"}));
	}	
	
	private static void makeSword(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{" C "," C "," S ",'C',material,'S',"stickWood"}));
	}
	
	private static void makeShovel(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{" C "," S "," S ",'C',material,'S',"stickWood"}));
	}	
}
