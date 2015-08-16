package com.armctec.nl.general.item;

import net.minecraft.item.Item;

public class ItemBasic extends Item
{
	private String ItemName = null;
	
	public ItemBasic() 
	{
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
