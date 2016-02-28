package com.armctec.nl.test.init;

import com.armctec.nl.test.world.WorldProviderVoid;
import com.armctec.nl.test.world.biome.BiomeGenVoid;

import net.minecraft.world.biome.BiomeCache;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;

public class ModWorld
{
	public final static BiomeGenVoid biomeVoid = new BiomeGenVoid(100);
	
	public static void init()
	{
		BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(biomeVoid, -1));
		
		DimensionManager.registerProviderType(2, WorldProviderVoid.class, false);
		DimensionManager.registerDimension(2, 2);
	}
}
