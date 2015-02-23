package com.craftfest.blocks.ire;

import net.minecraft.block.BlockGrass;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.craftfest.CraftFestMod;

public class CloverGrass extends BlockGrass {
	// TODO: CloverGrass: create customer grass renderer
	// TODO: CloverGrass: cannot place plants on yet.
	// TODO: CloverGrass: test silk touch

	private final String name = "clovergrass";

	public CloverGrass() {

		this.setUnlocalizedName(CraftFestMod.MODID + "_" + "clovergrass");
		this.setCreativeTab(CraftFestMod.tabSpring);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
	}

	public String getName() {
		return name;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		return ColorizerGrass.getGrassColor(0.0D, 1.0D);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess worldIn, BlockPos pos,
			int renderPass) {
		return 1;
	}

}
