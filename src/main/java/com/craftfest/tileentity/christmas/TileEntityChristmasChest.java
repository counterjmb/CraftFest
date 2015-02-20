package com.craftfest.tileentity.christmas;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;

import com.craftfest.blocks.christmas.ChristmasChest;

public class TileEntityChristmasChest extends TileEntityChest {
	
	public TileEntityChristmasChest adjacentChestZNeg;
    /** Contains the chest tile located adjacent to this one (if any) */
    public TileEntityChristmasChest adjacentChestXPos;
    /** Contains the chest tile located adjacent to this one (if any) */
    public TileEntityChristmasChest adjacentChestXNeg;
    /** Contains the chest tile located adjacent to this one (if any) */
    public TileEntityChristmasChest adjacentChestZPos;
    
    private String customName;
    private ItemStack[] chestContents = new ItemStack[36];
    private int cachedChestType;
	  
	
	    
	    public String getInventoryName()
	    {
	        return this.hasCustomInventoryName() ? this.customName : "christmaschest";
	    }
	    
	    /**
	     * Returns if the inventory is named
	     */
	    public boolean hasCustomInventoryName()
	    {
	        return this.customName != null && this.customName.length() > 0;
	    }

	    public void func_145976_a(String p_145976_1_)
	    {
	        this.customName = p_145976_1_;
	    }
	    
