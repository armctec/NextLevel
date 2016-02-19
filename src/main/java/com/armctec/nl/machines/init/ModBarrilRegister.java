package com.armctec.nl.machines.init;

import com.armctec.nl.machines.item.ItemBarril;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class ModBarrilRegister 
{
	public static void init()
	{
		/*
		ItemStack stackempty = new ItemStack(ModBlocks.Barril);
		ItemBarril itemBarril  = new ItemBarril(ModBlocks.Barril);
		
		for (Fluid fluid : FluidRegistry.getRegisteredFluids().values())
        {
            // add all fluids that the bucket can be filled  with
            FluidStack fs = new FluidStack(fluid, ModBlocks.Barril.capacity);
            ItemStack stack = new ItemStack(ModBlocks.Barril);
            
            itemBarril.fill(stack, fs, true);
            
            FluidContainerRegistry.registerFluidContainer(fs, stack, stackempty);
        }
        */
	}
}
