package com.armctec.nl.test.world;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class VoidTeleporter extends Teleporter 
{
	protected final WorldServer worldServerInstance;
	protected final Random random;
	
	public VoidTeleporter(WorldServer worldIn) 
	{
		super(worldIn);
		worldServerInstance = worldIn;
		random = new Random(worldIn.getSeed());
	}

	@Override
	public boolean makePortal(Entity p_85188_1_) 
	{
		return true;
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entityIn, float rotationYaw)
	{
		return true;
	}
	
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw) 
	{
        /*
		int i = MathHelper.floor_double(entityIn.posX);
        int j = MathHelper.floor_double(entityIn.posY) - 1;
        int k = MathHelper.floor_double(entityIn.posZ);
        int l = 1;
        int i1 = 0;

        for (int j1 = -2; j1 <= 2; ++j1)
        {
            for (int k1 = -2; k1 <= 2; ++k1)
            {
                for (int l1 = -1; l1 < 3; ++l1)
                {
                    int i2 = i + k1 * l + j1 * i1;
                    int j2 = j + l1;
                    int k2 = k + k1 * i1 - j1 * l;
                    boolean flag = l1 < 0;
                    this.worldServerInstance.setBlockState(new BlockPos(i2, j2, k2), flag ? Blocks.obsidian.getDefaultState() : Blocks.air.getDefaultState());
                }
            }
        }

        entityIn.setLocationAndAngles((double)i, (double)j, (double)k, entityIn.rotationYaw, 0.0F);
        */
        entityIn.motionX = entityIn.motionY = entityIn.motionZ = 0.0D;
	}
}
