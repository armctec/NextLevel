package com.armctec.nl.ores.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

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
	
	public static void init()
	{
		// Ingot
		registerItems(CopperIngot, Names.Items.COPPER_INGOT, "ingotCopper");
		registerItems(TinIngot, Names.Items.TIN_INGOT, "ingotTin");
		registerItems(LeadIngot, Names.Items.LEAD_INGOT, "ingotLead");
		registerItems(AluminiumIngot, Names.Items.ALUMINIUM_INGOT, "ingotAluminium");
	    registerItems(ZincIngot, Names.Items.ZINC_INGOT, "ingotZinc");
	    registerItems(TitaniumIngot, Names.Items.TITANIUM_INGOT, "ingotTitanium");		
	    registerItems(SilverIngot, Names.Items.SILVER_INGOT, "ingotSilver");	
	    registerItems(NickelIngot, Names.Items.NICKEL_INGOT, "ingotNickel");		
	    registerItems(TungstenIngot, Names.Items.TUNGSTEN_INGOT, "ingotTungsten");
	    registerItems(SiliconIngot, Names.Items.SILICON_INGOT, "ingotSilicon");
		// Gems
		registerItems(RubyGem, Names.Items.RUBY_GEM, "gemRuby");
		registerItems(SapphireGem, Names.Items.SAPPHIRE_GEM, "gemSapphire");
		registerItems(MoonstoneGem, Names.Items.MOONSTONE_GEM, "gemMoonstone");
		registerItems(BlackonyxGem, Names.Items.BLACKONYX_GEM, "gemBlackonyx");
		registerItems(RedonyxGem, Names.Items.REDONYX_GEM, "gemRedonyx");
		registerItems(AmethystGem, Names.Items.AMETHYST_GEM, "gemAmethyst");
		// Alloys
		registerItems(BronzeIngot, Names.Items.BRONZE_INGOT, "ingotBronze");
		registerItems(BrassIngot, Names.Items.BRASS_INGOT, "ingotBrass");
		registerItems(ZamakIngot, Names.Items.ZAMAK_INGOT, "ingotZamak");
		registerItems(SterlingSilverIngot, Names.Items.STERLING_INGOT, "ingotSterling");
		registerItems(CupronickelIngot, Names.Items.CUPRO_INGOT, "ingotCupro");
		registerItems(InvarIngot, Names.Items.INVAR_INGOT, "ingotInvar");
		registerItems(SteelIngot, Names.Items.STEEL_INGOT, "ingotSteel");
		registerItems(FerrosiliconIngot, Names.Items.FERSILICON_INGOT, "ingotFersilicon");
		registerItems(ElectrumIngot, Names.Items.ELECTRUM_INGOT, "ingotElectrum");
		registerItems(HssIngot, Names.Items.HSS_INGOT, "ingotHSS");
		registerItems(BabbittIngot, Names.Items.BABBITT_INGOT, "ingotBabbitt");
		registerItems(Grade5Ingot, Names.Items.GRADE_INGOT, "ingotGrade5");
		registerItems(CarbonIngot, Names.Items.CARBON_INGOT, "ingotCarbon");		
	}
	
	
	private static void registerItems(Item item, String name, String ore)
	{
		GameRegistry.registerItem(item, name);	// Register Minecraft
		OreDictionary.registerOre(ore, item);		// Register Forge
	}	
}
