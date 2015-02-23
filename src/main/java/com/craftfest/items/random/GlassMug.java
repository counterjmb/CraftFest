package com.craftfest.items.random;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class GlassMug extends Item {

	private final String name = "glassbottle";

	public GlassMug() {

		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "glassbottle");
		setCreativeTab(CraftFestMod.tabSpring);
	}

	public String getName() {
		return name;
	}
}
