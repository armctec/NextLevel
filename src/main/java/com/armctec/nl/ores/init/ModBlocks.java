package com.armctec.nl.ores.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import com.armctec.nl.general.reference.ToolRef;
import com.armctec.nl.general.utility.RegisterServer;
import com.armctec.nl.ores.block.BlockCompressed;
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
	
	// Blocks
	public final static BlockCompressed AluminiumBlock = new BlockCompressed(Names.Blocks.ALUMINIUM_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed AmethystBlock = new BlockCompressed(Names.Blocks.AMETHYST_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed BabbittBlock = new BlockCompressed(Names.Blocks.BABBITT_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed BlackonyxBlock = new BlockCompressed(Names.Blocks.BLACKONYX_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed BrassBlock = new BlockCompressed(Names.Blocks.BRASS_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed BronzeBlock = new BlockCompressed(Names.Blocks.BRONZE_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed CarbonBlock = new BlockCompressed(Names.Blocks.CARBON_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed CopperBlock = new BlockCompressed(Names.Blocks.COPPER_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed CuproBlock = new BlockCompressed(Names.Blocks.CUPRO_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed ElectrumBlock = new BlockCompressed(Names.Blocks.ELECTRUM_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed FersiliconBlock = new BlockCompressed(Names.Blocks.FERSILICON_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed GradeBlock = new BlockCompressed(Names.Blocks.GRADE_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed HssBlock = new BlockCompressed(Names.Blocks.HSS_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed InvarBlock = new BlockCompressed(Names.Blocks.INVAR_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed LeadBlock = new BlockCompressed(Names.Blocks.LEAD_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed MoonstoneBlock = new BlockCompressed(Names.Blocks.MOONSTONE_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed NickelBlock = new BlockCompressed(Names.Blocks.NICKEL_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed RedonyxBlock = new BlockCompressed(Names.Blocks.REDONYX_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed RubyBlock = new BlockCompressed(Names.Blocks.RUBY_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed SapphireBlock = new BlockCompressed(Names.Blocks.SAPPHIRE_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed SiliconBlock = new BlockCompressed(Names.Blocks.SILICON_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed SilverBlock = new BlockCompressed(Names.Blocks.SILVER_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed SteelBlock = new BlockCompressed(Names.Blocks.STEEL_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed SterlingBlock = new BlockCompressed(Names.Blocks.STERLING_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed TinBlock = new BlockCompressed(Names.Blocks.TIN_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed TitaniumBlock = new BlockCompressed(Names.Blocks.TITANIUM_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed TungstenBlock = new BlockCompressed(Names.Blocks.TUNGSTEN_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed ZamakBlock = new BlockCompressed(Names.Blocks.ZAMAK_BLOCK, ToolRef.IronTool);
	public final static BlockCompressed ZincBlock = new BlockCompressed(Names.Blocks.ZINC_BLOCK, ToolRef.IronTool);
	
	public static void init()
	{
		// Ores
        RegisterServer.registerBlocks(CopperOre, Names.Blocks.COPPER_ORE, "oreCopper");
        RegisterServer.registerBlocks(TinOre, Names.Blocks.TIN_ORE, "oreTin");
        RegisterServer.registerBlocks(LeadOre, Names.Blocks.LEAD_ORE, "oreLead");
        RegisterServer.registerBlocks(AluminiumOre, Names.Blocks.ALUMINIUM_ORE, "oreAluminium");
        RegisterServer.registerBlocks(ZincOre, Names.Blocks.ZINC_ORE, "oreZinc");
        RegisterServer.registerBlocks(TitaniumOre, Names.Blocks.TITANIUM_ORE, "oreTitanium");
        RegisterServer.registerBlocks(SilverOre, Names.Blocks.SILVER_ORE, "oreSilver");
        RegisterServer.registerBlocks(NickelOre, Names.Blocks.NICKEL_ORE, "oreNickel");
        RegisterServer.registerBlocks(TungstenOre, Names.Blocks.TUNGSTEN_ORE, "oreTungsten");
        RegisterServer.registerBlocks(SiliconOre, Names.Blocks.SILICON_ORE, "oreSilicon");
        // Gems
        RegisterServer.registerBlocks(RubyOre, Names.Blocks.RUBY_ORE, "oreRuby");
        RegisterServer.registerBlocks(SapphireOre, Names.Blocks.SAPPHIRE_ORE, "oreSaphire");
        RegisterServer.registerBlocks(MoonstoneOre, Names.Blocks.MOONSTONE_ORE, "oreMoonstone");
        RegisterServer.registerBlocks(BlackonyxOre, Names.Blocks.BLACKONYX_ORE, "oreBlackonyx");
        RegisterServer.registerBlocks(RedonyxOre, Names.Blocks.REDONYX_ORE, "oreRedonyx");
        RegisterServer.registerBlocks(AmethystOre, Names.Blocks.AMETHYST_ORE, "oreAmethyst");
        // Blocks
        RegisterServer.registerBlocks(AluminiumBlock, Names.Blocks.ALUMINIUM_BLOCK, "blockAluminium");
        RegisterServer.registerBlocks(AmethystBlock, Names.Blocks.AMETHYST_BLOCK, "blockAmethyst");
        RegisterServer.registerBlocks(BabbittBlock, Names.Blocks.BABBITT_BLOCK, "blockBabbitt");
        RegisterServer.registerBlocks(BlackonyxBlock, Names.Blocks.BLACKONYX_BLOCK, "blockBlackonyx");
        RegisterServer.registerBlocks(BrassBlock, Names.Blocks.BRASS_BLOCK, "blockBrass");
        RegisterServer.registerBlocks(BronzeBlock, Names.Blocks.BRONZE_BLOCK, "blockBronze");
        RegisterServer.registerBlocks(CarbonBlock, Names.Blocks.CARBON_BLOCK, "blockCarbon");
        RegisterServer.registerBlocks(CopperBlock, Names.Blocks.COPPER_BLOCK, "blockCopper");
        RegisterServer.registerBlocks(CuproBlock, Names.Blocks.CUPRO_BLOCK, "blockCupro");
        RegisterServer.registerBlocks(ElectrumBlock, Names.Blocks.ELECTRUM_BLOCK, "blockElectrum");
        RegisterServer.registerBlocks(FersiliconBlock, Names.Blocks.FERSILICON_BLOCK, "blockFersilicon");
        RegisterServer.registerBlocks(GradeBlock, Names.Blocks.GRADE_BLOCK, "blockGrade");
        RegisterServer.registerBlocks(HssBlock, Names.Blocks.HSS_BLOCK, "blockHss");
        RegisterServer.registerBlocks(InvarBlock, Names.Blocks.INVAR_BLOCK, "blockInvar");
        RegisterServer.registerBlocks(LeadBlock, Names.Blocks.LEAD_BLOCK, "blockLead");
        RegisterServer.registerBlocks(MoonstoneBlock, Names.Blocks.MOONSTONE_BLOCK, "blockMoonstone");
        RegisterServer.registerBlocks(NickelBlock, Names.Blocks.NICKEL_BLOCK, "blockNickel");
        RegisterServer.registerBlocks(RedonyxBlock, Names.Blocks.REDONYX_BLOCK, "blockRedonyx");
        RegisterServer.registerBlocks(RubyBlock, Names.Blocks.RUBY_BLOCK, "blockRuby");
        RegisterServer.registerBlocks(SapphireBlock, Names.Blocks.SAPPHIRE_BLOCK, "blockSapphire");
        RegisterServer.registerBlocks(SiliconBlock, Names.Blocks.SILICON_BLOCK, "blockSilicon");
        RegisterServer.registerBlocks(SilverBlock, Names.Blocks.SILVER_BLOCK, "blockSilver");
        RegisterServer.registerBlocks(SteelBlock, Names.Blocks.STEEL_BLOCK, "blockSteel");
        RegisterServer.registerBlocks(SterlingBlock, Names.Blocks.STERLING_BLOCK, "blockSterling");
        RegisterServer.registerBlocks(TinBlock, Names.Blocks.TIN_BLOCK, "blockTin");
        RegisterServer.registerBlocks(TitaniumBlock, Names.Blocks.TITANIUM_BLOCK, "blockTitanium");
        RegisterServer.registerBlocks(TungstenBlock, Names.Blocks.TUNGSTEN_BLOCK, "blockTungsten");
        RegisterServer.registerBlocks(ZamakBlock, Names.Blocks.ZAMAK_BLOCK, "blockZamak");
        RegisterServer.registerBlocks(ZincBlock, Names.Blocks.ZINC_BLOCK, "blockZinc");

	}
}
