package com.armctec.nl.machines.crafting;

import java.util.List;

import com.armctec.nl.machines.reference.ModConfig;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesAnexo 
{
	private float experience = 0.0F;

	private ItemStack stack1 = null;
	private ItemStack stack2 = null;
	private ItemStack stack3 = null;
	
	private float loto1 = 0.0F;
	private float loto2 = 0.0F;
	private float loto3 = 0.0F;
	
	public RecipesAnexo(ItemStack stack1, float experience) 
	{
		this.stack1 = stack1;
		this.experience = experience;
		loto1 = 1.0F;
	}

	public RecipesAnexo(ItemStack stack1, float loto1, float experience) 
	{
		this.stack1 = stack1;
		this.experience = experience;
		this.loto1 = loto1;
	}
	
	public RecipesAnexo(ItemStack stack1, float loto1, ItemStack stack2, float loto2, float experience) 
	{
		this.experience = experience;
		this.stack1 = stack1;
		this.loto1 = loto1;
		this.stack2 = stack2;
		this.loto2 = loto2;
	}
	
	public RecipesAnexo(ItemStack stack1, float loto1, ItemStack stack2, float loto2, ItemStack stack3, float loto3, float experience) 
	{
		this.experience = experience;
		this.stack1 = stack1;
		this.loto1 = loto1;
		this.stack2 = stack2;
		this.loto2 = loto2;
		this.stack3 = stack3;
		this.loto3 = loto3;
	}
	
	public RecipesAnexo(String name, int stack, float loto1, float experience)
	{
		this.experience = experience;
		this.loto1 = loto1;
		this.stack1 = null;

		List<ItemStack> items = OreDictionary.getOres(name);

		if(items!=null)
		{
			ModConfig.Log.info("RecipesAnexo: items.size = "+items.size());
			
			if(items.size()>0)
			{
				this.stack1 = new ItemStack(items.get(0).getItem(), stack);
			}
		}
		else
		{
			ModConfig.Log.info("RecipesAnexo: Nao encontrado:"+name);
		}
	}
	
	public ItemStack getStack1()
	{
		return stack1;
	}
	
	public ItemStack getStack2()
	{
		return stack2;
	}
	
	public ItemStack getStack3()
	{
		return stack3;
	}	
	
	public float getExperience()
	{
		return experience;
	}
	
	public float getLoto1()
	{
		return loto1;
	}	
	
	public float getLoto2()
	{
		return loto2;
	}
	
	public float getLoto3()
	{
		return loto3;
	}	
}
