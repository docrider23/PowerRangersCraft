package com.docrider.powerrangerscraft.items.client;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;


public class RangerRenderLayer<T extends GeoAnimatable> extends GeoRenderLayer<T> {

    public RangerRenderLayer(GeoRenderer<T> renderer ) {
        super(renderer);
    }

    protected ResourceLocation getTextureResource(T animatable,int n,LivingEntity entity,RangerChangerItem belt,EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET)  return   ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/belts/" +belt.getUnlimitedTextures(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.Rider, n + 1) + ".png");
        return   ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/" +belt.getUnlimitedTextures(entity.getItemBySlot(EquipmentSlot.FEET), entity, belt.Rider, n + 1) + ".png");
    }
    @Nullable
    protected RenderType getRenderType(T animatable,int run,LivingEntity entity,RangerChangerItem belt,EquipmentSlot slot) {
        return RenderType.entityTranslucent(getTextureResource(animatable,run,entity,belt,slot));
    }

    /**
     * This is the method that is actually called by the render for your render layer to function
     * <p>
     * This is called <i>after</i> the animatable has been rendered, but before supplementary rendering like nametags
     */
    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {

        if (this.getRenderer() instanceof RangerArmorRenderer renderer2) {
            LivingEntity RIDER = renderer2.GetEntity();
            if (RIDER!=null&&RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
                if (belt.Unlimited_Textures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.HEAD) {
                    for (int n = 0; n < belt.Unlimited_Textures; n++) {
                        renderType = getRenderType(animatable,n,RIDER,belt,EquipmentSlot.HEAD);

                        if (renderType != null) {
                            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }
                }else if (belt.Unlimited_Belt_Textures != 0 & renderer2.getCurrentSlot() == EquipmentSlot.FEET) {
                    for (int n = 0; n < belt.Unlimited_Belt_Textures; n++) {
                        renderType = getRenderType(animatable,n,RIDER,belt,EquipmentSlot.FEET);

                        if (renderType != null) {
                            getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, renderType,
                                    bufferSource.getBuffer(renderType), partialTick, packedLight, packedOverlay,
                                    getRenderer().getRenderColor(animatable, partialTick, packedLight).argbInt());
                        }
                    }
                }
            }
        }

    }
}


