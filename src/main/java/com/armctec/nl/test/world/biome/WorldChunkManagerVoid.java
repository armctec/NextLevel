package com.armctec.nl.test.world.biome;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.armctec.nl.test.init.ModWorld;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;

public class WorldChunkManagerVoid extends WorldChunkManager
{
	public WorldChunkManagerVoid() 
	{
		allowedBiomes.add(ModWorld.biomeVoid);
	}

	public WorldChunkManagerVoid(World worldIn) 
	{
		super(worldIn);
	}

	public WorldChunkManagerVoid(long seed, WorldType p_i45744_3_, String p_i45744_4_) 
	{
		super(seed, p_i45744_3_, p_i45744_4_);
	}
	
	@Override
	public BiomeGenBase getBiomeGenerator(BlockPos pos) 
	{
		return ModWorld.biomeVoid;
	}
	
	@Override
	public float[] getRainfall(float[] listToReuse, int x, int z, int width, int length)
	{
        if (listToReuse == null || listToReuse.length < width * length)
        {
            listToReuse = new float[width * length];
        }

        Arrays.fill(listToReuse, 0, width * length, 0.0f);
        return listToReuse;	
    }
	
	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] biomes, int x, int z, int width, int height)
	{
        if (biomes == null || biomes.length < width * height)
        {
            biomes = new BiomeGenBase[width * height];
        }

        Arrays.fill(biomes, 0, width * height, ModWorld.biomeVoid);
        return biomes;
	}
	
	@Override
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] oldBiomeList, int x, int z, int width, int depth)
	{
        if (oldBiomeList == null || oldBiomeList.length < width * depth)
        {
            oldBiomeList = new BiomeGenBase[width * depth];
        }

        Arrays.fill(oldBiomeList, 0, width * depth, ModWorld.biomeVoid);
        return oldBiomeList;
    }
	
	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] listToReuse, int x, int z, int width, int length, boolean cacheFlag)
	{
		return loadBlockGeneratorData(listToReuse, x, z, width, length);
	}
	
	@Override
	public BlockPos findBiomePosition(int x, int z, int range, List<BiomeGenBase> biomes, Random random)
	{
		return biomes.contains(ModWorld.biomeVoid) ? new BlockPos(x - range + random.nextInt(range * 2 + 1), 0, z - range + random.nextInt(range * 2 + 1)) : null;
	}
	
	@Override
	public boolean areBiomesViable(int p_76940_1_, int p_76940_2_, int p_76940_3_, List<BiomeGenBase> p_76940_4_)
	{
		return p_76940_4_.contains(ModWorld.biomeVoid);
	}
}
