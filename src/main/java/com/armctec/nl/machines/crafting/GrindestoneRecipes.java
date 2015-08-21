package com.armctec.nl.machines.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.armctec.nl.machines.reference.ModConfig;
import com.google.common.collect.Maps;

public class GrindestoneRecipes
{
    private static final GrindestoneRecipes grinderBase = new GrindestoneRecipes();
    /** The list of grinder results. */
    private HashMap<ItemStack, RecipesAnexo> grinderList = Maps.newHashMap();
    
    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static GrindestoneRecipes instance()
    {
        return grinderBase;
    }

    private GrindestoneRecipes()
    {
    	// Init Static items
    	// Diversos
    	this.addGrinderRecipe(Blocks.sandstone, new ItemStack(Blocks.sand, 4), 0.0F);
    	this.addGrinderRecipe(Blocks.cobblestone, new ItemStack(Blocks.gravel, 1),  0.0F);
    	this.addGrinderRecipe(Blocks.gravel, new RecipesAnexo(new ItemStack(Blocks.sand, 1), 1.0F, new ItemStack(Items.flint), 0.25F, 0.0F));
    }
    
    // Init Dynamic Items (mod items)
    public void initDynamic()
    {
    	// Dust for Ingots,  Gems
    	this.addGrinderRecipe("ingotAluminium", new RecipesAnexo("dustAluminium", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemAmethyst", new RecipesAnexo("dustAmethyst", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotBabbitt", new RecipesAnexo("dustBabbitt", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemBlackonyx", new RecipesAnexo("dustBlackonyx", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotBrass", new RecipesAnexo("dustBrass", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotBronze", new RecipesAnexo("dustBronze", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotCarbon", new RecipesAnexo("dustCarbon", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotCopper", new RecipesAnexo("dustCopper", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotCupro", new RecipesAnexo("dustCupro", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotElectrum", new RecipesAnexo("dustElectrum", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotFersilicon", new RecipesAnexo("dustFersilicon", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotGrade", new RecipesAnexo("dustGrade", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotHss", new RecipesAnexo("dustHss", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotInvar", new RecipesAnexo("dustInvar", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotLead", new RecipesAnexo("dustLead", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemMoonstone", new RecipesAnexo("dustMoonstone", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotNickel", new RecipesAnexo("dustNickel", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemRedonyx", new RecipesAnexo("dustRedonyx", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemRuby", new RecipesAnexo("dustRuby", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemSapphire", new RecipesAnexo("dustSapphire", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotSilicon", new RecipesAnexo("dustSilicon", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotSilver", new RecipesAnexo("dustSilver", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotSteel", new RecipesAnexo("dustSteel", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotSterling", new RecipesAnexo("dustSterling", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotTin", new RecipesAnexo("dustTin", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotTitanium", new RecipesAnexo("dustTitanium", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotTungsten", new RecipesAnexo("dustTungsten", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotZamak", new RecipesAnexo("dustZamak", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotZinc", new RecipesAnexo("dustZinc", 1, 1.0f, 0.0f));
    	
    	// Dust for Vanilla
    	this.addGrinderRecipe("ingotIron", new RecipesAnexo("dustIron", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("ingotGold", new RecipesAnexo("dustGold", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe(Items.ender_pearl, new RecipesAnexo("dustEnder", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemDiamond", new RecipesAnexo("dustDiamond", 1, 1.0f, 0.0f));
    	this.addGrinderRecipe("gemEmerald", new RecipesAnexo("dustEmerald", 1, 1.0f, 0.0f));
    	
    	
    }

    public void addGrinderRecipe(String name, ItemStack stack, float experience)
    {
    	List<ItemStack> items = OreDictionary.getOres(name);
    	
    	if(items==null)
    	{
    		ModConfig.Log.info("Erro ao tentar achar: "+name);
    		return;
    	}
    	
    	ModConfig.Log.info("addGrinderRecipe: items.size = "+items.size());
    	
    	for(int i=0; i<items.size(); i++)
    	{
    		ItemStack item = items.get(i);
    		this.addGrinderRecipe(item.getItem(), stack, experience);
    		ModConfig.Log.info("Adicionado: "+item.getUnlocalizedName());
    	}
    }
    

    public void addGrinderRecipe(String name, RecipesAnexo listitems)
    {
    	List<ItemStack> items = OreDictionary.getOres(name);
    	
    	if(items==null)
    	{
    		ModConfig.Log.info("Erro ao tentar achar: "+name);
    		return;
    	}
    	
    	ModConfig.Log.info("addGrinderRecipe: items.size = "+items.size());
    	
    	for(int i=0; i<items.size(); i++)
    	{
    		ItemStack item = items.get(i);
    		this.addGrinderRecipe(item.getItem(), listitems);
    	}
    }    
    
    /**
     * Adds a grinder recipe, where the input item is an instance of Block.
     *  
     * @param input The block to be used as the input for the grinder recipe.
     * @param stack The output for this recipe in the form of an ItemStack.
     * @param experience The amount of experience this recipe will give the player.
     */
    public void addGrinderRecipe(Block input, ItemStack stack, float experience)
    {
        this.addGrinderRecipe(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a grinder recipe using an Item as the input item.
     *  
     * @param input The input Item to be used for this recipe.
     * @param stack The output ItemStack for this recipe.
     * @param experience The amount of experience this recipe will give the player.
     */
    public void addGrinderRecipe(Item input, ItemStack stack, float experience)
    {
        this.addGrinderRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    
    /**
     * Adds a grinder recipe, where the input item is an instance of Block.
     *  
     * @param input The block to be used as the input for the grinder recipe.
     * @param items The output ItemStack and experience for this recipe.
     */
    public void addGrinderRecipe(Block input, RecipesAnexo items)
    {
        this.addGrinderRecipe(Item.getItemFromBlock(input), items);
    }

    /**
     * Adds a grinder recipe using an Item as the input item.
     *  
     * @param input The input Item to be used for this recipe.
     * @param items The output ItemStack and experience for this recipe.
     */
    public void addGrinderRecipe(Item input, RecipesAnexo items)
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
        Iterator<Entry<ItemStack, RecipesAnexo>> iterator = this.grinderList.entrySet().iterator();
        Entry<ItemStack, RecipesAnexo> entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry<ItemStack, RecipesAnexo>)iterator.next();
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

    public Map<ItemStack, RecipesAnexo> getGrinderList()
    {
        return this.grinderList;
    }
    
}