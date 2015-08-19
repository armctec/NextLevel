package com.armctec.nl.tools.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class Armor extends ItemArmor 
{
	private String ItemName = null;
	private String ModelArmor = "";
	private String nameMaterial = "";
	
	public Armor(String name, ArmorMaterial material, int tipo)  
	{
		super(material, 0, tipo);
		nameMaterial = material.getName();
	}
	
	public void setItemName(String ModIdName, String name)
    {
        this.ItemName = name;
    	setUnlocalizedName(ModIdName.toLowerCase() + ":" + name);
    	ModelArmor = ModIdName.toLowerCase() + ":textures/armor/" + nameMaterial + "_" + (this.armorType == 2 ? "2" : "1") + ".png";	
    }
    
    public String getName()
    {
    	return ItemName;
    }
    
    @Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
    {
		return ModelArmor;
	}
}
