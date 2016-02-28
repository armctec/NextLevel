package com.armctec.nl.test.world.biome;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoid extends BiomeGenBase 
{
	public BiomeGenVoid(int id) 
	{
		super(id);
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		topBlock = Blocks.air.getDefaultState();
		fillerBlock = Blocks.air.getDefaultState();
		setBiomeName("void");
		setColor(0);
	}

	public BiomeGenVoid(int id, boolean register) 
	{
		super(id, register);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) 
	{
		
	}
}
