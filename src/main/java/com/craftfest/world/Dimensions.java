package com.craftfest.world;
//https://www.youtube.com/watch?v=qwb2ykhnCsY&list=UU786-fvOTMkndZPRwr15zVA&index=195

import net.minecraftforge.common.DimensionManager;

import com.craftfest.CraftFestMod;

public class Dimensions {
	
	//dimension bits
	//TODO: add config element
	public static int christmasDimID = 9;
	
	public static void init(){
		//Dimensions
		DimensionManager.registerProviderType(christmasDimID, ChristmasWorldProvider.class, false);
		DimensionManager.registerDimension(christmasDimID, christmasDimID);
	}

}
