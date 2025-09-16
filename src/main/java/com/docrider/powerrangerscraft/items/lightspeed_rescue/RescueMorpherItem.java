package com.docrider.powerrangerscraft.items.lightspeed_rescue;

import com.docrider.powerrangerscraft.items.LightspeedRescueItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class RescueMorpherItem extends RangerChangerItem{

	public RescueMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
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
		else return riderName+get_Form_Item(itemstack,1).getFormName(fly);
	}
}