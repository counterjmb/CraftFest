package com.craftfest.items.thanksgiving;

import com.craftfest.CraftFestMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeedFood;

public class CranberryItem extends ItemSeedFood {
	
	public CranberryItem(int hunger, float saturation, Block grows, Block planton){
		super(hunger, saturation, grows, planton);
		
		setCreativeTab(CraftFestMod.tabFall);
		setUnlocalizedName("cranberry");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		
		
	}

}
