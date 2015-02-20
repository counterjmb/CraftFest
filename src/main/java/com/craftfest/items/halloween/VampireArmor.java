package com.craftfest.items.halloween;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class VampireArmor extends ItemArmor {
	
	public VampireArmor(ArmorMaterial material, int armorType, String name){
		
		super(material, 0, armorType);
		setUnlocalizedName(name);
		setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		
		if(stack.getItem() == ModItems.VampireHelm ||
			stack.getItem() == ModItems.VampireChest ||
			stack.getItem() == ModItems.VampireBoots	){
			return CraftFestMod.MODID + ":models/armor/vampirearmor1.png";
		}
		else if(stack.getItem() == ModItems.VampireLegs)
		{
			return CraftFestMod.MODID + ":models/armor/vampirearmor2.png";
		}
		else{
			
		
		    return null;
		}
	}

}
