package com.armctec.nl.general.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBasicContainer extends BlockContainer
{
    String BlockName = null;
    
	public BlockBasicContainer(Material material)
    {
        super(material);
    }

    public BlockBasicContainer()
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

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}
	
	@Override
    public int getRenderType()
    {
        return 3;
    }	
}