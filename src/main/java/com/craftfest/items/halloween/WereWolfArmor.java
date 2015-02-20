package com.craftfest.items.halloween;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class WereWolfArmor extends ItemArmor {
	
	public WereWolfArmor(ArmorMaterial material, int armorType, String name){
		
		super(material, 0, armorType);
		setUnlocalizedName(name);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModItems.WereWolfHelm ||
			stack.getItem() == ModItems.WereWolfChest ||
			stack.getItem() == ModItems.WereWolfBoots	){
			return CraftFestMod.MODID + ":models/armor/werewolfarmor1.png";
		}
		else if(stack.getItem() == ModItems.WereWolfLegs)
		{
			return CraftFestMod.MODID + ":models/armor/werewolfarmor2.png";
		}
		else{
			
		
		    return null;
		}
	}

}
