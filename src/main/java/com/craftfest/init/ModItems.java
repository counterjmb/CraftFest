package com.craftfest.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;

public class ModItems {

	public static void Init() {

		IreItems.init();
		RandomItems.init();

	}

	public static void register() {

		IreItems.register();
		RandomItems.register();

	}

	public static void regesterRender() {

		IreItems.regesterRender();
		RandomItems.regesterRender();

	}

}
