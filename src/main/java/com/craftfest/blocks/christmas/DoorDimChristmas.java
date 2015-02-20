package com.craftfest.blocks.christmas;
//https://github.com/Shinoow/AbyssalCraft/blob/c4b89b16adcca68709cf4093d4e04c52c5805d78/src/main/java/com/shinoow/abyssalcraft/common/blocks/BlockAbyssPortal.java
import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.handler.DimTeleporter;
import com.craftfest.items.ModItems;
import com.craftfest.world.Dimensions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DoorDimChristmas extends BlockDoor {

	@SideOnly(Side.CLIENT)
	private IIcon[] upper;
	@SideOnly(Side.CLIENT)
	private IIcon[] lower;

	public DoorDimChristmas() {
		super(Material.wood);
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
		this.setBlockName("christmasdoor");
		disableStats();
		setBlockTextureName("christmasdoor");

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.upper = new IIcon[2];
		this.lower = new IIcon[2];
		this.upper[0] = icon.registerIcon(CraftFestMod.MODID + ":" + this.getTextureName() + "_upper");
		this.lower[0] = icon.registerIcon(CraftFestMod.MODID + ":" + this.getTextureName() + "_lower");
		this.upper[1] = new IconFlipped(this.upper[0], true, false);
		this.lower[1] = new IconFlipped(this.lower[0], true, false);
		
		
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {

		return this.lower[0];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_,
			int p_149673_3_, int p_149673_4_, int p_149673_5_) {

		if (p_149673_5_ != 1 && p_149673_5_ != 0) {
			int i1 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_,
					p_149673_4_);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag) {
				if (j1 == 0 && p_149673_5_ == 2) {
					flag1 = !flag1;
				} else if (j1 == 1 && p_149673_5_ == 5) {
					flag1 = !flag1;
				} else if (j1 == 2 && p_149673_5_ == 3) {
					flag1 = !flag1;
				} else if (j1 == 3 && p_149673_5_ == 4) {
					flag1 = !flag1;
				}
			} else {
				if (j1 == 0 && p_149673_5_ == 5) {
					flag1 = !flag1;
				} else if (j1 == 1 && p_149673_5_ == 3) {
					flag1 = !flag1;
				} else if (j1 == 2 && p_149673_5_ == 4) {
					flag1 = !flag1;
				} else if (j1 == 3 && p_149673_5_ == 2) {
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0) {
					flag1 = !flag1;
				}
			}

			return flag2 ? this.upper[flag1 ? 1 : 0]
					: this.lower[flag1 ? 1 : 0];
		} else {
			return this.lower[0];
		}
	}



	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	@Override
	public void onBlockClicked(World p_149699_1_, int p_149699_2_,
			int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
	}

	@Override
	public Item getItemDropped(int meta, Random random, int j) {

		return ModItems.ChristmasDoorItem;
	}


	/**
	 * Checks to see if its valid to put this block at the specified
	 * coordinates. Args: world, x, y, z
	 */
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {

		if (y >= 255)
			return false;

		return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z)
				&& (world.getBlock(x, y, z) == Blocks.air)
				&& (world.getBlock(x, y + 1, z) == Blocks.air);

		/*
		 * return y >= world.getHeight() - 1 ? false : World
		 * .doesBlockHaveSolidTopSurface(world, x, y - 1, z) &&
		 * super.canPlaceBlockAt(world, x, y, z) && super.canPlaceBlockAt(world,
		 * x, y + 1, z);
		 */
	}




	/**
	 * Gets an item for the block being called on. Args: world, x, y, z
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World wolrd, int x, int y, int z) {
		return ModItems.ChristmasDoorItem;
	}

	
	//Dimension stuff
	public void onEntityCollideWithBlock(World world, int x, int y, int z, Entity entity){
		/*if(entity instanceof EntityPlayer) {
			entity.travelToDimension(Dimensions.christmasDimID);	}		
		
		if(world.isRemote){
			return;
		}
		*/
		

		if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP)
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
			//achievement
			//thePlayer.addStat(AbyssalCraft.enterabyss, 1);
			if (thePlayer.timeUntilPortal > 0)
				thePlayer.timeUntilPortal = 10;
			else if (thePlayer.dimension != Dimensions.christmasDimID)
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Dimensions.christmasDimID, new DimTeleporter(thePlayer.mcServer.worldServerForDimension(Dimensions.christmasDimID)));
			}
			else {
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new DimTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
		
	}
	
	

}
