package com.armctec.nl.machines.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.armctec.nl.ores.reference.ModConfig;

public class CreativeTabMachines 
{
    public static final CreativeTabs MACHINES_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.furnace_minecart;
        }
    };
}
