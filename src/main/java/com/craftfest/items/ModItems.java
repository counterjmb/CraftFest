package com.craftfest.items;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.handler.RegisterHelper;
import com.craftfest.items.christmas.CandyCane;
import com.craftfest.items.christmas.ChristmasDoorItem;
import com.craftfest.items.christmas.ChristmasLights;
import com.craftfest.items.christmas.FurArmor;
import com.craftfest.items.christmas.GingerBread;
import com.craftfest.items.christmas.HotCocoa;
import com.craftfest.items.christmas.Ornaments;
import com.craftfest.items.christmas.ReindeerFur;
import com.craftfest.items.christmas.SantaArmor;
import com.craftfest.items.christmas.UglySweaterArmor;
import com.craftfest.items.easter.CottonCandy;
import com.craftfest.items.easter.EasterEgg;
import com.craftfest.items.easter.Peeps;
import com.craftfest.items.halloween.Candy;
import com.craftfest.items.halloween.CaramelApple;
import com.craftfest.items.halloween.MummyArmor;
import com.craftfest.items.halloween.SeaCreatureArmor;
import com.craftfest.items.halloween.VampireArmor;
import com.craftfest.items.halloween.WereWolfArmor;
import com.craftfest.items.ire.CornedBeef;
import com.craftfest.items.ire.FourLeafClover;
import com.craftfest.items.ire.GreenBeer;
import com.craftfest.items.random.Beer;
import com.craftfest.items.random.BirthdayArmor;
import com.craftfest.items.random.BirthdayCakeItem;
import com.craftfest.items.random.GlassMug;
import com.craftfest.items.random.XPPie;
import com.craftfest.items.thanksgiving.AppleCider;
import com.craftfest.items.thanksgiving.CabbageItem;
import com.craftfest.items.thanksgiving.CornItem;
import com.craftfest.items.thanksgiving.CranberryItem;
import com.craftfest.items.thanksgiving.GreenBeansItem;
import com.craftfest.items.thanksgiving.Stuffing;
import com.craftfest.items.thanksgiving.YamsItem;

public class ModItems {
	
	//random
	public static Item GlassMug = new GlassMug();
	public static Item XPPie = new XPPie();
	public static Item Beer = new Beer(6);
	public static Item BirthdayCakeItem = new BirthdayCakeItem();
	
	//random: costumes
	public static ItemArmor BirthdayHat = new BirthdayArmor(ModMaterials.birthday, 0, "birthdayhat");
	
	
	//Ire
	public static Item FourLeafClover = new FourLeafClover();
	public static Item CornedBeef = new CornedBeef(6, 4.0F, true);
	public static Item GreenBeer = new GreenBeer(6);
	
	
	//Easter
	public static Item Peeps = new Peeps(2, 2.0F, false);
	public static Item CottonCandy = new CottonCandy(2, 2.0F, false);
	public static Item EasterEgg = new EasterEgg(2, 2.0F, false);
	
	//Halloween
	public static Item CaramelApple = new CaramelApple(2);
	public static Item Candy = new Candy(2, 2.0F, false);
	
	//Halloween:Costumes
	public static ItemArmor VampireHelm = new VampireArmor(ModMaterials.Vampire, 0, "vampirehelm");
	public static ItemArmor VampireChest = new VampireArmor(ModMaterials.Vampire, 1, "vampirechest");
	public static ItemArmor VampireLegs = new VampireArmor(ModMaterials.Vampire, 2, "vampirelegs");
	public static ItemArmor VampireBoots = new VampireArmor(ModMaterials.Vampire, 3, "vampireboots");
	
	public static ItemArmor WereWolfHelm = new WereWolfArmor(ModMaterials.WereWolf, 0, "werewolfhelm");
	public static ItemArmor WereWolfChest = new WereWolfArmor(ModMaterials.WereWolf, 1, "werewolfchest");
	public static ItemArmor WereWolfLegs = new WereWolfArmor(ModMaterials.WereWolf, 2, "werewolflegs");
	public static ItemArmor WereWolfBoots = new WereWolfArmor(ModMaterials.WereWolf, 3, "werewolfboots");
	
	public static ItemArmor SeaCreatureHelm = new SeaCreatureArmor(ModMaterials.SeaCreature, 0, "seacreaturehelm");
	public static ItemArmor SeaCreatureChest = new SeaCreatureArmor(ModMaterials.SeaCreature, 1, "seacreaturechest");
	public static ItemArmor SeaCreatureLegs = new SeaCreatureArmor(ModMaterials.SeaCreature, 2, "seacreaturelegs");
	public static ItemArmor SeaCreatureBoots = new SeaCreatureArmor(ModMaterials.SeaCreature, 3, "seacreatureboots");
	
	public static ItemArmor GhostHelm = new SeaCreatureArmor(ModMaterials.Ghost, 0, "ghosthelm");
	public static ItemArmor GhostChest = new SeaCreatureArmor(ModMaterials.Ghost, 1, "ghostchest");
	public static ItemArmor GhostLegs = new SeaCreatureArmor(ModMaterials.Ghost, 2, "ghostlegs");
	public static ItemArmor GhostBoots = new SeaCreatureArmor(ModMaterials.Ghost, 3, "ghostboots");
	
