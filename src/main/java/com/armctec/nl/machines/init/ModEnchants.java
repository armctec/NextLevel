package com.armctec.nl.machines.init;

import java.lang.reflect.Field;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.armctec.nl.machines.enchantment.EnchantmentDouble;
import com.armctec.nl.machines.enchantment.EnchantmentThroughput;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.reference.ModConfig;

public class ModEnchants 
{
	public static final EnumEnchantmentType EnchantMachines = EnumHelper.addEnchantmentType("MACHINES");
	public static Enchantment[] enchantmentsList = null;
	
	public static Enchantment double_output = null;
	public static Enchantment throughput = null;

	
	private static void initReflect()
	{
		try
		{
			Field field = ReflectionHelper.findField(Enchantment.class, "field_180311_a", "enchantmentsList");
			enchantmentsList = (Enchantment[]) field.get(Enchantment.efficiency);
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	private static int getEmptyEnchantId()
	{
		if(enchantmentsList==null)
			initReflect();
		
	    for (int i = 0; i < enchantmentsList.length; i++)
	    {
	    	if(enchantmentsList[i] == null)
	    	{
	    		return i;
	    	}
	    }
	    return -1;
	}	
	
	public static void init()
	{
		initReflect();
		
		double_output = new EnchantmentDouble(getEmptyEnchantId(), new ResourceLocation(ModConfig.MOD_ID, "Double"), 3, EnchantMachines);
		Enchantment.addToBookList(double_output);
		
		throughput = new EnchantmentThroughput(getEmptyEnchantId(), new ResourceLocation(ModConfig.MOD_ID, "Throughput"), 10, EnchantMachines);
		Enchantment.addToBookList(throughput);

		
		CreativeTabMachines.MACHINES_TAB.setRelevantEnchantmentTypes(EnchantMachines);
	}
	
	public static int getDoubleLevel(ItemStack stack)
    {
		return EnchantmentHelper.getEnchantmentLevel(double_output.effectId, stack);
    }

	public static int getThroughputLevel(ItemStack stack)
    {
		return EnchantmentHelper.getEnchantmentLevel(throughput.effectId, stack);
    }	
}
