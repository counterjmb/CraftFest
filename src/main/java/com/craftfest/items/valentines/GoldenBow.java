package com.craftfest.items.valentines;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class GoldenBow extends Item{
	public GoldenBow(){
		super();
		setUnlocalizedName("goldenbow");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}

}
