package com.armctec.nl.test.block;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockAdvanced;
import com.armctec.nl.test.gui.CreativeTabTest;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.reference.Names;

public class BlockCano extends BlockAdvanced
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyInteger DIRECAO =  PropertyInteger.create("direcao", 0, 2); 
	
	public BlockCano()
	{
		super();
		this.setCreativeTab(CreativeTabTest.ORES_TAB);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(DIRECAO, 1));
		setBlockName(ModConfig.MOD_ID, Names.Blocks.CANO);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 0);	// Stone Pickaxe
	}
	
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        EnumFacing enumfacing = (EnumFacing)worldIn.getBlockState(pos).getValue(FACING);
        int index = enumfacing.getHorizontalIndex();
        
        /** Ordering index for the HORIZONTALS field (S-W-N-E) */
        switch(index)
        {
        	case 0:
        		setBlockBounds(0.0f, 0.325f, 0.325f, 0.6875f, 0.6875f, 1.0f);
        		break;
        	case 1:
        		setBlockBounds(0.0f, 0.325f, 0.0f, 0.6875f, 0.6875f, 0.6875f);
        		break;
        	case 2:
        		setBlockBounds(0.325f, 0.325f, 0.0f, 1.0f, 0.6875f, 0.6875f);
        		break;
        	case 3:
        		setBlockBounds(0.325f, 0.325f, 0.325f, 1.0f, 0.6875f, 1.0f);
        		break;
        	default:
        		setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        		break;
        }
    }	
	
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumFacing enumfacing1 = placer.getHorizontalFacing().rotateY();
        int dir_bloco = facing.getAxis().ordinal();
        
        String text = enumfacing1.toString();
        String indexX = facing.getAxisDirection().toString();

        
        ModConfig.Log.info("Index x:"+text);
        ModConfig.Log.info("Direcao:"+dir_bloco);
        
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing1).withProperty(DIRECAO, dir_bloco);
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3)).withProperty(DIRECAO, Integer.valueOf(meta & 3)>>2);
    }
    
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH).withProperty(DIRECAO, 1);
    }
    
    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
    	byte b0 = 0;
        int i = b0 | ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
        i |= ((Integer)state.getValue(DIRECAO)).intValue() << 2;
        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING, DIRECAO});
    }

}
