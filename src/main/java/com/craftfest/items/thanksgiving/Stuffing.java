package com.craftfest.items.thanksgiving;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class Stuffing extends ItemFood{
	
	public Stuffing(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("stuffing");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
