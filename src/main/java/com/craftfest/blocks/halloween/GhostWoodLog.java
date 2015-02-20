package com.craftfest.blocks.halloween;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GhostWoodLog extends BlockLog {
	
    @SideOnly(Side.CLIENT)
    private IIcon[] icon = {null, null};
    
	public GhostWoodLog(){
		setCreativeTab(CraftFestMod.tabFall);
		setBlockName("ghostwoodlog");

	}
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister iconRegister)
	    {
	    	
	        icon[0] = iconRegister.registerIcon(CraftFestMod.MODID + ":ghostwoodlog");
	        icon[1] = iconRegister.registerIcon(CraftFestMod.MODID + ":ghostwoodlog_top");
	        
	       
	    }
		
		@SideOnly(Side.CLIENT)
	    protected IIcon getSideIcon(int p_150163_1_)
	    {
	        return icon[0];
	    }

	    @SideOnly(Side.CLIENT)
	    protected IIcon getTopIcon(int p_150161_1_)
	    {
	        return icon[1];
	    }
	    

}
