package com.craftfest.blocks.ire;

import java.util.Random;

import com.craftfest.init.IreItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class Cabbage extends BlockCrops {

	protected Item getSeed() {
		return IreItems.Cabbage;
	}

	protected Item getCrop() {
		return IreItems.Cabbage;
	}

}
