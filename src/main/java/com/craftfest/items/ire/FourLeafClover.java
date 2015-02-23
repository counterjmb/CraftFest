package com.craftfest.items.ire;

import net.minecraft.item.Item;

import com.craftfest.CraftFestMod;

public class FourLeafClover extends Item{
	
	private final String name = "FourLeafClover";
	
	public FourLeafClover(){
		
		super();
		setUnlocalizedName(CraftFestMod.MODID + "_" + "FourLeafClover");
		setCreativeTab(CraftFestMod.tabSpring);

	}
	
	public String getName() {
		return name;
	}

	//TODO: FourLeafClover: add action to item?
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
