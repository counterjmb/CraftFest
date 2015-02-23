package com.craftfest.items.random;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class Bacon extends ItemFood {

	private final String name = "bacon";

	public Bacon(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName(CraftFestMod.MODID + "_" + "bacon");

	}

	public String getName() {
		return name;
	}

}
