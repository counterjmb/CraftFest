package com.craftfest.items.random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.init.RandomItems;

public class Beer extends ItemSoup {

	public Beer(int hunger) {
		super(hunger);
		setUnlocalizedName("beer");
		setCreativeTab(CraftFestMod.tabSpring);
		setMaxStackSize(64);

	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world,
			EntityPlayer player) {
		super.onItemUseFinish(stack, world, player);
		
        if (!world.isRemote)
        {
        	player.addPotionEffect(new PotionEffect(Potion.confusion.id, 1));

        	
        }
        
		return new ItemStack(RandomItems.GlassMug);
	}

	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

}
