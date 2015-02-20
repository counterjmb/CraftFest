package com.craftfest.blocks.christmas;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChristmasTreePlanks extends Block{
	
	private IIcon icon;
	
	public ChristmasTreePlanks(){
		super(Material.wood);
		setCreativeTab(CraftFestMod.tabWinter);
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setBlockName("christmastreewood");
		setBlockTextureName(CraftFestMod.MODID + ":" + "christmastreeplanks");
		
	}
	



}
