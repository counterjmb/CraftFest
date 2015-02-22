package com.craftfest;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = CraftFestMod.MODID, name = CraftFestMod.NAME, version = CraftFestMod.VERSION)
public class CraftFestMod {
	
	public static final String MODID = "craftfest";
	public static final String VERSION = "0.1";
	public static final String NAME = "Craft Fest";
	
	@Instance(CraftFestMod.MODID)
	public static CraftFestMod instance;
	
	@SidedProxy(clientSide = "com.craftfest.ClientProxy", serverSide = "com.craftfest.ServerProxy")
	public static CommonProxy proxy;
	
	
	//tabs
		public static CreativeTabs tabWinter = new CreativeTabs(CreativeTabs.getNextID(), "winter"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Item.getItemFromBlock(Blocks.snow);
			}};
		
		public static CreativeTabs tabSpring = new CreativeTabs(CreativeTabs.getNextID(), "spring"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Item.getItemFromBlock(Blocks.diamond_ore);
			}};
		
		public static CreativeTabs tabSummer = new CreativeTabs(CreativeTabs.getNextID(), "summer"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Item.getItemFromBlock(Blocks.bookshelf);
			}};
		
		public static CreativeTabs tabFall = new CreativeTabs(CreativeTabs.getNextID(), "fall"){
			@Override
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return Item.getItemFromBlock(Blocks.end_portal);
			}};
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent  event){
		this.proxy.preInit(event);
			
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		this.proxy.init(event);
		
		
		proxy.registerRenderThings();
        //GameRegistry.registerTileEntity(WreathTileEntity.class, "wreathtileentity");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent  event){
		this.proxy.postInit(event);
	}
	
	

}
