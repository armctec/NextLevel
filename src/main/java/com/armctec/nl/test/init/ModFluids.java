package com.armctec.nl.test.init;

import com.armctec.nl.general.utility.UtilityFunctions;
import com.armctec.nl.test.gui.CreativeTabTest;
import com.armctec.nl.test.reference.ModConfig;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModFluids 
{
	public static final Fluid milkFluid = new Fluid("milk", new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/milk_still"), new ResourceLocation(ModConfig.MOD_ID.toLowerCase(), "blocks/milk_flow"));
	private static ModelResourceLocation milkLocation = new ModelResourceLocation(ModConfig.MOD_ID.toLowerCase() + ":" + TestFluidBlock.name, "milk");
	
	public static void preinit()
	{
		FluidRegistry.registerFluid(milkFluid);
		GameRegistry.registerBlock(MilkFluidBlock.instance, MilkFluidBlock.name);
		
		//FluidRegistry.addBucketForFluid(milkFluid);
		FluidContainerRegistry.registerFluidContainer(milkFluid, new ItemStack(Items.milk_bucket), FluidContainerRegistry.EMPTY_BUCKET);
	}
	
	public static void preinitclient()
	{
		Item milk = Item.getItemFromBlock(MilkFluidBlock.instance);
		ModelBakery.registerItemVariants(milk);
		ModelLoader.setCustomMeshDefinition(milk, new ItemMeshDefinition()
        {
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return milkLocation;
            }
        });
		ModelLoader.setCustomStateMapper(MilkFluidBlock.instance, new StateMapperBase()
        {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return milkLocation;
            }
        });		
	}
	
	public static final class TestFluid extends Fluid
    {
        public static final String name = "testfluid";
        public static final TestFluid instance = new TestFluid();

        private TestFluid()
        {
            super(name, new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/water_flow"));
        }

        @Override
        public int getColor()
        {
            return 0xFF00FF00;
        }
    }	
	public static final class TestFluidBlock extends BlockFluidClassic
    {
        public static final TestFluidBlock instance = new TestFluidBlock();
        public static final String name = "TestFluidBlock";

        private TestFluidBlock()
        {
            super(TestFluid.instance, Material.water);
            setCreativeTab(CreativeTabTest.TEST_TAB);
            setUnlocalizedName(ModConfig.MOD_ID.toLowerCase() + ":" + name);
        }
    }	
	
	public static final class MilkFluidBlock extends BlockFluidClassic
    {
        public static final MilkFluidBlock instance = new MilkFluidBlock();
        public static final String name = "MilkFluidBlock";

        private MilkFluidBlock()
        {
            super(milkFluid, Material.water);
            setCreativeTab(CreativeTabTest.TEST_TAB);
            setUnlocalizedName(ModConfig.MOD_ID.toLowerCase() + ":" + name);
        }
        
    }	
}
