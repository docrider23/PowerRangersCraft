package com.docrider.powerrangerscraft.entity.footsoldier;

import com.docrider.powerrangerscraft.entity.MobsCore;
import com.docrider.powerrangerscraft.items.MobsItems;
import com.docrider.powerrangerscraft.level.ModGameRules;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CogEntity extends BaseFootsoldierEntity{

    private BaseFootsoldierEntity boss;

    ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("kamenridercraft:moon"));

    public CogEntity(EntityType<? extends BaseFootsoldierEntity> type, Level level) {
        super(type, level);
        NAME="cogs";
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MobsItems.COG_SPEAR.get()));
        switch (this.getRandom().nextInt(2)) {
            case 0:
                NAME="cog_grey";
                break;
            case 1:
                NAME="cog_red";
                break;
        }
    }

    public void remove(RemovalReason p_149847_) {
        if (this.isDeadOrDying()) {
            if (this.random.nextDouble() * 100.0 <= this.level().getGameRules().getInt(ModGameRules.RULE_BOSS_SPAWN_PERCENTAGE)) {
                if (this.level().getBiome(this.blockPosition()).is(BiomeTags.IS_END))boss = MobsCore.GENERAL_VENJIX.get().create(this.level());
                else if (this.level().dimension() == MOON)boss = MobsCore.GENERAL_VENJIX.get().create(this.level());
                {
                    if (boss != null) {
                        boss.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        this.level().addFreshEntity(boss);
                    }
                }
            }
        }
        super.remove(p_149847_);
    }
}
