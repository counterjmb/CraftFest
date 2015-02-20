package com.craftfest.blocks.christmas;

import java.util.Random;

import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FrostedGlass extends BlockGlass{
	
	public FrostedGlass(){
		super(Material.glass, false);
		setBlockName("frostedglassblock");
		//setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		setStepSound(soundTypeGlass);
		setHardness(0.3F);
		setResistance(0.3F);
	}
	
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(CraftFestMod.MODID + ":" + "frostedglassblock");
    }

}
