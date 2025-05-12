package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.MobsItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HorridEntity extends BaseFootsoldierEntity {

    public HorridEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="horrid";
    }

    protected SoundEvent getAmbientSound() { return SoundEvents.ZOMBIE_AMBIENT; }

    protected SoundEvent getHurtSound(DamageSource p_34327_) { return SoundEvents.ZOMBIE_HURT; }

    protected SoundEvent getDeathSound() { return SoundEvents.ZOMBIE_DEATH; }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextInt(5) == 1) {
                BaseFootsoldierEntity boss = MobsCore.DEATH_RANGER.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);

                    if (this.getLastAttacker()instanceof Player){
                        Player playerIn = (Player) this.getLastAttacker();
                    }
                }
            }
        }
        super.remove(p_149847_);
    }
}