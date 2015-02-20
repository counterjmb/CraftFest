package com.craftfest.blocks.valentines;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PinkGrass extends BlockGrass {
	
	//TODO: PinkGrass: create customer grass renderer
	//TODO: PinkGrass: cannot place plants on yet. 
	
	public PinkGrass() {
		
		setBlockName("pinkgrass");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabSpring);
		setStepSound(soundTypeGrass);
		setHardness(0.5F);
		setResistance(0.5F);
	}
	



	

}
