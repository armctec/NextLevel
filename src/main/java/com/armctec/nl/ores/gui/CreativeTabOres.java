package com.armctec.nl.ores.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.armctec.nl.ores.reference.ModConfig;

public class CreativeTabOres 
{
    public static final CreativeTabs ORES_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.SADDLE;
        }
    };
}
