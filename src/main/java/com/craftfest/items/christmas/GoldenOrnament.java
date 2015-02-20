package com.craftfest.items.christmas;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class GoldenOrnament extends Item{
	public GoldenOrnament(){
		super();
		setUnlocalizedName("goldenornament");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}

}
