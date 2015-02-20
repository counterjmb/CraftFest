package com.craftfest.world;

import com.craftfest.world.biomes.ModBiomes;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class ChristmasWorldProvider extends WorldProvider {
	
	public void registerWorldChunkManager(){
		this.worldChunkMgr = new WorldChunkManagerHell(ModBiomes.snowyforest, 1.0F);
		this.dimensionId = Dimensions.christmasDimID;

		
	}
	
	public IChunkProvider createChunkGenerator(){
		return new CraftFestChunkProvider(worldObj, worldObj.getSeed(), true);
	}

	@Override
	public String getDimensionName() {
		return "Christmas Dimension";
	}
	
    public int getMoonPhase(long p_76559_1_)
    {
    	return 1;
        //return (int)(p_76559_1_ / 24000L % 8L + 8L) % 8;
    }
    
    /**
     * A message to display to the user when they transfer to this dimension.
     *
     * @return The message to be displayed
     */
    public String getWelcomeMessage()
    {
        if (this instanceof ChristmasWorldProvider)
        {
            return "Merry Christmas";
        }

        return null;
    }
    
    /**
     * A Message to display to the user when they transfer out of this dismension.
     *
     * @return The message to be displayed
     */
    public String getDepartMessage()
    {
        if (this instanceof ChristmasWorldProvider)
        {
            return "Leaving Christmas Land";
        }

        return null;
    }

}
