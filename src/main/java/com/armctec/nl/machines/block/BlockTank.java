package com.armctec.nl.machines.block;

import java.util.ArrayList;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.block.BlockAdvanced;
import com.armctec.nl.general.utility.CheckBlocks;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;

// Modo 0: Sem Conexao
// Modo 1: Conexao Acima
// Modo 2: Conexao Abaixo
// Modo 3: Conexao Esquerda
// Modo 4: Conexao Direita
// Modo 5: Conexao Atras
// Modo 6: Conexao Frente


public class BlockTank extends BlockAdvanced 
{
	public static final PropertyInteger MODO = PropertyInteger.create("modo", 0, 9);
	
	public BlockTank() 
	{
		super();
	
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		
		this.isBlockContainer = true;
		setBlockName(ModConfig.MOD_ID, Names.Blocks.TANQUE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(MODO, 0));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
    {
		return this.getDefaultState().withProperty(MODO, Integer.valueOf(meta));
    }
	
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(MODO)).intValue();
    }
	
	@Override
    protected BlockState createBlockState()
    {
		//ModConfig.Log.info("createBlockState");
		return new BlockState(this, new IProperty[] {MODO});
    }
	
	private boolean checkBreakBlock(World worldIn, BlockPos pos, BlockPos posini, ArrayList list, int z)
	{
		if(list.contains(pos))
			return false;
		
		if(z==0)
			return false;
		
		z--;
		
		list.add(pos);
		
		CheckBlocks chk = new CheckBlocks(worldIn, pos, this);
		// Modo 0: Sem Conexao
		// Modo 1: Conexao Acima, Up
		// Modo 2: Conexao Abaixo, Down
		// Modo 3: Conexao Atras, North
		// Modo 4: Conexao Frente, South
		// Modo 5: Conexao Esquerda, East
		// Modo 6: Conexao Direita, West
		// Modo 7: Conexao Up, Down
		// Modo 8: Conexao East, West
		// Modo 9: Conexao North, East
		switch(chk.conta_conexoes)
		{
			case 0:
				if(pos != posini)
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 0));
				return true;
			case 1:
				if(chk.checkDown == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 2));
					checkBreakBlock(worldIn, chk.downPos, posini, list, z);
				}
				if(chk.checkUp == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 1));
					checkBreakBlock(worldIn, chk.upPos, posini, list, z);
				}
				if(chk.checkEast == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 5));
					checkBreakBlock(worldIn, chk.eastPos, posini, list, z);
				}	
				if(chk.checkWest == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 6));
					checkBreakBlock(worldIn, chk.westPos, posini, list, z);
				}
				if(chk.checkNorth == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 3));
					checkBreakBlock(worldIn, chk.northPos, posini, list, z);
				}
				if(chk.checkSouth == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 4));
					checkBreakBlock(worldIn, chk.southPos, posini, list, z);
				}	
				break;
			case 2:
				if(chk.checkDown == true && chk.checkUp == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 7));
					checkBreakBlock(worldIn, chk.downPos, posini, list, z);
					checkBreakBlock(worldIn, chk.upPos, posini, list, z);
					break;
				}
				if(chk.checkEast == true && chk.checkWest == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 8));
					checkBreakBlock(worldIn, chk.eastPos, posini, list, z);
					checkBreakBlock(worldIn, chk.westPos, posini, list, z);
					break;
				}
				if(chk.checkNorth == true && chk.checkSouth == true)
				{
					if(pos != posini)
						worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 9));
					checkBreakBlock(worldIn, chk.northPos, posini, list, z);
					checkBreakBlock(worldIn, chk.southPos, posini, list, z);
					break;
				}
				return false;
			default:
				if(chk.northBlock == this)
					checkBreakBlock(worldIn, chk.northPos, posini, list, z);
				if(chk.southBlock == this)
					checkBreakBlock(worldIn, chk.southPos, posini, list, z);
				if(chk.eastBlock == this)
					checkBreakBlock(worldIn, chk.eastPos, posini, list, z);
				if(chk.westBlock == this)
					checkBreakBlock(worldIn, chk.westPos, posini, list, z);
				if(chk.downBlock == this)
					checkBreakBlock(worldIn, chk.downPos, posini, list, z);
				if(chk.upBlock == this)
					checkBreakBlock(worldIn, chk.upPos, posini, list, z);
				
				return false;
		}

		return true;
	}
	
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
		
		ArrayList list = new ArrayList();
		checkBreakBlock(worldIn, pos, pos, list, 3);
		list.clear();
	}
	
	private boolean checkPlaceBlock(World worldIn, BlockPos pos, ArrayList list, int z)
	{
		if(list.contains(pos))
			return false;
		
		if(z==0)
			return false;
			
		z--;
		
		list.add(pos);
		
		CheckBlocks chk = new CheckBlocks(worldIn, pos, this);
		// Modo 0: Sem Conexao
		// Modo 1: Conexao Acima, Up
		// Modo 2: Conexao Abaixo, Down
		// Modo 3: Conexao Atras, North
		// Modo 4: Conexao Frente, South
		// Modo 5: Conexao Esquerda, East
		// Modo 6: Conexao Direita, West
		// Modo 7: Conexao Up, Down
		// Modo 8: Conexao East, West
		// Modo 9: Conexao North, East
		
		switch(chk.conta_conexoes)
		{
			case 0:
				return false;
			case 1:
				if(chk.checkDown == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 2));
					checkPlaceBlock(worldIn, chk.downPos, list, z);
				}
				if(chk.checkUp == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 1));
					checkPlaceBlock(worldIn, chk.upPos, list, z);
				}
				if(chk.checkEast == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 5));
					checkPlaceBlock(worldIn, chk.eastPos, list, z);
				}	
				if(chk.checkWest == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 6));
					checkPlaceBlock(worldIn, chk.westPos, list, z);
				}
				if(chk.checkNorth == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 3));
					checkPlaceBlock(worldIn, chk.northPos, list, z);
				}
				if(chk.checkSouth == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 4));
					checkPlaceBlock(worldIn, chk.southPos, list, z);
				}	
				break;
			case 2:
				if(chk.checkDown == true && chk.checkUp == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 7));
					checkPlaceBlock(worldIn, chk.downPos, list, z);
					checkPlaceBlock(worldIn, chk.upPos, list, z);
					break;
				}
				if(chk.checkEast == true && chk.checkWest == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 8));
					checkPlaceBlock(worldIn, chk.eastPos, list, z);
					checkPlaceBlock(worldIn, chk.westPos, list, z);
					break;
				}
				if(chk.checkNorth == true && chk.checkSouth == true)
				{
					worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, 9));
					checkPlaceBlock(worldIn, chk.northPos, list, z);
					checkPlaceBlock(worldIn, chk.southPos, list, z);
					break;
				}
				return false;
			default:
				return false;
		}

		return true;
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		ArrayList list = new ArrayList();
		IBlockState retorno = super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(MODO, 0);
		
		if(checkPlaceBlock(worldIn, pos, list, 3)==false)
			return retorno;
		
		list.clear();
		
		return worldIn.getBlockState(pos);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		int valor = (Integer) state.getValue(MODO);
		valor++;
		if(valor>9)
			valor = 0;
		
		worldIn.setBlockState(pos, getDefaultState().withProperty(MODO, valor));
		return true;
	}	
	
	@SideOnly(Side.CLIENT)
	@Override
    public IBlockState getStateForEntityRender(IBlockState state)
    {
		return this.getDefaultState().withProperty(MODO, state.getValue(MODO));
    }
	
	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return this.getDefaultState().withProperty(MODO, state.getValue(MODO));
	}
	
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
}
