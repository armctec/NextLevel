package com.armctec.nl.test.gui;

import com.armctec.nl.test.configs.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSaddle;

public class CreativeTabTest 
{
    public static final CreativeTabs ORES_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.book;
        }
    };
}
