package com.craftfest.blocks.random;

import net.minecraft.block.BlockCake;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class BirthdayCakeBlock extends BlockCake {

	private final String name = "birthdaycake";

	public BirthdayCakeBlock() {

		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "birthdaycake");
		setCreativeTab(CraftFestMod.tabSpring);

	}

	public String getName() {
		return name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, BlockPos pos) {
		return ModItems.BirthdayCakeItem;
	}

}
