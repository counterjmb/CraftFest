package com.craftfest.blocks.random;

import net.minecraft.block.BlockCake;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;



public class BirthdayCakeBlock extends BlockCake{
	

	
	public BirthdayCakeBlock(){
		
		super();
		setUnlocalizedName("birthdaycake");
		setCreativeTab(CraftFestMod.tabSpring);
		
		
	}
	

	
	@Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos)
    {
        return ModItems.BirthdayCakeItem;
    }

}
