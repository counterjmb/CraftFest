package com.craftfest.blocks.ire;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.craftfest.blocks.ModBlocks;
import com.craftfest.world.Dimensions;
import com.craftfest.world.ModTeleporter;

public class IrePortal extends BlockPortal {
	
	public static final PropertyEnum AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class, new EnumFacing.Axis[] {EnumFacing.Axis.X, EnumFacing.Axis.Z});

	public IrePortal() {
		super();
		setDefaultState(this.blockState.getBaseState().withProperty(AXIS,EnumFacing.Axis.X));
		setTickRandomly(true);
		setUnlocalizedName("ireportal");
		
	}


	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
			EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
			int dimensionID = Dimensions.IreDimentionID;
			Block blockFrame = ModBlocks.CelticStone;
			if(thePlayer.timeUntilPortal > 0) 
				thePlayer.timeUntilPortal = 10;
			else if(thePlayer.dimension != dimensionID) {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimensionID, new ModTeleporter(thePlayer.mcServer.worldServerForDimension(dimensionID), dimensionID, this, blockFrame));

			} else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new ModTeleporter(thePlayer.mcServer.worldServerForDimension(0), 0, this, blockFrame));
			}
		}
	}
	
    public boolean func_176548_d(World world, BlockPos pos)
    {
        IrePortal.Size size = new IrePortal.Size(world, pos, EnumFacing.Axis.X);

        if (size.func_150860_b() && size.field_150864_e == 0)
        {
            size.func_150859_c();
            return true;
        }
        else
        {
        	IrePortal.Size size1 = new IrePortal.Size(world, pos, EnumFacing.Axis.Z);

            if (size1.func_150860_b() && size1.field_150864_e == 0)
            {
                size1.func_150859_c();
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        EnumFacing.Axis axis = (EnumFacing.Axis)state.getValue(AXIS);
        IrePortal.Size size;

        if (axis == EnumFacing.Axis.X)
        {
            size = new IrePortal.Size(worldIn, pos, EnumFacing.Axis.X);

            if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)
            {
                worldIn.setBlockState(pos, Blocks.air.getDefaultState());
            }
        }
        else if (axis == EnumFacing.Axis.Z)
        {
            size = new IrePortal.Size(worldIn, pos, EnumFacing.Axis.Z);

            if (!size.func_150860_b() || size.field_150864_e < size.field_150868_h * size.field_150862_g)
            {
                worldIn.setBlockState(pos, Blocks.air.getDefaultState());
            }
        }
    }

	public static class Size {
		private final World world;
		private final EnumFacing.Axis axis;
		private final EnumFacing facing1;
		private final EnumFacing facing2;
		private int field_150864_e = 0;
		private BlockPos pos;
		private int field_150862_g;
		private int field_150868_h;


		public Size(World world, BlockPos pos, EnumFacing.Axis axis) {
			this.world = world;
			this.axis = axis;

			if (axis == EnumFacing.Axis.X) {
				this.facing2 = EnumFacing.EAST;
				this.facing1 = EnumFacing.WEST;
			} else {
				this.facing2 = EnumFacing.NORTH;
				this.facing1 = EnumFacing.SOUTH;
			}

			for (BlockPos blockpos1 = pos; pos.getY() > blockpos1.getY() - 21
					&& pos.getY() > 0
					&& this.func_150857_a(world.getBlockState(pos.down())
							.getBlock()); pos = pos.down()) {
				;
			}

			int i = this.func_180120_a(pos, this.facing2) - 1;

			if (i >= 0) {
				this.pos = pos.offset(this.facing2, i);
				this.field_150868_h = this
						.func_180120_a(this.pos, this.facing1);

				if (this.field_150868_h < 2 || this.field_150868_h > 21) {
					this.pos = null;
					this.field_150868_h = 0;
				}
			}

			if (this.pos != null) {
				this.field_150862_g = this.func_150858_a();
			}
		}

		protected int func_180120_a(BlockPos pos, EnumFacing facing) {
			int i;

			for (i = 0; i < 22; ++i) {
				BlockPos blockpos1 = pos.offset(facing, i);

				if (!this.func_150857_a(this.world.getBlockState(blockpos1)
						.getBlock())
						|| this.world.getBlockState(blockpos1.down())
								.getBlock() != ModBlocks.CelticStone) {
					break;
				}
			}

			Block block = this.world.getBlockState(pos.offset(facing, i))
					.getBlock();
			return block == ModBlocks.CelticStone ? i : 0;
		}

		protected int func_150858_a() {
			int i;
			label56:

			for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g) {
				for (i = 0; i < this.field_150868_h; ++i) {
					BlockPos blockpos = this.pos.offset(this.facing1, i).up(
							this.field_150862_g);
					Block block = this.world.getBlockState(blockpos).getBlock();

					if (!this.func_150857_a(block)) {
						break label56;
					}

					if (block == ModBlocks.IrePortal) {
						++this.field_150864_e;
					}

					if (i == 0) {
						block = this.world.getBlockState(
								blockpos.offset(this.facing2)).getBlock();

						if (block != ModBlocks.CelticStone) {
							break label56;
						}
					} else if (i == this.field_150868_h - 1) {
						block = this.world.getBlockState(
								blockpos.offset(this.facing1)).getBlock();

						if (block != ModBlocks.CelticStone) {
							break label56;
						}
					}
				}
			}

			for (i = 0; i < this.field_150868_h; ++i) {
				if (this.world.getBlockState(
						this.pos.offset(this.facing1, i)
								.up(this.field_150862_g)).getBlock() != ModBlocks.CelticStone) {
					this.field_150862_g = 0;
					break;
				}
			}

			if (this.field_150862_g <= 21 && this.field_150862_g >= 3) {
				return this.field_150862_g;
			} else {
				this.pos = null;
				this.field_150868_h = 0;
				this.field_150862_g = 0;
				return 0;
			}
		}

		protected boolean func_150857_a(Block block) {
			return block.getMaterial() == Material.air || block == Blocks.fire || block == ModBlocks.IrePortal;
		}

		public boolean func_150860_b() {
			return this.pos != null && this.field_150868_h >= 2
					&& this.field_150868_h <= 21 && this.field_150862_g >= 3
					&& this.field_150862_g <= 21;
		}

		public void func_150859_c() {
			for (int i = 0; i < this.field_150868_h; ++i) {
				BlockPos blockpos = this.pos.offset(this.facing1, i);

				for (int j = 0; j < this.field_150862_g; ++j) {
					this.world.setBlockState(
							blockpos.up(j),
							ModBlocks.IrePortal.getDefaultState().withProperty(
									IrePortal.AXIS, this.axis), 2);
				}
			}
		}
	}

}
