package com.craftfest;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.handler.Config;
import com.craftfest.handler.Recipes;
import com.craftfest.items.ModItems;
import com.craftfest.tileentity.ModTileEntities;
import com.craftfest.world.Dimensions;
import com.craftfest.world.biomes.ModBiomes;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e){
		ModBlocks.Init();
		ModItems.Init();
		ModTileEntities.init();
		Config.init(e.getSuggestedConfigurationFile());
	}
	
	public void init(FMLInitializationEvent e){
		Recipes.addRecipes();
		Dimensions.init();
		ModBiomes.init();

	}
	
	public void postInit(FMLPostInitializationEvent  e){
		
	}
	
    public void registerRenderThings() {
        //ClientRegistry.bindTileEntitySpecialRenderer(WreathTileEntity.class, new WreathRenderer());
}

}
