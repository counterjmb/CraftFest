package com.craftfest.blocks.random;

import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BirthdayCakeBlock extends BlockCake{
	
    @SideOnly(Side.CLIENT)
    private IIcon field_150038_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150039_M;
    @SideOnly(Side.CLIENT)
    private IIcon field_150037_b;
	
	public BirthdayCakeBlock(){
		
		super();
		setBlockName("birthdaycake");
		
		
		
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150038_a : (p_149691_1_ == 0 ? this.field_150037_b : (p_149691_2_ > 0 && p_149691_1_ == 4 ? this.field_150039_M : this.blockIcon));
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getUnlocalizedName() + "_side");
        this.field_150039_M = p_149651_1_.registerIcon(this.getUnlocalizedName() +"_inner");
        this.field_150038_a = p_149651_1_.registerIcon(this.getUnlocalizedName() +"_top");
        this.field_150037_b = p_149651_1_.registerIcon(this.getUnlocalizedName() +"_bottom");
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ModItems.BirthdayCakeItem;
    }

}
