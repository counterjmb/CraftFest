package com.craftfest.blocks.halloween;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import com.craftfest.CraftFestMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BrokenGlassPane extends BlockPane{
	 @SideOnly(Side.CLIENT)
	    private IIcon icon;
	    private static final String __OBFID = "CL_00000322";

	    public BrokenGlassPane()
	    {
	        super("brokenglasspane", "brokenglasspane", Material.glass, true);
	        this.setCreativeTab(CraftFestMod.tabFall);
	        setBlockName("brokenglasspane");
	        setBlockTextureName("brokenglasspane");
	        setStepSound(soundTypeGlass);
	        
	    }
	    
	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	    	
	        return null;
	    }

	    /**
	     * The type of render function that is called for this block
	     */
	    public int getRenderType()
	    {
	        return this.blockMaterial == Material.glass ? 41 : 18;
	    }

	    /**
	     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
	     * coordinates.  Args: blockAccess, x, y, z, side
	     */
	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockAccess block, int x, int y, int z, int meta)
	    {
	        return block.getBlock(x, y, z) == this ? false : super.shouldSideBeRendered(block, x, y, z, meta);
	    }

	    /**
	     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
	     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
	     */
	    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB alligned, List list, Entity entity)
	    {
	        boolean flag  = this.canPaneConnectTo(world, x, y, z - 1, NORTH);
	        boolean flag1 = this.canPaneConnectTo(world, x, y, z + 1, SOUTH);
	        boolean flag2 = this.canPaneConnectTo(world, x - 1, y, z, WEST );
	        boolean flag3 = this.canPaneConnectTo(world, x + 1, y, z, EAST );

	        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
	        {
	            if (flag2 && !flag3)
	            {
	                this.setBlockBounds(0.0F, 0.0F, 0.4375F, 0.5F, 1.0F, 0.5625F);
	                super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	            }
	            else if (!flag2 && flag3)
	            {
	                this.setBlockBounds(0.5F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
	                super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	            }
	        }
	        else
	        {
	            this.setBlockBounds(0.0F, 0.0F, 0.4375F, 1.0F, 1.0F, 0.5625F);
	            super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	        }

	        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
	        {
	            if (flag && !flag1)
	            {
	                this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 0.5F);
	                super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	            }
	            else if (!flag && flag1)
	            {
	                this.setBlockBounds(0.4375F, 0.0F, 0.5F, 0.5625F, 1.0F, 1.0F);
	                super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	            }
	        }
	        else
	        {
	            this.setBlockBounds(0.4375F, 0.0F, 0.0F, 0.5625F, 1.0F, 1.0F);
	            super.addCollisionBoxesToList(world, x, y, z, alligned, list, entity);
	        }
	    }

	    /**
	     * Sets the block's bounds for rendering it as an item
	     */
	    public void setBlockBoundsForItemRender()
	    {
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    }

	    /**
	     * Updates the blocks bounds based on its current state. Args: world, x, y, z
	     */
	    public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	    {
	        float f = 0.4375F;
	        float f1 = 0.5625F;
	        float f2 = 0.4375F;
	        float f3 = 0.5625F;
	        boolean flag  = this.canPaneConnectTo(block, x, y, z - 1, NORTH);
	        boolean flag1 = this.canPaneConnectTo(block, x, y, z + 1, SOUTH);
	        boolean flag2 = this.canPaneConnectTo(block, x - 1, y, z, WEST );
	        boolean flag3 = this.canPaneConnectTo(block, x + 1, y, z, EAST );

	        if ((!flag2 || !flag3) && (flag2 || flag3 || flag || flag1))
	        {
	            if (flag2 && !flag3)
	            {
	                f = 0.0F;
	            }
	            else if (!flag2 && flag3)
	            {
	                f1 = 1.0F;
	            }
	        }
	        else
	        {
	            f = 0.0F;
	            f1 = 1.0F;
	        }

	        if ((!flag || !flag1) && (flag2 || flag3 || flag || flag1))
	        {
	            if (flag && !flag1)
	            {
	                f2 = 0.0F;
	            }
	            else if (!flag && flag1)
	            {
	                f3 = 1.0F;
	            }
	        }
	        else
	        {
	            f2 = 0.0F;
	            f3 = 1.0F;
	        }

	        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
	    }


	    @SideOnly(Side.CLIENT)
	    public IIcon func_150097_e()
	    {
	        return this.icon;
	    }



	    /**
	     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	     */
	    protected ItemStack createStackedBlock(int p_149644_1_)
	    {
	        return new ItemStack(Item.getItemFromBlock(this), 1, p_149644_1_);
	    }

	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister icon)
	    {
	    	 
	        this.blockIcon = icon.registerIcon(CraftFestMod.MODID + ":brokenglasspane");
	        this.icon = icon.registerIcon(CraftFestMod.MODID + ":brokenglasspane");
	    }

	    public boolean canPaneConnectTo(IBlockAccess world, int x, int y, int z, ForgeDirection dir)
	    {
	        return canPaneConnectToBlock(world.getBlock(x, y, z)) || 
	                world.isSideSolid(x, y, z, dir.getOpposite(), false);
	    }
}
