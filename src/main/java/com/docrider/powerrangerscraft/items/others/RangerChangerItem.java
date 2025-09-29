package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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

    public static boolean isTransforming(LivingEntity player) {
        if (!(player.getItemBySlot(EquipmentSlot.FEET).getItem()instanceof RangerChangerItem))return false;
        else if (player.getItemBySlot(EquipmentSlot.FEET).has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = player.getItemBySlot(EquipmentSlot.FEET).get(DataComponents.CUSTOM_DATA).getUnsafe();
            return tag.getDouble("is_transforming")!=0;
        }
        return false;
    }

    public static double getRenderType(ItemStack stack) {
        double form_double = 1;
        RangerFormChangeItem form = get_Form_Item(stack, 1);
        if (form.get_Show_Face())form_double=2;
        if (form.get_Show_under())form_double=3;
        return form_double ;
    }

    public void beltTick(ItemStack stack, Level level, LivingEntity player, int slotId) {
        if (stack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            if (tag.getBoolean("Update_form")&&slotId==36) OnformChange(stack, player, tag);
            if (!isTransformed(player)||slotId!=36) tag.putBoolean("Update_form", true);
            if (isTransformed(player)) tag.putDouble("render_type", getRenderType(stack));
            if (!isTransformed(player)) tag.putDouble("render_type", 0);
            if (tag.getDouble("is_transforming")!=0) tag.putDouble("is_transforming", tag.getDouble("is_transforming")-1);
            if (tag.getDouble("is_transforming")<0) tag.putDouble("is_transforming", 0);

            if (tag.getDouble("use_ability")!=0) tag.putDouble("use_ability", tag.getDouble("use_ability")-1);
            if (tag.getDouble("use_ability")<0) tag.putDouble("use_ability", 0);

            //if (!level.isClientSide)player.sendSystemMessage(Component.literal("SlotID=" + slotId));

        }else{
            set_Update_Form(stack);
        }
    }


    public void giveEffects(LivingEntity player) {

        if (isTransformed(player)) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RangerFormChangeItem form = get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), n + 1);
                List<MobEffectInstance> potionEffectList = form.getPotionEffectList();
                for (MobEffectInstance effect : potionEffectList) {
                    if (effect.getEffect() != MobEffects.DAMAGE_BOOST&
                            effect.getEffect() != MobEffects.DIG_SPEED&
                            effect.getEffect() != MobEffects.REGENERATION&
                            effect.getEffect() != MobEffects.DAMAGE_RESISTANCE&
                            effect.getEffect() != MobEffects.MOVEMENT_SPEED&
                            effect.getEffect() != EffectCore.SLASH&
                            effect.getEffect() != EffectCore.PUNCH
                            ||player instanceof Player) {
                        player.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier(), true, false));
                    }
                }
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity player) {
            beltTick(stack,level,player,slotId);
            giveEffects(player);
        }
    }

    public void OnformChange(ItemStack itemstack, LivingEntity player,CompoundTag  tag) {
        if(isTransformed(player)) {
            OnTransformation(itemstack,player);
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", false);
                form.putDouble("is_transforming",120);
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }

    }
    /*
    public void OnTransform(ItemStack itemstack, LivingEntity player) {
        if (player.getItemBySlot(EquipmentSlot.FEET)==itemstack) OnTransformation(itemstack, player);
    }
    */
    public void OnTransformation(ItemStack itemstack, LivingEntity player) {
        if(isTransformed(player) && !player.level().isClientSide()) {
            for (int n = 0; n < Num_Base_Form_Item; n++) {
                RangerFormChangeItem form = get_Form_Item(itemstack, n + 1);
                form.OnTransformation(itemstack, player);
            }
        }
    }

    public RangerChangerItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get());
        Num_Base_Form_Item=2;
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


    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity ranger, String rangerName)
    {

        boolean fly = ranger instanceof Player player && player.getAbilities().flying;

        if (equipmentSlot == EquipmentSlot.FEET) {
            String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
            if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null||get_Form_Item(itemstack,1).getIgnoreOverrideBeltText()) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return "belts/"+belt;
        }

        else return get_Form_Item(itemstack,1).getRangerName(rangerName)+get_Form_Item(itemstack,1).getFormName(fly);

    }

    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity ranger, String rangerName ,int num)
    {
        return "blank";
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack,RangerArmorItem animatable, EquipmentSlot slot, LivingEntity ranger) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).get_Belt_Model());
    }


    public ResourceLocation getModelResource(ItemStack itemstack,RangerArmorItem animatable, EquipmentSlot slot, LivingEntity ranger) {
        if (get_Form_Item(itemstack, 1).HasWingsIfFlying() && ranger instanceof Player player && player.getAbilities().flying){
            return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, 1).get_FlyingModel(this.Rider));
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, 1).get_Model(this.Rider));
    }

    public ResourceLocation getAnimationResource(ItemStack itemstack,RangerArmorItem animatable, EquipmentSlot slot) {

        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).get_Animation(this.Rider));

    }


    public static void reset_Form_Item(ItemStack  itemstack)
    {

        if(itemstack.getItem() instanceof RangerChangerItem belt){

            if (belt.Num_Base_Form_Item!=1) {
                for (int n = 0; n < belt.Num_Base_Form_Item-1; n++)
                {
                    set_Form_Item( itemstack,belt.Extra_Base_Form_Item.get(n),2+n);
                }
            }
            set_Form_Item( itemstack,belt.Base_Form_Item,1);

        }
    }

    public static void set_Update_Form(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> {
                form.putBoolean("Update_form", true);
                form.putDouble("render_type", getRenderType(itemstack));
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }

    public static void set_Use_Ability(ItemStack itemstack)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof RangerChangerItem) {
            Consumer<CompoundTag> data = form -> {
                form.putDouble("use_ability", 5);
            };
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
        }
    }


    public static void set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
    {
        if (!itemstack.has(DataComponents.CUSTOM_DATA)) itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        if (itemstack.getItem() instanceof RangerChangerItem changer) {
            Consumer<CompoundTag> data = form -> {
                if (!form.getString("slot_tex" + SLOT).equals(ITEM.toString())) {
                    form.putString("slot_tex" + SLOT, ITEM.toString());
                    form.putBoolean("Update_form", true);
                    form.putDouble("render_type", getRenderType(itemstack));
                }
            };

            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
            changer.Extra_set_Form_Item(itemstack, ITEM, SLOT, itemstack.get(DataComponents.CUSTOM_DATA).copyTag());
        }
    }


    public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT,CompoundTag  tag)
    {
    }


    public  boolean getGlowForSlot(ItemStack itemstack,EquipmentSlot currentSlot, LivingEntity livingEntity) {
        if (currentSlot== EquipmentSlot.FEET) return get_Form_Item(itemstack, 1).get_Is_Belt_Glowing();
        else if (isTransformed(livingEntity)) return get_Form_Item(itemstack, 1).get_Is_Glowing();
        return false;
    }
    public void openInventory(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
    }

    public void setUseAbility(ServerPlayer player, InteractionHand hand, ItemStack itemstack) {
        set_Use_Ability(itemstack);
    }

    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case HEAD,CHEST,LEGS ->{
                if (part =="head") return true;
                if (part =="body") return true;
                if (part =="rightArm") return true;
                if (part =="leftArm") return true;
                if (part =="rightLeg") return true;
                if (part =="leftLeg") return true;
            }

            default -> {}
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if (Has_basic_belt_info) {
            if (Show_belt_form_info) {
                {
                    Item formItem = this.get_Form_Item(stack, 1);
                    tooltipComponents.add(Component.translatable(formItem.toString() + ".form"));
                }
            }
        }
        super.appendHoverText(stack, context,tooltipComponents, tooltipFlag);
    }


    public static RangerFormChangeItem get_Form_Item(ItemStack itemstack,int SLOT) {

        RangerChangerItem belt = (RangerChangerItem) itemstack.getItem();
        RangerFormChangeItem Base_Form_Item = (SLOT>=2 ? belt.Extra_Base_Form_Item.get(SLOT-2) : belt.Base_Form_Item);

        if (itemstack.has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            ResourceLocation Used_Form_Item = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
            if (BuiltInRegistries.ITEM.get(Used_Form_Item) instanceof RangerFormChangeItem formItem) {
                return formItem;
            }
        }
        return Base_Form_Item;
    }

}