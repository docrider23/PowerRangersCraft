package com.docrider.powerrangerscraft.items.in_space;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.InSpaceItems;
import com.docrider.powerrangerscraft.items.others.RangerFormChangeItem;
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

public class AstroMorpherItem extends RangerChangerItem{

	public AstroMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
		Show_belt_form_info = false;
	}

	@Override
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
		super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);

		RangerFormChangeItem formItem1 = get_Form_Item(stack,1);
		if (formItem1 != Base_Form_Item) {
			tooltipComponents.add(Component.translatable(formItem1.toString() + ".form"));
		}
		Item formItem2 = get_Form_Item(stack, 2);
		if (formItem2 == InSpaceItems.BATTLIZER_DATA_CARD.get()){
			tooltipComponents.add(Component.translatable(formItem2.toString() + ".form"));
		}
	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
		
		boolean fly = !rider.onGround();
		
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (!isTransformed(rider)) {
				return "belts/astro_morpher";
			}
			else {
				if (rider.getMainHandItem().getItem() == InSpaceItems.ASTRO_BLASTER_1.get() |
						rider.getMainHandItem().getItem() == InSpaceItems.ASTRO_BLASTER_2.get() |
						rider.getMainHandItem().getItem() == InSpaceItems.ASTRO_BLASTER_COMBO.get()) {
					belt = get_Form_Item(itemstack, 1).getBeltTex() + "_empty";
				} else if (((RangerChangerItem) itemstack.getItem()).BELT_TEXT == null) {
					belt = get_Form_Item(itemstack, 1).getBeltTex();
				}
				return "belts/" + belt;
			}
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) {
			if (get_Form_Item(itemstack, 2).getFormName(fly).isEmpty()) return "blank";
			else return riderName + get_Form_Item(itemstack, 2).getFormName(fly);
		}
		else return riderName+get_Form_Item(itemstack,1).getFormName(fly);
	}

	@Override
	public ResourceLocation getBeltModelResource(ItemStack itemstack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/left_brace.geo.json");
		return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).getBeltModel());
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