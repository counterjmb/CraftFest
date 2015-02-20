package com.craftfest.blocks.christmas;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;
import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChristmasLightsBlock extends BlockRedstoneWire {

	private boolean powered = true;
	private Set hash = new HashSet();
	@SideOnly(Side.CLIENT)
	static private IIcon iconcross;
	@SideOnly(Side.CLIENT)
	static private IIcon line;
	@SideOnly(Side.CLIENT)
	static private IIcon cross_overlay;
	@SideOnly(Side.CLIENT)
	static private IIcon line_overlay;

	public ChristmasLightsBlock() {
		setBlockName("christmaslightsblock");
		setBlockTextureName("christmaslightsblock");
		// minX, minY, minZ, maxX, maxY, maxZ
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		

	}

	/*
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.isSideSolid(x - 1, y, z, EAST)
				|| world.isSideSolid(x + 1, y, z, WEST)
				|| world.isSideSolid(x, y, z - 1, SOUTH)
				|| world.isSideSolid(x, y, z + 1, NORTH);
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render. Default: 8388608
	 * changed to greenish
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		return 3394611;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ModItems.ChristmasLights;
	}

	private void func_150175_a(World world, int x, int y, int z,
			int p_150175_5_, int p_150175_6_, int p_150175_7_) {
		int k1 = world.getBlockMetadata(x, y, z);
		byte b0 = 0;
		int i3 = this.func_150178_a(world, p_150175_5_, p_150175_6_,
				p_150175_7_, b0);
		this.powered = false;
		int l1 = world.getStrongestIndirectPower(x, y, z);
		this.powered = true;

		if (l1 > 0 && l1 > i3 - 1) {
			i3 = l1;
		}

		int i2 = 0;

		for (int j2 = 0; j2 < 4; ++j2) {
			int k2 = x;
			int l2 = z;

			if (j2 == 0) {
				k2 = x - 1;
			}

			if (j2 == 1) {
				++k2;
			}

			if (j2 == 2) {
				l2 = z - 1;
			}

			if (j2 == 3) {
				++l2;
			}

			if (k2 != p_150175_5_ || l2 != p_150175_7_) {
				i2 = this.func_150178_a(world, k2, y, l2, i2);
			}

			if (world.getBlock(k2, y, l2).isNormalCube()
					&& !world.getBlock(x, y + 1, z).isNormalCube()) {
				if ((k2 != p_150175_5_ || l2 != p_150175_7_)
						&& y >= p_150175_6_) {
					i2 = this.func_150178_a(world, k2, y + 1, l2, i2);
				}
			} else if (!world.getBlock(k2, y, l2).isNormalCube()
					&& (k2 != p_150175_5_ || l2 != p_150175_7_)
					&& y <= p_150175_6_) {
				i2 = this.func_150178_a(world, k2, y - 1, l2, i2);
			}
		}

		if (i2 > i3) {
			i3 = i2 - 1;
		} else if (i3 > 0) {
			--i3;
		} else {
			i3 = 0;
		}

		if (l1 > i3 - 1) {
			i3 = l1;
		}

		if (k1 != i3) {
			world.setBlockMetadataWithNotify(x, y, z, i3, 2);
			this.hash.add(new ChunkPosition(x, y, z));
			this.hash.add(new ChunkPosition(x - 1, y, z));
			this.hash.add(new ChunkPosition(x + 1, y, z));
			this.hash.add(new ChunkPosition(x, y - 1, z));
			this.hash.add(new ChunkPosition(x, y + 1, z));
			this.hash.add(new ChunkPosition(x, y, z - 1));
			this.hash.add(new ChunkPosition(x, y, z + 1));
		}
	}

	private int func_150178_a(World world, int x, int y, int z, int meta) {
		if (world.getBlock(x, y, z) != this) {
			return meta;
		} else {
			int i1 = world.getBlockMetadata(x, y, z);
			return i1 > meta ? i1 : meta;
		}
	}

	private void func_150177_e(World world, int x, int y, int z) {
		this.func_150175_a(world, x, y, z, x, y, z);
		ArrayList arraylist = new ArrayList(this.hash);
		this.hash.clear();

		for (int l = 0; l < arraylist.size(); ++l) {
			ChunkPosition chunkposition = (ChunkPosition) arraylist.get(l);
			world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX,
					chunkposition.chunkPosY, chunkposition.chunkPosZ, this);
		}
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (!world.isRemote) {
			this.func_150177_e(world, x, y, z);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			this.func_150172_m(world, x - 1, y, z);
			this.func_150172_m(world, x + 1, y, z);
			this.func_150172_m(world, x, y, z - 1);
			this.func_150172_m(world, x, y, z + 1);

			if (world.getBlock(x - 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x - 1, y + 1, z);
			} else {
				this.func_150172_m(world, x - 1, y - 1, z);
			}

			if (world.getBlock(x + 1, y, z).isNormalCube()) {
				this.func_150172_m(world, x + 1, y + 1, z);
			} else {
				this.func_150172_m(world, x + 1, y - 1, z);
			}

			if (world.getBlock(x, y, z - 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z - 1);
			} else {
				this.func_150172_m(world, x, y - 1, z - 1);
			}

			if (world.getBlock(x, y, z + 1).isNormalCube()) {
				this.func_150172_m(world, x, y + 1, z + 1);
			} else {
				this.func_150172_m(world, x, y - 1, z + 1);
			}
		}
	}

	private void func_150172_m(World world, int x, int y, int z) {
		if (world.getBlock(x, y, z) == this) {
			world.notifyBlocksOfNeighborChange(x, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		}
	}

	@Override
	public int isProvidingStrongPower(IBlockAccess block, int x, int y, int z,
			int meta) {
		return 15;
	}

	@Override
	public int isProvidingWeakPower(IBlockAccess block, int x, int y, int z,
			int meta) {
		return 15;
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	@Override
	public boolean canProvidePower() {
		return false;
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		int l = world.getBlockMetadata(x, y, z);

		if (l > 0) {
			double d0 = (double) x + 0.5D
					+ ((double) random.nextFloat() - 0.5D) * 0.2D;
			double d1 = (double) ((float) y + 0.0625F);
			double d2 = (double) z + 0.5D
					+ ((double) random.nextFloat() - 0.5D) * 0.2D;
			float f = (float) l / 15.0F;
			float f1 = f * 0.6F + 0.4F;

			if (l == 0) {
				f1 = 0.0F;
			}

			float f2 = f * f * 0.7F - 0.5F;
			float f3 = f * f * 0.6F - 0.7F;

			if (f2 < 0.0F) {
				f2 = 0.0F;
			}

			if (f3 < 0.0F) {
				f3 = 0.0F;
			}
			/*
			 * TODO: add custom particle effect? world.spawnParticle("reddust",
			 * d0, d1, d2, (double)f1, (double)f2, (double)f3);
			 */

		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return ModItems.ChristmasLights;
	}
	/*
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.iconcross = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_cross");
		this.line = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_line");
		this.cross_overlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_cross_overlay");
		this.line_overlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_line_overlay");
		this.blockIcon = this.iconcross;
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		iconcross = icon.registerIcon(CraftFestMod.MODID + ":"
				+ getUnlocalizedName().substring(5) + "_cross");
		line = icon.registerIcon(CraftFestMod.MODID + ":"
				+ getUnlocalizedName().substring(5)  + "_line");
		cross_overlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ getUnlocalizedName().substring(5)  + "_cross_overlay");
		line_overlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ getUnlocalizedName().substring(5)  + "_line_overlay");
		blockIcon = iconcross;
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getRedstoneWireIcon(String str) {

		return str.equals("cross") ? iconcross : (str.equals("line") ? line
				: (str.equals("cross_overlay") ? cross_overlay : (str
						.equals("line_overlay") ? line_overlay : null)));
	}

}
