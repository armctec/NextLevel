package com.armctec.nl.general.world;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class VoidTeleporter extends Teleporter 
{
	public VoidTeleporter(WorldServer worldIn) 
	{
		super(worldIn);
	}

	@Override
	public boolean makePortal(Entity entity) 
	{
		return true;
	}
	
	@Override
	public void removeStalePortalLocations(long worldTime)
	{
	}
	
	@Override
	public boolean placeInExistingPortal(Entity entityIn, float rotationYaw)
	{
		return true;
	}
	
	@Override
	public void placeInPortal(Entity entityIn, float rotationYaw)
	{
		entityIn.setLocationAndAngles(MathHelper.floor_double(entityIn.posX), MathHelper.floor_double(entityIn.posY) + 2,  MathHelper.floor_double(entityIn.posZ), entityIn.rotationYaw, entityIn.rotationPitch);
    }
}