package com.armctec.nl.tools.item;

import java.lang.reflect.Field;

import com.armctec.nl.tools.gui.CreativeTabTools;
import com.armctec.nl.tools.reference.ModConfig;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class Armor extends ItemArmor 
{
	public final static int HELMET = 0;
	public final static int CHESTPLATE = 1;
	public final static int LEGGINGS = 2;
	public final static int BOOTS = 3;
	
	private String ItemName = null;
	private String ModelArmor = "";
	private String nameMaterial = "";
	private static Field fieldName = null;
	
	// Reflection for field MaterialArmor.name
	static 
	{
		try
		{
			fieldName = ReflectionHelper.findField(ArmorMaterial.class, "field_179243_f", "name");
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}
	
	private String getArmorName(ArmorMaterial material)
	{
		String name = "";
		
		if(fieldName == null)
			return name;
		
		try
		{
			name = (String) fieldName.get(material);
		}
		catch(Throwable e) 
		{
			e.printStackTrace();
		}
		
		return name;
	}	
	
	public Armor(String name, ArmorMaterial material, EntityEquipmentSlot tipo)  
	{
		super(material, 0, tipo);

		nameMaterial = getArmorName(material); //material.getName();

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
