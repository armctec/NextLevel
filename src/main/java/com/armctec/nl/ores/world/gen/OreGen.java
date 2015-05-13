package com.armctec.nl.ores.world.gen;

import com.armctec.nl.general.world.gen.BaseOreGen;
import com.armctec.nl.ores.init.ModBlocks;
import com.armctec.nl.ores.reference.OresConfig;

public class OreGen 
{
	// Ores
	public static final BaseOreGen AluminiumGen = new BaseOreGen(ModBlocks.AluminiumOre, OresConfig.Aluminium);
	public static final BaseOreGen CopperGen = new BaseOreGen(ModBlocks.CopperOre, OresConfig.Copper);
	public static final BaseOreGen TinGen = new BaseOreGen(ModBlocks.TinOre, OresConfig.Tin);
	public static final BaseOreGen ZincGen = new BaseOreGen(ModBlocks.ZincOre, OresConfig.Zinc);
	public static final BaseOreGen LeadGen = new BaseOreGen(ModBlocks.LeadOre, OresConfig.Lead);
	public static final BaseOreGen TitaniumGen = new BaseOreGen(ModBlocks.TitaniumOre, OresConfig.Titanium);
	public static final BaseOreGen TungstenGen = new BaseOreGen(ModBlocks.TungstenOre, OresConfig.Tungsten);
	public static final BaseOreGen SilverGen = new BaseOreGen(ModBlocks.SilverOre, OresConfig.Silver);
	public static final BaseOreGen NickelGen = new BaseOreGen(ModBlocks.NickelOre, OresConfig.Nickel);
	public static final BaseOreGen SiliconGen = new BaseOreGen(ModBlocks.SiliconOre, OresConfig.Silicon);
	// Gems
	public static final BaseOreGen RubyGen = new BaseOreGen(ModBlocks.RubyOre, OresConfig.Ruby);
	public static final BaseOreGen SapphireGen = new BaseOreGen(ModBlocks.SapphireOre, OresConfig.Sapphire);
	public static final BaseOreGen MoonstoneGen = new BaseOreGen(ModBlocks.MoonstoneOre, OresConfig.Moonstone);
	public static final BaseOreGen BlackonyxGen = new BaseOreGen(ModBlocks.BlackonyxOre, OresConfig.Blackonyx);
	public static final BaseOreGen RedonyxGen = new BaseOreGen(ModBlocks.RedonyxOre, OresConfig.Redonyx);
}
