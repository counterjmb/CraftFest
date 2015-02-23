package com.craftfest.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.CraftFestMod;


public class RegisterHelper {
	
	public static void registerBlock(Block block){
		
		
		//GameRegistry.registerBlock(block, CraftFestMod.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item){
		/*
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + (item).getName(), "inventory" ));
		GameRegistry.registerItem(item, CraftFestMod.MODID + "_" + item.getUnlocalizedName().substring(5));*/
	}
	
	public static void registerTileEntity(TileEntity tileentity){
		GameRegistry.registerTileEntity(tileentity.getClass(), CraftFestMod.MODID);
	}
	
	public static void render(TileEntity tileentity){

	}

}
