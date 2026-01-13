package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.level.ModGameRules;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PuttyPatrollersEntity extends BaseFootsoldierEntity {

    public PuttyPatrollersEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="putty_patroller";
    }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
                int bossChoice = this.random.nextInt(5);
                switch (bossChoice) {
                    case 0:
                        BaseFootsoldierEntity boss = MobsCore.GOLDAR.get().create(this.level());
                        if (boss != null) {
                            boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                            this.level().addFreshEntity(boss);

                            if (this.getLastAttacker()instanceof Player){
                                Player playerIn = (Player) this.getLastAttacker();
                            }
                        }
                        break;
                    case 1:
                        boss = MobsCore.EVILMMPRGREEN.get().create(this.level());
                        if (boss != null) {
                            boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                            this.level().addFreshEntity(boss);

                            if (this.getLastAttacker()instanceof Player){
                                Player playerIn = (Player) this.getLastAttacker();
                            }
                        }
                        break;
                }
            }
        }
        super.remove(p_149847_);
    }
}