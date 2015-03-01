package com.craftfest;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.init.ModItems;
import com.craftfest.tabs.TabFall;
import com.craftfest.tabs.TabSpring;
import com.craftfest.tabs.TabSummer;
import com.craftfest.tabs.TabWinter;
import com.craftfest.world.Dimensions;
import com.craftfest.world.biomes.ModBiomes;

@Mod(modid = CraftFestMod.MODID, name = CraftFestMod.NAME, version = CraftFestMod.VERSION)
public class CraftFestMod {

	// reference
	public static final String MODID = "craftfest";
	public static final String VERSION = "0.1";
	public static final String NAME = "Craft Fest";

	// TABS
	public static TabWinter tabWinter = new TabWinter("winter");
	public static TabSpring tabSpring = new TabSpring("spring");
	public static TabSummer tabSummer = new TabSummer("summer");
	public static TabFall tabFall = new TabFall("fall");

	@Instance(CraftFestMod.MODID)
	public static CraftFestMod instance;

	@SidedProxy(clientSide = "com.craftfest.ClientProxy", serverSide = "com.craftfest.CommonProxy")
	public static CommonProxy proxy;

	// Listeners
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		ModBlocks.Init();
		ModBlocks.register();
		ModItems.Init();
		ModItems.register();
		

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		proxy.init(event);
		proxy.registerRender();
		ModBiomes.init();
		Dimensions.init();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		proxy.postInit(event);
	}

}
