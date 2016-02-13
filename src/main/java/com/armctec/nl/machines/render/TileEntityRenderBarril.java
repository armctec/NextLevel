package com.armctec.nl.machines.render;

import java.util.Map;

import com.armctec.nl.machines.reference.ModConfig;
import com.armctec.nl.machines.tileentity.TileEntityBarril;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TileEntityRenderBarril extends TileEntitySpecialRenderer<TileEntityBarril> 
{
    /** The texture for the liquid inside of barril */
    private static Map<String, Fluid> fluidos = null;
    private static float fatory = 1.0f / 16.0f;
    private static float tamanhoy = fatory * 10;
    private static float miny = fatory*2;
    private static float maxy = (1.0f - miny);
    
    public static void initTextures()
    {
    	/** Obtem fluidos registrados */
    	fluidos = FluidRegistry.getRegisteredFluids();
    	
    	/** Mostra todos registrados */
    	for (Map.Entry<String, Fluid> entry : fluidos.entrySet()) 
    	{
    		ModConfig.Log.info("Key : " + entry.getKey() + " Value : " + entry.getValue().getStill().toString());
    	}
    }
    
	@Override
	public void renderTileEntityAt(TileEntityBarril te, double x, double y, double z, float partialTicks, int destroyStage) 
	{
		if(te==null)
			return;
		
		if(te.getAmount() == 0)
			return;
		
		FluidStack fstack = te.getFluid();
		if(fstack == null)
			return;
		
		String fname = te.getFluidName();
		if(fname == null)
			return;
	
		Fluid liquid =  fstack.getFluid();
        if(liquid == null)		
        	return;
		
        /* Inicializa todos que seram chamados depois */
        Tessellator tessellator = Tessellator.getInstance();
        if(tessellator == null)
        	return;
        
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        if(worldrenderer == null)
        	return; 
        			
        TextureMap texturemap = Minecraft.getMinecraft().getTextureMapBlocks();
        if(texturemap == null)
        	return;
        
        /* Guarda informacoes */
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		
		/* Configura render */
		GlStateManager.disableFog();
		GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.enableDepth();
        GlStateManager.disableCull();
        GlStateManager.resetColor();
        
        /** Seleciona textura */
        bindTexture(TextureMap.locationBlocksTexture);
        	
        Block blockliquid = liquid.getBlock();
        ResourceLocation liquidTexture = liquid.getStill();
        
        /** Obtem textura liquido */
        TextureAtlasSprite atlasSprites = texturemap.getAtlasSprite(liquidTexture.toString());
        if(atlasSprites==null)
        	return;
        
        /** Atualiza animacao */
        atlasSprites.updateAnimation();
        			
        /* Obtem coordenadas textura */
        float ui = atlasSprites.getMinU();
        float uf = atlasSprites.getMaxU();
        float vi = atlasSprites.getMinV();
        float vf = atlasSprites.getMaxV();
        
        float yoffset = ((float)(te.getAmount()) / (float)(te.getCapacity()));
        yoffset = yoffset*tamanhoy + fatory + fatory; 
        
        /** Desloca render para o bloco atual */
        GlStateManager.translate(x,y,z);

        /** Inicia render */
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        
        /* Vextex */
        worldrenderer.pos(miny, yoffset, miny).tex(ui, vi).endVertex();
        worldrenderer.pos(miny, yoffset, maxy).tex(ui, vf).endVertex();
        worldrenderer.pos(maxy, yoffset, maxy).tex(uf, vf).endVertex();
        worldrenderer.pos(maxy, yoffset, miny).tex(uf, vi).endVertex();
        
        /** Desenha */
        tessellator.draw();

        /* Volta configuracoes antigas */
        GlStateManager.popAttrib();
		GlStateManager.popMatrix();
    } 

}
