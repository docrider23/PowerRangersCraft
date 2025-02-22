package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.items.others.MechaArmorItem;
import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.MechaGattaiItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.GeoModel;

public class MechaArmorModel extends GeoModel<MechaArmorItem> {

	private static LivingEntity RIDER;
	private EquipmentSlot slot;

	public MechaArmorModel(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

		RIDER =  livingEntity;
		slot =  equipmentSlot;
	}

	@Override
	public ResourceLocation getModelResource(MechaArmorItem animatable) {
		if (slot== EquipmentSlot.HEAD) {
			if (RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MechaGattaiItem) {
				MechaGattaiItem BELT = ((MechaGattaiItem)RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem());

				return BELT.getBeltModelResource(RIDER.getItemBySlot(EquipmentSlot.HEAD),animatable,slot,RIDER);

			}else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/rangerbelt.geo.json");
		}else {

			if (RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MechaGattaiItem) {
				MechaGattaiItem BELT = ((MechaGattaiItem)RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem());

				return BELT.getModelResource(RIDER.getItemBySlot(EquipmentSlot.HEAD),animatable,slot,RIDER);

			}else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
		}
	}

	@Override
	public ResourceLocation getTextureResource(MechaArmorItem animatable) {


		String FORM="blank";
		ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.HEAD); 
		if (BELT.getItem() instanceof MechaGattaiItem) {
			FORM=((MechaGattaiItem) BELT.getItem()).GET_TEXT(BELT,slot,RIDER,((MechaGattaiItem) BELT.getItem()).Rider );
			if (slot == EquipmentSlot.HEAD) {

				FORM=((MechaGattaiItem) BELT.getItem()).GET_TEXT(BELT,slot ,RIDER,((MechaGattaiItem) BELT.getItem()).Rider);
			}else if ( ((MechaGattaiItem) BELT.getItem()).TORSO.asItem()!=RIDER.getItemBySlot(EquipmentSlot.CHEST).getItem()||
					 ((MechaGattaiItem) BELT.getItem()).LEGS.asItem()!=RIDER.getItemBySlot(EquipmentSlot.LEGS).getItem()||
					 ((MechaGattaiItem) BELT.getItem()).BOOTS.asItem()!=RIDER.getItemBySlot(EquipmentSlot.FEET).getItem()) {
				 FORM="blank";
			}
	

		}
		return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/mecha/"+FORM+".png");
	}



@Override
public ResourceLocation getAnimationResource(MechaArmorItem animatable) {
	if (slot== EquipmentSlot.HEAD) {
		return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/rangerbelt.animation.json");
	}else {
		
		if (RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MechaGattaiItem) {
			MechaGattaiItem BELT = ((MechaGattaiItem)RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem()); 
			
			return BELT.getAnimationResource(RIDER.getItemBySlot(EquipmentSlot.HEAD),animatable,slot);
			
		}else return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
	}

}
}