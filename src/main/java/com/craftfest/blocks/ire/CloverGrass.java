package com.craftfest.blocks.ire;

import net.minecraft.block.BlockGrass;
import net.minecraft.creativetab.CreativeTabs;

import com.craftfest.CraftFestMod;

public class CloverGrass extends BlockGrass {
	//TODO: CloverGrass: create customer grass renderer
	//TODO: CloverGrass: cannot place plants on yet. 
	
	
		public CloverGrass(){
			
	
			setBlockName("clovergrass");
			setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
			setCreativeTab(CraftFestMod.tabSpring);
			setStepSound(soundTypeGrass);
			setHardness(0.5F);
			setResistance(0.5F);
		}
		

}
