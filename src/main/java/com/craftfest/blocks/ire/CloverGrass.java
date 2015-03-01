package com.craftfest.blocks.ire;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.craftfest.CraftFestMod;
import com.craftfest.blocks.ModBlocks;

public class CloverGrass extends BlockGrass  {
	// TODO: CloverGrass: create customer grass renderer?
	// TODO: CloverGrass: cannot place plants on yet. DONE 
	// TODO: CloverGrass: test silk touch DONE
	// TODO: CloverGrass: will snow turn this back to grass? 

	public CloverGrass() {

		this.setUnlocalizedName("clovergrass");
		this.setCreativeTab(CraftFestMod.tabSpring);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setTickRandomly(true);
		this.setStepSound(soundTypeGrass);
		
		
	}

	//spread
	@Override
	public void updateTick(World wolrd, BlockPos pos, IBlockState state,
			Random rand) {
		if (!wolrd.isRemote) {
			if (wolrd.getLightFromNeighbors(pos.up()) < 4
					&& wolrd.getBlockState(pos.up()).getBlock()
							.getLightOpacity(wolrd, pos.up()) > 2) {
				wolrd.setBlockState(pos, Blocks.dirt.getDefaultState());
			} else {
				if (wolrd.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1,
								rand.nextInt(5) - 3, rand.nextInt(3) - 1);
						Block block = wolrd.getBlockState(blockpos1.up())
								.getBlock();
						IBlockState iblockstate1 = wolrd
								.getBlockState(blockpos1);

						if (iblockstate1.getBlock() == Blocks.dirt
								&& iblockstate1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT
								&& wolrd.getLightFromNeighbors(blockpos1.up()) >= 4
								&& block.getLightOpacity(wolrd, blockpos1.up()) <= 2) {
							wolrd.setBlockState(blockpos1,
									ModBlocks.CloverGrass.getDefaultState());
						}
					}
				}
			}
		}
	}

	@Override
	 public boolean canSustainPlant(IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable)
	    {
	       //TODO: Clovergrass: test cactus and bamboo: DONE
	       
	        
	        net.minecraftforge.common.EnumPlantType plantType = plantable.getPlantType(world, pos.up());
	        
	        switch (plantType)
	        {
	            case Desert: return false;
	            case Nether: return false;
	            case Crop:   return false;
	            case Cave:   return false;
	            case Plains: return true;
	            case Water:  return false;
	            case Beach:  return false;
	                
	        }
	        
	        return false;
	    }
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Blocks.dirt.getItemDropped(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), rand, fortune);
    }
    
    


}
