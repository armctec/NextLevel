package com.armctec.nl.tools.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.armctec.nl.tools.reference.ModConfig;

public class CreativeTabTools 
{
    public static final CreativeTabs TOOLS_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.diamond_pickaxe;
        }
    };
}
