package com.craftfest.items.easter;

import net.minecraft.item.ItemFood;

import com.craftfest.CraftFestMod;

public class EasterEgg extends ItemFood {
	
	public EasterEgg(int hunger, float saturation, boolean wolf) {
		super(hunger, saturation, wolf);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("easteregg");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));

	}

}
