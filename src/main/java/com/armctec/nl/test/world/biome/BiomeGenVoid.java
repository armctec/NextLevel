package com.armctec.nl.test.world.biome;

import java.util.Random;

import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenVoid extends BiomeGenBase 
{
	public BiomeGenVoid(int id) 
	{
		this(id, true);
	}

	public BiomeGenVoid(int id, boolean register) 
	{
		super(id, register);
		
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		topBlock = Blocks.air.getDefaultState();
		fillerBlock = Blocks.air.getDefaultState();
		setBiomeName("Void");
		setColor(0);		
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) 
	{
		ModConfig.Log.info("Void: Posicao chamada: X="+pos.getX()+" Y="+pos.getY()+" Z="+pos.getZ());
	}
}
