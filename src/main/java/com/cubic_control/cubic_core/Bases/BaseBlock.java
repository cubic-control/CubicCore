package com.cubic_control.cubic_core.Bases;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block{

	//Sets all the bases for the block
	protected BaseBlock(Material material, String name, float hardness, String toolClass, int level, float resistance, SoundType soundType) {
		super(material);
		this.setBlockName(name);
		this.setHardness(hardness);
		this.setHarvestLevel(toolClass, level);
		this.setResistance(resistance);
		this.setStepSound(soundType);
	}
	
	//Gets the blocks hardness
	public float getBlockHardness(){
		return this.blockHardness;
	}
	
	//Gets the blocks resistance
	public float getBlockResistance(){
		return this.blockResistance;
	}

}
