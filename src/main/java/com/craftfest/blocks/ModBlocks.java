package com.craftfest.blocks;

import net.minecraft.block.Block;

import com.craftfest.blocks.christmas.BarrelOfCookies;
import com.craftfest.blocks.christmas.BarrelOfMilk;
import com.craftfest.blocks.christmas.ChristmasChest;
import com.craftfest.blocks.christmas.ChristmasLights;
import com.craftfest.blocks.christmas.ChristmasTreeLeaves;
import com.craftfest.blocks.christmas.ChristmasTreeLog;
import com.craftfest.blocks.christmas.ChristmasTreePlanks;
import com.craftfest.blocks.christmas.DoorDimChristmas;
import com.craftfest.blocks.christmas.FrostedGlass;
import com.craftfest.blocks.christmas.FrostedGlassPane;
import com.craftfest.blocks.christmas.SnowyGrass;
import com.craftfest.blocks.christmas.Wreath;
import com.craftfest.blocks.halloween.BloodyCobblestone;
import com.craftfest.blocks.halloween.BrokenGlass;
import com.craftfest.blocks.halloween.CursedGrass;
import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.blocks.thanksgiving.CabbageBlock;
import com.craftfest.blocks.thanksgiving.CornBlock;
import com.craftfest.blocks.thanksgiving.CranberryBlock;
import com.craftfest.blocks.thanksgiving.GreenBeansBlock;
import com.craftfest.blocks.thanksgiving.YamsBlock;
import com.craftfest.blocks.valentines.CherryBlossomLeaves;
import com.craftfest.blocks.valentines.PinkGrass;
import com.craftfest.handler.RegisterHelper;

public class ModBlocks {

	
	//valentine's
	public static Block CherryBlossomLeaves = new CherryBlossomLeaves();
	public static Block PinkGrass = new PinkGrass();
	
	//Ire
	public static Block CloverGrass = new CloverGrass();
	
	//Halloween
	public static Block BrokenGlass = new BrokenGlass();
	public static Block CursedGrass = new CursedGrass();
	public static Block BloodyCobblestone = new BloodyCobblestone();
	
	//Thanksgiving
	public static Block CabbageBlock = new CabbageBlock();
	public static Block CornBlock = new CornBlock();
	public static Block GreenBeansBlock = new GreenBeansBlock();
	public static Block YamsBlock = new YamsBlock();
	public static Block CranberryBlock = new CranberryBlock();
		
	//Christmas
	public static Block BarrelOfCookies = new BarrelOfCookies();
	public static Block BarrelOfMilk = new BarrelOfMilk();
	public static Block ChristmasChest = new ChristmasChest(0);
	public static Block ChristmasLights = new ChristmasLights();
	public static Block ChristmasTreeLeaves = new ChristmasTreeLeaves();
	public static Block ChristmasTreeLog = new ChristmasTreeLog();
	public static Block ChristmasTreePlanks = new ChristmasTreePlanks();
	public static Block ChristmasDoor = new DoorDimChristmas();
	public static Block FrostedGlass = new FrostedGlass();
	public static Block FrostedGlassPane = new FrostedGlassPane();
	public static Block SnowyGrass = new SnowyGrass();
	public static Block Wreath = new Wreath();
	
	//christmas: tree
	
	
	
	
	public static void Init(){
		
			
		//valentines
		RegisterHelper.registerBlock(CherryBlossomLeaves);
		RegisterHelper.registerBlock(PinkGrass);
		
		//Ire
		RegisterHelper.registerBlock(CloverGrass);
		
		//Halloween
		RegisterHelper.registerBlock(BrokenGlass);
		RegisterHelper.registerBlock(CursedGrass);
		RegisterHelper.registerBlock(BloodyCobblestone);
		
		//Thanksgiving
		RegisterHelper.registerBlock(CabbageBlock);
		RegisterHelper.registerBlock(CornBlock);
		RegisterHelper.registerBlock(GreenBeansBlock);
		RegisterHelper.registerBlock(YamsBlock);
		RegisterHelper.registerBlock(CranberryBlock);
				
		//Christmas
		 RegisterHelper.registerBlock(BarrelOfCookies);
		 RegisterHelper.registerBlock(BarrelOfMilk);
		 RegisterHelper.registerBlock(ChristmasChest);
		 RegisterHelper.registerBlock(ChristmasLights);
		 RegisterHelper.registerBlock(ChristmasTreeLeaves);
		 RegisterHelper.registerBlock(ChristmasTreeLog);
		 RegisterHelper.registerBlock(ChristmasTreePlanks);
		 RegisterHelper.registerBlock(ChristmasDoor);
		 RegisterHelper.registerBlock(FrostedGlass);
		 RegisterHelper.registerBlock(FrostedGlassPane);
		 RegisterHelper.registerBlock(SnowyGrass);
		 RegisterHelper.registerBlock(Wreath);
		
	}

}
