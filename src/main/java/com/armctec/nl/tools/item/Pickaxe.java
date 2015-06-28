package com.armctec.nl.tools.item;

import com.armctec.nl.ores.gui.CreativeTabOres;
import com.armctec.nl.ores.reference.ModConfig;
import com.armctec.nl.tools.gui.CreativeTabTools;

import net.minecraft.item.ItemPickaxe;

public class Pickaxe extends ItemPickaxe
{
	String ItemName = null;
	
	public Pickaxe(String name, ToolMaterial material) 
	{
		super(material);
		setItemName(ModConfig.MOD_ID, name);
		this.setCreativeTab(CreativeTabTools.TOOLS_TAB);
	}
	
	public void setItemName(String ModIdName, String name)
    {
        this.ItemName = name;
    	setUnlocalizedName(ModIdName.toLowerCase() + ":" + name);
    }
    
    public String getName()
    {
    	return ItemName;
    }
}
