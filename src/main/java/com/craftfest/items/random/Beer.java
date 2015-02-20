package com.craftfest.items.random;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Beer extends ItemSoup{
	public Beer(int hunger) {
		super(hunger);
		setUnlocalizedName("beer");
		setCreativeTab(CraftFestMod.tabSpring);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setMaxStackSize(64);

	}
	
	@Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        super.onEaten(stack, world, player);
        return new ItemStack(ModItems.GlassMug);
    }


}
