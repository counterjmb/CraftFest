package com.craftfest.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.CraftFestMod;


public class RegisterHelper {
	
	public static void registerBlock(Block block){
		GameRegistry.registerBlock(block, CraftFestMod.MODID + "_" + block.getUnlocalizedName().substring(5));
	}
	
	public static void registerItem(Item item){
		GameRegistry.registerItem(item, CraftFestMod.MODID + "_" + item.getUnlocalizedName().substring(5));
	}
	
	public static void registerTileEntity(TileEntity tileentity){
		GameRegistry.registerTileEntity(tileentity.getClass(), CraftFestMod.MODID);
	}
	
	public static void render(TileEntity tileentity){

	}

}