package com.armctec.nl.machines.enchantment;

import com.armctec.nl.machines.item.ToolGrindstone;
import com.armctec.nl.machines.reference.ModConfig;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLootBonus;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class EnchantmentThroughput extends Enchantment
{
	public EnchantmentThroughput(int enchID, ResourceLocation enchName, int enchWeight, EnumEnchantmentType enchType)
	{
		super(enchID, enchName, enchWeight, enchType);
		setName(enchName.toString());
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) 
	{
		return stack.getItem() instanceof ToolGrindstone;
	}

	@Override
	public boolean isAllowedOnBooks()
	{
		return true;
	}
	
    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
	@Override
    public int getMinEnchantability(int enchantmentLevel)
    {
		return 1 + 10 * (enchantmentLevel - 1);
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
	@Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
	@Override
    public int getMaxLevel()
    {
        return 10;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     *  
     * @param ench A possible enchantment that may be applied along side this enchantment, depending on the results.
     */
	@Override
    public boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && ench.effectId != silkTouch.effectId;
    }	
}
