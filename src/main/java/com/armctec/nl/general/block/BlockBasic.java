package com.armctec.nl.general.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBasic extends Block 
{
    String BlockName = null;
    
	public BlockBasic(Material material)
    {
        super(material);
		setHarvestLevel("pickaxe", 0);	// Stone Pickaxe
		setResistance(2.0F);
		setHardness(2.5F);        
    }

    public BlockBasic()
    {
        this(Material.ROCK);
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
