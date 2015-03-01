package com.craftfest.world.biomes.ire;

import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.biome.BiomeGenBase;

import com.craftfest.blocks.ModBlocks;
import com.google.common.collect.Lists;

public class Moor extends BiomeGenBase{
	
	public Moor(int id) {
		super(id);
		this.setBiomeName("Moor");
		this.topBlock = ModBlocks.CloverGrass.getDefaultState();
		this.setTemperatureRainfall(1.2F, 0.5F);
		this.theBiomeDecorator.treesPerChunk = 2;
		
		

		
		//Mobs
        this.spawnableMonsterList = Lists.newArrayList();
        this.spawnableCreatureList = Lists.newArrayList();
		
		
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityRabbit.class, 10, 3, 3));
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPig.class, 10, 4, 4));

        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 5, 1, 1));
	}

}
