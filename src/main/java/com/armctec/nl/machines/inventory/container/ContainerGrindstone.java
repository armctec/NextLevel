package com.armctec.nl.machines.inventory.container;

import com.armctec.nl.machines.inventory.slot.SlotGrindstone;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerGrindstone extends Container
{
	private TileEntityGrindstone tileEntity = null;
    private World worldObj;
    private BlockPos blockPosition;
    
	public ContainerGrindstone(InventoryPlayer playerInventory, World worldIn, BlockPos blockPosition, TileEntityGrindstone tileEntity) 
	{
		this.worldObj = worldIn;
		this.tileEntity = tileEntity;
		this.blockPosition = blockPosition;
		
		tileEntity.setContainer(this);
		setSlots(playerInventory);
	}
	
	private void setSlots(InventoryPlayer playerInventory)
	{
        int i;
        int j;

        // Saidas
        this.addSlotToContainer(new SlotGrindstone(tileEntity, 0, 90, 25, true));
        this.addSlotToContainer(new SlotGrindstone(tileEntity, 1, 110, 25, true));
        this.addSlotToContainer(new SlotGrindstone(tileEntity, 2, 130, 25, true));

        // Entrada
        this.addSlotToContainer(new Slot(tileEntity, 3, 31, 25));
        this.addSlotToContainer(new SlotGrindstone(tileEntity, 4, 31, 45, false));

        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        onCraftMatrixChanged(tileEntity);		
	}
    
	// Vanilla calls this method every tick to make sure the player is still able to access the inventory, and if not closes the gui
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return tileEntity.isUseableByPlayer(player);
	}
	
	// pass the close container message to the tileEntityInventory (not strictly needed for this example)
	//  see ContainerChest and TileEntityChest
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
		super.onContainerClosed(playerIn);
		this.tileEntity.closeInventory(playerIn);
		worldObj.markBlockForUpdate(blockPosition);
	}	
	
	/**
     * Take a stack from the specified inventory slot.
     */
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 4)
            {
                
            	if (!this.mergeItemStack(itemstack1, 4, 40, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 4 && index < 31)
            {
                if (!this.mergeItemStack(itemstack1, 31, 40, false))
                {
                    return null;
                }
            }
            else if (index >= 31 && index < 40)
            {
                if (!this.mergeItemStack(itemstack1, 4, 31, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 4, 40, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }	
}
