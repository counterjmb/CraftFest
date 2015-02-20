package com.craftfest.items.easter;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class GoldenEasterEgg extends Item{
	
	public GoldenEasterEgg(){
		super();
		setUnlocalizedName("goldeneasteregg");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}

}
