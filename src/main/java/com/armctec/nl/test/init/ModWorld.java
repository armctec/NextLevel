package com.armctec.nl.test.init;

import com.armctec.nl.test.world.WorldProviderVoid;
import com.armctec.nl.test.world.biome.BiomeGenDeepOceanOil;
import com.armctec.nl.test.world.biome.BiomeGenVoid;

import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;

public class ModWorld
{
	public final static BiomeGenVoid biomeVoid = new BiomeGenVoid(findUnusedBiomeID("void"));
	public final static BiomeGenDeepOceanOil biomeDeepOil = new BiomeGenDeepOceanOil(findUnusedBiomeID("DeepOil")); 
	
	public static void init()
	{
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(biomeVoid, -1));
		BiomeDictionary.registerBiomeType(biomeVoid, BiomeDictionary.Type.DEAD);
		
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(biomeDeepOil, 10));
		BiomeManager.oceanBiomes.add(biomeDeepOil);
		BiomeDictionary.registerBiomeType(biomeDeepOil, BiomeDictionary.Type.WATER);		
		
		DimensionManager.registerProviderType(2, WorldProviderVoid.class, false);
		DimensionManager.registerDimension(2, 2);
	}
	
    private static int findUnusedBiomeID(String biomeName) 
    {
        for (int i = 1; i < 256; i++)
            if (BiomeGenBase.getBiomeGenArray()[i] == null)
                return i;
        // failed to find any free biome IDs
        throw new RuntimeException("You have run out of free Biome ID spaces for " + biomeName);
    }
}
