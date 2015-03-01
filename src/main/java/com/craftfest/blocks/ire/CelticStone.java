package com.craftfest.blocks.ire;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import com.craftfest.CraftFestMod;

public class CelticStone extends Block {
	
	public CelticStone(){
		super(Material.rock);
		setUnlocalizedName("celticstone");
		setCreativeTab(CraftFestMod.tabSpring);
		setStepSound(soundTypeStone);
		setHardness(2.0F);
		setResistance(10.0F);

	}
	
    public static Block getBlockFromItem(Item item)
    {
        return item instanceof ItemBlock ? ((ItemBlock)item).getBlock() : null;
    }


}
