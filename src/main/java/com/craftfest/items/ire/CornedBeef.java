package com.craftfest.items.ire;

import com.craftfest.CraftFestMod;

import net.minecraft.item.ItemFood;

public class CornedBeef extends ItemFood{
	
	public CornedBeef(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("cornedbeef");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
