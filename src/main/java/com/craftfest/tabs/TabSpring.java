package com.craftfest.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class TabSpring extends CreativeTabs {
	
	public TabSpring(String label){
		super(label);
		this.setBackgroundImageName("fuck.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.diamond_block);
	}

}
