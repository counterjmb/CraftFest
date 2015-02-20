package com.craftfest.items.random;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class Bacon extends ItemFood{
	
	public Bacon(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("bacon");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
