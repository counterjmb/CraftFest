package com.craftfest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = CraftFestMod.MODID, version = CraftFestMod.VERSION)
public class CraftFestMod {

	public static final String MODID = "craftfest";
	public static final String VERSION = "0.1";
	public static final String NAME = "Craft Fest";

	@Instance(CraftFestMod.MODID)
	public static CraftFestMod instance;

	@SidedProxy(clientSide = "com.craftfest.ClientProxy", serverSide = "com.craftfest.ServerProxy")
	public static CommonProxy proxy;

	// TABS
	public static CreativeTabs tabWinter = new CreativeTabs(
			CreativeTabs.getNextID(), "winter") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.snow);
		}

	};

	public static CreativeTabs tabSpring = new CreativeTabs(
			CreativeTabs.getNextID(), "spring") {

		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.diamond_block);
		}
	};

	public static CreativeTabs tabSummer = new CreativeTabs(
			CreativeTabs.getNextID(), "summer") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.sand);
		}
	};

	public static CreativeTabs tabFall = new CreativeTabs(
			CreativeTabs.getNextID(), "fall") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.wooden_slab);
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("SPANK: CRAFTFESTMOD POST INIT");
		if (event.getSide() == Side.CLIENT) {
			this.proxy.preInit(event);
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("SPANK: CRAFTFESTMOD POST INIT");

		if (event.getSide() == Side.CLIENT) {
			this.proxy.init(event);

			this.proxy.registerRenderThings();
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("SPANK: CRAFTFESTMOD POST INIT");
		this.proxy.postInit(event);
	}

}
