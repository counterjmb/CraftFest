package com.craftfest.blocks.ire;

import net.minecraft.block.BlockGrass;

import com.craftfest.CraftFestMod;

public class CloverGrass extends BlockGrass {
	//TODO: CloverGrass: create customer grass renderer
	//TODO: CloverGrass: cannot place plants on yet. 
	//TODO: CloverGrass: test silk touch
	
	private final String name = "clovergrass";
	
		public CloverGrass(){
	
			setUnlocalizedName(CraftFestMod.MODID + "_" + "clovergrass");
			setCreativeTab(CraftFestMod.tabSpring);
			setStepSound(soundTypeGrass);
			setHardness(0.5F);
			setResistance(0.5F);
		}
		
		public String getName(){
			return name;
		}
		

}
