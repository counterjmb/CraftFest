package com.craftfest.items.christmas;

import com.craftfest.CraftFestMod;
import com.craftfest.entity.items.EntityOrnaments;

import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class Ornaments extends ItemHangingEntity{
	
	
	//to add more types. change enum in entity ornaments class

	public Ornaments() {
		super(EntityOrnaments.class);
		setCreativeTab(CraftFestMod.tabWinter);
		this.setUnlocalizedName("ornament");
		this.setTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ == 0)
        {
            return false;
        }
        else if (p_77648_7_ == 1)
        {
            return false;
        }
        else
        {
            int i1 = Direction.facingToDirection[p_77648_7_];
            EntityOrnaments entityhanging = this.createHangingEntity(world, x, y, z, i1);

            if (!player.canPlayerEdit(x, y, z, p_77648_7_, stack))
            {
                return false;
            }
            else
            {
                if (entityhanging != null && entityhanging.onValidSurface())
                {
                    if (!world.isRemote)
                    {
                        world.spawnEntityInWorld(entityhanging);
                    }

                    --stack.stackSize;
                }

                return true;
            }
        }
    }

    /**
     * Create the hanging entity associated to this item.
     */
    private EntityOrnaments createHangingEntity(World world, int x, int y, int p_82810_4_, int p_82810_5_)
    {
        return new EntityOrnaments(world, x, y, p_82810_4_, p_82810_5_);
    }
	

}
