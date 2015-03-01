package com.craftfest.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ire.CornedBeef;
import com.craftfest.items.ire.FourLeafClover;
import com.craftfest.items.ire.GoldenFourLeafClover;
import com.craftfest.items.ire.GreenBeer;

public class IreItems {

	public static Item CornedBeef;
	public static Item FourLeafClover;
	public static Item GoldenFourLeafClover;
	public static Item GreenBeer;

	public static void init() {

		CornedBeef = new CornedBeef(6, 4.0F, true);
		FourLeafClover = new FourLeafClover();
		GoldenFourLeafClover = new GoldenFourLeafClover();
		GreenBeer = new GreenBeer(6);
	}

	public static void register() {

		GameRegistry.registerItem(CornedBeef,CornedBeef.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(FourLeafClover, FourLeafClover.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GoldenFourLeafClover, GoldenFourLeafClover.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(GreenBeer, GreenBeer.getUnlocalizedName().substring(5));

	}

	public static void regesterRender() {
		
		registerRender(CornedBeef);
		registerRender(FourLeafClover);
		registerRender(GoldenFourLeafClover);
		registerRender(GreenBeer);

	}

	public static void registerRender(Item item) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(CraftFestMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}

}
