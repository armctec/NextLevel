package com.armctec.nl.ores.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.armctec.nl.general.utility.RegisterServer;
import com.armctec.nl.ores.item.ItemDust;
import com.armctec.nl.ores.item.ItemGem;
import com.armctec.nl.ores.item.ItemIngot;
import com.armctec.nl.ores.reference.Names;

public class ModItems
{
	// Ingots
	public final static ItemIngot CopperIngot = new ItemIngot(Names.Items.COPPER_INGOT, 64);
	public final static ItemIngot TinIngot = new ItemIngot(Names.Items.TIN_INGOT, 64);
	public final static ItemIngot LeadIngot = new ItemIngot(Names.Items.LEAD_INGOT, 64);
	public final static ItemIngot AluminiumIngot = new ItemIngot(Names.Items.ALUMINIUM_INGOT, 64);
	public final static ItemIngot ZincIngot = new ItemIngot(Names.Items.ZINC_INGOT, 64);
	public final static ItemIngot TitaniumIngot = new ItemIngot(Names.Items.TITANIUM_INGOT, 64);
	public final static ItemIngot SilverIngot = new ItemIngot(Names.Items.SILVER_INGOT, 64);
	public final static ItemIngot NickelIngot = new ItemIngot(Names.Items.NICKEL_INGOT, 64);
	public final static ItemIngot TungstenIngot = new ItemIngot(Names.Items.TUNGSTEN_INGOT, 64);
	public final static ItemIngot SiliconIngot = new ItemIngot(Names.Items.SILICON_INGOT, 64);
	// Gems
	public final static ItemGem RubyGem = new ItemGem(Names.Items.RUBY_GEM, 64);
	public final static ItemGem SapphireGem = new ItemGem(Names.Items.SAPPHIRE_GEM, 64);
	public final static ItemGem MoonstoneGem = new ItemGem(Names.Items.MOONSTONE_GEM, 64);
	public final static ItemGem BlackonyxGem = new ItemGem(Names.Items.BLACKONYX_GEM, 64);
	public final static ItemGem RedonyxGem = new ItemGem(Names.Items.REDONYX_GEM, 64);
	public final static ItemGem AmethystGem = new ItemGem(Names.Items.AMETHYST_GEM, 64);
	// Alloys
	public final static ItemIngot BronzeIngot = new ItemIngot(Names.Items.BRONZE_INGOT, 64);	
	public final static ItemIngot BrassIngot = new ItemIngot(Names.Items.BRASS_INGOT, 64);	
	public final static ItemIngot ZamakIngot = new ItemIngot(Names.Items.ZAMAK_INGOT, 64);	
	public final static ItemIngot SterlingSilverIngot = new ItemIngot(Names.Items.STERLING_INGOT, 64);	
	public final static ItemIngot CupronickelIngot = new ItemIngot(Names.Items.CUPRO_INGOT, 64);	
	public final static ItemIngot InvarIngot = new ItemIngot(Names.Items.INVAR_INGOT, 64);	
	public final static ItemIngot SteelIngot = new ItemIngot(Names.Items.STEEL_INGOT, 64);	
	public final static ItemIngot FerrosiliconIngot = new ItemIngot(Names.Items.FERSILICON_INGOT, 64);	
	public final static ItemIngot ElectrumIngot = new ItemIngot(Names.Items.ELECTRUM_INGOT, 64);	
	public final static ItemIngot HssIngot = new ItemIngot(Names.Items.HSS_INGOT, 64);	
	public final static ItemIngot BabbittIngot = new ItemIngot(Names.Items.BABBITT_INGOT, 64);	
	public final static ItemIngot Grade5Ingot = new ItemIngot(Names.Items.GRADE_INGOT, 64);
	public final static ItemIngot CarbonIngot = new ItemIngot(Names.Items.CARBON_INGOT, 64);
	// Dust
	public final static ItemDust AluminiumDust = new ItemDust(Names.Items.ALUMINIUM_DUST, 64);
	public final static ItemDust AmethystDust = new ItemDust(Names.Items.AMETHYST_DUST, 64);
	public final static ItemDust BabbittDust = new ItemDust(Names.Items.BABBITT_DUST, 64);
	public final static ItemDust BlackonyxDust = new ItemDust(Names.Items.BLACKONYX_DUST, 64);
	public final static ItemDust BrassDust = new ItemDust(Names.Items.BRASS_DUST, 64);
	public final static ItemDust BronzeDust = new ItemDust(Names.Items.BRONZE_DUST, 64);
	public final static ItemDust CarbonDust = new ItemDust(Names.Items.CARBON_DUST, 64);
	public final static ItemDust CopperDust = new ItemDust(Names.Items.COPPER_DUST, 64);
	public final static ItemDust CuproDust = new ItemDust(Names.Items.CUPRO_DUST, 64);
	public final static ItemDust ElectrumDust = new ItemDust(Names.Items.ELECTRUM_DUST, 64);
	public final static ItemDust FersiliconDust = new ItemDust(Names.Items.FERSILICON_DUST, 64);
	public final static ItemDust GradeDust = new ItemDust(Names.Items.GRADE_DUST, 64);
	public final static ItemDust HssDust = new ItemDust(Names.Items.HSS_DUST, 64);
	public final static ItemDust InvarDust = new ItemDust(Names.Items.INVAR_DUST, 64);
	public final static ItemDust LeadDust = new ItemDust(Names.Items.LEAD_DUST, 64);
	public final static ItemDust MoonstoneDust = new ItemDust(Names.Items.MOONSTONE_DUST, 64);
	public final static ItemDust NickelDust = new ItemDust(Names.Items.NICKEL_DUST, 64);
	public final static ItemDust RedonyxDust = new ItemDust(Names.Items.REDONYX_DUST, 64);
	public final static ItemDust RubyDust = new ItemDust(Names.Items.RUBY_DUST, 64);
	public final static ItemDust SapphireDust = new ItemDust(Names.Items.SAPPHIRE_DUST, 64);
	public final static ItemDust SiliconDust = new ItemDust(Names.Items.SILICON_DUST, 64);
	public final static ItemDust SilverDust = new ItemDust(Names.Items.SILVER_DUST, 64);
	public final static ItemDust SteelDust = new ItemDust(Names.Items.STEEL_DUST, 64);
	public final static ItemDust SterlingDust = new ItemDust(Names.Items.STERLING_DUST, 64);
	public final static ItemDust TinDust = new ItemDust(Names.Items.TIN_DUST, 64);
	public final static ItemDust TitaniumDust = new ItemDust(Names.Items.TITANIUM_DUST, 64);
	public final static ItemDust TungstenDust = new ItemDust(Names.Items.TUNGSTEN_DUST, 64);
	public final static ItemDust ZamakDust = new ItemDust(Names.Items.ZAMAK_DUST, 64);
	public final static ItemDust ZincDust = new ItemDust(Names.Items.ZINC_DUST, 64);
	// Vanilla Dust
	public final static ItemDust DiamondDust = new ItemDust(Names.Items.DIAMOND_DUST, 64);
	public final static ItemDust EmeraldDust = new ItemDust(Names.Items.EMERALD_DUST, 64);
	public final static ItemDust Ender_pearlDust = new ItemDust(Names.Items.ENDER_PEARL_DUST, 64);
	public final static ItemDust GoldDust = new ItemDust(Names.Items.GOLD_DUST, 64);
	public final static ItemDust IronDust = new ItemDust(Names.Items.IRON_DUST, 64);

	
	public static void init()
	{
		// Ingot
		RegisterServer.registerItems(CopperIngot, Names.Items.COPPER_INGOT, "ingotCopper");
		RegisterServer.registerItems(TinIngot, Names.Items.TIN_INGOT, "ingotTin");
		RegisterServer.registerItems(LeadIngot, Names.Items.LEAD_INGOT, "ingotLead");
		RegisterServer.registerItems(AluminiumIngot, Names.Items.ALUMINIUM_INGOT, "ingotAluminium");
	    RegisterServer.registerItems(ZincIngot, Names.Items.ZINC_INGOT, "ingotZinc");
	    RegisterServer.registerItems(TitaniumIngot, Names.Items.TITANIUM_INGOT, "ingotTitanium");		
	    RegisterServer.registerItems(SilverIngot, Names.Items.SILVER_INGOT, "ingotSilver");	
	    RegisterServer.registerItems(NickelIngot, Names.Items.NICKEL_INGOT, "ingotNickel");		
	    RegisterServer.registerItems(TungstenIngot, Names.Items.TUNGSTEN_INGOT, "ingotTungsten");
	    RegisterServer.registerItems(SiliconIngot, Names.Items.SILICON_INGOT, "ingotSilicon");
		// Gems
		RegisterServer.registerItems(RubyGem, Names.Items.RUBY_GEM, "gemRuby");
		RegisterServer.registerItems(SapphireGem, Names.Items.SAPPHIRE_GEM, "gemSapphire");
		RegisterServer.registerItems(MoonstoneGem, Names.Items.MOONSTONE_GEM, "gemMoonstone");
		RegisterServer.registerItems(BlackonyxGem, Names.Items.BLACKONYX_GEM, "gemBlackonyx");
		RegisterServer.registerItems(RedonyxGem, Names.Items.REDONYX_GEM, "gemRedonyx");
		RegisterServer.registerItems(AmethystGem, Names.Items.AMETHYST_GEM, "gemAmethyst");
		// Alloys
		RegisterServer.registerItems(BronzeIngot, Names.Items.BRONZE_INGOT, "ingotBronze");
		RegisterServer.registerItems(BrassIngot, Names.Items.BRASS_INGOT, "ingotBrass");
		RegisterServer.registerItems(ZamakIngot, Names.Items.ZAMAK_INGOT, "ingotZamak");
		RegisterServer.registerItems(SterlingSilverIngot, Names.Items.STERLING_INGOT, "ingotSterling");
		RegisterServer.registerItems(CupronickelIngot, Names.Items.CUPRO_INGOT, "ingotCupro");
		RegisterServer.registerItems(InvarIngot, Names.Items.INVAR_INGOT, "ingotInvar");
		RegisterServer.registerItems(SteelIngot, Names.Items.STEEL_INGOT, "ingotSteel");
		RegisterServer.registerItems(FerrosiliconIngot, Names.Items.FERSILICON_INGOT, "ingotFersilicon");
		RegisterServer.registerItems(ElectrumIngot, Names.Items.ELECTRUM_INGOT, "ingotElectrum");
		RegisterServer.registerItems(HssIngot, Names.Items.HSS_INGOT, "ingotHSS");
		RegisterServer.registerItems(BabbittIngot, Names.Items.BABBITT_INGOT, "ingotBabbitt");
		RegisterServer.registerItems(Grade5Ingot, Names.Items.GRADE_INGOT, "ingotGrade");
		RegisterServer.registerItems(CarbonIngot, Names.Items.CARBON_INGOT, "ingotCarbon");	
		// Dust
		RegisterServer.registerItems(AluminiumDust, Names.Items.ALUMINIUM_DUST, "dustAluminium");
		RegisterServer.registerItems(AmethystDust, Names.Items.AMETHYST_DUST, "dustAmethyst");
		RegisterServer.registerItems(BabbittDust, Names.Items.BABBITT_DUST, "dustBabbitt");
		RegisterServer.registerItems(BlackonyxDust, Names.Items.BLACKONYX_DUST, "dustBlackonyx");
		RegisterServer.registerItems(BrassDust, Names.Items.BRASS_DUST, "dustBrass");
		RegisterServer.registerItems(BronzeDust, Names.Items.BRONZE_DUST, "dustBronze");
		RegisterServer.registerItems(CarbonDust, Names.Items.CARBON_DUST, "dustCarbon");
		RegisterServer.registerItems(CopperDust, Names.Items.COPPER_DUST, "dustCopper");
		RegisterServer.registerItems(CuproDust, Names.Items.CUPRO_DUST, "dustCupro");
		RegisterServer.registerItems(ElectrumDust, Names.Items.ELECTRUM_DUST, "dustElectrum");
		RegisterServer.registerItems(FersiliconDust, Names.Items.FERSILICON_DUST, "dustFersilicon");
		RegisterServer.registerItems(GradeDust, Names.Items.GRADE_DUST, "dustGrade");
		RegisterServer.registerItems(HssDust, Names.Items.HSS_DUST, "dustHss");
		RegisterServer.registerItems(InvarDust, Names.Items.INVAR_DUST, "dustInvar");
		RegisterServer.registerItems(LeadDust, Names.Items.LEAD_DUST, "dustLead");
		RegisterServer.registerItems(MoonstoneDust, Names.Items.MOONSTONE_DUST, "dustMoonstone");
		RegisterServer.registerItems(NickelDust, Names.Items.NICKEL_DUST, "dustNickel");
		RegisterServer.registerItems(RedonyxDust, Names.Items.REDONYX_DUST, "dustRedonyx");
		RegisterServer.registerItems(RubyDust, Names.Items.RUBY_DUST, "dustRuby");
		RegisterServer.registerItems(SapphireDust, Names.Items.SAPPHIRE_DUST, "dustSapphire");
		RegisterServer.registerItems(SiliconDust, Names.Items.SILICON_DUST, "dustSilicon");
		RegisterServer.registerItems(SilverDust, Names.Items.SILVER_DUST, "dustSilver");
		RegisterServer.registerItems(SteelDust, Names.Items.STEEL_DUST, "dustSteel");
		RegisterServer.registerItems(SterlingDust, Names.Items.STERLING_DUST, "dustSterling");
		RegisterServer.registerItems(TinDust, Names.Items.TIN_DUST, "dustTin");
		RegisterServer.registerItems(TitaniumDust, Names.Items.TITANIUM_DUST, "dustTitanium");
		RegisterServer.registerItems(TungstenDust, Names.Items.TUNGSTEN_DUST, "dustTungsten");
		RegisterServer.registerItems(ZamakDust, Names.Items.ZAMAK_DUST, "dustZamak");
		RegisterServer.registerItems(ZincDust, Names.Items.ZINC_DUST, "dustZinc");
		// Vanilla Dust
		RegisterServer.registerItems(DiamondDust, Names.Items.DIAMOND_DUST, "dustDiamond");
		RegisterServer.registerItems(EmeraldDust, Names.Items.EMERALD_DUST, "dustEmerald");
		RegisterServer.registerItems(Ender_pearlDust, Names.Items.ENDER_PEARL_DUST, "dustEnderPearl");
		RegisterServer.registerItems(GoldDust, Names.Items.GOLD_DUST, "dustGold");
		RegisterServer.registerItems(IronDust, Names.Items.IRON_DUST, "dustIron");
	}
}
