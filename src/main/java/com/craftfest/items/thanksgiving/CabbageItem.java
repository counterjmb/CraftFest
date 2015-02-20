package com.craftfest.items.thanksgiving;

import com.craftfest.CraftFestMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

public class CabbageItem extends ItemSeedFood {
	
	public CabbageItem(int hunger, float saturation, Block grows, Block planton){
		super(hunger, saturation, grows, planton);
		
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("cabbage");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		
		
	}

}
