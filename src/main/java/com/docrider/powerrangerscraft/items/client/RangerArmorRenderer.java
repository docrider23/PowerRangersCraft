package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class RangerArmorRenderer extends GeoArmorRenderer<RangerArmorItem> {

    public RangerArmorRenderer(LivingEntity entity, EquipmentSlot equipmentSlot) {

        super(new RangerArmorModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this){
            @Nullable
            protected RenderType getRenderType(RangerArmorItem animatable, @Nullable MultiBufferSource bufferSource) {
                if (this.getRenderer() instanceof RangerArmorRenderer renderer2) {
                    LivingEntity RIDER = renderer2.GetEntity();
                    if (RIDER!=null&&RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
                        return belt.getGlowForSlot(RIDER.getItemBySlot(EquipmentSlot.FEET), equipmentSlot,RIDER)? AutoGlowingTexture.getRenderType(getTextureResource(animatable)): null;
                    }}
                return null;
            }});

        if (entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
            if (belt.Unlimited_Textures != 0 & equipmentSlot == EquipmentSlot.HEAD
                    ||belt.Unlimited_Belt_Textures != 0 & equipmentSlot == EquipmentSlot.FEET) {
                addRenderLayer(new RangerRenderLayer<>(this));
            }
        }
    }

    public GeoArmorRenderer<RangerArmorItem> addRenderLayer(GeoRenderLayer<RangerArmorItem> renderLayer) {
        this.renderLayers.addLayer(renderLayer);

        return this;
    }

    public LivingEntity GetEntity(){
        if (getCurrentEntity() instanceof LivingEntity entity) return entity;
        else return null;
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

        if (GetEntity() != null) {
            if (!GetEntity().hasEffect(MobEffects.INVISIBILITY) || !GetEntity().isInvisible()) {
                if (currentSlot == EquipmentSlot.FEET) {
                    setBoneVisible(this.body, true);
                    setBoneVisible(this.leftArm, true);
                } else if (GetEntity().getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem BELT && BELT.isTransformed(GetEntity())) {
                    setBoneVisible(this.head, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "head"));
                    setBoneVisible(this.body, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "body"));
                    setBoneVisible(this.rightArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightArm"));
                    setBoneVisible(this.leftArm, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftArm"));
                    setBoneVisible(this.rightLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "rightLeg"));
                    setBoneVisible(this.leftLeg, BELT.getPartsForSlot(GetEntity().getItemBySlot(EquipmentSlot.FEET), currentSlot, "leftLeg"));
                }
            }
        }
    }
}