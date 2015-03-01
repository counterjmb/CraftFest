package com.craftfest.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ire.CelticStone;
import com.craftfest.blocks.ire.CloverGrass;

public class ModBlocks {
	
	public static Block CloverGrass;
	public static Block CelticStone;
	
	public static void Init(){
	
		CloverGrass = new CloverGrass();
		CelticStone = new CelticStone();
	}
	
	public static void register(){
		GameRegistry.registerBlock(CloverGrass, CloverGrass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(CelticStone, CelticStone.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(){
		registerRender(CloverGrass);
		registerRender(CelticStone);
	}
	
	
	public static void registerRender(Block block){
		
		Item item = GameRegistry.findItem(CraftFestMod.MODID, block.getUnlocalizedName().substring(5));
		//Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}
	



}
