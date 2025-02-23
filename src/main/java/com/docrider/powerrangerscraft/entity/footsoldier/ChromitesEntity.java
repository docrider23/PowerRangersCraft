package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.items.MobsItems;
import com.docrider.powerrangerscraft.entity.MobsCore;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChromitesEntity extends BaseFootsoldierEntity {

    public ChromitesEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.CHROMITES_SWORD.get()));
        switch (this.getRandom().nextInt(4)) {
            case 0:
                NAME="wumper_blue";
                break;
            case 1:
                NAME="wumper_pink";
                break;
            case 2:
                NAME="wumper_green";
                break;
            case 3:
                NAME="wumper_white";
                break;
        }
    }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextInt(5) == 1) {
                BaseFootsoldierEntity boss = MobsCore.BLUE_SENTURION_EVIL.get().create(this.level());
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