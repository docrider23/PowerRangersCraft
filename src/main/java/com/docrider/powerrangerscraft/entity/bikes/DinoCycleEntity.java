package com.docrider.powerrangerscraft.entity.bikes;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.DinoChargeItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class DinoCycleEntity extends baseBikeEntity {



	public DinoCycleEntity(EntityType<? extends baseBikeEntity> entityType, Level level) {
		super(entityType, level, DinoChargeItems.DINO_CYCLE_CHARGER.get());
		NAME ="dino_cycle";
		NAME_MODEL ="dino_cycle";
		}


	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3F).add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.ATTACK_DAMAGE, 2.0D);
	}
}
