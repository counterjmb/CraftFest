package com.craftfest.items.random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class Beer extends ItemSoup{
	public Beer(int hunger) {
		super(hunger);
		setUnlocalizedName("beer");
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
