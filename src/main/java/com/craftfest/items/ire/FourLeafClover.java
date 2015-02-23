package com.craftfest.items.ire;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class FourLeafClover extends Item{
	
	public FourLeafClover(){
		
		super();
		setUnlocalizedName("FourLeafClover");
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
