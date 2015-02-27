package com.craftfest.blocks.ire;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

public class CloverGrass extends BlockGrass {
	// TODO: CloverGrass: create customer grass renderer
	// TODO: CloverGrass: cannot place plants on yet.
	// TODO: CloverGrass: test silk touch

	public CloverGrass() {

		this.setUnlocalizedName("clovergrass");
		this.setCreativeTab(CraftFestMod.tabSpring);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setTickRandomly(true);
	}

	//spread
	@Override
	public void updateTick(World wolrd, BlockPos pos, IBlockState state,
			Random rand) {
		if (!wolrd.isRemote) {
			if (wolrd.getLightFromNeighbors(pos.up()) < 4
					&& wolrd.getBlockState(pos.up()).getBlock()
							.getLightOpacity(wolrd, pos.up()) > 2) {
				wolrd.setBlockState(pos, Blocks.dirt.getDefaultState());
			} else {
				if (wolrd.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1,
								rand.nextInt(5) - 3, rand.nextInt(3) - 1);
						Block block = wolrd.getBlockState(blockpos1.up())
								.getBlock();
						IBlockState iblockstate1 = wolrd
								.getBlockState(blockpos1);

						if (iblockstate1.getBlock() == Blocks.dirt
								&& iblockstate1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT
								&& wolrd.getLightFromNeighbors(blockpos1.up()) >= 4
								&& block.getLightOpacity(wolrd, blockpos1.up()) <= 2) {
							wolrd.setBlockState(blockpos1,
									ModBlocks.CloverGrass.getDefaultState());
						}
					}
				}
			}
		}
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state,
			boolean isClient) {
		return true;
	}
	
	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		BlockPos blockpos1 = pos.up();
		int i = 0;

		while (i < 128) {
			BlockPos blockpos2 = blockpos1;
			int j = 0;

			while (true) {
				if (j < i / 16) {
					blockpos2 = blockpos2.add(rand.nextInt(3) - 1,
							(rand.nextInt(3) - 1) * rand.nextInt(3) / 2,
							rand.nextInt(3) - 1);

					if (world.getBlockState(blockpos2.down()).getBlock() == Blocks.grass
							&& !world.getBlockState(blockpos2).getBlock()
									.isNormalCube()) {
						++j;
						continue;
					}
				} else if (world.isAirBlock(blockpos2)) {
					if (rand.nextInt(8) == 0) {
						world.getBiomeGenForCoords(blockpos2).plantFlower(
								world, rand, blockpos2);
					} else {
						IBlockState iblockstate2 = Blocks.tallgrass
								.getDefaultState().withProperty(
										BlockTallGrass.TYPE,
										BlockTallGrass.EnumType.GRASS);

						if (Blocks.tallgrass.canBlockStay(world, blockpos2,
								iblockstate2)) {
							world.setBlockState(blockpos2, iblockstate2, 3);
						}
					}
				}

				++i;
				break;
			}
		}
	}

}
