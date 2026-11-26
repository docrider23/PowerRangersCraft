package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.entity.summon.BaseSummonEntity;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.world.attribute.PRCAttributes;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredItem;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static com.docrider.powerrangerscraft.world.attribute.PRCAttributes.IS_TRANSFORMING;

public class RangerChangerItem extends RangerArmorItem{

    public RangerFormChangeItem Base_Form_Item;
    public RangerFormChangeItem Armor_Form_Item;
    protected ArrayList<RangerFormChangeItem> Extra_Base_Form_Item;

    public String Rider;
    public Item HEAD;
    public Item TORSO;
    public Item LEGS;
    public int Num_Base_Form_Item = 1;
    public String BELT_TEXT;
    private Boolean A1 = false;

    public int Unlimited_Textures = 0;
    public int Unlimited_Belt_Textures = 0;

    public Boolean Has_basic_belt_info = true;
    public Boolean Show_belt_form_info = true;

    public RangerChangerItem (Holder<ArmorMaterial> material, String ranger, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
    {
        super(material, ArmorItem.Type.BOOTS, properties);
        Rider=ranger;
        Base_Form_Item=((RangerFormChangeItem)baseFormItem.get());
        Armor_Form_Item=((RangerFormChangeItem)baseFormItem.get());
        HEAD=head.get();
        TORSO=torso.get();
        LEGS=legs.get();

    }

    public RangerChangerItem (Holder<ArmorMaterial> material, String ranger,DeferredItem<Item> baseFormItem,DeferredItem<Item> armorFormItem,DeferredItem<Item> head,DeferredItem<Item>torso,DeferredItem<Item> legs, Properties properties)
    {
        super(material, ArmorItem.Type.BOOTS, properties);
        Rider=ranger;
        Base_Form_Item=((RangerFormChangeItem)baseFormItem.get());
        Armor_Form_Item=((RangerFormChangeItem)armorFormItem.get());
        HEAD=head.get();
        TORSO=torso.get();
        LEGS=legs.get();

    }

    public boolean isTransformed(LivingEntity player) {
        if (!(player.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RangerChangerItem))return false;
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem()==HEAD.asItem()
                &&player.getItemBySlot(EquipmentSlot.CHEST).getItem()==TORSO.asItem()
                &&player.getItemBySlot(EquipmentSlot.LEGS).getItem()==LEGS.asItem()
                &&player.getItemBySlot(EquipmentSlot.FEET).getItem()==this;
    }

    public static boolean isTransforming(LivingEntity rider) {
        if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
            ItemStack stack = rider.getItemBySlot(EquipmentSlot.FEET);
            double henshin_tick = belt.getHenshinTick(stack, rider);
            return !(henshin_tick < 1);
        }
        return false;
    }

    public static Boolean isTransformingFromBlank(ItemStack itemStack, LivingEntity rider) {
        Double form_time = 30D;
        if (itemStack.getItem() instanceof RangerChangerItem belt) form_time = belt.getBaseHenshinTick(itemStack,rider);
        return get_Form_Item(itemStack, 1, form_time + 1) == OtherItems.BLANK_FORM.asItem()&isTransforming(rider) ;
    }

    public double getRenderType(ItemStack stack, double num , LivingEntity rider) {
        double form_double = 1;
        RangerFormChangeItem form = get_Form_Item(stack, 1, num);
        if (form.getShowHead()) {
            form_double = 4;
        }
        if (form.getShowFace()) {
            form_double = 2;
        }
        if (form.getShowUnder()) {
            form_double = 3;
        }
        if (form.getShowPlayer()) {
            form_double = 0;
        }
        return form_double;
    }