	public static ItemArmor MummyHelm = new MummyArmor(ModMaterials.Mummy, 0, "mummyhelm");
	public static ItemArmor MummyChest = new MummyArmor(ModMaterials.Mummy, 1, "mummychest");
	public static ItemArmor MummyLegs = new MummyArmor(ModMaterials.Mummy, 2, "mummylegs");
	public static ItemArmor MummyBoots = new MummyArmor(ModMaterials.Mummy, 3, "mummyboots");
	
	//Thanksgiving
	public static Item Stuffing = new Stuffing(6, 4.0F, false);
	public static Item AppleCider = new AppleCider(6, 4.0F, false);
	public static Item CabbageItem = new CabbageItem(4, 0.6F, ModBlocks.CabbageBlock, Blocks.farmland);
	public static Item CornItem = new CornItem(4, 0.6F, ModBlocks.CornBlock, Blocks.farmland);
	public static Item GreenBeansItem = new GreenBeansItem(4, 0.6F, ModBlocks.GreenBeansBlock, Blocks.farmland);
	public static Item YamsItem = new YamsItem(4, 0.6F, ModBlocks.YamsBlock, Blocks.farmland);
	public static Item CranberryItem = new CranberryItem(4, 0.6F, ModBlocks.CranberryBlock, Blocks.farmland);
		
	//Christmas
	public static Item ReindeerFur = new ReindeerFur();
	public static Item HotCocoa = new HotCocoa(6, 3.0F, false);
	public static Item GingerBread = new GingerBread(6, 3.0F, false);
	public static Item CandyCane = new CandyCane(6, 3.0F, false);
	public static Item BarrelOfMilk = (Item)Item.itemRegistry.getObject("BarrelOfMilk");
	public static Item ChristmasDoorItem = new ChristmasDoorItem();
	public static Item BarrelOfCookies = (Item)Item.itemRegistry.getObject("BarrelOfCookies");
	public static Item ChristmasLights = new ChristmasLights();
	public static Item Ornaments = new Ornaments();
	
	//Christmas:Armor
	public static ItemArmor FurHelm = new FurArmor(ModMaterials.fur, 0, "furhood");
	public static ItemArmor FurChest = new FurArmor(ModMaterials.fur, 1, "furchest");
	public static ItemArmor Furlegs= new FurArmor(ModMaterials.fur, 2, "furlegs");
	public static ItemArmor FurBoots= new FurArmor(ModMaterials.fur, 3, "furfeet");
	
	public static ItemArmor SantaHat = new SantaArmor(ModMaterials.santa, 0, "santahat");
	public static ItemArmor uglysweater = new UglySweaterArmor(ModMaterials.uglysweater, 1, "uglysweater");
	
		
	
	public static void Init(){
		
		//random
		RegisterHelper.registerItem(GlassMug);
		RegisterHelper.registerItem(XPPie);
		RegisterHelper.registerItem(Beer);
		RegisterHelper.registerItem(BirthdayCakeItem);
				
		//Ire
		RegisterHelper.registerItem(FourLeafClover);
		RegisterHelper.registerItem(CornedBeef);
		RegisterHelper.registerItem(GreenBeer);
		
		//Easter
		RegisterHelper.registerItem(Peeps);
		RegisterHelper.registerItem(CottonCandy);
		RegisterHelper.registerItem(EasterEgg);
		
		
		//Halloween
		RegisterHelper.registerItem(CaramelApple);
		RegisterHelper.registerItem(Candy);
		
		//Halloween: Costumes
		RegisterHelper.registerItem(VampireHelm);
		RegisterHelper.registerItem(VampireChest);
		RegisterHelper.registerItem(VampireLegs);
		RegisterHelper.registerItem(VampireBoots);
		
		RegisterHelper.registerItem(WereWolfHelm);
		RegisterHelper.registerItem(WereWolfChest);
		RegisterHelper.registerItem(WereWolfLegs);
		RegisterHelper.registerItem(WereWolfBoots);
		
		RegisterHelper.registerItem(SeaCreatureHelm);
		RegisterHelper.registerItem(SeaCreatureChest);
		RegisterHelper.registerItem(SeaCreatureLegs);
		RegisterHelper.registerItem(SeaCreatureBoots);
		
		RegisterHelper.registerItem(GhostHelm);
		RegisterHelper.registerItem(GhostChest);
		RegisterHelper.registerItem(GhostLegs);
		RegisterHelper.registerItem(GhostBoots);
		
		RegisterHelper.registerItem(MummyHelm);
		RegisterHelper.registerItem(MummyChest);
		RegisterHelper.registerItem(MummyLegs);
		RegisterHelper.registerItem(MummyBoots);
		
		//Thanksgiving
		RegisterHelper.registerItem(Stuffing);
		RegisterHelper.registerItem(AppleCider);
		RegisterHelper.registerItem(GreenBeansItem);
		
		
		//Christmas
		RegisterHelper.registerItem(ReindeerFur);
		RegisterHelper.registerItem(HotCocoa);
		RegisterHelper.registerItem(GingerBread);
		RegisterHelper.registerItem(CandyCane);
		RegisterHelper.registerItem(ChristmasDoorItem);
		RegisterHelper.registerItem(ChristmasLights);
		RegisterHelper.registerItem(Ornaments);
		
		//Christmas: Armor
		RegisterHelper.registerItem(FurHelm);
		RegisterHelper.registerItem(FurChest);
		RegisterHelper.registerItem(Furlegs);
		RegisterHelper.registerItem(FurBoots);
		
		
	}

}
