package com.craftfest.items.ire;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemSoup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class GreenBeer extends ItemSoup {

	public GreenBeer(int hunger) {
		super(hunger);
		setUnlocalizedName("greenbeer");
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
        
		return new ItemStack(ModItems.GlassMug);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}
	
   

}
