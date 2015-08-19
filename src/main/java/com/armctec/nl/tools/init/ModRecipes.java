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

		// Armor Helmet
		makeHelmet(ModItems.AluminiumHelmet,	 	"ingotAluminium");
		makeHelmet(ModItems.AmethystHelmet,	 		"ingotAmethyst");
		makeHelmet(ModItems.BabbittHelmet,	 		"ingotBabbitt");
		makeHelmet(ModItems.BlackonyxHelmet,	 	"ingotBlackonyx");
		makeHelmet(ModItems.BrassHelmet,	 		"ingotBrass");
		makeHelmet(ModItems.BronzeHelmet,	 		"ingotBronze");
		makeHelmet(ModItems.CarbonHelmet,	 		"ingotCarbon");
		makeHelmet(ModItems.CopperHelmet,	 		"ingotCopper");
		makeHelmet(ModItems.CuproHelmet,	 		"ingotCupro");
		makeHelmet(ModItems.ElectrumHelmet,	 		"ingotElectrum");
		makeHelmet(ModItems.FersiliconHelmet,	 	"ingotFersilicon");
		makeHelmet(ModItems.GradeHelmet,	 		"ingotGrade");
		makeHelmet(ModItems.HssHelmet,	 		    "ingotHss");
		makeHelmet(ModItems.InvarHelmet,	 		"ingotInvar");
		makeHelmet(ModItems.LeadHelmet,	 		    "ingotLead");
		makeHelmet(ModItems.MoonstoneHelmet,	 	"ingotMoonstone");
		makeHelmet(ModItems.NickelHelmet,	 		"ingotNickel");
		makeHelmet(ModItems.RedonyxHelmet,	 		"ingotRedonyx");
		makeHelmet(ModItems.RubyHelmet,	 		    "ingotRuby");
		makeHelmet(ModItems.SapphireHelmet,	 		"ingotSapphire");
		makeHelmet(ModItems.SiliconHelmet,	 		"ingotSilicon");
		makeHelmet(ModItems.SilverHelmet,	 		"ingotSilver");
		makeHelmet(ModItems.SteelHelmet,	 		"ingotSteel");
		makeHelmet(ModItems.SterlingHelmet,	 		"ingotSterling");
		makeHelmet(ModItems.TinHelmet,	 		    "ingotTin");
		makeHelmet(ModItems.TitaniumHelmet,	 		"ingotTitanium");
		makeHelmet(ModItems.TungstenHelmet,	 		"ingotTungsten");
		makeHelmet(ModItems.ZamakHelmet,	 		"ingotZamak");
		makeHelmet(ModItems.ZincHelmet,	 		    "ingotZinc");

		// Armor Chestplate
		makeChestplate(ModItems.AluminiumChestplate,	"ingotAluminium");
		makeChestplate(ModItems.AmethystChestplate,	    "ingotAmethyst");
		makeChestplate(ModItems.BabbittChestplate,	    "ingotBabbitt");
		makeChestplate(ModItems.BlackonyxChestplate,	"ingotBlackonyx");
		makeChestplate(ModItems.BrassChestplate,	    "ingotBrass");
		makeChestplate(ModItems.BronzeChestplate,	    "ingotBronze");
		makeChestplate(ModItems.CarbonChestplate,	    "ingotCarbon");
		makeChestplate(ModItems.CopperChestplate,	    "ingotCopper");
		makeChestplate(ModItems.CuproChestplate,	    "ingotCupro");
		makeChestplate(ModItems.ElectrumChestplate,	    "ingotElectrum");
		makeChestplate(ModItems.FersiliconChestplate,	"ingotFersilicon");
		makeChestplate(ModItems.GradeChestplate,	    "ingotGrade");
		makeChestplate(ModItems.HssChestplate,	        "ingotHss");
		makeChestplate(ModItems.InvarChestplate,	    "ingotInvar");
		makeChestplate(ModItems.LeadChestplate,	        "ingotLead");
		makeChestplate(ModItems.MoonstoneChestplate,	"ingotMoonstone");
		makeChestplate(ModItems.NickelChestplate,	    "ingotNickel");
		makeChestplate(ModItems.RedonyxChestplate,	    "ingotRedonyx");
		makeChestplate(ModItems.RubyChestplate,	        "ingotRuby");
		makeChestplate(ModItems.SapphireChestplate,	    "ingotSapphire");
		makeChestplate(ModItems.SiliconChestplate,	    "ingotSilicon");
		makeChestplate(ModItems.SilverChestplate,	    "ingotSilver");
		makeChestplate(ModItems.SteelChestplate,	    "ingotSteel");
		makeChestplate(ModItems.SterlingChestplate,	    "ingotSterling");
		makeChestplate(ModItems.TinChestplate,	        "ingotTin");
		makeChestplate(ModItems.TitaniumChestplate,	    "ingotTitanium");
		makeChestplate(ModItems.TungstenChestplate,	    "ingotTungsten");
		makeChestplate(ModItems.ZamakChestplate,	    "ingotZamak");
		makeChestplate(ModItems.ZincChestplate,	        "ingotZinc");

		// Armor Leggings
		makeLeggings(ModItems.AluminiumLeggings,	 	"ingotAluminium");
		makeLeggings(ModItems.AmethystLeggings,	 	    "ingotAmethyst");
		makeLeggings(ModItems.BabbittLeggings,	 	    "ingotBabbitt");
		makeLeggings(ModItems.BlackonyxLeggings,	 	"ingotBlackonyx");
		makeLeggings(ModItems.BrassLeggings,	 	    "ingotBrass");
		makeLeggings(ModItems.BronzeLeggings,	 	    "ingotBronze");
		makeLeggings(ModItems.CarbonLeggings,	 	    "ingotCarbon");
		makeLeggings(ModItems.CopperLeggings,	 	    "ingotCopper");
		makeLeggings(ModItems.CuproLeggings,	 	    "ingotCupro");
		makeLeggings(ModItems.ElectrumLeggings,	 	    "ingotElectrum");
		makeLeggings(ModItems.FersiliconLeggings,	 	"ingotFersilicon");
		makeLeggings(ModItems.GradeLeggings,	 	    "ingotGrade");
		makeLeggings(ModItems.HssLeggings,	 	        "ingotHss");
		makeLeggings(ModItems.InvarLeggings,	 	    "ingotInvar");
		makeLeggings(ModItems.LeadLeggings,	 	        "ingotLead");
		makeLeggings(ModItems.MoonstoneLeggings,	 	"ingotMoonstone");
		makeLeggings(ModItems.NickelLeggings,	 	    "ingotNickel");
		makeLeggings(ModItems.RedonyxLeggings,	 	    "ingotRedonyx");
		makeLeggings(ModItems.RubyLeggings,	 	        "ingotRuby");
		makeLeggings(ModItems.SapphireLeggings,	 	    "ingotSapphire");
		makeLeggings(ModItems.SiliconLeggings,	 	    "ingotSilicon");
		makeLeggings(ModItems.SilverLeggings,	 	    "ingotSilver");
		makeLeggings(ModItems.SteelLeggings,	 	    "ingotSteel");
		makeLeggings(ModItems.SterlingLeggings,	 	    "ingotSterling");
		makeLeggings(ModItems.TinLeggings,	 	        "ingotTin");
		makeLeggings(ModItems.TitaniumLeggings,	 	    "ingotTitanium");
		makeLeggings(ModItems.TungstenLeggings,	 	    "ingotTungsten");
		makeLeggings(ModItems.ZamakLeggings,	 	    "ingotZamak");
		makeLeggings(ModItems.ZincLeggings,	 	        "ingotZinc");

		// Armor Boots
		makeBoots(ModItems.AluminiumBoots,	 	"ingotAluminium");
		makeBoots(ModItems.AmethystBoots,	 	"ingotAmethyst");
		makeBoots(ModItems.BabbittBoots,	 	"ingotBabbitt");
		makeBoots(ModItems.BlackonyxBoots,	 	"ingotBlackonyx");
		makeBoots(ModItems.BrassBoots,	 		"ingotBrass");
		makeBoots(ModItems.BronzeBoots,	 		"ingotBronze");
		makeBoots(ModItems.CarbonBoots,	 		"ingotCarbon");
		makeBoots(ModItems.CopperBoots,	 		"ingotCopper");
		makeBoots(ModItems.CuproBoots,	 		"ingotCupro");
		makeBoots(ModItems.ElectrumBoots,	 	"ingotElectrum");
		makeBoots(ModItems.FersiliconBoots,	 	"ingotFersilicon");
		makeBoots(ModItems.GradeBoots,	 		"ingotGrade");
		makeBoots(ModItems.HssBoots,	 		"ingotHss");
		makeBoots(ModItems.InvarBoots,	 		"ingotInvar");
		makeBoots(ModItems.LeadBoots,	 		"ingotLead");
		makeBoots(ModItems.MoonstoneBoots,	 	"ingotMoonstone");
		makeBoots(ModItems.NickelBoots,	 		"ingotNickel");
		makeBoots(ModItems.RedonyxBoots,	 	"ingotRedonyx");
		makeBoots(ModItems.RubyBoots,	 		"ingotRuby");
		makeBoots(ModItems.SapphireBoots,	 	"ingotSapphire");
		makeBoots(ModItems.SiliconBoots,	 	"ingotSilicon");
		makeBoots(ModItems.SilverBoots,	 		"ingotSilver");
		makeBoots(ModItems.SteelBoots,	 		"ingotSteel");
		makeBoots(ModItems.SterlingBoots,	 	"ingotSterling");
		makeBoots(ModItems.TinBoots,	 		"ingotTin");
		makeBoots(ModItems.TitaniumBoots,	 	"ingotTitanium");
		makeBoots(ModItems.TungstenBoots,	 	"ingotTungsten");
		makeBoots(ModItems.ZamakBoots,	 		"ingotZamak");
		makeBoots(ModItems.ZincBoots,	 		"ingotZinc");
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
	
	private static void makeHelmet(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CCC","C C","   ",'C',material}));
	}

	private static void makeChestplate(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"C C","CCC","CCC",'C',material}));
	}

	private static void makeLeggings(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"CCC","C C","C C",'C',material}));
	}

	private static void makeBoots(Item item, String material)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[]{"   ","C C","C C",'C',material}));
	}
}
