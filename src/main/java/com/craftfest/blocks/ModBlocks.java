package com.craftfest.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;

import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.blocks.random.BirthdayCakeBlock;
import com.craftfest.util.RegisterHelper;

public class ModBlocks {

	// Ire
	public static Block CloverGrass = new CloverGrass();
	
	//Random
	public static BlockCake BirthdayCakeBlock = new BirthdayCakeBlock();

	public static void Init() {

		// Ire
		RegisterHelper.registerBlock(CloverGrass);
		
		//Random
		//RegisterHelper.registerBlock(BirthdayCakeBlock);

	}

}
