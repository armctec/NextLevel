package com.armctec.nl.tools.item;

import com.armctec.nl.tools.gui.CreativeTabTools;
import com.armctec.nl.tools.reference.ModConfig;

import net.minecraft.item.ItemSword;

public class Sword extends ItemSword
{
	private String ItemName = null;
	
	public Sword(String name, ToolMaterial material) 
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
