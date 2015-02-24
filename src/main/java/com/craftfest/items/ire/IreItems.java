package com.craftfest.items.ire;

import com.craftfest.CraftFestMod;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.BirthdayCakeItem;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class IreItems {

	public static Item FourLeafClover;
	public static Item CornedBeef;
	public static Item GreenBeer;

	public static void init() {

		FourLeafClover = new FourLeafClover();
		CornedBeef = new CornedBeef(6, 4.0F, true);
		GreenBeer = new GreenBeer(6);
	}

	public static void register() {

		GameRegistry.registerItem(FourLeafClover,((FourLeafClover) FourLeafClover).getName());
		GameRegistry.registerItem(CornedBeef,((CornedBeef) CornedBeef).getName());
		GameRegistry.registerItem(GreenBeer, GreenBeer.getUnlocalizedName().substring(5));

	}

	public static void regesterRender() {
		
		registerRender(FourLeafClover);
		registerRender(CornedBeef);
		registerRender(GreenBeer);

	}

	public static void registerRender(Item item) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}

}
