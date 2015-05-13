package com.armctec.nl.general.block;

import com.armctec.nl.general.block.material.MaterialAdvanced;
import com.armctec.nl.ores.gui.CreativeTabOres;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    
    public void setBlockName(String name)
    {
        setUnlocalizedName(name);
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
