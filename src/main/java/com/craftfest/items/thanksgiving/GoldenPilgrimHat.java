package com.craftfest.items.thanksgiving;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class GoldenPilgrimHat extends Item{
	public GoldenPilgrimHat(){
		super();
		setUnlocalizedName("goldenpilgrimhat");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}

}
