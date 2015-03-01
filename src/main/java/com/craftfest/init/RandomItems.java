package com.craftfest.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.CraftFestMod;
import com.craftfest.items.random.Bacon;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;

public class RandomItems {
	
	public static Item GlassMug;
	public static Item XPPie;
	public static Item Beer;
	public static Item Bacon;

	public static void init() {
		
		Bacon = new Bacon(6, 4.0F, true);
		Beer = new Beer(6);
		GlassMug = new GlassMug();
		XPPie = new XPPie();

	}

	public static void register() {

		GameRegistry.registerItem(Bacon,Bacon.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(Beer,Beer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GlassMug,GlassMug.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(XPPie,XPPie.getUnlocalizedName().substring(5));
	}

	public static void regesterRender() {
		
		registerRender(Bacon);
		registerRender(Beer);
		registerRender(GlassMug);
		registerRender(XPPie);

	}

	public static void registerRender(Item item) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}

}
