package com.armctec.nl.tools.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.tools.item.Pickaxe;
import com.armctec.nl.tools.item.Tools;
import com.armctec.nl.tools.reference.Names;

public class ModItems 
{
	public final static Pickaxe CopperPickaxe = new Pickaxe(Names.Items.COPPER_PICKAXE, Tools.COPPER);
	public final static Pickaxe TinPickaxe = new Pickaxe(Names.Items.TIN_PICKAXE, Tools.TIN);
	public final static Pickaxe LeadPickaxe = new Pickaxe(Names.Items.LEAD_PICKAXE, Tools.LEAD);
	public final static Pickaxe AluminiumPickaxe = new Pickaxe(Names.Items.ALUMINIUM_PICKAXE, Tools.ALUMINIUM);
	public final static Pickaxe ZincPickaxe = new Pickaxe(Names.Items.ZINC_PICKAXE, Tools.ZINC);
	public final static Pickaxe TitaniumPickaxe = new Pickaxe(Names.Items.TITANIUM_PICKAXE, Tools.TITANIUM);
	public final static Pickaxe SilverPickaxe = new Pickaxe(Names.Items.SILVER_PICKAXE, Tools.SILVER);
	public final static Pickaxe NickelPickaxe = new Pickaxe(Names.Items.NICKEL_PICKAXE, Tools.NICKEL);
	public final static Pickaxe TungstenPickaxe = new Pickaxe(Names.Items.TUNGSTEN_PICKAXE, Tools.TUNGSTEN);
	public final static Pickaxe SiliconPickaxe = new Pickaxe(Names.Items.SILICON_PICKAXE, Tools.SILICON);
	public final static Pickaxe RubyPickaxe = new Pickaxe(Names.Items.RUBY_PICKAXE, Tools.RUBY);
	public final static Pickaxe SapphirePickaxe = new Pickaxe(Names.Items.SAPPHIRE_PICKAXE, Tools.SAPPHIRE);
	public final static Pickaxe BlackonyxPickaxe = new Pickaxe(Names.Items.BLACKONYX_PICKAXE, Tools.BLACKONYX);
	public final static Pickaxe RedonyxPickaxe = new Pickaxe(Names.Items.REDONYX_PICKAXE, Tools.REDONYX);
	public final static Pickaxe AmethystPickaxe = new Pickaxe(Names.Items.AMETHYST_PICKAXE, Tools.AMETHYST);
	public final static Pickaxe BronzePickaxe = new Pickaxe(Names.Items.BRONZE_PICKAXE, Tools.BRONZE);
	public final static Pickaxe BrassPickaxe = new Pickaxe(Names.Items.BRASS_PICKAXE, Tools.BRASS);
	public final static Pickaxe ZamakPickaxe = new Pickaxe(Names.Items.ZAMAK_PICKAXE, Tools.ZAMAK);
	public final static Pickaxe SterlingPickaxe = new Pickaxe(Names.Items.STERLING_PICKAXE, Tools.STERLING);
	public final static Pickaxe CuproPickaxe = new Pickaxe(Names.Items.CUPRO_PICKAXE, Tools.CUPRO);
	public final static Pickaxe InvarPickaxe = new Pickaxe(Names.Items.INVAR_PICKAXE, Tools.INVAR);
	public final static Pickaxe SteelPickaxe = new Pickaxe(Names.Items.STEEL_PICKAXE, Tools.STEEL);
	public final static Pickaxe FersiliconPickaxe = new Pickaxe(Names.Items.FERSILICON_PICKAXE, Tools.FERSILICON);
	public final static Pickaxe ElectrumPickaxe = new Pickaxe(Names.Items.ELECTRUM_PICKAXE, Tools.ELECTRUM);
	public final static Pickaxe HSSPickaxe = new Pickaxe(Names.Items.HSS_PICKAXE, Tools.HSS);
	public final static Pickaxe BabbittPickaxe = new Pickaxe(Names.Items.BABBITT_PICKAXE, Tools.BABBITT);
	public final static Pickaxe GradePickaxe = new Pickaxe(Names.Items.GRADE_PICKAXE, Tools.GRADE);
	public final static Pickaxe CarbonPickaxe = new Pickaxe(Names.Items.CARBON_PICKAXE, Tools.CARBON);
	
	public static void init()
	{
		/* Pickaxe */
		registerItem(CopperPickaxe);
		registerItem(TinPickaxe);
		registerItem(LeadPickaxe);
		registerItem(AluminiumPickaxe);
		registerItem(ZincPickaxe);
		registerItem(TitaniumPickaxe);
		registerItem(SilverPickaxe);
		registerItem(NickelPickaxe);
		registerItem(TungstenPickaxe);
		registerItem(SiliconPickaxe);
		
		registerItem(RubyPickaxe);
		registerItem(SapphirePickaxe);
		registerItem(BlackonyxPickaxe);
		registerItem(RedonyxPickaxe);
		registerItem(AmethystPickaxe);
		
		registerItem(BronzePickaxe);
		registerItem(BrassPickaxe);
		registerItem(ZamakPickaxe);
		registerItem(SterlingPickaxe);
		registerItem(CuproPickaxe);
		registerItem(InvarPickaxe);
		registerItem(SteelPickaxe);
		registerItem(FersiliconPickaxe);
		registerItem(ElectrumPickaxe);
		registerItem(HSSPickaxe);
		registerItem(BabbittPickaxe);
		registerItem(GradePickaxe);
		registerItem(CarbonPickaxe);
	}
	
	public static void registerItem(Pickaxe item)
	{
		GameRegistry.registerItem(item ,item.getName());
	}
}
