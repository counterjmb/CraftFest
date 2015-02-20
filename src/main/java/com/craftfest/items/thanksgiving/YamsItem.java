package com.craftfest.items.thanksgiving;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

import com.craftfest.CraftFestMod;

public class YamsItem extends ItemSeedFood{
	
	
	public YamsItem(int hunger, float saturation, Block grows, Block planton){
		super(hunger, saturation, grows, planton);
		
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("yams");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		
		
	}

}
