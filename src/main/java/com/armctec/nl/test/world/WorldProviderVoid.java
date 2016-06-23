package com.armctec.nl.test.world;

import com.armctec.nl.test.world.biome.WorldChunkManagerVoid;
import com.armctec.nl.test.world.gen.ChunkProviderVoid;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderVoid extends WorldProvider 
{
	public WorldProviderVoid() 
	{
        isHellWorld = false;
        hasNoSky = false;
        dimensionId = 2;
        generateLightBrightnessTable();
        registerWorldChunkManager();
	}
	
	@Override
	protected void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerVoid();
	}
	
	@Override
	public String getDimensionName()
	{
		return "Void";
	}

	@Override
	public String getInternalNameSuffix()
	{
		return "_void";
	}

	
	@Override
	public IChunkProvider createChunkGenerator() 
	{
		return new ChunkProviderVoid(this.worldObj);
	}
	
	@Override
	public boolean isSurfaceWorld()
	{
		return true;
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) 
	{
		return false;
	}
	
	@Override
	public double getHorizon() 
	{
		return 0.0f;
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) 
	{
		return false;
	}
	
	@Override
	public int getAverageGroundLevel() 
	{
		return 0;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public double getVoidFogYFactor()
    {
        return 0.03125;
    }

}
