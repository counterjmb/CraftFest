package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class SantaArmor extends ItemArmor{
	public SantaArmor(ArmorMaterial material, int armorType, String name){
		
		super(material, 0, armorType);
		setUnlocalizedName(name);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModItems.SantaHat
			//||
			//stack.getItem() == ModItems.GhostChest ||
			//stack.getItem() == ModItems.GhostBoots	
				){
			return CraftFestMod.MODID + ":models/armor/santaarmor.png";
		}
		/*
		else if(stack.getItem() == ModItems.GhostLegs)
		{
			return CraftFestMod.MODID + ":models/armor/ghostarmor2.png";
		}*/
		else{
			
		
		    return null;
		}
	}

}
