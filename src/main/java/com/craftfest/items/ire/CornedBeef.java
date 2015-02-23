package com.craftfest.items.ire;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class CornedBeef extends ItemFood {

	private final String name = "cornedbeef";

	public CornedBeef(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName(CraftFestMod.MODID + "_" + "cornedbeef");

	}

	public String getName() {
		return name;
	}

}
