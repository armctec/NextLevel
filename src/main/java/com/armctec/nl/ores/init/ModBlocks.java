package com.armctec.nl.ores.init;

import com.armctec.nl.general.reference.ToolRef;
import com.armctec.nl.ores.block.BlockOre;
import com.armctec.nl.ores.reference.Names;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks 
{
	// Ores
	public final static BlockOre CopperOre = new BlockOre(Names.Blocks.COPPER_ORE,  ToolRef.StoneTool);
	public final static BlockOre TinOre = new BlockOre(Names.Blocks.TIN_ORE,  ToolRef.StoneTool);
	public final static BlockOre LeadOre = new BlockOre(Names.Blocks.LEAD_ORE,  ToolRef.IronTool);
	public final static BlockOre AluminiumOre = new BlockOre(Names.Blocks.ALUMINIUM_ORE,  ToolRef.StoneTool);
	public final static BlockOre ZincOre = new BlockOre(Names.Blocks.ZINC_ORE,  ToolRef.IronTool);
	public final static BlockOre TitaniumOre = new BlockOre(Names.Blocks.TITANIUM_ORE,  ToolRef.DiamondTool);
	public final static BlockOre SilverOre = new BlockOre(Names.Blocks.SILVER_ORE,  ToolRef.IronTool);
	public final static BlockOre NickelOre = new BlockOre(Names.Blocks.NICKEL_ORE,  ToolRef.IronTool);
	public final static BlockOre TungstenOre = new BlockOre(Names.Blocks.TUNGSTEN_ORE,  ToolRef.DiamondTool);
	public final static BlockOre SiliconOre = new BlockOre(Names.Blocks.SILICON_ORE,  ToolRef.IronTool);
	// Gems
	public final static BlockOre RubyOre = new BlockOre(Names.Blocks.RUBY_ORE,  ToolRef.IronTool);
	public final static BlockOre SapphireOre = new BlockOre(Names.Blocks.SAPPHIRE_ORE,  ToolRef.IronTool);
	public final static BlockOre MoonstoneOre = new BlockOre(Names.Blocks.MOONSTONE_ORE,  ToolRef.StoneTool);
	public final static BlockOre BlackonyxOre = new BlockOre(Names.Blocks.BLACKONYX_ORE,  ToolRef.IronTool);
	public final static BlockOre RedonyxOre = new BlockOre(Names.Blocks.REDONYX_ORE,  ToolRef.IronTool);
	
	
	public static void init()
	{
		// Ores
        GameRegistry.registerBlock(CopperOre, Names.Blocks.COPPER_ORE);
        GameRegistry.registerBlock(TinOre, Names.Blocks.TIN_ORE);
        GameRegistry.registerBlock(LeadOre, Names.Blocks.LEAD_ORE);
        GameRegistry.registerBlock(AluminiumOre, Names.Blocks.ALUMINIUM_ORE);
        GameRegistry.registerBlock(ZincOre, Names.Blocks.ZINC_ORE);
        GameRegistry.registerBlock(TitaniumOre, Names.Blocks.TITANIUM_ORE);
        GameRegistry.registerBlock(SilverOre, Names.Blocks.SILVER_ORE);
        GameRegistry.registerBlock(NickelOre, Names.Blocks.NICKEL_ORE);
        GameRegistry.registerBlock(TungstenOre, Names.Blocks.TUNGSTEN_ORE);
        GameRegistry.registerBlock(SiliconOre, Names.Blocks.SILICON_ORE);
        // Gems
        GameRegistry.registerBlock(RubyOre, Names.Blocks.RUBY_ORE);
        GameRegistry.registerBlock(SapphireOre, Names.Blocks.SAPPHIRE_ORE);
        GameRegistry.registerBlock(MoonstoneOre, Names.Blocks.MOONSTONE_ORE);
        GameRegistry.registerBlock(BlackonyxOre, Names.Blocks.BLACKONYX_ORE);
        GameRegistry.registerBlock(RedonyxOre, Names.Blocks.REDONYX_ORE);
	}
}
