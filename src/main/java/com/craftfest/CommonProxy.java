package com.craftfest;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;
import com.craftfest.util.Recipes;
import com.craftfest.world.Dimensions;
import com.craftfest.world.biomes.ModBiomes;

public class CommonProxy {

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {

		// FMLCommonHandler.instance().bus().register(handler);
		System.out.println("SPANK: PRE INIT");

		// Config.init(e.getSuggestedConfigurationFile());

	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		System.out.println("SPANK: INIT");

		ModBlocks.Init();
		ModItems.Init();
		Recipes.addRecipes();
		Dimensions.init();
		ModBiomes.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		System.out.println("SPANK: POST INIT");

	}

	public void registerRenderThings() {

	}

}
