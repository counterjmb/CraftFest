package com.craftfest.items.easter;

import com.craftfest.CraftFestMod;

import net.minecraft.item.ItemFood;

public class CottonCandy extends ItemFood {
	
	public CottonCandy(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("cottoncandy");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}


}
