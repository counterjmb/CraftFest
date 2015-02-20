package com.craftfest.blocks.halloween;

import net.minecraft.block.BlockGrass;
import net.minecraft.creativetab.CreativeTabs;

import com.craftfest.CraftFestMod;

public class CursedGrass extends BlockGrass{
	//TODO: CursedGrass: create customer grass renderer
	//TODO: CursedGrass: cannot place plants on yet. 
	public CursedGrass(){
	
		setBlockName("cursedgrass");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		setStepSound(soundTypeGrass);
		setHardness(0.5F);
		setResistance(0.5F);
	}

}
