package com.craftfest.entity.items;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityOrnaments extends EntityPainting {
	public EntityOrnaments.EnumArt types;
    
    public EntityOrnaments(World world)
    {
        super(world);
    }

    public EntityOrnaments(World world, int x, int y, int z, int dir)
    {
        super(world, x, y, z, dir);
        ArrayList arraylist = new ArrayList();
        EntityOrnaments.EnumArt[] aenumart = EntityOrnaments.EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; ++j1)
        {
        	EntityOrnaments.EnumArt enumart = aenumart[j1];
            this.types = enumart;
            this.setDirection(dir);

            if (this.onValidSurface())
            {
                arraylist.add(enumart);
            }
        }

        if (!arraylist.isEmpty())
        {
            this.types = (EntityOrnaments.EnumArt)arraylist.get(this.rand.nextInt(arraylist.size()));
        }

        this.setDirection(dir);
    }

    @SideOnly(Side.CLIENT)
    public EntityOrnaments(World world, int x, int y, int z, int p_i1601_5_, String str)
    {
        this(world, x, y, z, p_i1601_5_);
        EntityOrnaments.EnumArt[] aenumart = EntityOrnaments.EnumArt.values();
        int i1 = aenumart.length;

        for (int j1 = 0; j1 < i1; ++j1)
        {
        	EntityOrnaments.EnumArt enumart = aenumart[j1];

            if (enumart.title.equals(str))
            {
                this.types = enumart;
                break;
            }
        }

        this.setDirection(p_i1601_5_);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        p_70014_1_.setString("Motive", this.types.title);
        super.writeEntityToNBT(p_70014_1_);
    }


    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        String s = p_70037_1_.getString("Motive");
        EntityOrnaments.EnumArt[] aenumart = EntityOrnaments.EnumArt.values();
        int i = aenumart.length;

        for (int j = 0; j < i; ++j)
        {
        	EntityOrnaments.EnumArt enumart = aenumart[j];

            if (enumart.title.equals(s))
            {
                this.types = enumart;
            }
        }

        if (this.types == null)
        {
            this.types = EntityOrnaments.EnumArt.Kebab;
        }

        super.readEntityFromNBT(p_70037_1_);
    }



    public int getWidthPixels()
    {
        return this.types.sizeX;
    }

    public int getHeightPixels()
    {
        return this.types.sizeY;
    }

    /**
     * Called when this entity is broken. Entity parameter may be null.
     */
    public void onBroken(Entity p_110128_1_)
    {
        if (p_110128_1_ instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)p_110128_1_;

            if (entityplayer.capabilities.isCreativeMode)
            {
                return;
            }
        }

        this.entityDropItem(new ItemStack(Items.painting), 0.0F);
    }

    public static enum EnumArt
    {
    	//name, width, height, width offset, height offset
        Kebab("Kebab", 16, 16, 0, 0),
        Aztec("Aztec", 16, 16, 16, 0),
        Alban("Alban", 16, 16, 32, 0),
        Aztec2("Aztec2", 16, 16, 48, 0),
        Bomb("Bomb", 16, 16, 64, 0),
        Plant("Plant", 16, 16, 80, 0),
        Wasteland("Wasteland", 16, 16, 96, 0);
        //second row
        /*
        Pool("Pool", 32, 16, 0, 32),
        Courbet("Courbet", 32, 16, 32, 32),
        Sea("Sea", 32, 16, 64, 32),
        Sunset("Sunset", 32, 16, 96, 32),
        Creebet("Creebet", 32, 16, 128, 32),
        Wanderer("Wanderer", 16, 32, 0, 64),
        Graham("Graham", 16, 32, 16, 64),
        Match("Match", 32, 32, 0, 128),
        Bust("Bust", 32, 32, 32, 128),
        Stage("Stage", 32, 32, 64, 128),
        Void("Void", 32, 32, 96, 128),
        SkullAndRoses("SkullAndRoses", 32, 32, 128, 128),
        Wither("Wither", 32, 32, 160, 128),
        Fighters("Fighters", 64, 32, 0, 96),
        Pointer("Pointer", 64, 64, 0, 192),
        Pigscene("Pigscene", 64, 64, 64, 192),
        BurningSkull("BurningSkull", 64, 64, 128, 192),
        Skeleton("Skeleton", 64, 48, 192, 64),
        DonkeyKong("DonkeyKong", 64, 48, 192, 112);
        */
        /** Holds the maximum length of paintings art title. */
        public static final int maxArtTitleLength = "Kebab".length();
        
        /** Painting Title. */
        public final String title;
        public final int sizeX;
        public final int sizeY;
        public final int offsetX;
        public final int offsetY;

        

        private EnumArt(String type, int par1, int par2, int par3, int par4)
        {
            this.title = type;
            this.sizeX = par1;
            this.sizeY = par2;
            this.offsetX = par3;
            this.offsetY = par4;
        }
    }

}
