package com.armctec.nl.test.world.gen.layer;

import com.armctec.nl.general.utility.SimplexNoise;
import com.armctec.nl.test.init.ModWorld;
import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeepOcenOil extends GenLayer 
{
    public static final double NOISE_FIELD_SCALE = 0.0005;
    public static final double NOISE_FIELD_THRESHOLD = 0.01; //0.9;	

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
	public int[] getInts(int x, int z, int width, int length) 
	{
		final int[] inputBiomeIDs = parent.getInts(x - 1, z - 1, width + 2, length + 2);
        final int[] outputBiomeIDs = IntCache.getIntCache(width * length);
        for (int xIter = 0; xIter < width; ++xIter) 
        {
            for (int zIter = 0; zIter < length; ++zIter) 
            {
                initChunkSeed(xIter + x, zIter + z);
                final int currentBiomeId = inputBiomeIDs[xIter + 1 + (zIter + 1) * (width + 2)];
                if (canReplaceBiome(currentBiomeId) /*&& SimplexNoise.noise((xIter + x) * NOISE_FIELD_SCALE, (zIter + z) * NOISE_FIELD_SCALE) > NOISE_FIELD_THRESHOLD*/ && nextInt(25)==0)
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
