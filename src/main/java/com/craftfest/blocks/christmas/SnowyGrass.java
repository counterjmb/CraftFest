package com.craftfest.blocks.christmas;

import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.world.ColorizerGrass;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SnowyGrass extends BlockGrass implements IGrowable {

	
	//TODO: SnowyGrass: create customer grass renderer
	//TODO: SnowyGrass: cannot place plants on yet. 

	public SnowyGrass() {
		
		setBlockName("snowygrass");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		setHardness(0.5F);
		setResistance(0.5F);

	}
	
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double d0 = 0.0D;
        double d1 = 0.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }
	


}
