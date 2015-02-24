package com.craftfest.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ire.IreItems;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.BirthdayCakeItem;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;

public class ModItems {

	
	
	// random
	public static Item GlassMug;
	public static Item XPPie;
	public static Item Beer;
	public static Item BirthdayCakeItem;

	

	public static void Init() {
		// Ire
		IreItems.init();
			
			
		// random
		GlassMug = new GlassMug();
		XPPie = new XPPie();
		Beer = new Beer(6);
		BirthdayCakeItem = new BirthdayCakeItem();
		
	}
	
	public static void register(){
		
		IreItems.register();
		
		//Random
	}
	
	public static void regesterRender(){
		
		IreItems.regesterRender();
		
	}
	
	public static void regesterRender(Item item){
		
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		// Ire
			
		// random
		renderItem.getItemModelMesher().register(GlassMug,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((GlassMug) GlassMug).getName(),"inventory"));
		renderItem.getItemModelMesher().register(XPPie,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((XPPie) XPPie).getName(),"inventory"));
		renderItem.getItemModelMesher().register(Beer,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((Beer) Beer).getName(),"inventory"));
		renderItem.getItemModelMesher().register(BirthdayCakeItem,0,new ModelResourceLocation(CraftFestMod.MODID + ":" + ((BirthdayCakeItem) BirthdayCakeItem).getName(),"inventory"));
						
		
	}
	
	

}
