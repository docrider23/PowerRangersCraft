package com.docrider.powerrangerscraft.items.wild_force;

import com.docrider.powerrangerscraft.items.others.MechaGattaiItem;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class WildForceMegazordItem extends MechaGattaiItem {

	public WildForceMegazordItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> torso, DeferredItem<Item> legs, DeferredItem<Item> boot, Properties properties) {
		super(material, rider, baseFormItem, torso, legs, boot, properties);
		Unlimited_Textures=4;
	}

	@Override
	public String getUnlimitedTextures(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName, int num)
	{
		boolean fly = rider instanceof Player player && player.getAbilities().flying;

		if(num==2) return get_Form_Item(itemstack,3).getFormName(fly);
		else if(num==3) return get_Form_Item(itemstack,4).getFormName(fly);
		else if(num==4) return get_Form_Item(itemstack,5).getFormName(fly);

		return riderName+get_Form_Item(itemstack,1).getFormName(fly);
	}

	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String rangerName) {
		boolean fly = !rider.onGround();

		String belt = ((MechaGattaiItem)itemstack.getItem()).BELT_TEXT;

		if (equipmentSlot == EquipmentSlot.HEAD) {
			if (!this.isTransformed(rider)) {
				belt = "blank";
			}
			else if (rangerName == "isis_megazord") {
				belt = "isis_megazord_wings";
			}
			else belt = "blank";
			return belt;
		}

		if (equipmentSlot == EquipmentSlot.FEET) return get_Form_Item(itemstack,3).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.CHEST) return get_Form_Item(itemstack,4).getFormName(fly);
		else if (equipmentSlot == EquipmentSlot.LEGS) return get_Form_Item(itemstack,5).getFormName(fly);

		else return rangerName+get_Form_Item(itemstack,1).getFormName(fly);
	}

	public  boolean getPartsForSlot(ItemStack itemstack,EquipmentSlot currentSlot,String  part) {

		switch (currentSlot) {
			case FEET,LEGS,CHEST ->{
				return true;
			}
			default -> {}
		}
		return false;
	}
}