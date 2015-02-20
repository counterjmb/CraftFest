package com.craftfest.blocks.christmas;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class ChristmasTreeLeaves extends BlockLeaves {
	
    @SideOnly(Side.CLIENT)
    private IIcon icon;

	public ChristmasTreeLeaves(){
		super();
		setBlockName("christmastreeleaves");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		
	}
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister iconRegister)
	    {
	    	
	        icon = iconRegister.registerIcon(CraftFestMod.MODID + ":christmastreeleaves");
    
	       
	    }
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		
		return icon;
	}

	@Override
	public String[] func_150125_e() {
		return null;
	}
	

}
