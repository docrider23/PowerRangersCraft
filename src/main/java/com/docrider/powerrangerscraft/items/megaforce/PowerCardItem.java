package com.docrider.powerrangerscraft.items.megaforce;

import com.docrider.powerrangerscraft.items.others.BaseItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.MegaforceItems;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PowerCardItem extends BaseItem {

    public String ranger;
    private String weapons;

    public PowerCardItem(Item.Properties properties, String ranger, String weapons) {
        super(properties);
        this.ranger = ranger;
        this.weapons = weapons;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        if (!level.isClientSide() && player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt && belt.isTransformed(player)) {
            if (ranger.equals(((RangerChangerItem) player.getItemBySlot(EquipmentSlot.FEET).getItem()).Rider)) {
                switch (weapons) {
                    case "dragon_sword":
                        ItemStack item = new ItemStack(MegaforceItems.DRAGON_SWORD.get(), 1);
                        ItemEntity entity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item, 0, 0, 0);
                        entity.setPickUpDelay(0);
                        level.addFreshEntity(entity);
                        break;
                    case "phoenix_shot":
                        ItemStack item1 = new ItemStack(MegaforceItems.PHOENIX_SHOT.get(), 1);
                        ItemEntity entity1 = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item1, 0, 0, 0);
                        entity1.setPickUpDelay(0);
                        level.addFreshEntity(entity1);
                        break;
                    case "snake_axe":
                        ItemStack item2 = new ItemStack(MegaforceItems.SNAKE_AXE.get(), 1);
                        ItemEntity entity2 = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item2, 0, 0, 0);
                        entity2.setPickUpDelay(0);
                        level.addFreshEntity(entity2);
                        break;
                    case "tiger_claw":
                        ItemStack item3 = new ItemStack(MegaforceItems.TIGER_CLAW.get(), 1);
                        ItemEntity entity3 = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item3, 0, 0, 0);
                        entity3.setPickUpDelay(0);
                        level.addFreshEntity(entity3);
                        break;
                    case "shark_bowgun":
                        ItemStack item4 = new ItemStack(MegaforceItems.SHARK_BOWGUN.get(), 1);
                        ItemEntity entity4 = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), item4, 0, 0, 0);
                        entity4.setPickUpDelay(0);
                        level.addFreshEntity(entity4);
                        break;
                }

                if (!player.isCreative()) {
                    itemstack.shrink(1);
                    player.getCooldowns().addCooldown(this, 500);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
