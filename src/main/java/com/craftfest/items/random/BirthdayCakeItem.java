package com.craftfest.items.random;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class BirthdayCakeItem extends Item {

	private final String name = "birthdaycake";

	public BirthdayCakeItem() {
		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "birthdaycake");
		setCreativeTab(CraftFestMod.tabSpring);
	}

	public String getName() {
		return name;
	}

}
