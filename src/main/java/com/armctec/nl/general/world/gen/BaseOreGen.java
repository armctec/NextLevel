package com.armctec.nl.general.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.armctec.nl.general.reference.OreConfig;

public class BaseOreGen 
{
	private WorldGenMinable minableGen = null;
	private OreConfig oreconfig = null;
	
	public BaseOreGen(Block blockore, OreConfig oreconfig)
	{
		this.minableGen = new WorldGenMinable(blockore.getDefaultState(), oreconfig.NumberOfBlocks);
		this.oreconfig = oreconfig;
	}
	
	public void generate(World world, int x, int z, Random random)
	{
		if(minableGen == null)
			return;
		
		for(int i = 0; i < oreconfig.Veins; i++) 
		{
			int randX = x + random.nextInt(16);
			int randY = oreconfig.Ymin + random.nextInt(oreconfig.Ymax);
			int randZ = z + random.nextInt(16);
        
			minableGen.generate(world, random, new BlockPos(randX, randY, randZ));
		}
	}
}
