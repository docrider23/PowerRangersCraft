package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.google.common.collect.Lists;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MechaGattaiItem extends MechaArmorItem{

    public String armorNamePrefix;
    public RangerFormChangeItem Base_Form_Item;
    private ArrayList<RangerFormChangeItem> Extra_Base_Form_Item;
    public String Rider;
    public Item TORSO;
    public Item LEGS;
    public Item BOOTS;
    public int Num_Base_Form_Item = 1;
    public String BELT_TEXT;

    public Boolean Has_basic_belt_info = true;
    public Boolean Show_belt_form_info = true;

    public int Unlimited_Textures = 0;


    public MechaGattaiItem (Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item>torso, DeferredItem<Item> legs, DeferredItem<Item> boot, Item.Properties properties)
    {
        super(material, ArmorItem.Type.HELMET, properties);

        Rider=rider;
        Base_Form_Item=((RangerFormChangeItem)baseFormItem.get());
        TORSO=torso.get();
        LEGS=legs.get();
        BOOTS=boot.get();

    }

    public boolean isTransformed(LivingEntity player) {
        return BOOTS.asItem()==player.getItemBySlot(EquipmentSlot.FEET).getItem()
                &&TORSO.asItem()==player.getItemBySlot(EquipmentSlot.CHEST).getItem()
                &&LEGS.asItem()==player.getItemBySlot(EquipmentSlot.LEGS).getItem();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {

        if (entity instanceof LivingEntity player) {

            if (stack.getComponents().has(DataComponents.CUSTOM_DATA)) {
                CompoundTag tag = stack.get(DataComponents.CUSTOM_DATA).getUnsafe();
                if (tag.getBoolean("Update_form")) OnformChange(stack, player, tag);
            }

            if (isTransformed(player) && player.getItemBySlot(EquipmentSlot.HEAD) == stack) {
                for (int n = 0; n < Num_Base_Form_Item; n++) {
                    List<MobEffectInstance> potionEffectList = get_Form_Item(player.getItemBySlot(EquipmentSlot.HEAD), n + 1).getPotionEffectList();
                    for (int i = 0; i < potionEffectList.size(); i++) {
                        player.addEffect(new MobEffectInstance(potionEffectList.get(i).getEffect(), potionEffectList.get(i).getDuration(), potionEffectList.get(i).getAmplifier(), true, false));
                    }
                }
            }
        }
    }

    public void OnformChange(ItemStack itemstack, LivingEntity player,CompoundTag  tag) {
        player.setInvisible(false);
        tag.putBoolean("Update_form", false);
    }

    public MechaGattaiItem Add_Extra_Base_Form_Items(DeferredItem<Item> item) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get());
        Num_Base_Form_Item=2;
        return this;
    }

    public MechaGattaiItem Override_belt_text(String belt) {
        BELT_TEXT = belt;
        return this;
    }

    public MechaGattaiItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get());
        Num_Base_Form_Item=3;
        return this;
    }

    public MechaGattaiItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get(),(RangerFormChangeItem)item3.get());
        Num_Base_Form_Item=4;
        return this;
    }

    public MechaGattaiItem Add_Extra_Base_Form_Items(DeferredItem<Item> item,DeferredItem<Item> item2,DeferredItem<Item> item3,DeferredItem<Item> item4) {
        Extra_Base_Form_Item= Lists.newArrayList((RangerFormChangeItem)item.get(),(RangerFormChangeItem)item2.get(),(RangerFormChangeItem)item3.get(),(RangerFormChangeItem)item4.get());
        Num_Base_Form_Item=5;
        return this;
    }

    public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
    {

        boolean fly = !rider.onGround();

        if (equipmentSlot == EquipmentSlot.HEAD) {
            String belt = ((MechaGattaiItem)itemstack.getItem()).BELT_TEXT;
            if (((MechaGattaiItem)itemstack.getItem()).BELT_TEXT==null) {
                belt = get_Form_Item(itemstack,1).getBeltTex();
            }
            return belt;
        }
        else return riderName+get_Form_Item(itemstack,1).getFormName(fly);

    }

    public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName ,int num)
    {
        return "blank";
    }

    public ResourceLocation getModelResource(ItemStack itemstack, MechaArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).get_Model(this.Rider));
    }

    public ResourceLocation getBeltModelResource(ItemStack itemstack,MechaArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).get_Belt_Model());
    }

    public ResourceLocation getAnimationResource(ItemStack itemstack,MechaArmorItem animatable, EquipmentSlot slot) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
    }


    public static void set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT)
    {
        if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
            itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        }
        if (itemstack.getItem() instanceof MechaGattaiItem changer) {
            CompoundTag  tag = new CompoundTag();
            Consumer<CompoundTag> data = form ->
            {
                form.putString("slot_tex"+SLOT, ITEM.toString());
                form.putInt("slot"+SLOT, Item.getId(ITEM));
                form.putBoolean("Update_form", true);
            };

            data.accept(tag);
            CustomData.update(DataComponents.CUSTOM_DATA, itemstack, data);
            changer.Extra_set_Form_Item(itemstack, ITEM, SLOT,tag);
        }
    }

    public void Extra_set_Form_Item(ItemStack itemstack, Item ITEM,int SLOT, CompoundTag tag)
    {
    }

    public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

        switch (currentSlot) {
            case FEET ->{
                if (part =="head") return true;
            }
            case CHEST -> {
                if (part =="body") return true;
                if (part =="rightArm") return true;
                if (part =="leftArm") return true;
            }
            case LEGS -> {

                if (part =="rightLeg") return true;
                if (part =="leftLeg") return true;
            }
            default -> {}
        }
        return false;
    }




    public static RangerFormChangeItem get_Form_Item(ItemStack itemstack, int SLOT)
    {

        MechaGattaiItem belt = (MechaGattaiItem)itemstack.getItem();
        RangerFormChangeItem Base_Form_Item = belt.Base_Form_Item;

        if (SLOT == 2) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(0);
        }else if (SLOT == 3) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(1);
        }else if (SLOT == 4) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(2);
        }else if (SLOT == 5) {
            Base_Form_Item =belt.Extra_Base_Form_Item.get(3);
        }

        if (itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
            CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
            ResourceLocation Used_Form_Item = ResourceLocation.parse(tag.getString("slot_tex" + SLOT));
            if (BuiltInRegistries.ITEM.get(Used_Form_Item) instanceof RangerFormChangeItem formItem) {
                return formItem;
            }
        }

        return Base_Form_Item;
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
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


}