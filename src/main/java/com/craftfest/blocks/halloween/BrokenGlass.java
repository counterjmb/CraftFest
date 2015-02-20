package com.craftfest.blocks.halloween;

import java.util.Random;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BrokenGlass extends BlockGlass {
	
	public BrokenGlass(){
		super(Material.glass, false);
		setBlockName("brokenglass");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabFall);
		setStepSound(soundTypeGlass);
		setHardness(0.3F);
		setResistance(0.3F);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(CraftFestMod.MODID + ":" + "brokenglassblock");
    }

	

}
