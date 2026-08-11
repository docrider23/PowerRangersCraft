package com.docrider.powerrangerscraft.items.beast_morphers;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.BeastMorphersItems;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

public class EvoxBeastXMorpherItem extends RangerChangerItem{

	public EvoxBeastXMorpherItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item>torso, DeferredItem<Item> legs, Properties properties)
	{
		super(material, rider, baseFormItem, head, torso, legs, properties);
	}
	
	@Override
	public String GET_TEXT(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName)
	{
		boolean fly = !rider.onGround();

		if (equipmentSlot == EquipmentSlot.FEET) {
			String belt = ((RangerChangerItem)itemstack.getItem()).BELT_TEXT;
			if (!isTransformed(rider)) {
				if (this == BeastMorphersItems.BLAZE_EVOX_BEAST_X_MORPHER.get()) return "belts/evox_beast_x_morpher_blaze";
				if (this == BeastMorphersItems.ROXY_EVOX_BEAST_X_MORPHER.get()) return "belts/evox_beast_x_morpher_roxy";
				if (this == BeastMorphersItems.ROBO_BLAZE_EVOX_BEAST_X_MORPHER.get()) return "belts/evox_beast_x_morpher_robo_blaze";
				if (this == BeastMorphersItems.ROBO_ROXY_EVOX_BEAST_X_MORPHER.get()) return "belts/evox_beast_x_morpher_robo_roxy";
			}
			else {
				if (((RangerChangerItem) itemstack.getItem()).BELT_TEXT == null) {
					belt = get_Form_Item(itemstack, 1).getBeltTex();
				}
			}
			return "belts/"+belt;
		}
		else return get_Form_Item(itemstack,1).getRangerName(riderName)+get_Form_Item(itemstack,1).getFormName(fly);

	}

	@Override
	public ResourceLocation getBeltModelResource(ItemStack itemstack, RangerArmorItem animatable, EquipmentSlot slot, LivingEntity rider) {
		if (!isTransformed(rider)) return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/left_brace1.geo.json");
		return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, get_Form_Item(itemstack, 1).get_Belt_Model());
	}
}