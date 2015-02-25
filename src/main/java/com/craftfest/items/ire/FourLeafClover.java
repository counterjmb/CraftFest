package com.craftfest.items.ire;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class FourLeafClover extends Item {

	public FourLeafClover() {

		setUnlocalizedName("fourleafclover");
		setCreativeTab(CraftFestMod.tabSpring);

	}

	// TODO: FourLeafClover: add action to item?
	/*
	 * @Override public boolean itemInteractionForEntity(ItemStack stack,
	 * EntityPlayer player, EntityLivingBase target) {
	 * if(!target.worldObj.isRemote){ player.addPotionEffect(); } return false;
	 * }
	 */

}
