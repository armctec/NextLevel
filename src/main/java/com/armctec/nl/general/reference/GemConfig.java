package com.armctec.nl.general.reference;

import net.minecraft.item.Item;

public class GemConfig
{
	public int ExpBase = 0;
	public int ExpRandom = 0;
	public int ExpFortune = 0;
	
	public int DropBase = 1;
	public int DropRandom = 0;
	public int DropFortune = 0;
	
	public Item DropItem = null;
	
	public GemConfig(Item DropItem, int DropBase, int DropRandom, int DropFortune, int ExpBase, int ExpRandom, int ExpFortune)
	{
		this.DropBase = DropBase;
		this.DropRandom = DropRandom;
		this.DropFortune = DropFortune;
		this.ExpBase = ExpBase;
		this.ExpRandom = ExpRandom;
		this.ExpFortune = ExpFortune;
		this.DropItem = DropItem;
	}
}
