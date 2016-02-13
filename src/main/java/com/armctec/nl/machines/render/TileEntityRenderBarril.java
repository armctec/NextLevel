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
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TileEntityRenderBarril extends TileEntitySpecialRenderer<TileEntityBarril> 
{
    /** The texture for the liquid inside of barril */
    private static ResourceLocation FLUIDS_TEXTURES[] = null;
    private BlockRendererDispatcher blockRenderer;
    private static Map<String, Fluid> fluidos = null;
    		
    public static void initTextures()
    {
    	fluidos = FluidRegistry.getRegisteredFluids();
    	
    	for (Map.Entry<String, Fluid> entry : fluidos.entrySet()) 
    	{
    		ModConfig.Log.info("Key : " + entry.getKey() + " Value : " + entry.getValue().getStill().toString());
    	}
    	
    	FLUIDS_TEXTURES = new ResourceLocation[2];
    	FLUIDS_TEXTURES[0] = new ResourceLocation("textures/blocks/water_still.png");
    	FLUIDS_TEXTURES[1] = new ResourceLocation("textures/blocks/lava_still.png");
    	/*
        TextureManager texturemanager = Minecraft.getMinecraft().renderEngine;  
        
        TEXTURE_IDs = new ITextureObject[2];
        TEXTURE_IDs[0] = texturemanager.getTexture(FLUIDS_TEXTURES[0]);
        TEXTURE_IDs[1] = texturemanager.getTexture(FLUIDS_TEXTURES[1]);
        */
    }
    
	@Override
	public void renderTileEntityAt(TileEntityBarril te, double x, double y, double z, float partialTicks, int destroyStage) 
	{
		// TODO Auto-generated method stub
		if(blockRenderer == null) 
			blockRenderer = Minecraft.getMinecraft().getBlockRendererDispatcher();
		//ModConfig.Log.info("Chamado");
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		
		GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        
        Fluid liquid =  fluidos.get("water");
        if(liquid != null)
        {
        	//ModConfig.Log.info("Chamado");
        	float ui = 0.0f;
        	float uf = 1.0f;
        	float vi = 0.0f;
        	float vf = 0.05f;
        	
        	Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        	
        	Block blockliquid = liquid.getBlock();
        	ResourceLocation liquidTexture = liquid.getStill();
        	
        	TextureMap texturemap = Minecraft.getMinecraft().getTextureMapBlocks();
        	if(texturemap!=null)
        	{
        		TextureAtlasSprite[] atlasSprites = new TextureAtlasSprite[2];
        		atlasSprites[0] = texturemap.getAtlasSprite("minecraft:blocks/lava_still");
        		atlasSprites[1] = texturemap.getAtlasSprite("minecraft:blocks/water_still");
            
        		if(atlasSprites[1]!=null)
        		{
        			//ModConfig.Log.info("lava:"+atlasSprites[0].hasAnimationMetadata());
        			//ModConfig.Log.info("Frames:"+atlasSprites[0].getFrameCount());
        			
        			atlasSprites[1].updateAnimation();
        			
        			ui = atlasSprites[1].getMinU();
        			uf = atlasSprites[1].getMaxU();
        			vi = atlasSprites[1].getMinV();
        			vf = atlasSprites[1].getMaxV();
        			
        		}
        		//if(atlasSprites[1]!=null)
        		//	ModConfig.Log.info("water:"+atlasSprites[1].hasAnimationMetadata());
        	}
        	//ModConfig.Log.info(liquidTexture.getResourceDomain());
        	if(liquidTexture.getResourceDomain()=="minecraft")
        	{
        		liquidTexture = new ResourceLocation("textures/"+liquid.getStill().getResourcePath()+".png");
        		//ModConfig.Log.info(liquidTexture);
        	}
        	
        	
        	
        	/*
        	if(liquidTexture!=null)
        		ModConfig.Log.info(liquidTexture);
        	*/
        	
        	//bindTexture(FLUIDS_TEXTURES[0]);
        	//bindTexture(liquidTexture);
        	
        	/*
            ITextureObject itextureobject = rendererDispatcher.renderEngine.getTexture(liquidTexture);

            if (itextureobject != null)
            {
            	//ModConfig.Log.info("OK");
            	GlStateManager.bindTexture(itextureobject.getGlTextureId());
            }
            else
            {
            	bindTexture(FLUIDS_TEXTURES[0]);
            }
        	*/
        	
        	GlStateManager.translate(x,y,z);
        	//modelbase.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0f, 0.0F, 0.9f);
            worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldrenderer.pos(0.1f, 0.2f, 0.1f).tex( ui,  vi).endVertex();
            worldrenderer.pos(0.1f, 0.2f, 0.9f).tex( ui,  vf).endVertex();
            worldrenderer.pos(0.9f, 0.2f, 0.9f).tex( uf,  vf).endVertex();
            worldrenderer.pos(0.9f, 0.2f, 0.1f).tex( uf,  vi).endVertex();
            
            tessellator.draw();
        }
        /*
		this.bindTexture(FLUIDS_TEXTURES[1]);
		GlStateManager.translate(x,y,z);
		worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldrenderer.pos(0.0f, 1.2f, 0.0f).tex( 0.0f,  0.0f).endVertex();
        worldrenderer.pos(0.0f, 1.2f, 1.0f).tex( 0.0f,  0.1f).endVertex();
        worldrenderer.pos(1.0f, 1.2f, 1.0f).tex( 1.0f,  0.1f).endVertex();
        worldrenderer.pos(1.0f, 1.2f, 0.0f).tex( 1.0f,  0.0f).endVertex();
        tessellator.draw();
        */
        
        GlStateManager.popAttrib();
		GlStateManager.popMatrix();
    } 

}
