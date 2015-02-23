package com.craftfest.items.ire;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class GoldenFourLeafClover extends Item {

	private final String name = "goldenfourleafclover";

	public GoldenFourLeafClover() {
		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "goldenfourleafclover");
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(1);
	}

	public String getName() {
		return name;
	}

}
