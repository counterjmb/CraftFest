package com.craftfest.blocks.halloween;

import com.craftfest.CraftFestMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BloodyCobblestone extends Block{
	
	public BloodyCobblestone(){
		super(Material.rock);
		setBlockName("bloodycobblestone");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		setStepSound(soundTypePiston);
		setHardness(2.0F);
		setResistance(10.0F);
		setLightLevel(9);
		
	}

}
