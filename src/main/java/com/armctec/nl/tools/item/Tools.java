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
	
	public static ToolMaterial COPPER = EnumHelper.addToolMaterial("Copper", 2, 160, 8.0F, 1.0F, 10);
	
	public static void init()
	{
		COPPER.setRepairItem(new ItemStack(ModItems.CopperIngot));
	}
}
