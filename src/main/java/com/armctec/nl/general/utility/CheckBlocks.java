package com.armctec.nl.general.utility;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CheckBlocks 
{
	public BlockPos downPos;
	public BlockPos upPos;
	public BlockPos eastPos;
	public BlockPos westPos;
	public BlockPos northPos;
	public BlockPos southPos;
	
	public IBlockState downBlockState;
	public IBlockState upBlockState;
	public IBlockState eastBlockState;
	public IBlockState westBlockState;
	public IBlockState northBlockState;
	public IBlockState southBlockState;

	public Block downBlock;
	public Block upBlock;
	public Block eastBlock;
	public Block westBlock;
	public Block northBlock;
	public Block southBlock;

	public boolean checkDown = false;
	public boolean checkUp = false;
	public boolean checkEast = false;
	public boolean checkWest = false;
	public boolean checkNorth = false;
	public boolean checkSouth = false;

	public int conta_conexoes = 0;

	
	public CheckBlocks(World worldIn, BlockPos pos, Block atual) 
	{
		downPos = pos.down();
		upPos = pos.up();
		eastPos = pos.east();
		westPos = pos.west();
		northPos = pos.north();
		southPos = pos.south();
		
		downBlockState = worldIn.getBlockState(downPos);
		upBlockState = worldIn.getBlockState(upPos);
		eastBlockState = worldIn.getBlockState(eastPos);
		westBlockState = worldIn.getBlockState(westPos);
		northBlockState = worldIn.getBlockState(northPos);
		southBlockState = worldIn.getBlockState(southPos);
		
		downBlock = downBlockState.getBlock();
		upBlock = upBlockState.getBlock();
		eastBlock = eastBlockState.getBlock();
		westBlock = westBlockState.getBlock();
		northBlock = northBlockState.getBlock();
		southBlock = southBlockState.getBlock();
		
		if(downBlock == atual)
		{
			conta_conexoes++;
			checkDown = true;
		}
		
		if(upBlock == atual)
		{
			conta_conexoes++;
			checkUp = true;
		}
		
		if(eastBlock == atual)
		{
			conta_conexoes++;
			checkEast = true;
		}
		
		if(westBlock == atual)
		{
			conta_conexoes++;
			checkWest = true;
		}
		
		if(northBlock == atual)
		{
			conta_conexoes++;
			checkNorth = true;
		}
		
		if(southBlock == atual)
		{
			conta_conexoes++;
			checkSouth = true;
		}

	}

}