	    public void readFromNBT(NBTTagCompound p_145839_1_)
	    {
	        super.readFromNBT(p_145839_1_);
	        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
	        this.chestContents = new ItemStack[this.getSizeInventory()];

	        if (p_145839_1_.hasKey("CustomName", 8))
	        {
	            this.customName = p_145839_1_.getString("CustomName");
	        }

	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            int j = nbttagcompound1.getByte("Slot") & 255;

	            if (j >= 0 && j < this.chestContents.length)
	            {
	                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	            }
	        }
	    }

	    public void writeToNBT(NBTTagCompound p_145841_1_)
	    {
	        super.writeToNBT(p_145841_1_);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.chestContents.length; ++i)
	        {
	            if (this.chestContents[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.chestContents[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        p_145841_1_.setTag("Items", nbttaglist);

	        if (this.hasCustomInventoryName())
	        {
	            p_145841_1_.setString("CustomName", this.customName);
	        }
	    }
	    
	    
	    private void func_145978_a(TileEntityChest p_145978_1_, int p_145978_2_)
	    {
	        if (p_145978_1_.isInvalid())
	        {
	            this.adjacentChestChecked = false;
	        }
	        else if (this.adjacentChestChecked)
	        {
	            switch (p_145978_2_)
	            {
	                case 0:
	                    if (this.adjacentChestZPos != p_145978_1_)
	                    {
	                        this.adjacentChestChecked = false;
	                    }

	                    break;
	                case 1:
	                    if (this.adjacentChestXNeg != p_145978_1_)
	                    {
	                        this.adjacentChestChecked = false;
	                    }

	                    break;
	                case 2:
	                    if (this.adjacentChestZNeg != p_145978_1_)
	                    {
	                        this.adjacentChestChecked = false;
	                    }

	                    break;
	                case 3:
	                    if (this.adjacentChestXPos != p_145978_1_)
	                    {
	                        this.adjacentChestChecked = false;
	                    }
	            }
	        }
	    }
	    
	    private boolean func_145977_a(int p_145977_1_, int p_145977_2_, int p_145977_3_)
	    {
	        if (this.worldObj == null)
	        {
	            return false;
	        }
	        else
	        {
	            Block block = this.worldObj.getBlock(p_145977_1_, p_145977_2_, p_145977_3_);
	            return block instanceof ChristmasChest && ((ChristmasChest)block).field_149956_a == this.func_145980_j();
	        }
	    }

	    /**
	     * Performs the check for adjacent chests to determine if this chest is double or not.
	     */
	    public void checkForAdjacentChests()
	    {
	        if (!this.adjacentChestChecked)
	        {
	            this.adjacentChestChecked = true;
	            this.adjacentChestZNeg = null;
	            this.adjacentChestXPos = null;
	            this.adjacentChestXNeg = null;
	            this.adjacentChestZPos = null;

	            if (this.func_145977_a(this.xCoord - 1, this.yCoord, this.zCoord))
	            {
	                this.adjacentChestXNeg = (TileEntityChristmasChest)this.worldObj.getTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
	            }

	            if (this.func_145977_a(this.xCoord + 1, this.yCoord, this.zCoord))
	            {
	                this.adjacentChestXPos = (TileEntityChristmasChest)this.worldObj.getTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
	            }

	            if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord - 1))
	            {
	                this.adjacentChestZNeg = (TileEntityChristmasChest)this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
	            }

	            if (this.func_145977_a(this.xCoord, this.yCoord, this.zCoord + 1))
	            {
	                this.adjacentChestZPos = (TileEntityChristmasChest)this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
	            }

	            if (this.adjacentChestZNeg != null)
	            {
	                this.adjacentChestZNeg.func_145978_a(this, 0);
	            }

	            if (this.adjacentChestZPos != null)
	            {
	                this.adjacentChestZPos.func_145978_a(this, 2);
	            }

	            if (this.adjacentChestXPos != null)
	            {
	                this.adjacentChestXPos.func_145978_a(this, 1);
	            }

	            if (this.adjacentChestXNeg != null)
	            {
	                this.adjacentChestXNeg.func_145978_a(this, 3);
	            }
	        }
	    }
	    
	    public int func_145980_j()
	    {
	        if (this.cachedChestType == -1)
	        {
	            if (this.worldObj == null || !(this.getBlockType() instanceof ChristmasChest))
	            {
	                return 0;
	            }

	            this.cachedChestType = ((ChristmasChest)this.getBlockType()).field_149956_a;
	        }

	        return this.cachedChestType;
	    }
	    
	    /*TODO: add custom sound?*//*
	    public void updateEntity()
	    {
	        super.updateEntity();
	        this.checkForAdjacentChests();
	        ++this.ticksSinceSync;
	        float f;

	        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
	        {
	            this.numPlayersUsing = 0;
	            f = 5.0F;
	            List list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)this.xCoord - f), (double)((float)this.yCoord - f), (double)((float)this.zCoord - f), (double)((float)(this.xCoord + 1) + f), (double)((float)(this.yCoord + 1) + f), (double)((float)(this.zCoord + 1) + f)));
	            Iterator iterator = list.iterator();

	            while (iterator.hasNext())
	            {
	                EntityPlayer entityplayer = (EntityPlayer)iterator.next();

	                if (entityplayer.openContainer instanceof ContainerChest)
	                {
	                    IInventory iinventory = ((ContainerChest)entityplayer.openContainer).getLowerChestInventory();

	                    if (iinventory == this || iinventory instanceof InventoryLargeChest && ((InventoryLargeChest)iinventory).isPartOfLargeChest(this))
	                    {
	                        ++this.numPlayersUsing;
	                    }
	                }
	            }
	        }

	        this.prevLidAngle = this.lidAngle;
	        f = 0.1F;
	        double d2;

	        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
	        {
	            double d1 = (double)this.xCoord + 0.5D;
	            d2 = (double)this.zCoord + 0.5D;

	            if (this.adjacentChestZPos != null)
	            {
	                d2 += 0.5D;
	            }

	            if (this.adjacentChestXPos != null)
	            {
	                d1 += 0.5D;
	            }

	            this.worldObj.playSoundEffect(d1, (double)this.yCoord + 0.5D, d2, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
	        }

	        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
	        {
	            float f1 = this.lidAngle;

	            if (this.numPlayersUsing > 0)
	            {
	                this.lidAngle += f;
	            }
	            else
	            {
	                this.lidAngle -= f;
	            }

	            if (this.lidAngle > 1.0F)
	            {
	                this.lidAngle = 1.0F;
	            }

	            float f2 = 0.5F;

	            if (this.lidAngle < f2 && f1 >= f2 && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null)
	            {
	                d2 = (double)this.xCoord + 0.5D;
	                double d0 = (double)this.zCoord + 0.5D;

	                if (this.adjacentChestZPos != null)
	                {
	                    d0 += 0.5D;
	                }

	                if (this.adjacentChestXPos != null)
	                {
	                    d2 += 0.5D;
	                }

	                this.worldObj.playSoundEffect(d2, (double)this.yCoord + 0.5D, d0, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
	            }

	            if (this.lidAngle < 0.0F)
	            {
	                this.lidAngle = 0.0F;
	            }
	        }
	    }*/

}
