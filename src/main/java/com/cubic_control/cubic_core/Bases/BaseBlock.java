package com.cubic_control.cubic_core.Bases;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block{
	protected float hardness;
	protected float resistance;

	/**
	 * Sets all the bases for the block
	 * @param material
	 * @param name
	 * @param hardness
	 * @param toolClass
	 * @param level
	 * @param resistance
	 * @param soundType
	 */
	protected BaseBlock(Material material, String name, float hardness, String toolClass, int level, float resistance, SoundType soundType) {
		super(material);
		this.setBlockName(name);
		this.setHardness(hardness);
		this.setHarvestLevel(toolClass, level);
		this.setResistance(resistance);
		this.setStepSound(soundType);
		
		this.hardness = hardness;
		this.resistance = resistance;
	}
	
	/**
	 * Gets the blocks hardness
	 */
	public float getBlockHardness(){
		return this.blockHardness;
	}
	
	/**
	 * Gets the blocks resistance
	 */
	public float getBlockResistance(){
		return this.blockResistance;
	}
	
	/**
	 * Gets the selected blocks hardness
	 * @param block
	 * @return
	 */
	public float getBlockHardness2(BaseBlock block){
		return block.hardness;
	}
	
	/**
	 * Gets the selected blocks resistance
	 * @param block
	 * @return
	 */
	public float getBlockResistance2(BaseBlock block){
		return block.resistance;
	}

}
