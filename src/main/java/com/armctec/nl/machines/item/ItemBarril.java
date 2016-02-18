package com.armctec.nl.machines.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.armctec.nl.general.item.ItemBasic;
import com.armctec.nl.machines.block.BlockBarril;
import com.armctec.nl.machines.gui.CreativeTabMachines;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.reference.Names;

public class ItemBarril extends ItemBlock implements IFluidContainerItem
{
	protected int capacity;
	
	public ItemBarril(Block block) 
	{
		super(block);
		this.maxStackSize = 1;
		this.setCreativeTab(CreativeTabMachines.MACHINES_TAB);
		capacity = BlockBarril.capacity;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if(playerIn.isSneaking())
		{
			MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, false);
			if (mop != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
	        {
				BlockPos pos = mop.getBlockPos().offset(mop.sideHit);
				// can we place liquid there?
	            if (worldIn.isBlockModifiable(playerIn, pos))
	            {
	            	Material material = worldIn.getBlockState(pos).getBlock().getMaterial();

	            	if (!worldIn.isAirBlock(pos) && !material.isSolid())
	            		return itemStackIn;

	            	FluidStack liquid_1 = getFluid(itemStackIn);
	            	FluidStack liquid_2 = drain(itemStackIn, FluidContainerRegistry.BUCKET_VOLUME, true);
            	
	            	if(liquid_1!=null)
	            	{
	            		if(!liquid_1.isFluidStackIdentical(liquid_2) || liquid_2==null)
	            		{
	            			Block fluid = liquid_1.getFluid().getBlock();
            			
	            			if (!worldIn.isRemote && !material.isSolid() && !material.isLiquid())
	            				worldIn.destroyBlock(pos, true);
	            			
	            			IBlockState state = fluid.getDefaultState();

	            			worldIn.setBlockState(pos, state, 3);

	            			// Nao sei como atualizar a nao ser assim
	            			if (fluid instanceof BlockLiquid)
	            				((BlockLiquid)fluid).onNeighborBlockChange(worldIn, pos, state, null);
	            			
	            			if (fluid instanceof BlockFluidBase)
	            				((BlockFluidBase)fluid).onNeighborBlockChange(worldIn, pos, state, null);
	            			
	            		}
	            	}
	            }
	        }
		}
		
		return itemStackIn;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(playerIn.isSneaking())
			return false;

		return super.onItemUse(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		super.addInformation(stack, playerIn, tooltip, advanced);
		
		NBTTagCompound tag = stack.getTagCompound(); 
		
		if(tag != null)
		{
			if(tag.hasKey("Amount"))
			{
				String nome = tag.getString("FluidName");
				int quantidade = tag.getInteger("Amount");

				tooltip.add("Fluido: " + nome);
				tooltip.add("Amount: " + quantidade);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) 
	{
		return false;
	}

	@Override
	public FluidStack getFluid(ItemStack container) 
	{
		NBTTagCompound tag = container.getTagCompound();
		
		if(tag == null)
            return null;
		
		if(!tag.hasKey("FluidName"))
			return null;

        return FluidStack.loadFluidStackFromNBT(tag);
	}

	@Override
	public int getCapacity(ItemStack container) 
	{
        return capacity;
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill)
	{
		return 0;
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) 
	{
        FluidStack stack = getFluid(container);
        if (stack == null)
            return null;

        NBTTagCompound tag = container.getTagCompound();
        
        int currentAmount = stack.amount;
        stack.amount = Math.min(stack.amount, maxDrain);
        if (doDrain)
        {
            if (currentAmount == stack.amount)
            {
                tag.removeTag("FluidName");
                tag.removeTag("Amount");

                if (tag.hasNoTags())
                {
                    container.setTagCompound(null);
                }
                
                return null;
            }

            tag.setInteger("Amount", currentAmount - stack.amount);
        }
        return stack;
	}
}
