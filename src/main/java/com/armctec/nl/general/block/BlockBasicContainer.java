package com.armctec.nl.general.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockBasicContainer extends BlockContainer
{
    String BlockName = null;
    
	public BlockBasicContainer(Material material)
    {
        super(material);
		setHarvestLevel("pickaxe", 0);	// Stone Pickaxe
		setResistance(2.0F);
		setHardness(2.5F);        
    }

    public BlockBasicContainer()
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

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}
	
    /**
     * The type of render function called. 3 for standard block models, 2 for TESR's, 1 for liquids, -1 is no render
     */
	@Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
}
