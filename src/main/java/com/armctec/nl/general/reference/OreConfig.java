package com.armctec.nl.general.reference;

public class OreConfig
{
	public int NumberOfBlocks = 1;
	public int Ymin = 0;
	public int Ymax = 255;
	public int Veins = 1;
	
	public OreConfig(int Veins, int NumberOfBlocks, int Ymin, int Ymax)
	{
		this.NumberOfBlocks = NumberOfBlocks;
		this.Ymin = Ymin;
		this.Ymax = Ymax;
		this.Veins = Veins;
	}
}