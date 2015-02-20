package com.craftfest.items.ire;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class GoldenFourLeafClover extends Item {
	
	public GoldenFourLeafClover(){
		super();
		setUnlocalizedName("goldenfourleafclover");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}
	

}
