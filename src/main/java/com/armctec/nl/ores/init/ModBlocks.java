package com.armctec.nl.ores.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.armctec.nl.general.reference.ToolRef;
import com.armctec.nl.general.utility.RegisterServer;
import com.armctec.nl.ores.block.BlockGem;
import com.armctec.nl.ores.block.BlockOre;
import com.armctec.nl.ores.reference.GemsConfig;
import com.armctec.nl.ores.reference.Names;

public class ModBlocks 
{
	// Ores
	public final static BlockOre CopperOre = new BlockOre(Names.Blocks.COPPER_ORE, ToolRef.StoneTool);
	public final static BlockOre TinOre = new BlockOre(Names.Blocks.TIN_ORE, ToolRef.StoneTool);
	public final static BlockOre LeadOre = new BlockOre(Names.Blocks.LEAD_ORE, ToolRef.IronTool);
	public final static BlockOre AluminiumOre = new BlockOre(Names.Blocks.ALUMINIUM_ORE, ToolRef.StoneTool);
	public final static BlockOre ZincOre = new BlockOre(Names.Blocks.ZINC_ORE, ToolRef.IronTool);
	public final static BlockOre TitaniumOre = new BlockOre(Names.Blocks.TITANIUM_ORE, ToolRef.DiamondTool);
	public final static BlockOre SilverOre = new BlockOre(Names.Blocks.SILVER_ORE, ToolRef.IronTool);
	public final static BlockOre NickelOre = new BlockOre(Names.Blocks.NICKEL_ORE, ToolRef.IronTool);
	public final static BlockOre TungstenOre = new BlockOre(Names.Blocks.TUNGSTEN_ORE, ToolRef.DiamondTool);
	public final static BlockOre SiliconOre = new BlockOre(Names.Blocks.SILICON_ORE, ToolRef.IronTool);
	// Gems
	public final static BlockGem RubyOre = new BlockGem(Names.Blocks.RUBY_ORE, ToolRef.IronTool, GemsConfig.configRuby);
	public final static BlockGem SapphireOre = new BlockGem(Names.Blocks.SAPPHIRE_ORE, ToolRef.IronTool, GemsConfig.configSapphire);
	public final static BlockGem MoonstoneOre = new BlockGem(Names.Blocks.MOONSTONE_ORE, ToolRef.StoneTool, GemsConfig.configMoonstone);
	public final static BlockGem BlackonyxOre = new BlockGem(Names.Blocks.BLACKONYX_ORE, ToolRef.IronTool, GemsConfig.configBlackonyx);
	public final static BlockGem RedonyxOre = new BlockGem(Names.Blocks.REDONYX_ORE, ToolRef.IronTool, GemsConfig.configRedonyx);
	public final static BlockGem AmethystOre = new BlockGem(Names.Blocks.AMETHYST_ORE, ToolRef.IronTool, GemsConfig.configAmethyst);
	
	public static void init()
	{
		// Ores
        RegisterServer.registerBlocks(CopperOre, Names.Blocks.COPPER_ORE,"oreCopper");
        RegisterServer.registerBlocks(TinOre, Names.Blocks.TIN_ORE,"oreTin");
        RegisterServer.registerBlocks(LeadOre, Names.Blocks.LEAD_ORE,"oreLead");
        RegisterServer.registerBlocks(AluminiumOre, Names.Blocks.ALUMINIUM_ORE,"oreAluminium");
        RegisterServer.registerBlocks(ZincOre, Names.Blocks.ZINC_ORE,"oreZinc");
        RegisterServer.registerBlocks(TitaniumOre, Names.Blocks.TITANIUM_ORE,"oreTitanium");
        RegisterServer.registerBlocks(SilverOre, Names.Blocks.SILVER_ORE,"oreSilver");
        RegisterServer.registerBlocks(NickelOre, Names.Blocks.NICKEL_ORE,"oreNickel");
        RegisterServer.registerBlocks(TungstenOre, Names.Blocks.TUNGSTEN_ORE,"oreTungsten");
        RegisterServer.registerBlocks(SiliconOre, Names.Blocks.SILICON_ORE,"oreSilicon");
        // Gems
        RegisterServer.registerBlocks(RubyOre, Names.Blocks.RUBY_ORE,"oreRuby");
        RegisterServer.registerBlocks(SapphireOre, Names.Blocks.SAPPHIRE_ORE,"oreSaphire");
        RegisterServer.registerBlocks(MoonstoneOre, Names.Blocks.MOONSTONE_ORE,"oreMoonstone");
        RegisterServer.registerBlocks(BlackonyxOre, Names.Blocks.BLACKONYX_ORE,"oreBlackonyx");
        RegisterServer.registerBlocks(RedonyxOre, Names.Blocks.REDONYX_ORE,"oreRedonyx");
        RegisterServer.registerBlocks(AmethystOre, Names.Blocks.AMETHYST_ORE,"oreAmethyst");
	}
}
