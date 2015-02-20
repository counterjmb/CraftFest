package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ChristmasDoorItem extends ItemDoor {

	public ChristmasDoorItem() {
		super(Material.wood);
		setCreativeTab(CraftFestMod.tabWinter);
		this.setUnlocalizedName("christmasdoorItem");
		this.setTextureName(CraftFestMod.MODID + ":"
				+ getUnlocalizedName().substring(5));

	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float p_77648_8_, float p_77648_9_,
			float p_77648_10_) {

		if (side != 1) {

			return false;
		} else {
			++y;
			Block block = ModBlocks.ChristmasDoor;

			if (player.canPlayerEdit(x, y, z, side, stack)
					&& player.canPlayerEdit(x, y + 1, z, side, stack)) {
				if (!block.canPlaceBlockAt(world, x, y, z)) {

					return false;
				} else {
					int i1 = MathHelper
							.floor_double((double) ((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
					placeDoorBlock(world, x, y, z, i1, block);
					--stack.stackSize;

					return true;
				}
			} else {

				return false;
			}
		}
	}

	public static void placeDoorBlock(World wolrd, int x, int y, int z,
			int p_150924_4_, Block block) {

		byte b0 = 0;
		byte b1 = 0;

		if (p_150924_4_ == 0) {
			b1 = 1;
		}

		if (p_150924_4_ == 1) {
			b0 = -1;
		}

		if (p_150924_4_ == 2) {
			b1 = -1;
		}

		if (p_150924_4_ == 3) {
			b0 = 1;
		}

		int i1 = (wolrd.getBlock(x - b0, y, z - b1).isNormalCube() ? 1 : 0)
				+ (wolrd.getBlock(x - b0, y + 1, z - b1).isNormalCube() ? 1 : 0);
		int j1 = (wolrd.getBlock(x + b0, y, z + b1).isNormalCube() ? 1 : 0)
				+ (wolrd.getBlock(x + b0, y + 1, z + b1).isNormalCube() ? 1 : 0);
		boolean flag = wolrd.getBlock(x - b0, y, z - b1) == block
				|| wolrd.getBlock(x - b0, y + 1, z - b1) == block;
		boolean flag1 = wolrd.getBlock(x + b0, y, z + b1) == block
				|| wolrd.getBlock(x + b0, y + 1, z + b1) == block;
		boolean flag2 = false;

		if (flag && !flag1) {
			flag2 = true;
		} else if (j1 > i1) {
			flag2 = true;
		}

		wolrd.setBlock(x, y, z, block, p_150924_4_, 2);
		wolrd.setBlock(x, y + 1, z, block, 8 | (flag2 ? 1 : 0), 2);
		wolrd.notifyBlocksOfNeighborChange(x, y, z, block);
		wolrd.notifyBlocksOfNeighborChange(x, y + 1, z, block);

	}

}
