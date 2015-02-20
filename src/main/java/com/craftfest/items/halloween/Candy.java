package com.craftfest.items.halloween;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class Candy extends ItemFood {
	public Candy(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("candy");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
