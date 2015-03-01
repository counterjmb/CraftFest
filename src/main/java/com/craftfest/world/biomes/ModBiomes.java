package com.craftfest.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

import com.craftfest.world.biomes.ire.Cliffs;
import com.craftfest.world.biomes.ire.CloverFields;
import com.craftfest.world.biomes.ire.Moor;

public class ModBiomes {
	
	//IDs
	//Ire
	public static int cloverfieldsID = 120;
	public static int MoorID = 121;
	public static int CliffsID = 122;
	
	
	//Instantiations 
	//Ire
	public static BiomeGenBase CloverFields;
	public static BiomeGenBase Moor;
	public static BiomeGenBase Cliffs;
	
	public static void init(){
		
		//Constructors
		//Ire
		CloverFields = new CloverFields(cloverfieldsID);
		Moor = new Moor(MoorID);
		Cliffs = new Cliffs(CliffsID);
		
		
		//Registers
		//Ire
		BiomeDictionary.registerBiomeType(CloverFields, Type.MAGICAL);
		BiomeManager.addSpawnBiome(CloverFields);
		BiomeDictionary.registerBiomeType(Moor, Type.WET);
		BiomeManager.addSpawnBiome(Moor);
		BiomeDictionary.registerBiomeType(Cliffs, Type.HILLS);
		BiomeManager.addSpawnBiome(Cliffs);
	
		
	}
	
	public static void register(){
		
	}

}
