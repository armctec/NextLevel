package com.armctec.nl.general.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.material.MaterialAdvanced;

public class BlockAdvanced extends BlockBasic
{
    public BlockAdvanced(Material material)
    {
        super(material);
    }

    public BlockAdvanced()
    {
        this(MaterialAdvanced.Advanced);
    }	
	
	@Override
    public boolean isOpaqueCube() 
    {
    	return false;
    }	
    
    @Override
    public boolean isFullCube()
    {
        return false;
    }    
    
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
}
