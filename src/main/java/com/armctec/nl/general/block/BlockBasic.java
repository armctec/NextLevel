package com.armctec.nl.general.block;

import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasic extends Block 
{
    public BlockBasic(Material material)
    {
        super(material);
    }

    public BlockBasic()
    {
        this(Material.rock);
    }

    public void setBlockName(String name)
    {
        setUnlocalizedName(name);
    }

    
    /*
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }    
    
    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    */    
    
    /*
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
    	return EnumWorldBlockLayer.SOLID;
    }

    // used by the renderer to control lighting and visibility of other blocks.
    // set to true because this block is opaque and occupies the entire 1x1x1 space
    // not strictly required because the default (super method) is true
    @Override
    public boolean isOpaqueCube() 
    {
    	return true;
    }

    // used by the renderer to control lighting and visibility of other blocks, also by
    // (eg) wall or fence to control whether the fence joins itself to this block
    // set to true because this block occupies the entire 1x1x1 space
    // not strictly required because the default (super method) is true
    @Override
    public boolean isFullCube() 
    {
    	return true;
    }

    // render using a BakedModel (mbe01_block_simple.json --> mbe01_block_simple_model.json)
    // not strictly required because the default (super method) is 3.
    @Override
    public int getRenderType() 
    {
    	return 3;
    }    
    */
}
