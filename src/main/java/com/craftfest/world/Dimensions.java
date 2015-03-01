package com.craftfest.world;

import net.minecraftforge.common.DimensionManager;

//https://www.youtube.com/watch?v=qwb2ykhnCsY&list=UU786-fvOTMkndZPRwr15zVA&index=195


public class Dimensions {
	
	//dimension bits
	//TODO: add config element
	public static int IreDimentionID = 9;
	
	public static void init(){
		registerDimension(); 

	}
	
	public static void registerDimension(){
		
		//ire
		DimensionManager.registerProviderType(IreDimentionID, WolrdProviderIre.class, false);
		DimensionManager.registerDimension(IreDimentionID, IreDimentionID);
		
	}

}
