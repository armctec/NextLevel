package com.armctec.nl.general.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialAdvanced extends Material 
{
	public final static MaterialAdvanced Advanced = new MaterialAdvanced();
	
	public MaterialAdvanced() 
	{
		super(MapColor.AIR);
		setRequiresTool();
	}

    @Override
	public boolean isOpaque()
    {
        return true;
    }
}
