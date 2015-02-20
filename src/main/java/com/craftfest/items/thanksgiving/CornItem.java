package com.craftfest.items.thanksgiving;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

import com.craftfest.CraftFestMod;

public class CornItem extends ItemSeedFood {
	
	public CornItem(int hunger, float saturation, Block grows, Block planton){
		super(hunger, saturation, grows, planton);
		
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("corn");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		
		
	}

}
