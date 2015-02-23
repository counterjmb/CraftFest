package com.craftfest;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;
import com.craftfest.tileentity.ModTileEntities;
import com.craftfest.util.Config;
import com.craftfest.util.Recipes;
import com.craftfest.world.Dimensions;
import com.craftfest.world.biomes.ModBiomes;


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
