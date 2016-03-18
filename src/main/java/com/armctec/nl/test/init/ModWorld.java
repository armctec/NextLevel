package com.armctec.nl.test.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.world.WorldProviderVoid;
import com.armctec.nl.test.world.biome.BiomeGenDeepOceanOil;
import com.armctec.nl.test.world.biome.BiomeGenVoid;

import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.StructureOceanMonument;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import sun.reflect.FieldAccessor;
import sun.reflect.ReflectionFactory;

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
		addOceanMonument();
		
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
    
    private static void addOceanMonument()
    {
        try
        {
            Field field = ReflectionHelper.findField(StructureOceanMonument.class, "field_175802_d", "field_175802_d");
            field.setAccessible(true);
           
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
           
            int modifiers = modifiersField.getInt(field);
            // blank out the final bit in the modifiers int
            modifiers &= ~Modifier.FINAL;
            modifiersField.setInt(field, modifiers);
            FieldAccessor fa = ReflectionFactory.getReflectionFactory().newFieldAccessor(field, false);           
           
            List<BiomeGenBase> new_list = Arrays.<BiomeGenBase>asList(new BiomeGenBase[StructureOceanMonument.field_175802_d.size()+1]);
             
            Iterator itr = StructureOceanMonument.field_175802_d.iterator();
            int i=0;
            while(itr.hasNext())
            {
                BiomeGenBase e = (BiomeGenBase)itr.next();
                new_list.set(i++, e);
            }
                       
            new_list.set(i, biomeDeepOil);
            field.set(null, new_list);

            ModConfig.Log.info("Reflection Ocean Monument: Ok");
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
    }
}
