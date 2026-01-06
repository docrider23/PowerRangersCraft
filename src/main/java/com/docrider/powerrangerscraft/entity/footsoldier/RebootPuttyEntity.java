package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.level.ModGameRules;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import com.docrider.powerrangerscraft.items.MobsItems;

public class RebootPuttyEntity extends BaseFootsoldierEntity {

    public RebootPuttyEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="reboot_putty";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.NO_ENTRY_SIGN.get()));
    }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
                BaseFootsoldierEntity boss = MobsCore.REBOOT_RITA.get().create(this.level());
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