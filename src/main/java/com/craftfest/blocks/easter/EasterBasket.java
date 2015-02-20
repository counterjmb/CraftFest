package com.craftfest.blocks.easter;

import com.craftfest.CraftFestMod;

import net.minecraft.block.BlockChest;

public class EasterBasket extends BlockChest {
	
	public EasterBasket(int chest){
		super(chest);
		setCreativeTab(CraftFestMod.tabSpring);
		
	}

}
