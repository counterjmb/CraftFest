package com.craftfest.blocks.christmas;

import java.util.Random;

import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BarrelOfCookies extends BlockCauldron {

	@SideOnly(Side.CLIENT)
	private IIcon inner;
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon bottom;

	public BarrelOfCookies() {
		setBlockName("barrelofcookies");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		this.setHardness(5.0F);
		setStepSound(soundTypeWood);
	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? this.top
				: (side == 0 ? this.bottom : this.blockIcon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		this.inner = icon.registerIcon(this.getTextureName() + "_" + "inner");
		this.top = icon.registerIcon(this.getTextureName() + "_top");
		this.bottom = icon.registerIcon(this.getTextureName() + "_" + "bottom");
		this.blockIcon = icon.registerIcon(this.getTextureName() + "_side");
	}



	/**
	 * Called when a player hits the block. Args: world, x, y, z, player
	 */
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){ 

		if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)
				|| Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			ItemStack stack = new ItemStack(Items.cookie, 64);
			player.inventory.addItemStackToInventory(stack);
			return true;
		} else {
			ItemStack stack = new ItemStack(Items.cookie, 1);
			player.inventory.addItemStackToInventory(stack);
			return true;
		}
		

	}
	
    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.BarrelOfCookies;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ModItems.BarrelOfCookies;
    }

}
