package com.craftfest.items.easter;

import com.craftfest.CraftFestMod;

import net.minecraft.item.ItemFood;

public class Peeps extends ItemFood {
	
	public Peeps(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("peeps");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}


}