    public void beltTick(ItemStack stack, Level level, LivingEntity rider, int slotId) {
        if (stack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(stack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            if (tag.getBoolean("Update_form") && slotId == 36) {
                onFormChange(stack, rider, tag);
            }
            if (!isTransformed(rider) || slotId != 36) {
                tag.putBoolean("Update_form", true);
            }
            if (isTransformed(rider)) {
                tag.putDouble("render_type", getRenderType(stack, rider.getAttribute(IS_TRANSFORMING).getBaseValue(),rider));
            }
            if (!isTransformed(rider)) {
                tag.putDouble("render_type", 0);
            }

            if (!rider.level().isClientSide()) {
                for (int n = 0; n < Num_Base_Form_Item; n++) {
                    RangerFormChangeItem form = get_Form_Item(stack, n + 1);
                    form.transformationEffect(stack, rider, Objects.requireNonNull(rider.getAttribute(IS_TRANSFORMING)).getBaseValue());
                    if (get_Form_Item(stack, n + 1, get_Form_Item(stack, n + 1).getHenshinTick() + 1) != get_Form_Item(stack, n + 1))RangerChangerItem.updateOldFormItemSlot(stack,n + 1);
                }
            }
        } else {
            set_Update_Form(stack);
        }
    }


    public void giveEffects(LivingEntity player) {

        if (isTransformed(player)) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RangerFormChangeItem form = get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), n + 1);
                List<MobEffectInstance> potionEffectList = form.getPotionEffectList();
                for (MobEffectInstance effect : potionEffectList) {
                    if ((effect.getEffect() != MobEffects.DAMAGE_BOOST&&
                            effect.getEffect() != MobEffects.DIG_SPEED&&
                            effect.getEffect() != MobEffects.REGENERATION&&
                            effect.getEffect() != MobEffects.DAMAGE_RESISTANCE&&
                            effect.getEffect() != MobEffects.MOVEMENT_SPEED&&
                            effect.getEffect() != EffectCore.SLASH&&
                            effect.getEffect() != EffectCore.PUNCH)
                            ||(player instanceof BaseSummonEntity
                            &&(effect.getEffect() != MobEffects.DAMAGE_RESISTANCE || effect.getAmplifier() < 3))
                            ||player instanceof Player) {
                        player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
                    }
                }
            }
        }
    }

    public void timeoutForms(LivingEntity rider, ItemStack stack) {
        if (!rider.level().isClientSide()) {
            for (int n = 1; n == this.Num_Base_Form_Item; n++) {
                RangerFormChangeItem form = RangerChangerItem.get_Form_Item(stack, n);
                if (form.getTimeoutDuration() != 0) {
                    RangerChangerItem.setFormItem(stack, form.getRevertForm(), n);
                    rider.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, form.getLockDuration(), 0, false, false));
                }
            }
            rider.removeEffect(EffectCore.FORM_TIMEOUT);
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity rider && stack == rider.getItemBySlot(EquipmentSlot.FEET)) {
            this.beltTick(stack, level, rider, slotId);
            this.giveEffects(rider);
            if (rider.hasEffect(EffectCore.FORM_TIMEOUT) && !isTransformed(rider)) {
                this.timeoutForms(rider, stack);
            }
        }
        if (entity instanceof LivingEntity player) {
            if (stack.has(DataComponents.CUSTOM_DATA)) {
                if (!isTransformed(player) || slotId != 36) {
                    Consumer<CompoundTag> data = form -> {
                        form.putBoolean("rider_kicking", false);
                        form.putDouble("rider_kick_cooldown", 200);
                        form.putDouble("rider_kick_tick", 0);
                        form.putDouble("render_type", 0);
                        form.putDouble("changed_form_slot", 0);
                        form.putBoolean("Update_form", true);
                        if (get_Form_Item(stack, 1).GetIsAttackForm()) {
                            form.putString("slot_tex" + 1, form.getString("slot_tex_old" + 1));
                        }
                        form.putString("slot_tex_old" + 1, OtherItems.BLANK_FORM.asItem().toString());

                    };
                    CustomData.update(DataComponents.CUSTOM_DATA, stack, data);
                }
            } else {
                set_Update_Form(stack);
            }
            if (player.hasEffect(EffectCore.FORM_TIMEOUT)) {
                this.timeoutForms(player, stack);
            }
        }
    }

    public void onFormChange(ItemStack itemStack, LivingEntity rider, CompoundTag tag) {
        if (isTransformed(rider)) {
            onTransformation(itemStack, rider);
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", false);
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
            Objects.requireNonNull(rider.getAttribute(IS_TRANSFORMING)).setBaseValue(getBaseHenshinTick(itemStack,rider));
            Objects.requireNonNull(rider.getAttribute(PRCAttributes.CAPE_ROT)).setBaseValue(0);
            Objects.requireNonNull(rider.getAttribute(PRCAttributes.WHEEL_ROT)).setBaseValue(0);
            Objects.requireNonNull(rider.getAttribute(PRCAttributes.BALL_ROT)).setBaseValue(0);
        }
    }
    /*
    public void OnTransform(ItemStack itemstack, LivingEntity player) {
        if (player.getItemBySlot(EquipmentSlot.FEET)==itemstack) OnTransformation(itemstack, player);
    }
    */
    public void onTransformation(ItemStack itemStack, LivingEntity rider) {
        if (isTransformed(rider) && !rider.level().isClientSide()) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RangerFormChangeItem form = get_Form_Item(itemStack, n + 1);
                form.OnTransformation(itemStack, rider);
            }
        }
    }

    public RangerChangerItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get());
        Num_Base_Form_Item=2;
        return this;
    }

    public RangerChangerItem Dont_show_basic_belt_info() {
        Has_basic_belt_info=false;
        return this;
    }

    public RangerChangerItem Dont_show_belt_form_info() {
        Show_belt_form_info=false;
        return this;
    }

    public RangerChangerItem Override_belt_text(String belt) {
        BELT_TEXT = belt;
        return this;
    }

    public RangerChangerItem IsA1() {
        A1=true;
        return this;
    }
    public RangerChangerItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get());
        Num_Base_Form_Item=3;
        return this;
    }

    public RangerChangerItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get(),(RangerFormChangeItem)item3.get());
        Num_Base_Form_Item=4;
        return this;
    }
    public RangerChangerItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3,DeferredItem<Item> item4) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get(),(RangerFormChangeItem)item3.get(),(RangerFormChangeItem)item4.get());
        Num_Base_Form_Item=5;
        return this;
    }


    public String GET_TEXT(ItemStack itemStack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName) {
        double henshin_tick = getHenshinTick(itemStack, rider);
        boolean fly = rider.getAttribute(PRCAttributes.WINGS_OUT).getBaseValue() == 1;


        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RangerChangerItem) itemStack.getItem()).BELT_TEXT;
            if (((RangerChangerItem) itemStack.getItem()).BELT_TEXT == null || get_Form_Item(itemStack, 1).getIgnoreOverrideBeltText()) {
                belt = get_Form_Item(itemStack, 1).getBeltTex();
            }
            return "belts/" + belt;
        } else {
            return get_Form_Item(itemStack, 1, henshin_tick).getRangerName(rangerName) + get_Form_Item(itemStack, 1, henshin_tick).getFormName(fly);
        }
    }

    public String getUnlimitedTextures(ItemStack itemstack, LivingEntity ranger, String rangerName ,int num)
    {
        return "blank";
    }

    public void setCustomAnimations(RangerArmorItem an, long instanceId, AnimationState<RangerArmorItem> state) {

    }

    public String getUnlimitedBeltTextures(ItemStack itemStack, LivingEntity rider, String riderName, int num) {
        return "blank";
    }

    public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {

        //if(slot==EquipmentSlot.HEAD&isTransformed(rider))layerInfo.add(new RenderLayerInfo("ferbus", "ferbus"));
        //if(slot==EquipmentSlot.HEAD&isTransformed(rider))layerInfo.add(new ModuleRenderLayerInfo("ferbus", "ferbus", Color.MAGENTA.getColor(),1));

        double henshin_tick = getHenshinTick(itemStack, rider);
        for (int n = 0; n < Num_Base_Form_Item; n++) {
            RangerFormChangeItem form = get_Form_Item(rider.getItemBySlot(EquipmentSlot.FEET), n + 1, henshin_tick);
            form.SetUnlimitedModels(layerInfo, itemStack, rider, slot);
        }

        if (slot == EquipmentSlot.FEET) {
            String texture = GET_TEXT(itemStack, EquipmentSlot.FEET, rider, Rider);
            ResourceLocation location = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/" + texture + ".png");
            if (this.getGlowForSlot(itemStack, EquipmentSlot.FEET, rider)) {
                if (ModList.get().isLoaded("iris")) {
                    layerInfo.add(new RenderLayerInfo(AutoGlowingTexture.getRenderType(location), null));
                } else {
                    layerInfo.add(new RenderLayerInfo(texture, null, texture + "_glowmask"));
                }
            }

            if (Unlimited_Belt_Textures != 0) {
                for (int n = 0; n < Unlimited_Belt_Textures; n++) {
                    layerInfo.add(new RenderLayerInfo("belts/" + getUnlimitedBeltTextures(itemStack, rider, this.Rider, n + 1), null));
                }
            }
        } else if (Unlimited_Belt_Textures != 0 & slot == EquipmentSlot.HEAD & isTransformed(rider)) {
            for (int n = 0; n < Unlimited_Textures; n++) {
                layerInfo.add(new RenderLayerInfo(getUnlimitedTextures(itemStack, rider, this.Rider, n + 1), null));
            }
        }


    }

    public double getHenshinTick(ItemStack itemStack, LivingEntity rider) {
        double transformingTick = Objects.requireNonNull(rider.getAttribute(IS_TRANSFORMING)).getBaseValue();
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            if (tag.getBoolean("Update_form")) {
                transformingTick = getBaseHenshinTick(itemStack,rider);
            }
        }
        return transformingTick;
    }

    public double getBaseHenshinTick(ItemStack stack, LivingEntity ride){
        return get_Form_Item(stack, 1).getHenshinTick();
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack,RangerArmorItem animatable, EquipmentSlot slot, LivingEntity ranger) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).getBeltModel());
    }


    public ResourceLocation getModelResource(ItemStack itemStack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        double transformingTick = getHenshinTick(itemStack, rider);
        if (get_Form_Item(itemStack, 1, transformingTick).hasWingsIfFlying() && rider.getAttribute(PRCAttributes.WINGS_OUT).getBaseValue() == 1) {
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/" + get_Form_Item(itemStack, 1, transformingTick).getFlyingModel(this.Rider));
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/" + get_Form_Item(itemStack, 1, transformingTick).getModel(this.Rider));
    }


    public static void reset_Form_Item(ItemStack  itemstack)
    {
        if(itemstack.getItem() instanceof RangerChangerItem belt){
            if (belt.Num_Base_Form_Item!=1) {
                for (int n = 0; n < belt.Num_Base_Form_Item-1; n++)
                {
                    setFormItem( itemstack,belt.Extra_Base_Form_Item.get(n),2+n);
                }
            }
            setFormItem(itemstack,belt.Base_Form_Item,1);
        }
    }

    public static void set_Update_Form(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem belt) {
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", true);
                form.putDouble("render_type", 0);
                form.putDouble("changed_form_slot", 0);
                form.putString("slot_tex_old" + 1, OtherItems.BLANK_FORM.asItem().toString());
                for (int n = 1; n <= belt.Num_Base_Form_Item; n++) {
                    form.putString("slot_tex" + n, get_Form_Item(itemstack, n).toString());
                }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    public static void setUseAbility(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> form.putDouble("use_ability", 5);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }


    public static void setFormItem(ItemStack itemStack, Item item, int slot) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            set_Update_Form(itemStack);
        }
        if (itemStack.getItem() instanceof RangerChangerItem driver) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + slot).equals(item.toString())) {
                    form.putString("slot_tex" + slot, item.toString());
                    form.putDouble("changed_form_slot", slot);
                    form.putBoolean("Update_form", true);
                }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
            driver.setExtraFormItem(itemStack, item, slot, itemStack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
    }


    public static void setFormItemNoExtra(ItemStack itemStack, Item item, int slot) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            set_Update_Form(itemStack);
        }
        if (itemStack.getItem() instanceof RangerChangerItem driver) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + slot).equals(item.toString())) {
                    form.putString("slot_tex" + slot, item.toString());
                    form.putBoolean("Update_form", true);
                }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }

    public static void revertFormItem(ItemStack itemStack, int slot) {
        Item form = RangerChangerItem.get_Form_Item(itemStack, 1, 200);
        if (form != OtherItems.BLANK_FORM.asItem()) {
            RangerChangerItem.setFormItem(itemStack, RangerChangerItem.get_Form_Item(itemStack, 1, 200), slot);
        } else {
            RangerChangerItem.reset_Form_Item(itemStack);
        }
    }

    public static void updateOldFormItem(ItemStack itemStack) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            set_Update_Form(itemStack);
        }
        if (itemStack.getItem() instanceof RangerChangerItem driver) {
            Consumer<CompoundTag> data = form -> {
                for (int n = 1; n <= driver.Num_Base_Form_Item; n++) {
                    form.putString("slot_tex_old" + n, form.getString("slot_tex" + n));
                }
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }

    public static void updateOldFormItemSlot(ItemStack itemStack, int slot) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            set_Update_Form(itemStack);
        }
        if (itemStack.getItem() instanceof RangerChangerItem driver) {
            Consumer<CompoundTag> data = form -> {
                form.putString("slot_tex_old" + slot, form.getString("slot_tex" + slot));
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }

    public static void setOldFormItem(ItemStack itemStack, Item formItem, int slot) {
        if (!itemStack.has(DataComponents.CUSTOM_DATA)) {
            set_Update_Form(itemStack);
        }
        if (itemStack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> {
                form.putString("slot_tex_old" + slot, formItem.toString());
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemStack, data);
        }
    }

    public void setExtraFormItem(ItemStack itemStack, Item ITEM, int SLOT, CompoundTag tag) {
    }

    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {
        if (currentSlot== EquipmentSlot.FEET) return get_Form_Item(itemstack, 1).getIsBeltGlowing();
        else if (isTransformed(livingEntity)) return get_Form_Item(itemstack, 1).getIsGlowing();
        return false;
    }
    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
    }

    public boolean getPartsForSlot(ItemStack itemStack, EquipmentSlot currentSlot, String part) {
        return currentSlot.equals(EquipmentSlot.HEAD);
    }

    public RangerChangerItem CanChangeTexture() {
        PowerRangersCraftCore.CHANGE_CHANGER_TEXTURE.add(this);
        return this;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        LocalDate localdate = LocalDate.now();
        boolean isDateA1 = localdate.getMonthValue() == 4 && localdate.getDayOfMonth() == 1;

        if (Has_basic_belt_info) {
            if (A1 & isDateA1) {
                tooltipComponents.add(Component.translatable("powerrangerscraft.name." + Rider + ".a1"));
            } else {
                tooltipComponents.add(Component.translatable("powerrangerscraft.name." + Rider));
            }
            if (Show_belt_form_info) {
                RangerFormChangeItem formItem = get_Form_Item(itemStack, 1);
                if (formItem.getA1() & isDateA1) {
                    tooltipComponents.add(Component.translatable(formItem + ".form.a1"));

                } else {
                    tooltipComponents.add(Component.translatable(formItem + ".form"));
                }
            }
        }

        int i = 0;
        int j = 0;
        Iterator<ItemStack> var7 = itemStack.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).nonEmptyItems().iterator();
        if (var7.hasNext()) {
            tooltipComponents.add(Component.translatable("container.rider_belt"));
        }

        while (var7.hasNext()) {
            ItemStack inventoryStack = var7.next();
            ++j;
            if (i <= 2) {
                ++i;
                tooltipComponents.add(Component.translatable("container.shulkerBox.itemCount", inventoryStack.getHoverName(), inventoryStack.getCount()));
            }
        }

        if (j - i > 0) {
            tooltipComponents.add(Component.translatable("container.shulkerBox.more", j - i).withStyle(ChatFormatting.ITALIC));
        }
        super.appendHoverText(itemStack, tooltipContext, tooltipComponents, tooltipFlag);
    }


    public static RangerFormChangeItem get_Form_Item(ItemStack itemstack,int SLOT, double num) {

        RangerChangerItem belt = (RangerChangerItem) itemstack.getItem();
        RangerFormChangeItem Base_Form_Item = (SLOT>=2 ? belt.Extra_Base_Form_Item.get(SLOT-2) : belt.Base_Form_Item);

        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemstack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            ResourceLocation UsedFormItem = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
            ResourceLocation UsedFormItemOld = ResourceLocation.parse(tag.getString("slot_tex_old" + SLOT));
            if (BuiltInRegistries.ITEM.get(UsedFormItem) instanceof RangerFormChangeItem formItem) {
                if (BuiltInRegistries.ITEM.get(UsedFormItemOld) instanceof RangerFormChangeItem formItem2 && (num > formItem.getFormDelay())) {
                    return formItem2;

                } else if (num > formItem.getFormDelay()) {
                    return (RangerFormChangeItem) OtherItems.BLANK_FORM.asItem();
                }
                return formItem;
            }
        }
        return Base_Form_Item;
    }

    public static RangerFormChangeItem get_Form_Item(ItemStack itemStack, int slot) {
        return get_Form_Item(itemStack, slot, 0d);
    }

    public static boolean wasSlotChanged(ItemStack itemStack, int slot) {
        if (itemStack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = Objects.requireNonNull(itemStack.get(DataComponents.CUSTOM_DATA)).getUnsafe();
            String UsedFormItem = tag.getString("slot_tex" + slot);
            String UsedFormItemOld = tag.getString("slot_tex_old" + slot);
            //System.err.println(UsedFormItem+"_"+UsedFormItemOld);
            return !UsedFormItem.equals(UsedFormItemOld);
        }
        return false;
    }

    public boolean HasCpae(ItemStack itemstack) {
        for (int n = 0; n < Num_Base_Form_Item; n++) {
            if(get_Form_Item(itemstack, n + 1).getHasCape())return true;
        }
        return false;
    }
}