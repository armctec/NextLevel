package com.armctec.nl.general.block;

import com.armctec.nl.general.block.material.MaterialAdvanced;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
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
	
	@Override
    public boolean isOpaqueCube(IBlockState iBlockState) 
    {
    	return false;
    }	
    
	@Override
	public boolean isFullCube(IBlockState iBlockState)
	{
	    return true;
	}   
    
    // the block will render in the SOLID layer.  See http://greyminecraftcoder.blogspot.co.at/2014/12/block-rendering-18.html for more information.
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
      return BlockRenderLayer.CUTOUT;
    }
}
