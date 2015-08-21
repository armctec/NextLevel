package com.armctec.nl.tools.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.armctec.nl.tools.gui.CreativeTabTools;
import com.armctec.nl.tools.reference.ModConfig;

public class Armor extends ItemArmor 
{
	public final static int HELMET = 0;
	public final static int CHESTPLATE = 1;
	public final static int LEGGINGS = 2;
	public final static int BOOTS = 3;
	
	private String ItemName = null;
	private String ModelArmor = "";
	private String nameMaterial = "";
	
	public Armor(String name, ArmorMaterial material, int tipo)  
	{
		super(material, 0, tipo);
		nameMaterial = material.getName();

		setItemName(ModConfig.MOD_ID, name);
		this.setCreativeTab(CreativeTabTools.ARMOR_TAB);
	}
	
	public void setItemName(String ModIdName, String name)
    {
        this.ItemName = name;
    	setUnlocalizedName(ModIdName.toLowerCase() + ":" + name);
    	ModelArmor = ModIdName.toLowerCase() + ":textures/models/armor/" + nameMaterial + "_layer_" + (this.armorType == 2 ? "2" : "1") + ".png";	
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
