package com.armctec.nl.test.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.armctec.nl.test.init.ModWorld;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.world.gen.layer.GenLayerDeepOcenOil;
import com.armctec.nl.test.world.gen.layer.GenLayerModded;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerIsland;
import net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize;
import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;

public class Event_InitBiomeGens 
{
	@SubscribeEvent
	public void getInitBiomeGens(InitBiomeGens event) 
	{
		int i;
		
		ModConfig.Log.info("InitBiomeGens --> Chamado");

		if (ModWorld.biomeDeepOil != null) 
		{
            for (i = 0; i < event.newBiomeGens.length; i++) {
                event.newBiomeGens[i] = new GenLayerDeepOcenOil(event.seed, event.newBiomeGens[i]);
            }
        }		
	}
}
