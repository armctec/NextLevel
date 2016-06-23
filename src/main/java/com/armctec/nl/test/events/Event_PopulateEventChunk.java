package com.armctec.nl.test.events;

import java.util.Random;

import com.armctec.nl.test.init.ModWorld;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_PopulateEventChunk
{
	public static final EventType EVENT_TYPE = EnumHelper.addEnum(EventType.class, "NEXTLEVEL_OIL", new Class[0], new Object[0]);
	
	@SubscribeEvent
    public void populate(PopulateChunkEvent.Post event)
	{
		generateOil(event.world, event.rand, event.chunkX, event.chunkZ);
		
        event.setResult(Result.ALLOW);
    }
	
    public void generateOil(World world, Random rand, int chunkX, int chunkZ) 
    {
    	// shift to world coordinates
    	int x = chunkX * 16 + 8;
    	int z = chunkZ * 16 + 8;
    	
    	for(int xi=0;xi<16;xi++)
    	{
			for(int zi=0;zi<16;zi++)
    		{
    			BlockPos pos = new BlockPos(x+xi, 60, z+zi);
    			BiomeGenBase biome = world.getBiomeGenForCoords(pos);
    			
    			// Do not generate oil in the End or Nether
    			if (biome.biomeID == ModWorld.biomeDeepOil.biomeID)
    			{
    				//ModConfig.Log.info("Mudando em X:"+x+" Z:"+z);
    				
    				for (int y = 60; y < 80; y++)
    				{
    					world.setBlockState(pos, Blocks.brick_block.getDefaultState(), 2);
    					pos = pos.add(0,1,0);
    				}
    			}
    		}
    	}
    }
}
