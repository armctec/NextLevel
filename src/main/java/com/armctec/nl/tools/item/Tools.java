package com.armctec.nl.tools.item;

import com.armctec.nl.ores.init.ModItems;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Tools 
{
	/*
	String Name is just the String name of the material.

	int harvestLevel indicates the harvest level of tools made of this material. 
	For reference vanilla harvest levels are as follows:
	0 Wood or Gold
	1 Stone
	2 Iron
	3 Diamond
	
	copper tools will be able to harvest the same things as iron ones.  
	If we wanted we could give our new material a harvest level of 4, 
	which would allow it to harvest anything diamond can, plus some things it can't! (which is nothing in vanilla minecraft)

	
	int maxUses indicates number of time the tool can be used before it breaks, also known as the durability. 
	For reference vanilla durabilities are as follows
	Gold 32
	Wood 59
	Stone 131
	Iron 250
	Diamond 1561
	So our tools made from our material are less durable than iron, but moreso than stone.

	float efficiency indicates the speed at which the tool mines, digs, swings, or whatever it does.
	Vanilla efficiency levels are:
	Wood 2.0
	Stone 4.0
	Iron 6.0
	Diamond 8.0
	Gold 12.0
	Making copper as speedy as diamond!
	
	float damage indicates how much damage is done to entities that are attacked with a tool made from this material, 
	although it should be noted that certain tools, such as swords have a higher base damage.
	Vanilla damage levels are:
	Wood or Gold 0.0
	Stone 1.0
	Iron 2.0
	Diamond 3.0
	So copper tools are as effective as stone for dealing damage.

	int enchantability indicates the natural enchantability factor for the material.
	Vanilla enchantability levels are:
	Wood 15
	Stone 5
	Iron 14
	Diamond 10
	Gold 22
	This means our copper tools will take enchantments about as well as diamond tools.  
	All in all this makes copper a little better than iron for tools (except maybe swords) 
	but significantly less durable, which I think balances it out some.
	*/
	
	//public static ToolMaterial WOOD 		= EnumHelper.addToolMaterial("WOOD", 		0, 59, 2.0F, 0.0F, 15);
	//public static ToolMaterial GOLD 		= EnumHelper.addToolMaterial("GOLD", 		0, 32, 12.0F, 0.0F, 22);
	//public static ToolMaterial STONE 		= EnumHelper.addToolMaterial("STONE", 		1, 131, 4.0F, 1.0F, 5);
	//public static ToolMaterial IRON 		= EnumHelper.addToolMaterial("IRON", 		2, 250, 6.0F, 2.0F, 14);
	//public static ToolMaterial DIAMOND 	= EnumHelper.addToolMaterial("DIAMOND", 	3, 1561, 8.0F, 3.0F, 10);
	
	public static ToolMaterial COPPER 		= EnumHelper.addToolMaterial("COPPER", 		2, 160, 8.0F, 1.0F, 10);    
	public static ToolMaterial TIN 			= EnumHelper.addToolMaterial("TIN", 		1, 100, 6.0F, 0.5F, 14);
    public static ToolMaterial LEAD 		= EnumHelper.addToolMaterial("LEAD", 		0, 50, 4.0F, 0.5F, 5);
	public static ToolMaterial ALUMINIUM 	= EnumHelper.addToolMaterial("ALUMINIUM", 	1, 130, 6.0F, 0.5F, 18);
	public static ToolMaterial ZINC 		= EnumHelper.addToolMaterial("ZINC", 		2, 300, 8.0F, 1.5F, 10);
	public static ToolMaterial TITANIUM 	= EnumHelper.addToolMaterial("TITANIUM", 	3, 150, 8.0F, 1.5F, 8);
	public static ToolMaterial SILVER		= EnumHelper.addToolMaterial("SILVER", 		2, 130, 10.0F, 1.0F, 14);
	public static ToolMaterial NICKEL 		= EnumHelper.addToolMaterial("NICKEL", 		2, 180, 8.0F, 1.0F, 18);
	public static ToolMaterial TUNGSTEN 	= EnumHelper.addToolMaterial("TUNGSTEN", 	3, 80, 4.0F, 2.0F, 10);
	public static ToolMaterial SILICON 		= EnumHelper.addToolMaterial("SILICON", 	0, 30, 3.0F, 0.5F, 20);
	
	public static ToolMaterial RUBY 		= EnumHelper.addToolMaterial("RUBY", 		3, 1560, 8.0F, 3.0F, 10);
	public static ToolMaterial SAPPHIRE 	= EnumHelper.addToolMaterial("SAPPHIRE", 	3, 1560, 8.0F, 3.0F, 10);
	public static ToolMaterial MOONSTONE 	= EnumHelper.addToolMaterial("MOONSTONE", 	2, 800, 10.0F, 4.0F, 30);
	public static ToolMaterial BLACKONYX 	= EnumHelper.addToolMaterial("BLACKONYX", 	2, 650, 6.0F, 2.5F, 25);
	public static ToolMaterial REDONYX 		= EnumHelper.addToolMaterial("REDONYX", 	2, 650, 6.0F, 2.5F, 20);
	public static ToolMaterial AMETHYST 	= EnumHelper.addToolMaterial("AMETHYST", 	1, 350, 4.0F, 1.5F, 10);
	
	public static ToolMaterial BRONZE 		= EnumHelper.addToolMaterial("BRONZE", 		2, 240, 10.0F, 1.5F, 14);   // Copper, Tin
	public static ToolMaterial BRASS 		= EnumHelper.addToolMaterial("BRASS", 		2, 250, 10.0F, 1.5F, 14);   // Copper, Zinc
	public static ToolMaterial ZAMAK 		= EnumHelper.addToolMaterial("ZAMAK", 		2, 380, 10.0F, 1.5F, 14);   // Copper, Aluminium
	public static ToolMaterial STERLING 	= EnumHelper.addToolMaterial("STERLING", 	2, 300, 12.0F, 2.5F, 14);   // Copper, Silver
	public static ToolMaterial CUPRO 		= EnumHelper.addToolMaterial("CUPRO", 		2, 340, 12.0F, 2.5F, 14);   // Copper, Nickel
	public static ToolMaterial INVAR 		= EnumHelper.addToolMaterial("INVAR", 		2, 560, 10.0F, 2.0F, 14);   // Iron, Nickel
	public static ToolMaterial STEEL 		= EnumHelper.addToolMaterial("STEEL", 		3, 740, 8.0F, 2.0F, 10);    // Iron, Carbon
	public static ToolMaterial FERSILICON 	= EnumHelper.addToolMaterial("FERSILICON", 	2, 200, 12.0F, 2.0F, 14);   // Iron, Silicon
	public static ToolMaterial ELECTRUM 	= EnumHelper.addToolMaterial("ELECTRUM", 	1, 80, 10.0F, 3.5F, 22);    // Silver, Gold
	public static ToolMaterial HSS 			= EnumHelper.addToolMaterial("HSS", 		3, 1000, 12.0F, 2.0F, 10);  // Steel, Tungsten
	public static ToolMaterial BABBITT 		= EnumHelper.addToolMaterial("BABBITT", 	3, 450, 8.0F, 1.5F, 10);    // Lead, Tin
	public static ToolMaterial GRADE 		= EnumHelper.addToolMaterial("GRADE", 		2, 650, 8.0F, 2.0F, 14);    // Titanium, Aluminium
	public static ToolMaterial CARBON 		= EnumHelper.addToolMaterial("CARBON", 		0, 20, 4.0F, 0.5F, 22);    	// Coal, Charcoal
	
	public static void init()
	{
		COPPER.setRepairItem(new ItemStack(ModItems.CopperIngot));
		TIN.setRepairItem(new ItemStack(ModItems.TinIngot));
		LEAD.setRepairItem(new ItemStack(ModItems.LeadIngot));
		ALUMINIUM.setRepairItem(new ItemStack(ModItems.AluminiumIngot));
		ZINC.setRepairItem(new ItemStack(ModItems.ZincIngot));
		TITANIUM.setRepairItem(new ItemStack(ModItems.TitaniumIngot));
		SILVER.setRepairItem(new ItemStack(ModItems.SilverIngot));
		NICKEL.setRepairItem(new ItemStack(ModItems.NickelIngot));
		TUNGSTEN.setRepairItem(new ItemStack(ModItems.TungstenIngot));
		SILICON.setRepairItem(new ItemStack(ModItems.SiliconIngot));
		
		RUBY.setRepairItem(new ItemStack(ModItems.RubyGem));
		SAPPHIRE.setRepairItem(new ItemStack(ModItems.SapphireGem));
		MOONSTONE.setRepairItem(new ItemStack(ModItems.MoonstoneGem));
		BLACKONYX.setRepairItem(new ItemStack(ModItems.BlackonyxGem));
		REDONYX.setRepairItem(new ItemStack(ModItems.RedonyxGem));
		AMETHYST.setRepairItem(new ItemStack(ModItems.AmethystGem));
		
		BRONZE.setRepairItem(new ItemStack(ModItems.BronzeIngot));
		BRASS.setRepairItem(new ItemStack(ModItems.BrassIngot));
		ZAMAK.setRepairItem(new ItemStack(ModItems.ZamakIngot));
		STERLING.setRepairItem(new ItemStack(ModItems.SterlingSilverIngot));
		CUPRO.setRepairItem(new ItemStack(ModItems.CupronickelIngot));
		INVAR.setRepairItem(new ItemStack(ModItems.InvarIngot));
		STEEL.setRepairItem(new ItemStack(ModItems.SteelIngot));
		FERSILICON.setRepairItem(new ItemStack(ModItems.FerrosiliconIngot));
		ELECTRUM.setRepairItem(new ItemStack(ModItems.ElectrumIngot));
		HSS.setRepairItem(new ItemStack(ModItems.HssIngot));
		BABBITT.setRepairItem(new ItemStack(ModItems.BabbittIngot));
		GRADE.setRepairItem(new ItemStack(ModItems.Grade5Ingot));
		CARBON.setRepairItem(new ItemStack(ModItems.CarbonIngot));
	}
}
