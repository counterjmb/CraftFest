package com.craftfest.blocks.christmas;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockCauldron;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BarrelOfMilk extends BlockCauldron {
	
    @SideOnly(Side.CLIENT)
    private IIcon inner;
    @SideOnly(Side.CLIENT)
    private IIcon top;
    @SideOnly(Side.CLIENT)
    private IIcon bottom;

	
	
	public BarrelOfMilk(){
		setBlockName("barrelofmilk");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
		setStepSound(soundTypeWood);
		this.setHardness(5.0F);
		
	}
	
	   /**
     * Gets the block's texture. Args: side, meta
     */
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? this.top : (side == 0 ? this.bottom : this.blockIcon);
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.inner = icon.registerIcon(this.getTextureName() + "_" + "inner");
        this.top = icon.registerIcon(this.getTextureName() + "_top");
        this.bottom = icon.registerIcon(this.getTextureName() + "_" + "bottom");
        this.blockIcon = icon.registerIcon(this.getTextureName() + "_side");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = player.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                
                if (itemstack.getItem() == Items.bucket)
                {
                        if (!player.capabilities.isCreativeMode)
                        {
                            ItemStack itemstack1 = new ItemStack(Items.milk_bucket, 1, 0);

                            if (!player.inventory.addItemStackToInventory(itemstack1))
                            {
                                world.spawnEntityInWorld(new EntityItem(world, (double)x + 0.5D, (double)y + 1.5D, (double)z + 0.5D, itemstack1));
                            }
                            else if (player instanceof EntityPlayerMP)
                            {
                                ((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
                            }

                            --itemstack.stackSize;

                            if (itemstack.stackSize <= 0)
                            {
                                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                            }
                        }

                    
                    
                }
                

                return false;
                
            }
        }
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.BarrelOfMilk;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return ModItems.BarrelOfMilk;
    }



}
