package com.armctec.nl.ores.block;

import java.util.Collection;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockAdvanced;
import com.armctec.nl.general.block.BlockBasic;
import com.armctec.nl.general.reference.GemConfig;
import com.armctec.nl.general.reference.ToolRef;
import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.ores.reference.Names;
import com.google.common.collect.ImmutableMap;

public class BlockGem extends BlockBasic
{
	GemConfig gemparm = new GemConfig(null,1,0,0,0,0,0);

	public BlockGem(String NameBlock, int ToolLevel, GemConfig gemparm)
	{
		this(NameBlock,"picaxe",ToolLevel,gemparm);
	}

	public BlockGem(String NameBlock, String NameTool, int ToolLevel, GemConfig gemparm)
	{
		super();
		
		if(gemparm!=null)
			this.gemparm = gemparm;
		this.setCreativeTab(CreativeTabOres.ORES_TAB);
		setBlockName(ModConfig.MOD_ID, NameBlock);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel(NameTool, ToolLevel);
	}
	
    /**
     * Get the Item that this Block should drop when harvested.
     *  
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if(gemparm.DropItem == null)
        	return Item.getItemFromBlock(this);
        
    	return gemparm.DropItem;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    @Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        int quant;
        
        quant = this.quantityDropped(random);

        if(fortune>0)
        	quant += gemparm.DropFortune>0?random.nextInt((fortune+1) * gemparm.DropFortune):0;
        
    	return quant;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random random)
    {
    	int quant;
    	 
    	quant = gemparm.DropBase; 
    	quant += gemparm.DropRandom>0?random.nextInt(gemparm.DropRandom):0;
    	
    	return quant;
    }

    /**
     * Returns the exp of items to drop on block destruction.
     */
    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        int quant;
    	if (this.getItemDropped(world.getBlockState(pos), RANDOM, fortune) != Item.getItemFromBlock(this))
        {
    		quant = gemparm.ExpBase;
    		quant += gemparm.ExpRandom>0?RANDOM.nextInt(gemparm.ExpRandom):0;
    		if(fortune>0)	
    			quant += gemparm.ExpFortune>0?RANDOM.nextInt(fortune * gemparm.ExpFortune):0;
        	
        	return quant;
        }
        return 0;
    }
    
    /**
     * Spawns this Block's drops into the World as EntityItems.
     *  
     * @param chance The chance that each Item is actually spawned (1.0 = always, 0.0 = never)
     * @param fortune The player's fortune level
     */
    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }    
	
}
