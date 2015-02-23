package com.craftfest.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ire.CornedBeef;
import com.craftfest.items.ire.FourLeafClover;
import com.craftfest.items.ire.GreenBeer;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.BirthdayCakeItem;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;
import com.craftfest.util.RegisterHelper;

public class ModItems {
	
	
	//random
	public static Item GlassMug = new GlassMug();
	public static Item XPPie = new XPPie();
	public static Item Beer = new Beer(6);
	public static Item BirthdayCakeItem = new BirthdayCakeItem();
	
	//Ire
	public static Item FourLeafClover = new FourLeafClover();
	public static Item CornedBeef = new CornedBeef(6, 4.0F, true);
	public static Item GreenBeer = new GreenBeer(6);
	
		
	
	public static void Init(){
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		//random
		RegisterHelper.registerItem(GlassMug);
		RegisterHelper.registerItem(XPPie);
		RegisterHelper.registerItem(Beer);
		RegisterHelper.registerItem(BirthdayCakeItem);
				
		//Ire
		
		renderItem.getItemModelMesher().register(FourLeafClover, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + ((FourLeafClover) FourLeafClover).getName(), "inventory" ));
		/*
		RegisterHelper.registerItem(FourLeafClover);
		RegisterHelper.registerItem(CornedBeef);
		RegisterHelper.registerItem(GreenBeer);
		*/
	}

}
