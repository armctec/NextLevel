package com.armctec.nl.tools.item.material;

import com.armctec.nl.ores.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MyArmor 
{
/*
	private final String name;
     	// Holds the name
     	
    private final int maxDamageFactor;
     	// Holds the maximum damage factor (each piece multiply this by it's own value) of the material, this is the
    	// item damage (how much can absorb before breaks)
     
    private final int[] damageReductionAmountArray;
     	// Holds the damage reduction (each 1 points is half a shield on gui) of each piece of armor (helmet, plate,
     	// legs and boots)

	private final int enchantability;
    	// Return the enchantability factor of the material

	ArmorMaterial LEATHER 	= addArmorMaterial("leather", 	05, new int[]{1, 3, 2, 1}, 15),
    ArmorMaterial GOLD 		= addArmorMaterial("gold", 		07, new int[]{2, 5, 3, 1}, 25),
    ArmorMaterial CHAIN 	= addArmorMaterial("chainmail", 	15, new int[]{2, 5, 4, 1}, 12),
    ArmorMaterial IRON 		= addArmorMaterial("iron", 		15, new int[]{2, 6, 5, 2}, 09),
    ArmorMaterial DIAMOND 	= addArmorMaterial("diamond", 	33, new int[]{3, 8, 6, 3}, 10);
*/
	public static ArmorMaterial COPPER 		= addArmorMaterial("COPPER", 	 7, new int[]{1,5,4,2}, 10);    
	public static ArmorMaterial TIN         = addArmorMaterial("TIN", 		 6, new int[]{1,4,4,1}, 14);
    public static ArmorMaterial LEAD 		= addArmorMaterial("LEAD", 		14, new int[]{2,6,4,1}, 5);
	public static ArmorMaterial ALUMINIUM 	= addArmorMaterial("ALUMINIUM",  8, new int[]{1,4,3,1}, 18);
	public static ArmorMaterial ZINC 		= addArmorMaterial("ZINC", 		16, new int[]{2,6,7,3}, 10);
	public static ArmorMaterial TITANIUM 	= addArmorMaterial("TITANIUM", 	22, new int[]{3,7,6,2}, 8);
	public static ArmorMaterial SILVER		= addArmorMaterial("SILVER", 	18, new int[]{2,5,4,2}, 14);
	public static ArmorMaterial NICKEL 		= addArmorMaterial("NICKEL", 	16, new int[]{2,7,5,2}, 18);
	public static ArmorMaterial TUNGSTEN 	= addArmorMaterial("TUNGSTEN", 	22, new int[]{3,8,6,2}, 10);
	public static ArmorMaterial SILICON 	= addArmorMaterial("SILICON", 	 3, new int[]{1,2,2,1}, 20);
	
	public static ArmorMaterial RUBY 		= addArmorMaterial("RUBY", 		30, new int[]{3,8,6,3}, 10);
	public static ArmorMaterial SAPPHIRE 	= addArmorMaterial("SAPPHIRE", 	30, new int[]{3,8,6,3}, 10);
	public static ArmorMaterial MOONSTONE 	= addArmorMaterial("MOONSTONE", 25, new int[]{2,7,5,3}, 30);
	public static ArmorMaterial BLACKONYX 	= addArmorMaterial("BLACKONYX", 20, new int[]{2,6,4,2}, 25);
	public static ArmorMaterial REDONYX 	= addArmorMaterial("REDONYX", 	20, new int[]{2,6,4,2}, 20);
	public static ArmorMaterial AMETHYST 	= addArmorMaterial("AMETHYST", 	15, new int[]{2,4,4,1}, 10);
	
	public static ArmorMaterial BRONZE 		= addArmorMaterial("BRONZE", 	13, new int[]{2,6,5,2}, 14);  // Copper, Tin
	public static ArmorMaterial BRASS 		= addArmorMaterial("BRASS", 	10, new int[]{2,5,5,2}, 14);  // Copper, Zinc
	public static ArmorMaterial ZAMAK 		= addArmorMaterial("ZAMAK", 	15, new int[]{2,5,4,1}, 14);  // Copper, Aluminium
	public static ArmorMaterial STERLING 	= addArmorMaterial("STERLING", 	20, new int[]{2,5,4,2}, 14);  // Copper, Silver
	public static ArmorMaterial CUPRO 		= addArmorMaterial("CUPRO", 	18, new int[]{2,6,5,2}, 14);  // Copper, Nickel
	public static ArmorMaterial INVAR 		= addArmorMaterial("INVAR", 	22, new int[]{2,7,5,2}, 14);  // Iron, Nickel
	public static ArmorMaterial STEEL 		= addArmorMaterial("STEEL", 	26, new int[]{3,7,6,3}, 10);  // Iron, Carbon
	public static ArmorMaterial FERSILICON 	= addArmorMaterial("FERSILICON",10, new int[]{2,4,3,1}, 14);  // Iron, Silicon
	public static ArmorMaterial ELECTRUM 	= addArmorMaterial("ELECTRUM", 	14, new int[]{1,4,3,2}, 22);  // Silver, Gold
	public static ArmorMaterial HSS 		= addArmorMaterial("HSS", 		32, new int[]{3,9,7,3}, 10);  // Steel, Tungsten
	public static ArmorMaterial BABBITT 	= addArmorMaterial("BABBITT", 	10, new int[]{2,7,5,2}, 10);  // Lead, Tin
	public static ArmorMaterial GRADE 		= addArmorMaterial("GRADE", 	20, new int[]{3,8,7,3}, 14);  // Titanium, Aluminium
	public static ArmorMaterial CARBON 		= addArmorMaterial("CARBON", 	18, new int[]{1,2,2,1}, 22);  // Coal, Charcoal
	
	public static ArmorMaterial addArmorMaterial(String name, int durability, int[] reductionAmounts, int enchantability)
	{
		return EnumHelper.addArmorMaterial(name, "", durability, reductionAmounts, enchantability);
	}
	
	public static void init()
	{
		COPPER.customCraftingMaterial = ModItems.CopperIngot;
		TIN.customCraftingMaterial = ModItems.TinIngot;
		LEAD.customCraftingMaterial = ModItems.LeadIngot;
		ALUMINIUM.customCraftingMaterial = ModItems.AluminiumIngot;
		ZINC.customCraftingMaterial = ModItems.ZincIngot;
		TITANIUM.customCraftingMaterial = ModItems.TitaniumIngot;
		SILVER.customCraftingMaterial = ModItems.SilverIngot;
		NICKEL.customCraftingMaterial = ModItems.NickelIngot;
		TUNGSTEN.customCraftingMaterial = ModItems.TungstenIngot;
		SILICON.customCraftingMaterial = ModItems.SiliconIngot;
		
		RUBY.customCraftingMaterial = ModItems.RubyGem;
		SAPPHIRE.customCraftingMaterial = ModItems.SapphireGem;
		MOONSTONE.customCraftingMaterial = ModItems.MoonstoneGem;
		BLACKONYX.customCraftingMaterial = ModItems.BlackonyxGem;
		REDONYX.customCraftingMaterial = ModItems.RedonyxGem;
		AMETHYST.customCraftingMaterial = ModItems.AmethystGem;
		
		BRONZE.customCraftingMaterial = ModItems.BronzeIngot;
		BRASS.customCraftingMaterial = ModItems.BrassIngot;
		ZAMAK.customCraftingMaterial = ModItems.ZamakIngot;
		STERLING.customCraftingMaterial = ModItems.SterlingSilverIngot;
		CUPRO.customCraftingMaterial = ModItems.CupronickelIngot;
		INVAR.customCraftingMaterial = ModItems.InvarIngot;
		STEEL.customCraftingMaterial = ModItems.SteelIngot;
		FERSILICON.customCraftingMaterial = ModItems.FerrosiliconIngot;
		ELECTRUM.customCraftingMaterial = ModItems.ElectrumIngot;
		HSS.customCraftingMaterial = ModItems.HssIngot;
		BABBITT.customCraftingMaterial = ModItems.BabbittIngot;
		GRADE.customCraftingMaterial = ModItems.Grade5Ingot;
		CARBON.customCraftingMaterial = ModItems.CarbonIngot;
	}	
}
