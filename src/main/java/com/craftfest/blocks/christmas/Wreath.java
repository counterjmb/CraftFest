package com.craftfest.blocks.christmas;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.entity.blocks.WreathTileEntity;

public class Wreath extends BlockContainer {
	
	public Wreath(){
		
		super(Material.grass);
		setBlockName("wreath");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName());
		setCreativeTab(CraftFestMod.tabWinter);
		setStepSound(soundTypeGrass);
		setHardness(0.5F);
		setResistance(0.5F);
		setLightLevel(7);
			
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {

		return new WreathTileEntity();
	}

        
    @Override
    public int getRenderType() {
            return -1;
    }
    
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    //This is the icon to use for showing the block in your hand.
    public void registerIcons(IIconRegister icon) {
            this.blockIcon = icon.registerIcon(CraftFestMod.MODID + ":" + getUnlocalizedName());
    }

}
