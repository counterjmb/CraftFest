package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;

import net.minecraft.item.ItemFood;

public class HotCocoa extends ItemFood {

	public HotCocoa(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabWinter);
		setUnlocalizedName("hotcocoa");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
