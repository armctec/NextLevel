package com.armctec.nl.general.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block 
{
    String BlockName = null;
    
	public BlockBasic(Material material)
    {
        super(material);
    }

    public BlockBasic()
    {
        this(Material.rock);
    }

    public void setBlockName(String ModIdName, String name)
    {
        this.BlockName = name;
    	setUnlocalizedName(ModIdName.toLowerCase() + ":" + name);
    }
    
    public String getName()
    {
    	return BlockName;
    }
}
