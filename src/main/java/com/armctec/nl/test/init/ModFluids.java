package com.armctec.nl.test.init;

import com.armctec.nl.test.fluids.FluidMilk;
import com.armctec.nl.test.fluids.FluidOil;
import com.armctec.nl.test.reference.Names;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFluids 
{
	public static FluidMilk block_milk = null;
	public static Fluid fluid_milk = null;
	
	public static FluidOil block_oil = null;
	public static Fluid fluid_oil = null;
	
	public static void init()
	{
		fluid_milk = block_milk.milkFluid;
		fluid_oil = block_oil.oilFluid;
		
		FluidRegistry.registerFluid(fluid_milk);
		block_milk = new FluidMilk();
		GameRegistry.registerBlock(block_milk, Names.Fluids.MILK_FLUID);
		fluid_milk.setBlock(block_milk);

		FluidRegistry.registerFluid(fluid_oil);
		block_oil = new FluidOil();
		GameRegistry.registerBlock(block_oil, Names.Fluids.OIL_FLUID);
		fluid_oil.setBlock(block_oil);
		
		FluidContainerRegistry.registerFluidContainer(fluid_milk, new ItemStack(Items.milk_bucket), FluidContainerRegistry.EMPTY_BUCKET);
		FluidContainerRegistry.registerFluidContainer(fluid_oil, new ItemStack(ModItems.oil_bucket), FluidContainerRegistry.EMPTY_BUCKET);
	}
	
	public static void initclient()
	{
		block_milk.RegisterItemClient(block_milk);
		block_oil.RegisterItemClient(block_oil);
	}
}
