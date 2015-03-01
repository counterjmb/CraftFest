package com.craftfest.world;

import java.util.List;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import com.craftfest.world.biomes.ModBiomes;
import com.google.common.collect.Lists;

public class WolrdProviderIre extends WorldProvider {

	//TODO: add multiple biomes to dimension 
	public static List<BiomeGenBase> allowedBiomes = Lists.newArrayList(
			ModBiomes.Moor, ModBiomes.Cliffs, ModBiomes.CloverFields);

	public void registerWorldChunkManager() {

		this.worldChunkMgr = new WorldChunkManagerHell(ModBiomes.CloverFields,0.6F);
		this.dimensionId = Dimensions.IreDimentionID;
	}

	//TODO: find out what this string does
	public IChunkProvider createChunkGeneration() {
		return new ModChunkProvider(worldObj, worldObj.getSeed(), true, "idontknow");

	}

	@Override
	public String getDimensionName() {
		return "The Ire";
	}

	@Override
	public String getInternalNameSuffix() {

		return null;
	}

}
