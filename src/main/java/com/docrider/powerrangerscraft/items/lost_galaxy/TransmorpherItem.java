package com.docrider.powerrangerscraft.items.lost_galaxy;

import com.docrider.powerrangerscraft.items.LostGalaxyItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class TransmorpherItem extends RangerChangerItem {

	public TransmorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName)
	{
		String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
		
		boolean fly = !rider.onGround();
		
		if (equipmentSlot == EquipmentSlot.FEET) {
			if (get_Form_Item(itemstack,2).getFormName(fly)=="_lights_of_orion") {
				if (rider.getMainHandItem().getItem()==LostGalaxyItems.QUASAR_SABER.get() |
						rider.getOffhandItem().getItem()==LostGalaxyItems.QUASAR_SABER.get()) {
					belt = get_Form_Item(itemstack,2).getBeltTex()+"_empty";
				}
				else if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,2).getBeltTex();
				}
			}
			else {
				if (rider.getMainHandItem().getItem()==LostGalaxyItems.QUASAR_SABER.get() |
						rider.getOffhandItem().getItem()==LostGalaxyItems.QUASAR_SABER.get()) {
					belt = get_Form_Item(itemstack,1).getBeltTex()+"_empty";
				}
				else if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
			}
			return "belts/"+belt;
		}
		else if (equipmentSlot == EquipmentSlot.HEAD) return rangerName+get_Form_Item(itemstack,2).getFormName(fly);

		else return rangerName+get_Form_Item(itemstack,1).getFormName(fly);
	}
	
	public  boolean getPartsForSlot(EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
		case HEAD ->{ 
			if (part =="head") return true;
			if (part =="body") return true;
			if (part =="rightArm") return true;
			if (part =="leftArm") return true;
			if (part =="rightLeg") return true;
			if (part =="leftLeg") return true;
		}
		case CHEST -> {
			if (part =="head") return true;
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
}