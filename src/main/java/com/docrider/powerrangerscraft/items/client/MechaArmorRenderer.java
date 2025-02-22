package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.MechaArmorItem;
import com.docrider.powerrangerscraft.items.others.MechaGattaiItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MechaArmorRenderer extends GeoArmorRenderer<MechaArmorItem> {
	 
	private static LivingEntity RIDER;
	
    public MechaArmorRenderer(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {
    
        super(new MechaArmorModel(livingEntity, equipmentSlot));
        RIDER =  livingEntity;

		if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MechaGattaiItem belt) {
			if (belt.Unlimited_Textures!=0&equipmentSlot==EquipmentSlot.FEET){
				for (int n = 0; n < belt.Unlimited_Textures; n++) {
					{
						addRenderLayer(new MechaRenderLayer<>(this, ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/armor/mecha/"+
								belt.getUnlimitedTextures(livingEntity.getItemBySlot(EquipmentSlot.HEAD), equipmentSlot, RIDER, belt.Rider, n + 1)+".png")));
					}
				}
			}

		}
    }
    
    

	protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
		setAllVisible(false);

		if (currentSlot == EquipmentSlot.HEAD) {
			setBoneVisible(this.body, true);
		} else if (RIDER.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof MechaGattaiItem BELT && BELT.isTransformed(RIDER)) {
			setBoneVisible(this.head, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"head"));
			setBoneVisible(this.body, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"body"));
			setBoneVisible(this.rightArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"rightArm"));
			setBoneVisible(this.leftArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"leftArm"));
			setBoneVisible(this.rightLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"rightLeg"));
			setBoneVisible(this.leftLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.HEAD),currentSlot,"leftLeg"));
		}
	}

}