package com.craftfest.items.ire;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.craftfest.CraftFestMod;

public class FourLeafClover extends Item{
	
	public FourLeafClover(){
		
		super();
		setUnlocalizedName("FourLeafClover");
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);

	}
	
	//action
	/*
	@Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target)
    {
		if(!target.worldObj.isRemote){
		player.addPotionEffect();
		}
        return false;
    }
    */

}
