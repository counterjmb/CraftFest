package com.craftfest.items.ire;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeedFood;

public class Cabbage extends ItemSeedFood {
	
	
	public Cabbage(int heals, float sat, Block Cabbage, Block farm) {
		super(heals, sat, Cabbage, farm);
		this.setUnlocalizedName("cabbage");
		this.setCreativeTab(CraftFestMod.tabSpring);
		
	}

}
