package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ReindeerFur extends Item {
	
	public ReindeerFur(){
		super();
		setUnlocalizedName("reindeerfur");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
	}

}
