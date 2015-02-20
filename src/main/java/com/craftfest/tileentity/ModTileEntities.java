package com.craftfest.tileentity;

import net.minecraft.tileentity.TileEntityChest;

import com.craftfest.handler.RegisterHelper;
import com.craftfest.tileentity.christmas.TileEntityChristmasChest;

public class ModTileEntities {
	
	public static TileEntityChest christmaschest = new TileEntityChristmasChest();
	
	public static void init(){
		RegisterHelper.registerTileEntity(christmaschest);
	}

}
