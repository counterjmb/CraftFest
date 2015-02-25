package com.craftfest.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabFall extends CreativeTabs {

	public TabFall(String label) {
		super(label);
		this.setBackgroundImageName("fuck.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Blocks.wooden_slab);
	}

}
