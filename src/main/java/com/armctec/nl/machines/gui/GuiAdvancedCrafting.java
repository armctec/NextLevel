package com.armctec.nl.machines.gui;

import com.armctec.nl.general.tileentity.TileEntityBasicInventory;
import com.armctec.nl.machines.inventory.ContainerAdvancedCrafting;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.tileentity.TileEntityAdvancedCrafting;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiAdvancedCrafting extends GuiContainer
{
	private static final ResourceLocation craftingTableGuiTextures = new ResourceLocation(ModConfig.MOD_ID, "textures/gui/container/advanced_crafting_table.png");
	TileEntityAdvancedCrafting tileEntity	= null;

    public GuiAdvancedCrafting(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition, TileEntityAdvancedCrafting tileEntity) 
    {
		super(new ContainerAdvancedCrafting(playerInv, worldIn, blockPosition, tileEntity));
		this.tileEntity = tileEntity;
    }
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        // Trocar texto en_Us.lang --> I18n.format("container.crafting"
    	this.fontRendererObj.drawString("Advanced Crafting", 28, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(craftingTableGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
