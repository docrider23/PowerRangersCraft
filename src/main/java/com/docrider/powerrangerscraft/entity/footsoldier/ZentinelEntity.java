package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ZentinelEntity extends BaseFootsoldierEntity {

    public ZentinelEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="zentinel";
        switch (this.getRandom().nextInt(2)) {
            case 0:
                NAME="zentinel_grey";
                break;
            case 1:
                NAME="zentinel_red";
                break;
        }
    }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextInt(5) == 1) {
                if (this.random.nextInt(2) == 0) {
                    BaseFootsoldierEntity boss = MobsCore.EVIL_BLUE_DINO_FURY_RANGER.get().create(this.level());
                    if (boss != null) {
                        boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(boss);

                        if (this.getLastAttacker()instanceof Player){
                            Player playerIn = (Player) this.getLastAttacker();

                        }
                    }
                }
            }
        }
        super.remove(p_149847_);
    }
}
