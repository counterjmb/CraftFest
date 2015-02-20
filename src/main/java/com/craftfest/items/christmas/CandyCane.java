package com.craftfest.items.christmas;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class CandyCane extends ItemFood {
	
	public CandyCane(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabWinter);
		setUnlocalizedName("candycane");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
