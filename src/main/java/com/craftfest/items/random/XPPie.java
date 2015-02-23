package com.craftfest.items.random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;

public class XPPie extends ItemFood {

	private boolean alwaysEdible;
	private final String name = "xppie";

	public XPPie() {

		super(2, 2.0F, false);
		setUnlocalizedName(CraftFestMod.MODID + "_" + "xppie");
		setCreativeTab(CraftFestMod.tabSpring);

		this.alwaysEdible = true;

	}

	public String getName() {
		return name;
	}

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
		player.addExperienceLevel(3);
		--stack.stackSize;
		player.getFoodStats().addStats(this, stack);
		world.playSoundAtEntity(player, "random.burp", 0.5F,
				world.rand.nextFloat() * 0.1F + 0.9F);
		this.onFoodEaten(stack, world, player);
		return stack;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack stack, World world,
			EntityPlayer player) {
		if (player.canEat(this.alwaysEdible)) {
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}

		return stack;
	}

}
