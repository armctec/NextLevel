package com.armctec.nl.test.events;

import com.armctec.nl.test.init.ModWorld;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.world.gen.layer.GenLayerDeepOcenOil;

import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
