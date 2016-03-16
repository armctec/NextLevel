package com.armctec.nl.test.world.biome;

import java.util.Random;

import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
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
	public void decorate(World worldIn, Random rand, BlockPos pos) 
	{
		//ModConfig.Log.info("Posicao chamada: X="+pos.getX()+" Y="+pos.getY()+" Z="+pos.getZ());
		
		super.decorate(worldIn, rand, pos);
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int p_180622_4_, int p_180622_5_, double p_180622_6_)
	{
		//ModConfig.Log.info("genTerrainBlocks");
		
		super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, p_180622_4_, p_180622_5_, p_180622_6_);
	}

	@Override
	public BiomeGenBase createMutatedBiome(int id) 
	{
		return this;
	}
	
	@Override
	public BiomeGenBase createMutation() 
	{
		return this;
	}
	
	
}
