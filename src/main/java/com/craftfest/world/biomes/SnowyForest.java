package com.craftfest.world.biomes;

import java.util.List;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.craftfest.blocks.ModBlocks;

public class SnowyForest extends BiomeGenBase {
	
	public SnowyForest(int id){
		super(id);
		setBiomeName("snowyforest");
		this.topBlock = ModBlocks.SnowyGrass;
		this.enableSnow = true;
		this.temperature = 0.0F;
		this.rainfall = 1.0F;
		this.theBiomeDecorator.coalGen = new WorldGenMinable(Blocks.coal_ore, 128);
		this.theBiomeDecorator.treesPerChunk = 10;
		
		
		//Mobs:clear
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		//Mobs:add
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
		
		
	}
	
    /**
     * Returns the correspondent list of the EnumCreatureType informed.
     */
    public List getSpawnableList(EnumCreatureType p_76747_1_)
    {
        return p_76747_1_ == EnumCreatureType.monster ? this.spawnableMonsterList : (p_76747_1_ == EnumCreatureType.creature ? this.spawnableCreatureList : (p_76747_1_ == EnumCreatureType.waterCreature ? this.spawnableWaterCreatureList : (p_76747_1_ == EnumCreatureType.ambient ? this.spawnableCaveCreatureList : null)));
    }
    
    

}
