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

public class ModItems {

	// random
	public static Item GlassMug = new GlassMug();
	public static Item XPPie = new XPPie();
	public static Item Beer = new Beer(6);
	public static Item BirthdayCakeItem = new BirthdayCakeItem();

	// Ire
	public static Item FourLeafClover = new FourLeafClover();
	public static Item CornedBeef = new CornedBeef(6, 4.0F, true);
	public static Item GreenBeer = new GreenBeer(6);

	public static void Init() {
		
		System.out.println("SPANK: ITEMS INIT");
		
		

		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		// random
//		renderItem.getItemModelMesher().register(GlassMug,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((FourLeafClover) GlassMug).getName(),"inventory"));
//		renderItem.getItemModelMesher().register(XPPie,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((GlassMug) XPPie).getName(),"inventory"));
//		renderItem.getItemModelMesher().register(Beer,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((Beer) Beer).getName(),"inventory"));
//		renderItem.getItemModelMesher().register(BirthdayCakeItem,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((BirthdayCakeItem) BirthdayCakeItem).getName(),"inventory"));
//		
		

		// Ire
//		renderItem.getItemModelMesher().register(FourLeafClover,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((FourLeafClover) FourLeafClover).getName(),"inventory"));
//		renderItem.getItemModelMesher().register(CornedBeef,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((CornedBeef) CornedBeef).getName(),"inventory"));
//		renderItem.getItemModelMesher().register(GreenBeer,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((GreenBeer) GreenBeer).getName(),"inventory"));
//		
		 
	}

}
