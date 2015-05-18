package com.armctec.nl.test.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.armctec.nl.test.reference.ModConfig;

public class CreativeTabTest 
{
    public static final CreativeTabs ORES_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.book;
        }
    };
}
