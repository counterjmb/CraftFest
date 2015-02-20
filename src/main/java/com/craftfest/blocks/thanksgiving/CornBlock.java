package com.craftfest.blocks.thanksgiving;

import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class CornBlock extends BlockCrops {
	
	public CornBlock(){
		super();
		this.setBlockName("corn");
		this.setBlockTextureName("cornblock");	
	}
	
	
	
	private IIcon[] icon;
	
	@Override
    protected Item func_149866_i()
    {
        return ModItems.CornItem;
    }
	
	@Override
    protected Item func_149865_P()
    {
        return ModItems.CornItem;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.icon = new IIcon[8];

        for (int i = 0; i < this.icon.length; ++i)
        {
            this.icon[i] = p_149651_1_.registerIcon(this.getTextureName() + "_stage_" + i);
        }
    }

}
