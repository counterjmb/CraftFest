package com.craftfest.items.ire;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class CornedBeef extends ItemFood {

	public CornedBeef(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("cornedbeef");

	}

}
