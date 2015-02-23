package com.craftfest.util;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;



public class Recipes {

	public static void addRecipes() {

		// Ire
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.CloverGrass),
				new Object[] { Blocks.grass, ModItems.FourLeafClover });
		
			}

}
