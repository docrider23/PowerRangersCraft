package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.MobsItems;
import com.docrider.powerrangerscraft.level.ModGameRules;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HengemenEntity extends BaseFootsoldierEntity {
	
    public HengemenEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="hengemen";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.HENGEMEN_SPEAR.get()));
        this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MobsItems.HENGEMEN_SHIELD.get()));
    }

    public void remove(RemovalReason p_149847_) {
    	if ( this.isDeadOrDying()) {
    		if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
    				BaseFootsoldierEntity boss = MobsCore.VOID_KNIGHT.get().create(this.level());
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