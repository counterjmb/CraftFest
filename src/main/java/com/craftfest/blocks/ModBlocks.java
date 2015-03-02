package com.craftfest.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ire.Cabbage;
import com.craftfest.blocks.ire.CelticStone;
import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.blocks.ire.IrePortal;

public class ModBlocks {
	
	public static Block Cabbage;
	public static Block CelticStone;
	public static Block CloverGrass;
	public static Block IrePortal;
	
	public static void Init(){ 
	
		Cabbage = new Cabbage();
		CelticStone = new CelticStone();
		CloverGrass = new CloverGrass();
		IrePortal = new IrePortal(); 
		
	}
	
	public static void register(){
		GameRegistry.registerBlock(Cabbage, Cabbage.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(CelticStone, CelticStone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(CloverGrass, CloverGrass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(IrePortal, IrePortal.getUnlocalizedName().substring(5));
	}
	
	public static void registerRender(){
		
		registerRender(Cabbage);
		registerRender(CelticStone);
		registerRender(CloverGrass);
		registerRender(IrePortal);
	}
	
	
	public static void registerRender(Block block){
		
		Item item = GameRegistry.findItem(CraftFestMod.MODID, block.getUnlocalizedName().substring(5));
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}
	



}
