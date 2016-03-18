package com.armctec.nl.test.world.gen.layer;

import com.armctec.nl.general.utility.NoiseGenerator;
import com.armctec.nl.test.init.ModWorld;
import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeepOcenOil extends GenLayer 
{
	private NoiseGenerator noise = null;
	
	public GenLayerDeepOcenOil(long hashid, GenLayer parent)
    {
        super(hashid);
        this.parent = parent;
	}
	
    protected boolean canReplaceBiome(int biomeId) 
    {
        return biomeId == BiomeGenBase.ocean.biomeID || biomeId == BiomeGenBase.deepOcean.biomeID;
    }	
	
	@Override
	public int[] getInts(int x, int z, int width, int height) 
	{
		if(noise == null)
			noise = new NoiseGenerator(width, height);

		noise.setTamanho(width, height);
		noise.setSeed(this.baseSeed);
		noise.setFilter(5, 3);
		noise.GenerateNoise(x, z);
		
		byte cache[][] = noise.getCache();
		
		int[] inputBiomeIDs = parent.getInts(x - 1, z - 1, width + 2, height + 2);
        int[] outputBiomeIDs = IntCache.getIntCache(width * height);
        
        for (int xIter = 0; xIter < width; ++xIter) 
        {
            for (int zIter = 0; zIter < height; ++zIter) 
            {
                initChunkSeed(xIter + x, zIter + z);
                final int currentBiomeId = inputBiomeIDs[xIter + 1 + (zIter + 1) * (width + 2)];

                if (canReplaceBiome(currentBiomeId) && cache[xIter][zIter]==0)
                {
                    outputBiomeIDs[xIter + zIter * width] = ModWorld.biomeDeepOil.biomeID;
                    //ModConfig.Log.info("X:"+xIter+" Z:"+zIter);
                } 
                else 
                {
                    outputBiomeIDs[xIter + zIter * width] = currentBiomeId;
                }
            }
        }

        //ModConfig.Log.info("X:"+x+" Z:"+z);
        return outputBiomeIDs;       
  	}
}
