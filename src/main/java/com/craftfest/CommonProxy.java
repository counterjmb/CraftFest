package com.craftfest;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;
import com.craftfest.recipes.Recipes;
import com.craftfest.world.Dimensions;
import com.craftfest.world.biomes.ModBiomes;

public class CommonProxy {

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// FMLCommonHandler.instance().bus().register(handler);

		// Config.init(e.getSuggestedConfigurationFile());

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
/*
		ModBlocks.Init();
		ModItems.Init();
		Recipes.addRecipes();
		Dimensions.init();
		ModBiomes.init();
*/
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}

	public void registerRender() {

	}

}
