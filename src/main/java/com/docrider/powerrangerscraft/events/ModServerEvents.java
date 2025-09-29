package com.docrider.powerrangerscraft.events;

import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;


public class ModServerEvents {


	public static class ServerEvents {

		@SubscribeEvent
		public void EquipmentChange(LivingEquipmentChangeEvent event) {

			ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.FEET);
			if (event.getSlot().isArmor() && stack.getItem() instanceof RangerChangerItem belt && belt.isTransformed(event.getEntity()) && !stack.has(DataComponents.CUSTOM_DATA)) {
				RangerChangerItem.set_Update_Form(event.getEntity().getItemBySlot(EquipmentSlot.FEET));
			}

		}
	}
}
