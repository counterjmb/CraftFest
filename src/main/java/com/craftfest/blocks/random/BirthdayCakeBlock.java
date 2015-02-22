package com.craftfest.blocks.random;

import net.minecraft.block.BlockCake;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BirthdayCakeBlock extends BlockCake{
	

	
	public BirthdayCakeBlock(){
		
		super();
		setUnlocalizedName("birthdaycake");
		
		
		
	}
	

	
	@Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos)
    {
        return ModItems.BirthdayCakeItem;
    }

}
