package com.craftfest.items.random;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class BirthdayCakeItem extends Item {
	
	public BirthdayCakeItem(){
		super();
		setUnlocalizedName("birthdaycake");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
	}
	

}
