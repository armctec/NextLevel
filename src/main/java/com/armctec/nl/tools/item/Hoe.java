package com.armctec.nl.tools.item;

import net.minecraft.item.ItemHoe;

import com.armctec.nl.tools.gui.CreativeTabTools;
import com.armctec.nl.tools.reference.ModConfig;

public class Hoe extends ItemHoe
{
	private String ItemName = null;
	
	public Hoe(String name, ToolMaterial material) 
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
