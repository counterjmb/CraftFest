package com.craftfest.blocks;

import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ire.CloverGrass;
import com.craftfest.blocks.random.BirthdayCakeBlock;

public class ModBlocks {

	// Ire
	public static BlockGrass CloverGrass = new CloverGrass();

	// Random
	public static BlockCake BirthdayCakeBlock = new BirthdayCakeBlock();

	public static void Init() {
		
		System.out.println("SPANK: MODBLOCKS INIT");

		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

		// Ire
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(CloverGrass), 0 ,new ModelResourceLocation(CraftFestMod.MODID + ":"+ ((CloverGrass) CloverGrass).getName(), "inventory"));
		System.out.println("SPANK:" + new ModelResourceLocation(CraftFestMod.MODID + ":"+ ((CloverGrass) CloverGrass).getName(), "inventory"));
		// Random
		renderItem.getItemModelMesher().register(Item.getItemFromBlock(BirthdayCakeBlock),0,new ModelResourceLocation(CraftFestMod.MODID + ":"+ ((BirthdayCakeBlock)BirthdayCakeBlock).getName(), "inventory"));

	}

}
