package com.docrider.powerrangerscraft.items.megaforce;

import com.docrider.powerrangerscraft.items.MegaforceItems;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.items.SamuraiItems;
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

public class GoseiMorpherItem extends RangerChangerItem{

	public GoseiMorpherItem(Holder<ArmorMaterial> material, String ranger, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Item.Properties properties)
	{
		super(material, ranger, baseFormItem, head, torso, legs, properties);
	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity ranger, String rangerName)
	{
		String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
		
		boolean fly = !ranger.onGround();
		
		if (equipmentSlot == EquipmentSlot.FEET) {
				if (ranger.getMainHandItem().getItem()== MegaforceItems.MEGA_BLASTER.get() ||
						ranger.getMainHandItem().getItem()==MegaforceItems.MEGA_BLASTER_DRAGON.get() ||
						ranger.getMainHandItem().getItem()==MegaforceItems.MEGA_BLASTER_PHOENIX.get() ||
						ranger.getMainHandItem().getItem()==MegaforceItems.MEGA_BLASTER_SNAKE.get() ||
						ranger.getMainHandItem().getItem()==MegaforceItems.MEGA_BLASTER_TIGER.get() ||
						ranger.getMainHandItem().getItem()==MegaforceItems.MEGA_BLASTER_SHARK.get()) {
					belt = get_Form_Item(itemstack,1).getBeltTex()+"_empty";
				}
				else if (((RangerChangerItem)itemstack.getItem()).BELT_TEXT==null) {
					belt = get_Form_Item(itemstack,1).getBeltTex();
				}
				return "belts/"+belt;
		}

		else return rangerName+get_Form_Item(itemstack,1).getFormName(fly);
	}
}