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

public class FluidOil extends BlockFluidClassic 
{
	public static final Fluid oilFluid = new Fluid("oil", new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/oil_still"), new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/oil_flow"));
	private static ModelResourceLocation oilLocation = new ModelResourceLocation(ModConfig.MOD_ID.toLowerCase() + ":" + Names.Fluids.OIL_FLUID, "oil");
    
	public FluidOil() 
	{
        super(oilFluid, Material.water);
        setCreativeTab(CreativeTabTest.TEST_TAB);
        setUnlocalizedName(ModConfig.MOD_ID.toLowerCase() + ":" + Names.Fluids.OIL_FLUID);
	}
	
	public void RegisterItemClient(FluidOil instance)
	{
		Item milk = Item.getItemFromBlock(instance);
		ModelBakery.registerItemVariants(milk);
		ModelLoader.setCustomMeshDefinition(milk, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return oilLocation;
            }
        });
		ModelLoader.setCustomStateMapper(instance, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return oilLocation;
            }
        });		
	}
}
