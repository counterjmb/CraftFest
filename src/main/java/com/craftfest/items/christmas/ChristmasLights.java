package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemRedstone;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ChristmasLights extends ItemRedstone {
	
	public ChristmasLights(){
		setCreativeTab(CraftFestMod.tabWinter);
		setTextureName(CraftFestMod.MODID + ":christmaslights");
		setUnlocalizedName("christmaslights");
			
	}
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (world.getBlock(x, y, z) != Blocks.snow_layer)
        {
            if (p_77648_7_ == 0)
            {
                --y;
            }

            if (p_77648_7_ == 1)
            {
                ++y;
            }

            if (p_77648_7_ == 2)
            {
                --z;
            }

            if (p_77648_7_ == 3)
            {
                ++z;
            }

            if (p_77648_7_ == 4)
            {
                --x;
            }

            if (p_77648_7_ == 5)
            {
                ++x;
            }

            if (!world.isAirBlock(x, y, z))
            {
                return false;
            }
        }

        if (!player.canPlayerEdit(x, y, z, p_77648_7_, stack))
        {
            return false;
        }
        else
        {	
            if (ModBlocks.ChristmasLights.canPlaceBlockAt(world, x, y, z))
            {
                --stack.stackSize;
                world.setBlock(x, y, z, ModBlocks.ChristmasLights);
            }
			
            return true;
        }
    }

}
