package com.docrider.powerrangerscraft.items.operation_overdrive;

import com.docrider.powerrangerscraft.items.OperationOverdriveItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class OverdriveTrackerItem extends RangerChangerItem{

	public OverdriveTrackerItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Show_belt_form_info=false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

		Item formItem = this.get_Form_Item(stack, 1);
		Item formItem2 = this.get_Form_Item(stack, 2);
		boolean isSentinel = formItem == OperationOverdriveItems.SENTINEL_MORPHER.get();

		Has_basic_belt_info = !isSentinel;
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

		if (isSentinel) {tooltipComponents.add(Component.translatable("powerrangerscraft.name.red_sentinel_ranger"));}
		if (formItem2 != OtherItems.BLANK_FORM.get()) {tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));}

	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName)
	{
		String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
		
		boolean fly = !rider.onGround();
		
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (!isTransformed(rider)) {
				return "blank";
			}
			else {
				if (rider.getMainHandItem().getItem() == OperationOverdriveItems.DRIVE_DEFENDER.get()) {
					belt = get_Form_Item(itemstack, 1).getBeltTex() + "_empty";
				} else if (((RangerChangerItem) itemstack.getItem()).BELT_TEXT == null) {
					belt = get_Form_Item(itemstack, 1).getBeltTex();
				}
				return "belts/" + belt;
			}
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) {
			if (get_Form_Item(itemstack,2).getFormName(fly)=="") return "blank";
			else return get_Form_Item(itemstack,2).getFormName(fly);
		}
		
		else return rangerName+get_Form_Item(itemstack,1).getFormName(fly);
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