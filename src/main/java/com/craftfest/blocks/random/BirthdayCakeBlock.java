package com.craftfest.blocks.random;

import net.minecraft.block.BlockCake;

import com.craftfest.CraftFestMod;

public class BirthdayCakeBlock extends BlockCake {

	private final String name = "birthdaycake";

	public BirthdayCakeBlock() {

		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "birthdaycake");
		setCreativeTab(CraftFestMod.tabSpring);

	}

	public String getName() {
		return name;
	}


}
