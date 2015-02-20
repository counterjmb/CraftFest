package com.craftfest.items.christmas;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

public class FurArmor extends ItemArmor{
	
	public FurArmor(ArmorMaterial material, int armorType, String name){
		
		super(material, 0, armorType);
		setUnlocalizedName(name);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModItems.FurHelm ||
				stack.getItem() == ModItems.FurChest ||
				stack.getItem() == ModItems.FurBoots ){
			return CraftFestMod.MODID + ":models/armor/furarmor1.png";
		}
		else if(stack.getItem() == ModItems.Furlegs)
		{
			return CraftFestMod.MODID + ":models/armor/furarmor2.png";
		}
		else{
			
			//add log issue
		
		    return null;
		}
	}

}
