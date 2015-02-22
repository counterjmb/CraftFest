package com.craftfest.blocks;

import net.minecraft.block.Block;

import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.handler.RegisterHelper;

public class ModBlocks {

	

	
	//Ire
	public static Block CloverGrass = new CloverGrass();
	
	public static void Init(){
		
		
		//Ire
		RegisterHelper.registerBlock(CloverGrass);
		
		
	}

}
