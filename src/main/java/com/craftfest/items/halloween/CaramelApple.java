package com.craftfest.items.halloween;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;

public class CaramelApple extends ItemSoup{
	
	public CaramelApple(int hunger) {
		super(hunger);
		setCreativeTab(CraftFestMod.tabSpring);
		setUnlocalizedName("caramelapple");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setMaxStackSize(64);

	}
	
	@Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        super.onEaten(stack, world, player);
        return new ItemStack(Items.stick);
    }

}
