package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class RangerArmorRenderer extends GeoArmorRenderer<RangerArmorItem> {

    private static LivingEntity RIDER;

    public RangerArmorRenderer(LivingEntity livingEntity, EquipmentSlot equipmentSlot) {

        super(new RangerArmorModel(livingEntity, equipmentSlot));

        if (livingEntity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
            if (belt.getGlowForSlot(livingEntity.getItemBySlot(EquipmentSlot.FEET), equipmentSlot,livingEntity))addRenderLayer(new AutoGlowingGeoLayer<>(this));


            if (belt.Unlimited_Textures!=0&equipmentSlot==EquipmentSlot.HEAD){
                for (int n = 0; n < belt.Unlimited_Textures; n++) {
                    {
                        addRenderLayer(new RangerRenderLayer<>(this, ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID,"textures/armor/"+
                                belt.getUnlimitedTextures(livingEntity.getItemBySlot(EquipmentSlot.FEET), equipmentSlot, RIDER, belt.Rider, n + 1)+".png")));
                    }
                }
            }

        }
        RIDER =  livingEntity;
    }

    /*
    @Override
	public GeoBone getRightBootBone(GeoModel<RiderArmorItem> model) {
		return model.getBone("armorBody").orElse(super.getRightBootBone(model));
	}
    // We don't use the boot bones, so we better let other mods know
	@Override
	public GeoBone getLeftBootBone(GeoModel<RiderArmorItem> model) {
		return model.getBone("armorBody").orElse(super.getLeftBootBone(model));
	}
    */

    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        setAllVisible(false);

        if (!RIDER.hasEffect(MobEffects.INVISIBILITY) || !RIDER.isInvisible()) {
            if (currentSlot == EquipmentSlot.FEET) {
                setBoneVisible(this.body, true);
                setBoneVisible(this.leftArm, true);
            } else if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem BELT && BELT.isTransformed(RIDER)) {
                setBoneVisible(this.head, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"head"));
                setBoneVisible(this.body, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"body"));
                setBoneVisible(this.rightArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightArm"));
                setBoneVisible(this.leftArm, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftArm"));
                setBoneVisible(this.rightLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"rightLeg"));
                setBoneVisible(this.leftLeg, BELT.getPartsForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET),currentSlot,"leftLeg"));
            }
        }
    }

}