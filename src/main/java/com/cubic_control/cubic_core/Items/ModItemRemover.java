package com.cubic_control.cubic_core.Items;

import com.cubic_control.cubic_core.Bases.BaseItem;
import com.cubic_control.cubic_core.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModItemRemover extends BaseItem{

	public ModItemRemover(String name, float f1) {
		super(name);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setTextureName(RefStrings.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(block != null ){
			world.setBlock(x, y, z, Blocks.air);
			return true;
		}else if(tile != null){
			world.setTileEntity(x, y, z, null);
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		entity.setDead();
		return super.onLeftClickEntity(stack, player, entity);
	}

}
