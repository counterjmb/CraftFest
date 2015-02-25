package com.craftfest;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
/*
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);

	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
*/
	@Override
	public void registerRender() {

		//ModBlocks.registerRender();
		ModItems.regesterRender();

	}

}
