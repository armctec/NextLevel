package com.armctec.nl.test.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.armctec.nl.test.block.BlockCano;
import com.armctec.nl.test.reference.Names;

public class ModBlocks 
{
	public static Block Cano = null;
	
	public static void init()
	{
		Cano = new BlockCano();
        GameRegistry.registerBlock(Cano, Names.Blocks.CANO);
		
	}
}
