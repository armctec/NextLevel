package com.armctec.nl.test.world.biome;

import java.util.Random;

import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeGenDeepOceanOil extends BiomeGenBase
{
	public BiomeGenDeepOceanOil(int id) 
	{
		this(id, true);
	}
	
	public BiomeGenDeepOceanOil(int id, boolean register) 
	{
		super(id, register);
		
		setColor(48);
		setBiomeName("Deep Ocean Oil");
		setHeight(height_DeepOceans);
		ModConfig.Log.info("biomeID:" + biomeID);
	}
	
	@Override
	public BiomeGenBase.TempCategory getTempCategory()
    {
        return BiomeGenBase.TempCategory.OCEAN;
    }

	@Override
	public BiomeGenBase createMutatedBiome(int id) 
	{
		return null;
	}
	
	@Override
	public BiomeGenBase createMutation() 
	{
		return null;
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double p_180622_6_)
	{
		super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, x, z, p_180622_6_);
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		super.decorate(worldIn, rand, pos);
	}
	
}
