package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.MobsItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SwabbiesEntity extends BaseFootsoldierEntity {
	
    public SwabbiesEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="swabbies";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.SWABBIES_CUTLASS.get()));
    }

    public void remove(RemovalReason p_149847_) {
        if ( this.isDeadOrDying()) {
            if (this.random.nextInt(5) == 1) {
                BaseFootsoldierEntity boss = MobsCore.MAGNA_DEFENDER.get().create(this.level());
                if (boss != null) {
                    boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(boss);

                    if (this.getLastAttacker()instanceof Player){
                        Player playerIn = (Player) this.getLastAttacker();
                        playerIn.sendSystemMessage(Component.translatable("change.powerrangerscraft.magna_defender"));
                    }
                }
            }
        }
        super.remove(p_149847_);
    }
}