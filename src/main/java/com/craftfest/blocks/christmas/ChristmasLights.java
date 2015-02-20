package com.craftfest.blocks.christmas;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChristmasLights extends BlockRedstoneWire {
	private boolean powered = true;
	private Set hash = new HashSet();
	@SideOnly(Side.CLIENT)
	private static IIcon icon_cross;
	@SideOnly(Side.CLIENT)
	private static IIcon icon_line;
	@SideOnly(Side.CLIENT)
	private static IIcon icon_crossoverlay;
	@SideOnly(Side.CLIENT)
	private static IIcon icone_lineoverlay;

	// TODO: Christmas lights block: fix it

	public ChristmasLights() {
		setBlockName("christmaslightsblock");
		setBlockTextureName("christmaslightsblock");
		// minX, minY, minZ, maxX, maxY, maxZ
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		setHardness(0.0F);
		setStepSound(soundTypeStone);
		disableStats();
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this
	 * box can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x,
			int y, int z) {
		return null;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 5;
	}

	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied
	 * against the blocks color. Note only called when first determining what to
	 * render. render. Default: 8388608 changed to greenish
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block, int x, int y, int z) {
		return 3394611;
	}

	/**
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

	public void breakBlock(World world, int x, int y, int z, Block blcok,
			int p_149749_6_) {
		super.breakBlock(world, x, y, z, blcok, p_149749_6_);

		if (!world.isRemote) {
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			this.func_150177_e(world, x, y, z);
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

	private int func_150178_a(World world, int x, int y, int z, int p_150178_5_) {
		if (world.getBlock(x, y, z) != this) {
			return p_150178_5_;
		} else {
			int i1 = world.getBlockMetadata(x, y, z);
			return i1 > p_150178_5_ ? i1 : p_150178_5_;
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which
	 * neighbor changed (coordinates passed are their own) Args: x, y, z,
	 * neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z,
			Block block) {
		if (!world.isRemote) {
			boolean flag = this.canPlaceBlockAt(world, x, y, z);

			if (flag) {
				this.func_150177_e(world, x, y, z);
			} else {
				this.dropBlockAsItem(world, x, y, z, 0, 0);
				world.setBlockToAir(x, y, z);
			}

			super.onNeighborBlockChange(world, x, y, z, block);
		}
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ModItems.ChristmasLights;
	}

	public int isProvidingStrongPower(IBlockAccess p_149748_1_,
			int p_149748_2_, int p_149748_3_, int p_149748_4_, int p_149748_5_) {
		return !this.powered ? 0 : this.isProvidingWeakPower(p_149748_1_,
				p_149748_2_, p_149748_3_, p_149748_4_, p_149748_5_);
	}

	public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_,
			int p_149709_3_, int p_149709_4_, int p_149709_5_) {
		if (!this.powered) {
			return 0;
		} else {
			int i1 = p_149709_1_.getBlockMetadata(p_149709_2_, p_149709_3_,
					p_149709_4_);

			if (i1 == 0) {
				return 0;
			} else if (p_149709_5_ == 1) {
				return i1;
			} else {
				boolean flag = func_150176_g(p_149709_1_, p_149709_2_ - 1,
						p_149709_3_, p_149709_4_, 1)
						|| !p_149709_1_.getBlock(p_149709_2_ - 1, p_149709_3_,
								p_149709_4_).isNormalCube()
						&& func_150176_g(p_149709_1_, p_149709_2_ - 1,
								p_149709_3_ - 1, p_149709_4_, -1);
				boolean flag1 = func_150176_g(p_149709_1_, p_149709_2_ + 1,
						p_149709_3_, p_149709_4_, 3)
						|| !p_149709_1_.getBlock(p_149709_2_ + 1, p_149709_3_,
								p_149709_4_).isNormalCube()
						&& func_150176_g(p_149709_1_, p_149709_2_ + 1,
								p_149709_3_ - 1, p_149709_4_, -1);
				boolean flag2 = func_150176_g(p_149709_1_, p_149709_2_,
						p_149709_3_, p_149709_4_ - 1, 2)
						|| !p_149709_1_.getBlock(p_149709_2_, p_149709_3_,
								p_149709_4_ - 1).isNormalCube()
						&& func_150176_g(p_149709_1_, p_149709_2_,
								p_149709_3_ - 1, p_149709_4_ - 1, -1);
				boolean flag3 = func_150176_g(p_149709_1_, p_149709_2_,
						p_149709_3_, p_149709_4_ + 1, 0)
						|| !p_149709_1_.getBlock(p_149709_2_, p_149709_3_,
								p_149709_4_ + 1).isNormalCube()
						&& func_150176_g(p_149709_1_, p_149709_2_,
								p_149709_3_ - 1, p_149709_4_ + 1, -1);

				if (!p_149709_1_.getBlock(p_149709_2_, p_149709_3_ + 1,
						p_149709_4_).isNormalCube()) {
					if (p_149709_1_.getBlock(p_149709_2_ - 1, p_149709_3_,
							p_149709_4_).isNormalCube()
							&& func_150176_g(p_149709_1_, p_149709_2_ - 1,
									p_149709_3_ + 1, p_149709_4_, -1)) {
						flag = true;
					}

					if (p_149709_1_.getBlock(p_149709_2_ + 1, p_149709_3_,
							p_149709_4_).isNormalCube()
							&& func_150176_g(p_149709_1_, p_149709_2_ + 1,
									p_149709_3_ + 1, p_149709_4_, -1)) {
						flag1 = true;
					}

					if (p_149709_1_.getBlock(p_149709_2_, p_149709_3_,
							p_149709_4_ - 1).isNormalCube()
							&& func_150176_g(p_149709_1_, p_149709_2_,
									p_149709_3_ + 1, p_149709_4_ - 1, -1)) {
						flag2 = true;
					}

					if (p_149709_1_.getBlock(p_149709_2_, p_149709_3_,
							p_149709_4_ + 1).isNormalCube()
							&& func_150176_g(p_149709_1_, p_149709_2_,
									p_149709_3_ + 1, p_149709_4_ + 1, -1)) {
						flag3 = true;
					}
				}

				return !flag2 && !flag1 && !flag && !flag3 && p_149709_5_ >= 2
						&& p_149709_5_ <= 5 ? i1 : (p_149709_5_ == 2 && flag2
						&& !flag && !flag1 ? i1 : (p_149709_5_ == 3 && flag3
						&& !flag && !flag1 ? i1 : (p_149709_5_ == 4 && flag
						&& !flag2 && !flag3 ? i1 : (p_149709_5_ == 5 && flag1
						&& !flag2 && !flag3 ? i1 : 0))));
			}
		}
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this
	 * change based on its state.
	 */
	public boolean canProvidePower() {
		return this.powered;
	}

	/**
	 * Returns true if redstone wire can connect to the specified block. Params:
	 * World, X, Y, Z, side (not a normal notch-side, this can be 0, 1, 2, 3 or
	 * -1)
	 */
	public static boolean isPowerProviderOrWire(IBlockAccess blockaccess,
			int x, int y, int z, int p_150174_4_) {
		Block block = blockaccess.getBlock(x, y, z);

		if (block == Blocks.redstone_wire) {
			return true;
		} else if (!Blocks.unpowered_repeater.func_149907_e(block)) {
			return block.canConnectRedstone(blockaccess, x, y, z, p_150174_4_);
		} else {
			int i1 = blockaccess.getBlockMetadata(x, y, z);
			return p_150174_4_ == (i1 & 3)
					|| p_150174_4_ == Direction.rotateOpposite[i1 & 3];
		}
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_,
			int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
		int l = p_149734_1_.getBlockMetadata(p_149734_2_, p_149734_3_,
				p_149734_4_);

		if (l > 0) {
			double d0 = (double) p_149734_2_ + 0.5D
					+ ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
			double d1 = (double) ((float) p_149734_3_ + 0.0625F);
			double d2 = (double) p_149734_4_ + 0.5D
					+ ((double) p_149734_5_.nextFloat() - 0.5D) * 0.2D;
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
			// TODO: Christmas Lights Block: add custom particle
			p_149734_1_.spawnParticle("reddust", d0, d1, d2, (double) f1,
					(double) f2, (double) f3);
		}
	}

	public static boolean func_150176_g(IBlockAccess p_150176_0_,
			int p_150176_1_, int p_150176_2_, int p_150176_3_, int p_150176_4_) {
		if (isPowerProviderOrWire(p_150176_0_, p_150176_1_, p_150176_2_,
				p_150176_3_, p_150176_4_)) {
			return true;
		} else if (p_150176_0_.getBlock(p_150176_1_, p_150176_2_, p_150176_3_) == Blocks.powered_repeater) {
			int i1 = p_150176_0_.getBlockMetadata(p_150176_1_, p_150176_2_,
					p_150176_3_);
			return p_150176_4_ == (i1 & 3);
		} else {
			return false;
		}
	}

	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_,
			int p_149694_4_) {
		return ModItems.ChristmasLights;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.icon_cross = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_" + "cross");
		this.icon_line = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_" + "line");
		this.icon_crossoverlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_" + "cross_overlay");
		this.icone_lineoverlay = icon.registerIcon(CraftFestMod.MODID + ":"
				+ this.getTextureName() + "_" + "line_overlay");
		this.blockIcon = this.icon_cross;
	}

	@SideOnly(Side.CLIENT)
	public static IIcon getRedstoneWireIcon(String str) {
		return str.equals("cross") ? ChristmasLights.icon_cross
				: (str.equals("line") ? ChristmasLights.icon_line
						: (str.equals("cross_overlay") ? ChristmasLights.icon_crossoverlay
								: (str.equals("line_overlay") ? ChristmasLights.icone_lineoverlay
										: null)));
	}
}