package com.armctec.nl.general.utility;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.MinecraftForgeClient;

public class UtilityFunctions 
{
	public UtilityFunctions() 
	{
	}
	
	public static void spawnItemStack(World worldIn, BlockPos pos, ItemStack stack)
	{
		spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
	}

	public static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack)
    {
		Random rand = worldIn.rand;
		
        float f = rand.nextFloat() * 0.8F + 0.1F;
        float f1 = rand.nextFloat() * 0.8F + 0.1F;
        float f2 = rand.nextFloat() * 0.8F + 0.1F;

        while (stack.stackSize > 0)
        {
            int i = rand.nextInt(21) + 10;

            if (i > stack.stackSize)
            {
                i = stack.stackSize;
            }

            stack.stackSize -= i;
            EntityItem entityitem = new EntityItem(worldIn, x + (double)f, y + (double)f1, z + (double)f2, new ItemStack(stack.getItem(), i, stack.getMetadata()));

            if (stack.hasTagCompound())
            {
                entityitem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
            }

            float f3 = 0.05F;
            entityitem.motionX = rand.nextGaussian() * (double)f3;
            entityitem.motionY = rand.nextGaussian() * (double)f3 + 0.20000000298023224D;
            entityitem.motionZ = rand.nextGaussian() * (double)f3;
            worldIn.spawnEntityInWorld(entityitem);
        }
    }
	
	public static MovingObjectPosition getMovingObjectPositionFromPlayer(World worldIn, EntityPlayer playerIn, boolean useLiquids)
    {
        float f = playerIn.rotationPitch;
        float f1 = playerIn.rotationYaw;
        double d0 = playerIn.posX;
        double d1 = playerIn.posY + (double)playerIn.getEyeHeight();
        double d2 = playerIn.posZ;
        Vec3 vec3 = new Vec3(d0, d1, d2);
        float f2 = MathHelper.cos(-f1 * 0.017453292F - (float)Math.PI);
        float f3 = MathHelper.sin(-f1 * 0.017453292F - (float)Math.PI);
        float f4 = -MathHelper.cos(-f * 0.017453292F);
        float f5 = MathHelper.sin(-f * 0.017453292F);
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d3 = 5.0D;
        if (playerIn instanceof net.minecraft.entity.player.EntityPlayerMP)
        {
            d3 = ((net.minecraft.entity.player.EntityPlayerMP)playerIn).theItemInWorldManager.getBlockReachDistance();
        }
        Vec3 vec31 = vec3.addVector((double)f6 * d3, (double)f5 * d3, (double)f7 * d3);
        return worldIn.rayTraceBlocks(vec3, vec31, useLiquids, !useLiquids, false);
    }
	
	public static boolean travelToDimensionEntity(Entity entityorigem, int dimensionId)
	{
		if(entityorigem == null)
			return false;
		
		World worldIn = entityorigem.worldObj;
		
		if (worldIn.isRemote || entityorigem.isDead)
			return false;
		
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		if(minecraftserver == null)
		{
			System.out.println("minecraftserver == null");
			return false;
		}
		
		/** Getting world */
		WorldServer worldorigem = minecraftserver.worldServerForDimension(entityorigem.dimension);
        WorldServer worlddestino = minecraftserver.worldServerForDimension(dimensionId);
        
        if(worldorigem == null || worlddestino == null || worlddestino == worldorigem)
        	return false;
        
        worldIn.removeEntity(entityorigem);
        entityorigem.isDead = false;
        
        /** transferEntityToWorld */
        if (entityorigem.isEntityAlive())
        {
        	worlddestino.spawnEntityInWorld(entityorigem);
        	worlddestino.updateEntityWithOptionalForce(entityorigem, false);
        }
        entityorigem.setWorld(worlddestino);        
        
        /** Spawn in new world */
        Entity entitydestino = EntityList.createEntityByName(EntityList.getEntityString(entityorigem), worlddestino);
        if (entitydestino != null)
        {
        	entitydestino.copyDataFromOld(entityorigem);
            worlddestino.spawnEntityInWorld(entitydestino);
        }

        entityorigem.isDead = true;

        /** Update entity list */
        worldorigem.resetUpdateEntityTick();
        worlddestino.resetUpdateEntityTick();
        
		return true;
	}

	public static boolean travelToDimensionEntityPlayer(EntityPlayerMP entityorigem, int dimensionId)
	{
		int dimension;
		
		if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(entityorigem, dimensionId)) 
			return false;
		
		if(entityorigem == null)
			return false;
		
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		if(minecraftserver == null)
		{
			System.out.println("minecraftserver == null");
			return false;
		}
		
		ServerConfigurationManager servercfg = minecraftserver.getConfigurationManager();
		if(servercfg == null)
		{
			System.out.println("servercfg == null");
			return false;	
		}
		
		/** Getting world */
		WorldServer worldorigem = minecraftserver.worldServerForDimension(entityorigem.dimension);
        WorldServer worlddestino = minecraftserver.worldServerForDimension(dimensionId);
        
        if(worldorigem == null || worlddestino == null || worlddestino == worldorigem)
        	return false;
        
        dimension = entityorigem.dimension;
        entityorigem.dimension = dimensionId; 
        
        entityorigem.playerNetServerHandler.sendPacket(new S07PacketRespawn(dimensionId, worlddestino.getDifficulty(), worlddestino.getWorldInfo().getTerrainType(), entityorigem.theItemInWorldManager.getGameType()));
        worldorigem.removePlayerEntityDangerously(entityorigem);
        entityorigem.isDead = false;
        
        /** transferEntityToWorld */
        if (entityorigem.isEntityAlive())
        {
        	worlddestino.spawnEntityInWorld(entityorigem);
        	worlddestino.updateEntityWithOptionalForce(entityorigem, false);
        }
        entityorigem.setWorld(worlddestino);  

        
        servercfg.preparePlayer(entityorigem, worldorigem);
        
        entityorigem.playerNetServerHandler.setPlayerLocation(entityorigem.posX, entityorigem.posY, entityorigem.posZ, entityorigem.rotationYaw, entityorigem.rotationPitch);
        entityorigem.theItemInWorldManager.setWorld(worlddestino);
        
        servercfg.updateTimeAndWeatherForPlayer(entityorigem, worlddestino);
        servercfg.syncPlayerInventory(entityorigem);

        for (PotionEffect potioneffect : entityorigem.getActivePotionEffects())
        {
        	entityorigem.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(entityorigem.getEntityId(), potioneffect));
        }        
        
        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerChangedDimensionEvent(entityorigem, dimension, dimensionId);
        
		return true;
	}
	
}
