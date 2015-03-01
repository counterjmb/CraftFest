package com.craftfest.blocks.ire;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class IrePortal extends BlockPortal {

	public IrePortal() {
		super();
		setDefaultState(this.blockState.getBaseState().withProperty(AXIS,
				EnumFacing.Axis.X));
		setTickRandomly(true);
		setUnlocalizedName("ireportal");
	}

	public boolean renderAsNormalBlock() {
		return false;
	}



}
