package com.armctec.nl.ores.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

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
		GameRegistry.registerItem(CopperIngot, Names.Items.COPPER_INGOT);
		GameRegistry.registerItem(TinIngot, Names.Items.TIN_INGOT);
		GameRegistry.registerItem(LeadIngot, Names.Items.LEAD_INGOT);
		GameRegistry.registerItem(AluminiumIngot, Names.Items.ALUMINIUM_INGOT);
	    GameRegistry.registerItem(ZincIngot, Names.Items.ZINC_INGOT);
	    GameRegistry.registerItem(TitaniumIngot, Names.Items.TITANIUM_INGOT);		
	    GameRegistry.registerItem(SilverIngot, Names.Items.SILVER_INGOT);	
	    GameRegistry.registerItem(NickelIngot, Names.Items.NICKEL_INGOT);		
	    GameRegistry.registerItem(TungstenIngot, Names.Items.TUNGSTEN_INGOT);
	    GameRegistry.registerItem(SiliconIngot, Names.Items.SILICON_INGOT);
		// Gems
		GameRegistry.registerItem(RubyGem, Names.Items.RUBY_GEM);
		GameRegistry.registerItem(SapphireGem, Names.Items.SAPPHIRE_GEM);
		GameRegistry.registerItem(MoonstoneGem, Names.Items.MOONSTONE_GEM);
		GameRegistry.registerItem(BlackonyxGem, Names.Items.BLACKONYX_GEM);
		GameRegistry.registerItem(RedonyxGem, Names.Items.REDONYX_GEM);
		GameRegistry.registerItem(AmethystGem, Names.Items.AMETHYST_GEM);
		// Alloys
		GameRegistry.registerItem(BronzeIngot, Names.Items.BRONZE_INGOT);
		GameRegistry.registerItem(BrassIngot, Names.Items.BRASS_INGOT);
		GameRegistry.registerItem(ZamakIngot, Names.Items.ZAMAK_INGOT);
		GameRegistry.registerItem(SterlingSilverIngot, Names.Items.STERLING_INGOT);
		GameRegistry.registerItem(CupronickelIngot, Names.Items.CUPRO_INGOT);
		GameRegistry.registerItem(InvarIngot, Names.Items.INVAR_INGOT);
		GameRegistry.registerItem(SteelIngot, Names.Items.STEEL_INGOT);
		GameRegistry.registerItem(FerrosiliconIngot, Names.Items.FERSILICON_INGOT);
		GameRegistry.registerItem(ElectrumIngot, Names.Items.ELECTRUM_INGOT);
		GameRegistry.registerItem(HssIngot, Names.Items.HSS_INGOT);
		GameRegistry.registerItem(BabbittIngot, Names.Items.BABBITT_INGOT);
		GameRegistry.registerItem(Grade5Ingot, Names.Items.GRADE_INGOT);
		GameRegistry.registerItem(CarbonIngot, Names.Items.CARBON_INGOT);		
	}

}
