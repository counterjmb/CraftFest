package com.craftfest.items.random;

import com.craftfest.CraftFestMod;

import net.minecraft.item.Item;

public class GlassMug extends Item{
	
	public GlassMug(){
	
		super();
		setUnlocalizedName("glassbottle");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
	}

}
