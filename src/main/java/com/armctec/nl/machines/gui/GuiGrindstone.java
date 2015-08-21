package com.armctec.nl.machines.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.armctec.nl.machines.inventory.container.ContainerGrindstone;
import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.tileentity.TileEntityGrindstone;

public class GuiGrindstone extends GuiContainer
{
	private static final ResourceLocation grinstoneTextures = new ResourceLocation(ModConfig.MOD_ID, "textures/gui/container/grindstone.png");
	TileEntityGrindstone tileEntity = null;

	private String getTextI18n(String item)
	{
		return I18n.format("container."+ModConfig.MOD_ID.toLowerCase()+":"+item, new Object[0]);
	}
	
    public GuiGrindstone(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition, TileEntityGrindstone tileEntity) 
    {
		super(new ContainerGrindstone(playerInv, worldIn, blockPosition, tileEntity));
		this.tileEntity = tileEntity;
    }
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items). Args : mouseX, mouseY
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
    	this.fontRendererObj.drawString(getTextI18n("grindstone.crafting"), 28, 12, 4210752);
        this.fontRendererObj.drawString(getTextI18n("grindstone.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Args : renderPartialTicks, mouseX, mouseY
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(grinstoneTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        int pos = tileEntity.getPosicao();
        
        pos = (30*pos)/4;
        		
        //System.out.println(pos);
        this.drawTexturedModalRect(k + 54, l + 26, 176, 0, pos, 16);
    }
}
