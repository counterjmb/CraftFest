package com.craftfest;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.init.ModItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRender() {

		ModBlocks.registerRender();
		ModItems.regesterRender();

	}

}
