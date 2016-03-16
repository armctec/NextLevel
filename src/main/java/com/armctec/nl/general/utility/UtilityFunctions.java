package com.armctec.nl.general.utility;

import java.util.Random;

import com.armctec.nl.test.world.VoidTeleporter;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S06PacketUpdateHealth;
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
	
	public static boolean travelToDimensionEntity(Entity entityIn, int dimensionId)
	{
		return travelToDimensionEntity(entityIn, dimensionId, entityIn.posX, entityIn.posY, entityIn.posZ);
	}
	
	public static boolean travelToDimensionEntity(Entity entityIn, int dimensionId, double x, double y, double z)
	{
		if (!entityIn.worldObj.isRemote)
        {
			 MinecraftServer server = MinecraftServer.getServer();
			 WorldServer oldWorldServer = server.worldServerForDimension(entityIn.dimension);
			 WorldServer newWorldServer = server.worldServerForDimension(dimensionId);
			 
             NBTTagCompound tag = new NBTTagCompound();
             
             entityIn.writeToNBTOptional(tag);
             entityIn.setDead();
             oldWorldServer.playSoundEffect(entityIn.posX, entityIn.posY, entityIn.posZ, "mob.endermen.portal", 1.0F, 1.0F);

             Entity teleportedEntity = EntityList.createEntityFromNBT(tag, newWorldServer);
             if (teleportedEntity != null)
             {
                 teleportedEntity.setLocationAndAngles(x, y , z, entityIn.rotationYaw, entityIn.rotationPitch);
                 teleportedEntity.forceSpawn = true;
                 newWorldServer.spawnEntityInWorld(teleportedEntity);
                 teleportedEntity.setWorld(newWorldServer);
                 teleportedEntity.timeUntilPortal = 150;
             }

             oldWorldServer.resetUpdateEntityTick();
             newWorldServer.resetUpdateEntityTick();
             
             return true;
        }
		return false;
	}

	public static boolean travelToDimensionEntityPlayer(EntityPlayerMP entityIn, int dimensionId)
	{
		return travelToDimensionEntityPlayer(entityIn, dimensionId, entityIn.posX, entityIn.posY, entityIn.posZ);
	}
	
	public static boolean travelToDimensionEntityPlayer(EntityPlayerMP entityIn, int dimensionId, double x, double y, double z)
	{
		 if (entityIn != null)
         {
			 MinecraftServer server = MinecraftServer.getServer();
			 WorldServer oldWorld = server.worldServerForDimension(entityIn.dimension);
			 WorldServer newWorldServer = server.worldServerForDimension(dimensionId);
			 
             if (entityIn.timeUntilPortal <= 0)
             {
                 if (entityIn instanceof EntityPlayer)
                 {
                     EntityPlayerMP player = (EntityPlayerMP) entityIn;

                     if (!player.worldObj.isRemote)
                     {
                         server.getConfigurationManager().transferPlayerToDimension(player, dimensionId, new VoidTeleporter(newWorldServer));
                         player.setPositionAndUpdate(x, y, z);
                         player.worldObj.updateEntityWithOptionalForce(player, false);
                     }

                 }
                 entityIn.timeUntilPortal = 150;

                 newWorldServer.playSoundEffect(x, y, z, "mob.endermen.portal", 1.0F, 1.0F);
                 
                 return true;
             }
         }
		 
		 return false;
	}
	
}
