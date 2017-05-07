package com.cubic_control.cubic_core.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.util.ForgeDirection;

public class CubicUtils {
	private static final HashMap<String, ResourceLocation> cachedSkins = new HashMap<String, ResourceLocation>();
	
	/**
	 * Used to get random values
	 */
	public static Random rand = new Random();
	
	/**
	 * Used to add light to a moving object
	 * @param world
	 * @param mop
	 * @param entity
	 */
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
        
        if(entity.isDead){
        	updateLightByMOP(world, mop);
        }
    }
	
	/**
	 * Used to add light to an entity
	 * @param world
	 * @param entity
	 */
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
        
        if(entity.isDead){
        	updateLightByEntity(world, entity);
        }
    }
	
	/**
	 * Used to clear the light next to a moving object
	 * @param world
	 * @param mop
	 */
	public static void updateLightByMOP(World world, MovingObjectPosition mop) {
		world.updateLightByType(EnumSkyBlock.Block, (int)mop.blockX, (int)mop.blockY, (int)mop.blockZ);
	}
	
	/**
	 * Used to clear the light next to an entity
	 * @param world
	 * @param entity
	 */
	public static void updateLightByEntity(World world, Entity entity) {
		world.updateLightByType(EnumSkyBlock.Block, (int)entity.posX, (int)entity.posY, (int)entity.posZ);
	}
	
	/**
	 * Used to draw GUIs on screen
	 * @param posX
	 * @param posY
	 * @param width
	 * @param height
	 */
	public static void drawTexturedRect(double posX, double posY, double width, double height) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + height), 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + height), 0.0, 1.0, 1.0);
        tessellator.addVertexWithUV((double)(posX + width), (double)(posY + 0), 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV((double)(posX + 0), (double)(posY + 0), 0.0, 0.0, 0.0);
        tessellator.draw();
    }
	
	/**
	 * Used to get the blocks around a point
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public static Block[] getBlocksAroundPoint(World world, int x, int y, int z) {
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
	
	/**
	 * Used to replace the blocks around a point
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param blockToRemove
	 * @param bockToSet
	 */
	public static void replaceBlocksAroundPoint(World world, int x, int y, int z, Block blockToRemove, Block blockToSet) {
		Block blocks[] = CubicUtils.getBlocksAroundPoint(world, x, y, z);
		
		for(int i = 0; i < blocks.length; i++){
			Block block = blocks[i];
			
			if(block == blockToRemove){
				ForgeDirection[] directions = ForgeDirection.VALID_DIRECTIONS;
				
				for(int i1 = 0; i1 < directions.length; i1++){
					int xCoord = x + directions[i1].offsetX;
					int yCoord = y + directions[i1].offsetY;
					int zCoord = z + directions[i1].offsetZ;
					world.setBlock(xCoord, yCoord, zCoord, blockToSet);
				}
			}
		}
	}
	
	/**
	 * Used to replace the block at a given point
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @param blockToRemove
	 * @param blockToSet
	 */
	public static void replaceBlockAtPoint(World world, int x, int y, int z, Block blockToRemove, Block blockToSet) {
		if(world.getBlock(x, y, z) == blockToRemove){
			world.setBlock(x, y, z, blockToSet);
		}
	}
	
	/**
	 * Used to select a random item from the registry
	 * @return
	 */
	public static Item getRandomItem() {
		Item i = null;
		int length = Item.itemRegistry.getKeys().toArray().length;
		Object select = Item.itemRegistry.getObjectById(CubicUtils.rand.nextInt(length));
		
		if(select != null && select instanceof Item){
			i = (Item) select;
		}else{
			return getRandomItem();
		}
		return i;
	}
	
	/**
	 * Used to see if dimension id is valid
	 * @param world
	 * @param i
	 * @return
	 */
	public static boolean isValidDimension(World world, int[] i) {
		String value = "";
		
		for(int i1 = 0; i1 < i.length - 1; i1++){
			value += i[i1];
		}
		int i2 = Integer.parseInt(value);
		
		if(world.provider.dimensionId == i2){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Used to get the UUID from an entity.
	 * @param entity
	 * @return
	 */
	public static UUID getUUIDFromEntity(Entity entity) {
		return entity.getUniqueID();
	}
	
	/**
	 * Used to get the current dimension of an entity.
	 * @param entity
	 * @return
	 */
	public static int getDimFromEntity(Entity entity) {
		return entity.worldObj.provider.dimensionId;
	}
	
	/**
	 * Used to add a keyBinding.
	 * @param keyDescription
	 * @param keyCode
	 * @param keyCategory
	 * @return
	 */
	public static KeyBinding addKeyBinding(String keyDescription, int keyCode, String keyCategory){
		KeyBinding newKey = new KeyBinding(keyDescription, keyCode, keyCategory);
		ClientRegistry.registerKeyBinding(newKey);
		return newKey;
	}
	
	/**
	 * Used to get the skin from any username.
	 * @param username
	 * @return
	 */
	public static ResourceLocation getSkinTexture(String username) {
		ResourceLocation resource = cachedSkins.get(username);
		
		if(resource == null){
			resource = AbstractClientPlayer.getLocationSkin(username);
			
			try{
				AbstractClientPlayer.getDownloadImageSkin(resource, username);
				cachedSkins.put(username, resource);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return resource;
	}
	
	/**
	 * Used to get the entities around a given entity
	 * @param entity
	 * @param radius
	 * @return
	 */
	public static List<Entity> getEntitiesAroundEntity(Entity entity, double radius){
		List<Entity> list = entity.worldObj.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(entity.posX - radius, entity.posY - radius, entity.posZ - radius, entity.posX + radius, entity.posY + radius, entity.posZ + radius));
		return list;
	}

}
