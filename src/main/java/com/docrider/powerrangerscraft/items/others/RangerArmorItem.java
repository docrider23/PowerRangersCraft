package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.client.renderer.armor.RangerArmorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class RangerArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private Item RepairItem = OtherItems.GRID_INFUSED_GOLD_INGOT.get();

    public RangerArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties.stacksTo(1).durability(type ==Type.BOOTS?600:500));

    }

    @Override
    public boolean canElytraFly(ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
        return entity.hasEffect(EffectCore.GLIDE);
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, net.minecraft.world.entity.LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                entity.gameEvent(net.minecraft.world.level.gameevent.GameEvent.ELYTRA_GLIDE);
            }
        }
        return true;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private RangerArmorRenderer renderer;

            @Override
            public <T extends LivingEntity> HumanoidModel<?> getGeoArmorRenderer(@Nullable T livingEntity, ItemStack itemStack, @Nullable EquipmentSlot equipmentSlot, @Nullable HumanoidModel<T> original) {
                if(this.renderer == null)
                    this.renderer = new RangerArmorRenderer(livingEntity, equipmentSlot);
                final Minecraft mc = Minecraft.getInstance();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original, mc.renderBuffers().bufferSource(), mc.getTimer().getGameTimeDeltaPartialTick(true), 0, 0, 0, 0);

                return this.renderer;
            }
        });
    }

    public RangerArmorItem AddToTabList(List<Item> TabList) {
        TabList.add(this);
        return this;
    }

    public static Float GetWheelRotation(ItemStack itemstack)
    {
        if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof RangerArmorItem) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getFloat("wheel_rotation");
        }
        return 0f;
    }

    public static void setWheelRotation(ItemStack itemstack,Float num)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> form.putFloat("wheel_rotation", num);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    public static Float GetBallRotation(ItemStack itemstack)
    {
        if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof RangerArmorItem) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getFloat("ball_rotation");
        }
        return 0f;
    }

    public static void setBallRotation(ItemStack itemstack,Float num)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> form.putFloat("ball_rotation", num);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    public static Float GetCapeRotation(ItemStack itemstack)
    {
        if (itemstack.has(DataComponents.CUSTOM_DATA)&itemstack.getItem()instanceof RangerArmorItem) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getFloat("cape_rotation");
        }
        return 0f;
    }

    public static void setCapeRotation(ItemStack itemstack,Float num)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> form.putFloat("cape_rotation", num);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
        controllerRegistrar.add(new AnimationController<>(this, "riderAnim", 20, state -> {
            state.setAndContinue(IDLE);
            return PlayState.CONTINUE;
        }));
    }

    public RangerArmorItem ChangeRepairItem(Item item) {
        RepairItem = item;
        return this;
    }

    public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
        return p_40393_.getItem()== RepairItem;
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}