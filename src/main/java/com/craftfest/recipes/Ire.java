package com.craftfest.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ire.IreItems;

public class Ire {

	public static void addRecipes() {

		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.CloverGrass),
				new Object[] { Blocks.grass, IreItems.FourLeafClover });

	}
}
