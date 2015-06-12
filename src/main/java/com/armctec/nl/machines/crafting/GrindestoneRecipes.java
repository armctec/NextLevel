package com.armctec.nl.machines.crafting;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class GrindestoneRecipes
{
    private static final GrindestoneRecipes grinderBase = new GrindestoneRecipes();
    /** The list of grinder results. */
    private Map grinderList = Maps.newHashMap();
    
    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static GrindestoneRecipes instance()
    {
        return grinderBase;
    }

    private GrindestoneRecipes()
    {
    	this.addGrinderRecipeForBlock(Blocks.sandstone, new ItemStack(Blocks.sand, 4), 0.0F);
    	this.addGrinderRecipeForBlock(Blocks.cobblestone, new ItemStack(Blocks.gravel, 1),  0.0F);
    	this.addGrinderRecipeForBlock(Blocks.gravel, new RecipesAnexo(new ItemStack(Blocks.sand, 1), 1.0F, new ItemStack(Items.flint), 0.25F, 0.0F));
    	
        /*
    	this.addSmeltingRecipeForBlock(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
        this.addSmelting(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
        this.addSmelting(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
        this.addSmelting(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
        this.addSmelting(Items.rabbit, new ItemStack(Items.cooked_rabbit), 0.35F);
        this.addSmelting(Items.mutton, new ItemStack(Items.cooked_mutton), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.stonebrick, 1, BlockStoneBrick.CRACKED_META), 0.1F);
        this.addSmelting(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
        this.addSmeltingRecipeForBlock(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.cactus, new ItemStack(Items.dye, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
        this.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.sponge, 1, 1), new ItemStack(Blocks.sponge, 1, 0), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
        this.addSmeltingRecipeForBlock(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.lapis_ore, new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
        */
    }

    /**
     * Adds a grinder recipe, where the input item is an instance of Block.
     *  
     * @param input The block to be used as the input for the grinder recipe.
     * @param stack The output for this recipe in the form of an ItemStack.
     * @param experience The amount of experience this recipe will give the player.
     */
    public void addGrinderRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addGrinder(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a grinder recipe using an Item as the input item.
     *  
     * @param input The input Item to be used for this recipe.
     * @param stack The output ItemStack for this recipe.
     * @param experience The amount of experience this recipe will give the player.
     */
    public void addGrinder(Item input, ItemStack stack, float experience)
    {
        this.addGrinderRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    
    /**
     * Adds a grinder recipe, where the input item is an instance of Block.
     *  
     * @param input The block to be used as the input for the grinder recipe.
     * @param items The output ItemStack and experience for this recipe.
     */
    public void addGrinderRecipeForBlock(Block input, RecipesAnexo items)
    {
        this.addGrinder(Item.getItemFromBlock(input), items);
    }

    /**
     * Adds a grinder recipe using an Item as the input item.
     *  
     * @param input The input Item to be used for this recipe.
     * @param items The output ItemStack and experience for this recipe.
     */
    public void addGrinder(Item input, RecipesAnexo items)
    {
        this.addGrinderRecipe(new ItemStack(input, 1, 32767), items);
    }
    
    /**
     * Adds a grinder recipe using an ItemStack as the input for the recipe.
     *  
     * @param input The input ItemStack for this recipe.
     * @param stack The output ItemStack for this recipe.
     * @param experience The amount of experience this recipe will give the player.
     */
    public void addGrinderRecipe(ItemStack input, ItemStack stack, float experience)
    {
        this.grinderList.put(input, new RecipesAnexo(stack, experience));
    }

    
    /**
     * Adds a grinder recipe using an ItemStack as the input for the recipe.
     *  
     * @param input The input ItemStack for this recipe.
     * @param items The output ItemStack and experience for this recipe.
     */
    public void addGrinderRecipe(ItemStack input, RecipesAnexo items)
    {
        this.grinderList.put(input, items);
    }
    
    /**
     * Returns the grinder result of an item.
     */
    public RecipesAnexo getGrinderResult(ItemStack stack)
    {
        Iterator iterator = this.grinderList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(stack, (ItemStack)entry.getKey()));

        return (RecipesAnexo)entry.getValue();
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map getGrinderList()
    {
        return this.grinderList;
    }
    
}