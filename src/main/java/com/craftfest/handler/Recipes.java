package com.craftfest.handler;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void addRecipes() {

		// Ire
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.CloverGrass),
				new Object[] { Blocks.grass, ModItems.FourLeafClover });
		
		//Christmas
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.FrostedGlass),
				new Object[] { Blocks.snow, Blocks.glass });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.FrostedGlassPane),
				new Object[] { Items.snowball, Blocks.glass_pane });
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.FrostedGlassPane, 16), new Object[] {
			"AAA",
			"AAA", 
			'A', ModBlocks.FrostedGlass
		});
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.ChristmasTreePlanks, 4),
				new Object[] { ModBlocks.ChristmasTreeLog });
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.ChristmasChest), new Object[] {
			"AAA",
			"A A",
			"AAA",
			'A', ModBlocks.ChristmasTreePlanks
		});
		//Christmas: Armor
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.FurHelm), new Object[] {
			"AAA",
			"A A", 
			'A', ModItems.ReindeerFur
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.FurChest), new Object[] {
			"A A",
			"AAA",
			"AAA",
			'A', ModItems.ReindeerFur
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Furlegs), new Object[] {
			"AAA",
			"A A",
			"A A",
			'A', ModItems.ReindeerFur
		});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.FurBoots), new Object[] {
			"A A",
			"A A",
			'A', ModItems.ReindeerFur
		});


		

	}

}
