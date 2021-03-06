package com.armctec.nl.tools.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.armctec.nl.tools.reference.ModConfig;

public class CreativeTabTools 
{
    public static final CreativeTabs TOOLS_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase()+":Tools")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.diamond_pickaxe;
        }
    };

    public static final CreativeTabs ARMOR_TAB = new CreativeTabs(ModConfig.MOD_ID.toLowerCase()+":Armor")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.diamond_chestplate;
        }
    };
    
}
