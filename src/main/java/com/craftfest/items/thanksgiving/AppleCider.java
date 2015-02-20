package com.craftfest.items.thanksgiving;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class AppleCider extends ItemFood {
	
	public AppleCider(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("applecider");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
