package com.cubic_control.cubic_core.Utils;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ModUtils {
	//Used to get random values
	public static Random rand = new Random();
	
	//Used to add light to a moving object
	public static void addLightToMOP(World world, MovingObjectPosition mop, Entity entity) {
    	world.setLightValue(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ, 15);
        world.markBlockRangeForRenderUpdate((int)mop.blockX, (int)mop.blockY, (int)mop.blockX, 12, 12, 12);
        world.markBlockForUpdate((int)mop.blockX, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY +1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY +1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY -1, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY -1, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX +1, (int)mop.blockY, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX -1, (int)mop.blockY, (int)mop.blockZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ -1);
        
        if (entity.isDead) {
        	updateLightByMOP(world, mop);
        }
    }
	
	//Used to add light to an entity
	public static void addLightToEntity(World world, Entity entity) {
    	world.setLightValue(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ, 15);
        world.markBlockRangeForRenderUpdate((int)entity.posX, (int)entity.posY, (int)entity.posX, 12, 12, 12);
        world.markBlockForUpdate((int)entity.posX, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY +1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY +1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY -1, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY -1, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX +1, (int)entity.posY, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ -1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX -1, (int)entity.posY, (int)entity.posZ);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ +1);
        world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ -1);
        
        if (entity.isDead) {
        	updateLightByEntity(world, entity);
        }
    }
	
	//Used to clear the light next to a moving object
	public static void updateLightByMOP(World world, MovingObjectPosition mop) {
		world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ);
	}
	
	//Used to clear the light next to an entity
	public static void updateLightByEntity(World world, Entity entity) {
		world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ);
	}
	
	//Used to draw GUIs on screen
	public static void drawTexturedRect(double posX, double posY, double width, double height) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + height), 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + height), 0.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + 0), 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + 0), 0.0, 0.0, 0.0);
        tessellator.draw();
    }
	
	//Used to get the blocks around a point
	public static Block[] getBlocksAroundPoint(World world, int x, int y, int z){
		ForgeDirection[] directions = ForgeDirection.VALID_DIRECTIONS;
		Block[] blocks = new Block[directions.length];
		for(int i = 0; i < directions.length; i++){
			int xCoord = x + directions[i].offsetX;
			int yCoord = y + directions[i].offsetY;
			int zCoord = z + directions[i].offsetZ;

			blocks[i] = world.getBlock(xCoord, yCoord, zCoord);
		}
		return blocks;
	}
	
	//Used to select a random item from the registry
	public static Item getRandomItem() {
		Item i = null;
		int length = Item.itemRegistry.getKeys().toArray().length;
		Object select = Item.itemRegistry.getObjectById(ModUtils.rand.nextInt(length));
		if(select != null && select instanceof Item) {
			i = (Item) select;
		} else {
			return getRandomItem();
		}
		return i;
	}
	
	//Used to see if dimension id is valid
	public static boolean isValidDimension(World world, int[] i){
		String value = "";
		for(int i1 = 0; i1 < i.length - 1; i1++) {
			value += i[i1];
		}
		int i2 = Integer.parseInt(value);
		
		if(world.provider.dimensionId == i2){
			return true;
		}else{
			return false;
		}
	}

}
