package com.craftfest.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.blocks.random.BirthdayCakeBlock;

public class ModBlocks {

	// Ire
	public static CloverGrass CloverGrass = new CloverGrass();

	// Random
	public static BirthdayCakeBlock BirthdayCakeBlock = new BirthdayCakeBlock();

	public static void Init() {

		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		// Ire
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(CloverGrass),
				0,
				new ModelResourceLocation(CraftFestMod.MODID + ":"
						+ CloverGrass.getName(), "inventory"));

		// Random
		renderItem.getItemModelMesher().register(
				Item.getItemFromBlock(BirthdayCakeBlock),
				0,
				new ModelResourceLocation(CraftFestMod.MODID + ":"
						+ BirthdayCakeBlock.getName(), "inventory"));

	}

}
