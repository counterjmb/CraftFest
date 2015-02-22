package com.craftfest.items.ire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class GreenBeer extends ItemSoup{

	
	public GreenBeer(int hunger) {
		super(hunger);
		setUnlocalizedName("greenbeer");
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(64);

	}
	
	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
        super.onItemUseFinish(stack, world, player);
        return new ItemStack(ModItems.GlassMug);
    }

}
