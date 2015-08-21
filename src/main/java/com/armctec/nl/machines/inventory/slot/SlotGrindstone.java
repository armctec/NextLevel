package com.armctec.nl.machines.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.armctec.nl.machines.init.ModItems;

public class SlotGrindstone extends Slot 
{
	private boolean saida;
	
	public SlotGrindstone(IInventory inventoryIn, int index, int xPosition, int yPosition, boolean saida)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.saida = saida;
	}

	@Override
	public boolean isItemValid(ItemStack stack)
	{
		if(saida == true)
			return false;
		
		if(stack.getItem()!=ModItems.ToolGrind)
			return false;
		
		return true;
	}
}
