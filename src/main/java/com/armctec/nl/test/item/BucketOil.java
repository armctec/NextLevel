package com.armctec.nl.test.item;

import com.armctec.nl.general.item.ItemBasic;
import com.armctec.nl.test.gui.CreativeTabTest;
import com.armctec.nl.test.reference.ModConfig;
import com.armctec.nl.test.reference.Names;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BucketOil extends ItemBasic 
{
	public BucketOil() 
	{
		setItemName(ModConfig.MOD_ID, Names.Items.OIL_BUCKET);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabTest.TEST_TAB);
	}
	
    @Override
    public int getMaxItemUseDuration(ItemStack stack) 
    {
        return 32;
    }

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);

        if (movingobjectposition == null)
        {
            return itemStackIn;
        }
        else
        {
            ItemStack ret = net.minecraftforge.event.ForgeEventFactory.onBucketUse(playerIn, worldIn, itemStackIn, movingobjectposition);
            if (ret != null) 
            	return ret;
        }
        return itemStackIn;
	}
}
