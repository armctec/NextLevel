package com.armctec.nl.test.events;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Event_onBucketFill 
{
    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        IBlockState state = event.world.getBlockState(event.target.getBlockPos());
        if (state.getBlock() instanceof IFluidBlock)
        {
            Fluid fluid = ((IFluidBlock) state.getBlock()).getFluid();
            FluidStack fs = new FluidStack(fluid, FluidContainerRegistry.BUCKET_VOLUME);

            ItemStack filled = FluidContainerRegistry.fillFluidContainer(fs, event.current);
            if (filled != null)
            {
                event.result = filled;
                event.world.setBlockToAir(event.target.getBlockPos());

                event.setResult(Result.ALLOW);
            }
        }
        
        //Log.info("onBucketFill");
    }
}
