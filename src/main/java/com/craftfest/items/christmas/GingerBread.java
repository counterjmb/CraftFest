package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;

import net.minecraft.item.ItemFood;

public class GingerBread extends ItemFood {
	
	public GingerBread(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabWinter);
		setUnlocalizedName("gingerbread");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
