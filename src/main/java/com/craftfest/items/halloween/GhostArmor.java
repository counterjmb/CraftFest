package com.craftfest.items.halloween;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class GhostArmor extends ItemArmor{
	
	public GhostArmor(ArmorMaterial material, int armorType, String name){
		
		super(material, 0, armorType);
		setUnlocalizedName(name);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModItems.GhostHelm ||
			stack.getItem() == ModItems.GhostChest ||
			stack.getItem() == ModItems.GhostBoots	){
			return CraftFestMod.MODID + ":models/armor/ghostarmor1.png";
		}
		else if(stack.getItem() == ModItems.GhostLegs)
		{
			return CraftFestMod.MODID + ":models/armor/ghostarmor2.png";
		}
		else{
			
		
		    return null;
		}
	}


}
