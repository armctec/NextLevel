package com.armctec.nl.test.fluids;

import com.armctec.nl.test.gui.CreativeTabTest;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.reference.Names;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class FluidMilk extends BlockFluidClassic 
{
	public static final Fluid milkFluid = new Fluid("milk", new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/milk_still"), new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/milk_flow"));
	private static ModelResourceLocation milkLocation = new ModelResourceLocation(ModConfig.MOD_ID.toLowerCase() + ":" + Names.Fluids.MILK_FLUID, "milk");
    
	public FluidMilk() 
	{
        super(milkFluid, Material.water);
        setCreativeTab(CreativeTabTest.TEST_TAB);
        setUnlocalizedName(ModConfig.MOD_ID.toLowerCase() + ":" + Names.Fluids.MILK_FLUID);
	}
	
	public void RegisterItemClient(FluidMilk instance)
	{
		Item milk = Item.getItemFromBlock(instance);
		ModelBakery.registerItemVariants(milk);
		ModelLoader.setCustomMeshDefinition(milk, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return milkLocation;
            }
        });
		ModelLoader.setCustomStateMapper(instance, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return milkLocation;
            }
        });		
	}
}
