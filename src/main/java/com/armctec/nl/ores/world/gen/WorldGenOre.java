package com.armctec.nl.ores.world.gen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator 
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		int x = chunkX * 16;
        int z = chunkZ * 16;
        switch(world.provider.getDimensionId())
        {
            case 0:
                generateSurface(world, x, z, random);
                break;
            case -1:
                generateNether(world, x, z, random);
                break;
            case 1:
                generateEnd(world, x, z, random);
                break;
            default:
                generateSurface(world, x, z, random);
        }		
	}
	
	private void generateEnd(World world, int x, int z, Random random)
	{

    }

    private void generateNether(World world, int x, int z, Random random)
    {

    }
    
    private void generateSurface(World world, int x, int z, Random random)
    {
    	// Ores
    	OreGen.AluminiumGen.generate(world, x,  z, random);
    	OreGen.CopperGen.generate(world, x,  z, random);
    	OreGen.LeadGen.generate(world, x,  z, random);
    	OreGen.NickelGen.generate(world, x,  z, random);
    	OreGen.SiliconGen.generate(world, x,  z, random);
    	OreGen.SilverGen.generate(world, x,  z, random);
    	OreGen.TinGen.generate(world, x,  z, random);
    	OreGen.TitaniumGen.generate(world, x,  z, random);
    	OreGen.TungstenGen.generate(world, x,  z, random);
    	OreGen.ZincGen.generate(world, x,  z, random);
    	// Gems
    	OreGen.RubyGen.generate(world, x,  z, random);
    	OreGen.SapphireGen.generate(world, x,  z, random);
    	OreGen.MoonstoneGen.generate(world, x,  z, random);
    	OreGen.BlackonyxGen.generate(world, x,  z, random);
    	OreGen.RedonyxGen.generate(world, x,  z, random);
    	OreGen.AmethystGen.generate(world, x,  z, random);
    }    

}
