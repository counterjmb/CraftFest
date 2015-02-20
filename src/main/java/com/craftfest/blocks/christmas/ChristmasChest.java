package com.craftfest.blocks.christmas;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.tileentity.christmas.TileEntityChristmasChest;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChristmasChest extends BlockChest {
	
	private final Random field_149955_b = new Random();
	
	public ChristmasChest(int power){
		
		super(power);
		setBlockName("christmaschest");
		setBlockTextureName(CraftFestMod.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(CraftFestMod.tabWinter);
				
	}
	
	   public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase p_149689_5_, ItemStack itm)
	    {
	        Block block = world.getBlock(x, y, z - 1);
	        Block block1 = world.getBlock(x, y, z + 1);
	        Block block2 = world.getBlock(x - 1, y, z);
	        Block block3 = world.getBlock(x + 1, y, z);
	        byte b0 = 0;
	        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

	        if (l == 0)
	        {
	            b0 = 2;
	        }

	        if (l == 1)
	        {
	            b0 = 5;
	        }

	        if (l == 2)
	        {
	            b0 = 3;
	        }

	        if (l == 3)
	        {
	            b0 = 4;
	        }

	        if (block != this && block1 != this && block2 != this && block3 != this)
	        {
	            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	        }
	        else
	        {
	            if ((block == this || block1 == this) && (b0 == 4 || b0 == 5))
	            {
	                if (block == this)
	                {
	                    world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
	                }
	                else
	                {
	                    world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
	                }

	                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	            }

	            if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3))
	            {
	                if (block2 == this)
	                {
	                    world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
	                }
	                else
	                {
	                    world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
	                }

	                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
	            }
	        }

	        if (itm.hasDisplayName())
	        {
	            ((TileEntityChristmasChest)world.getTileEntity(x, y, z)).func_145976_a(itm.getDisplayName());
	        }
	    }
	   
	    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
	    {
	        super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
	        TileEntityChristmasChest tileentitychest = (TileEntityChristmasChest)p_149695_1_.getTileEntity(p_149695_2_, p_149695_3_, p_149695_4_);

	        if (tileentitychest != null)
	        {
	            tileentitychest.updateContainingBlockInfo();
	        }
	    }
	    
	    public void breakBlock(World world, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
	    {
	        TileEntityChristmasChest techristmaschest = (TileEntityChristmasChest)world.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

	        if (techristmaschest != null)
	        {
	            for (int i1 = 0; i1 < techristmaschest.getSizeInventory(); ++i1)
	            {
	                ItemStack itemstack = techristmaschest.getStackInSlot(i1);

	                if (itemstack != null)
	                {
	                    float f = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
	                    float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
	                    EntityItem entityitem;

	                    for (float f2 = this.field_149955_b.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
	                    {
	                        int j1 = this.field_149955_b.nextInt(21) + 10;

	                        if (j1 > itemstack.stackSize)
	                        {
	                            j1 = itemstack.stackSize;
	                        }

	                        itemstack.stackSize -= j1;
	                        entityitem = new EntityItem(world, (double)((float)p_149749_2_ + f), (double)((float)p_149749_3_ + f1), (double)((float)p_149749_4_ + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
	                        float f3 = 0.05F;
	                        entityitem.motionX = (double)((float)this.field_149955_b.nextGaussian() * f3);
	                        entityitem.motionY = (double)((float)this.field_149955_b.nextGaussian() * f3 + 0.2F);
	                        entityitem.motionZ = (double)((float)this.field_149955_b.nextGaussian() * f3);

	                        if (itemstack.hasTagCompound())
	                        {
	                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
	                        }
	                    }
	                }
	            }

	            world.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
	        }

	        super.breakBlock(world, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
	    }
	    
	    public IInventory func_149951_m(World p_149951_1_, int p_149951_2_, int p_149951_3_, int p_149951_4_)
	    {
	        Object object = (TileEntityChristmasChest)p_149951_1_.getTileEntity(p_149951_2_, p_149951_3_, p_149951_4_);

	        if (object == null)
	        {
	            return null;
	        }
	        else if (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_, DOWN))
	        {
	            return null;
	        }
	        else if (func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_))
	        {
	            return null;
	        }
	        else if (p_149951_1_.getBlock(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.isSideSolid(p_149951_2_ - 1, p_149951_3_ + 1, p_149951_4_, DOWN) || func_149953_o(p_149951_1_, p_149951_2_ - 1, p_149951_3_, p_149951_4_)))
	        {
	            return null;
	        }
	        else if (p_149951_1_.getBlock(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this && (p_149951_1_.isSideSolid(p_149951_2_ + 1, p_149951_3_ + 1, p_149951_4_, DOWN) || func_149953_o(p_149951_1_, p_149951_2_ + 1, p_149951_3_, p_149951_4_)))
	        {
	            return null;
	        }
	        else if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this && (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_ - 1, DOWN) || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ - 1)))
	        {
	            return null;
	        }
	        else if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this && (p_149951_1_.isSideSolid(p_149951_2_, p_149951_3_ + 1, p_149951_4_ + 1, DOWN) || func_149953_o(p_149951_1_, p_149951_2_, p_149951_3_, p_149951_4_ + 1)))
	        {
	            return null;
	        }
	        else
	        {
	            if (p_149951_1_.getBlock(p_149951_2_ - 1, p_149951_3_, p_149951_4_) == this)
	            {
	                object = new InventoryLargeChest("double christmas chest", (TileEntityChristmasChest)p_149951_1_.getTileEntity(p_149951_2_ - 1, p_149951_3_, p_149951_4_), (IInventory)object);
	            }

	            if (p_149951_1_.getBlock(p_149951_2_ + 1, p_149951_3_, p_149951_4_) == this)
	            {
	                object = new InventoryLargeChest("double christmas chest", (IInventory)object, (TileEntityChristmasChest)p_149951_1_.getTileEntity(p_149951_2_ + 1, p_149951_3_, p_149951_4_));
	            }

	            if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ - 1) == this)
	            {
	                object = new InventoryLargeChest("double christmas chest", (TileEntityChristmasChest)p_149951_1_.getTileEntity(p_149951_2_, p_149951_3_, p_149951_4_ - 1), (IInventory)object);
	            }

	            if (p_149951_1_.getBlock(p_149951_2_, p_149951_3_, p_149951_4_ + 1) == this)
	            {
	                object = new InventoryLargeChest("double christmas chest", (IInventory)object, (TileEntityChristmasChest)p_149951_1_.getTileEntity(p_149951_2_, p_149951_3_, p_149951_4_ + 1));
	            }

	            return (IInventory)object;
	        }
	    }
	    
	    private static boolean func_149953_o(World wolrd, int p_149953_1_, int p_149953_2_, int p_149953_3_)
	    {
	        Iterator iterator = wolrd.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double)p_149953_1_, (double)(p_149953_2_ + 1), (double)p_149953_3_, (double)(p_149953_1_ + 1), (double)(p_149953_2_ + 2), (double)(p_149953_3_ + 1))).iterator();
	        EntityOcelot entityocelot;

	        do
	        {
	            if (!iterator.hasNext())
	            {
	                return false;
	            }

	            Entity entity = (Entity)iterator.next();
	            entityocelot = (EntityOcelot)entity;
	        }
	        while (!entityocelot.isSitting());

	        return true;
	    }

	    /**
	     * Returns a new instance of a block's tile entity class. Called on placing the block.
	     */
	    public TileEntity createNewTileEntity(World wolrd, int p_149915_2_)
	    {
	        TileEntityChristmasChest tileentitychest = new TileEntityChristmasChest();
	        return tileentitychest;
	    }
	    
	    public int isProvidingWeakPower(IBlockAccess p_149709_1_, int p_149709_2_, int p_149709_3_, int p_149709_4_, int p_149709_5_)
	    {
	        if (!this.canProvidePower())
	        {
	            return 0;
	        }
	        else
	        {
	            int i1 = ((TileEntityChristmasChest)p_149709_1_.getTileEntity(p_149709_2_, p_149709_3_, p_149709_4_)).numPlayersUsing;
	            return MathHelper.clamp_int(i1, 0, 15);
	        }
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister icon)
	    {
	        this.blockIcon = icon.registerIcon(CraftFestMod.MODID + ":chrismaschest");
	    }
	
	

}
