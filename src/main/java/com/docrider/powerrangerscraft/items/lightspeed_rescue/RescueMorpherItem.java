package com.docrider.powerrangerscraft.items.lightspeed_rescue;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.LightspeedRescueItems;
import com.docrider.powerrangerscraft.items.LostGalaxyItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class RescueMorpherItem extends RangerChangerItem{

	public RescueMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Has_basic_belt_info=false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		Item formItem = this.get_Form_Item(stack, 1);
		Item formItem2 = this.get_Form_Item(stack, 2);

		if (formItem2== OtherItems.BLANK_FORM.get()) tooltipComponents.add(Component.literal(Component.translatable(formItem.toString() + ".form").getString()));
		else {
			tooltipComponents.add(Component.literal(Component.translatable(formItem.toString() + ".form").getString()
					+ " " + Component.translatable(formItem2.toString() + ".form").getString()));
		}
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
		
		boolean fly = !rider.onGround();
		
		if (equipmentSlot == EquipmentSlot.FEET) {
				if (rider.getMainHandItem().getItem()== LightspeedRescueItems.RESCUE_BLASTER_RED.get()|
						rider.getMainHandItem().getItem()== LightspeedRescueItems.RESCUE_BLASTER_BLUE.get()|
						rider.getMainHandItem().getItem()== LightspeedRescueItems.RESCUE_BLASTER_GREEN.get()|
						rider.getMainHandItem().getItem()== LightspeedRescueItems.RESCUE_BLASTER_YELLOW.get()|
						rider.getMainHandItem().getItem()== LightspeedRescueItems.RESCUE_BLASTER_PINK.get()) {
					belt = get_Form_Item(itemstack,1).getBeltTex()+"_empty";
				}
				else if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) {
			if (get_Form_Item(itemstack, 2).getFormName(fly).equals("_megabattle")) {
				return get_Form_Item(itemstack, 2).getRangerName(riderName) + get_Form_Item(itemstack, 2).getFormName(fly);
			}
			if (get_Form_Item(itemstack, 2).getFormName(fly).equals("_trans_armor")) {
				return get_Form_Item(itemstack, 2).getRangerName(riderName) + get_Form_Item(itemstack, 2).getFormName(fly);
			}
		}
		return riderName+get_Form_Item(itemstack,1).getFormName(fly);

	}

	public ResourceLocation getModelResource(ItemStack itemstack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		int num = 1;
		if (slot == EquipmentSlot.HEAD)num=2;

		return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+get_Form_Item(itemstack, num).get_Model(this.Rider));
	}

	@Override
	public boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case HEAD, LEGS ->{
				return true;
			}
			case CHEST -> {
			}
			default -> {}
		}
		return false;
	}
}