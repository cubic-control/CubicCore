package com.cubic_control.cubic_core.Entity;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFakeMob extends EntityCreature implements IAnimals{

	public EntityFakeMob(World par1World) {
		super(par1World);
		this.experienceValue = 5;
	}
	
	//Stuff from EntityMob\\
	
	/**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
	@Override
    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
    }
	/**
     * Called to update the entity's position/logic.
     */
	@Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }
	@Override
	protected String getSwimSound() {
        return "game.hostile.swim";
    }
	@Override
    protected String getSplashSound() {
        return "game.hostile.swim.splash";
    }
	/**
     * Called when the entity is attacked.
     */
	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float f1) {
        if (this.isEntityInvulnerable()) {
            return false;
        }else if (super.attackEntityFrom(par1DamageSource, f1)) {
            Entity entity = par1DamageSource.getEntity();

            if (this.riddenByEntity != entity && this.ridingEntity != entity) {
                if (entity != this) {
                    this.entityToAttack = entity;
                }
                return true;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
	/**
     * Returns the sound this mob makes when it is hurt.
     */
	@Override
    protected String getHurtSound() {
        return "game.hostile.hurt";
    }
    /**
     * Returns the sound this mob makes on death.
     */
	@Override
    protected String getDeathSound() {
        return "game.hostile.die";
    }
	@Override
    protected String func_146067_o(int i1) {
        return i1 > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
    }
	@Override
	public boolean attackEntityAsMob(Entity par1Entity) {
        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        int i = 0;

        if (par1Entity instanceof EntityLivingBase) {
            f += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase)par1Entity);
            i += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase)par1Entity);
        }
        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        
        if (flag) {
            if (i > 0) {
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)i * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0) {
                par1Entity.setFire(j * 4);
            }

            if (par1Entity instanceof EntityLivingBase) {
                EnchantmentHelper.func_151384_a((EntityLivingBase)par1Entity, this);
            }
            EnchantmentHelper.func_151385_b(this, par1Entity);
        }
        return flag;
    }
	/**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
	@Override
    protected void attackEntity(Entity par1Entity, float par2) {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY) {
            this.attackTime = 20;
            this.attackEntityAsMob(par1Entity);
        }
    }
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
    }
	@Override
    protected boolean func_146066_aG() {
        return true;
    }

}
