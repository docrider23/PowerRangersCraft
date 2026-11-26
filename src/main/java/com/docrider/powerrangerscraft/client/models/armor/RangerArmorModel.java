package com.docrider.powerrangerscraft.client.models.armor;

import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.client.renderer.armor.RangerArmorRenderer;
import com.docrider.powerrangerscraft.items.others.RangerArmorItem;
import com.docrider.powerrangerscraft.items.others.RangerChangerItem;
import com.docrider.powerrangerscraft.world.attribute.PRCAttributes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationProcessor;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;

import static com.docrider.powerrangerscraft.world.attribute.PRCAttributes.CHANGE_KICK_MODEL;
import static com.docrider.powerrangerscraft.world.attribute.PRCAttributes.WINGS_OUT;

public class RangerArmorModel<T extends RangerArmorItem> extends GeoModel<T> {
    public RangerArmorModel() {
    }

    @Override
    public ResourceLocation getModelResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        if (renderer instanceof RangerArmorRenderer riderRenderer) {
            LivingEntity rider = riderRenderer.GetEntity();
            EquipmentSlot slot = riderRenderer.getCurrentSlot();

            if (rider.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem riderDriverItem) {
                if (slot == EquipmentSlot.FEET) {
                    return riderDriverItem.getBeltModelResource(rider.getItemBySlot(EquipmentSlot.FEET), animatable, slot, rider);
                } else {
                    if (riderDriverItem.isTransformed(rider))
                        return riderDriverItem.getModelResource(rider.getItemBySlot(EquipmentSlot.FEET), animatable, slot, rider);
                }
            }
        }
        return getModelResource(animatable);
    }

    @Override
    public ResourceLocation getModelResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/ranger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable, @Nullable GeoRenderer<T> renderer) {
        if (renderer instanceof RangerArmorRenderer riderRenderer) {
            LivingEntity RIDER = riderRenderer.GetEntity();
            EquipmentSlot slot = riderRenderer.getCurrentSlot();
            ItemStack BELT = RIDER.getItemBySlot(EquipmentSlot.FEET);
            if (BELT.getItem() instanceof RangerChangerItem DRIVER) {
                if (slot == EquipmentSlot.FEET || DRIVER.isTransformed(RIDER))
                    return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/" + DRIVER.GET_TEXT(BELT, slot, RIDER, DRIVER.Rider) + ".png");
            }
        }
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/blank.png");
    }

    @Override
    public ResourceLocation getTextureResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "textures/armor/blank.png");
    }


    @Override
    public ResourceLocation getAnimationResource(T animatable) {
        return ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/ranger.animation.json");
    }

    @Override
    public void setCustomAnimations(T an, long instanceId, AnimationState<T> state) {
        Entity entity = state.getData(DataTickets.ENTITY);

        if (entity instanceof LivingEntity RIDER) {
            double GetTransforming = RIDER.getAttribute(PRCAttributes.IS_TRANSFORMING).getBaseValue();
            double GetBallOld = RIDER.getAttribute(PRCAttributes.BALL_ROT_OLD).getBaseValue();
            double GetBall = RIDER.getAttribute(PRCAttributes.BALL_ROT).getBaseValue();
            double GetWheelOld = RIDER.getAttribute(PRCAttributes.WHEEL_ROT_OLD).getBaseValue();
            double GetWheel = RIDER.getAttribute(PRCAttributes.WHEEL_ROT).getBaseValue();
            double GetCapeOld = RIDER.getAttribute(PRCAttributes.CAPE_ROT_OLD).getBaseValue();
            double GetCape = RIDER.getAttribute(PRCAttributes.CAPE_ROT).getBaseValue();

            float Transforming = (float) Mth.lerp(1, GetTransforming, (GetTransforming - 1) - state.getPartialTick());
            float wheel = (float) Mth.lerp(state.getPartialTick(), GetWheelOld, GetWheel);
            float ball = (float) Mth.lerp(state.getPartialTick(), GetBallOld, GetBall);
            float Cape = (float) Mth.lerp(state.getPartialTick(), GetCapeOld, GetCape);



            GeoBone head = getAnimationProcessor().getBone("armorHead");
            GeoBone tail= getAnimationProcessor().getBone("tail");
            GeoBone tail2= getAnimationProcessor().getBone("tail2");
            GeoBone tail3= getAnimationProcessor().getBone("tail3");
            GeoBone tail4= getAnimationProcessor().getBone("tail4");
            if (head != null & tail != null) {
                float x = head.getRotX();
                if (x>0)x= -head.getRotX();
                else if (x<-0.5)x=-0.5f;
                tail.updateRotation(x, -head.getRotY(), head.getRotZ());
            }
            if (head != null & tail2 != null) {
                float x = head.getRotX();
                if (x<-0.5)x=-0.5f;
                tail2.updateRotation(x, head.getRotY(), head.getRotZ());
            }
            if (head != null & tail3 != null) {
                float x = head.getRotX();
                if (x<-0.5)x=-0.5f;
                tail3.updateRotation(x, head.getRotY(), -head.getRotZ());
            }
            if (head != null & tail4 != null) {
                float x = head.getRotX();
                if (x>0)x= -head.getRotX();
                if (x<-0.5)x=-0.5f;
                tail4.updateRotation(x, -head.getRotY(), head.getRotZ());
            }

            String[] boneNames = new String[]{"armorHead", "armorBody", "armorRightArm", "armorLeftArm", "armorRightLeg", "armorLeftLeg"};
            for (String boneName : boneNames) {
                GeoBone head2 = getAnimationProcessor().getBone(boneName+"2");
                GeoBone head3 = getAnimationProcessor().getBone(boneName+"3");
                GeoBone headO = getAnimationProcessor().getBone(boneName);
                if (headO != null & head2 != null) {
                    head2.updateRotation(-headO.getRotX(), headO.getRotY(), headO.getRotZ());
                }
                if (headO != null & head3 != null) {
                    head3.updateRotation(headO.getRotX(), -headO.getRotY(), headO.getRotZ());
                }
            }

            GeoBone front_fork = getAnimationProcessor().getBone("front_fork");
            GeoBone front_fork2 = getAnimationProcessor().getBone("front_fork2");
            GeoBone b_wheel = getAnimationProcessor().getBone("b_wheel");
            GeoBone f_wheel = getAnimationProcessor().getBone("f_wheel");
            GeoBone f_wheel2 = getAnimationProcessor().getBone("f_wheel2");
            GeoBone poop_ball_vice = getAnimationProcessor().getBone("poop_ball_vice");
            GeoBone cape = getAnimationProcessor().getBone("cape");
            GeoBone cape2 = getAnimationProcessor().getBone("cape2");

            GeoBone tire = getAnimationProcessor().getBone("tire");
            GeoBone tire2 = getAnimationProcessor().getBone("tire2");
            GeoBone tire3 = getAnimationProcessor().getBone("tire3");

            if (!(entity instanceof Player)) {
                GeoBone bipedHead = getAnimationProcessor().getBone("armorHead");
                if (bipedHead != null) {
                    bipedHead.setScaleX((float) RIDER.getAttribute(PRCAttributes.HEAD_SIZE).getValue());
                    bipedHead.setScaleY((float) RIDER.getAttribute(PRCAttributes.HEAD_SIZE).getValue());
                    bipedHead.setScaleZ((float) RIDER.getAttribute(PRCAttributes.HEAD_SIZE).getValue());
                }
            }
            if (cape != null & Cape < 0) {
                cape.setRotX(Cape);
            }
            if (cape != null & ball != 0) {
                cape.setRotY(ball);
            }

            if (cape2 != null & Cape < 0) {
                cape2.setRotX(Cape);
            }
            if (cape2 != null & ball != 0) {
                cape2.setRotY(ball);
            }

            if (RIDER.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RangerChangerItem belt) {
                belt.setCustomAnimations(an, instanceId, (AnimationState<RangerArmorItem>) state);

                GeoBone parkaGhost = getAnimationProcessor().getBone("parkaGhost");
                if (parkaGhost != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        float X = -Transforming - 1;
                        if (Transforming > 20) {
                            X = X - ((Transforming - 20) - 1);
                        }
                        parkaGhost.setPosX(X);
                        if (Transforming > 5) {
                            float Y = (10 - (Transforming - 10) / 2);
                            parkaGhost.setPosY(Y);
                        } else {
                            parkaGhost.setPosY((Transforming + 1) * 2);
                        }


                        if (Transforming > 20) {
                            float size = 1 - ((Transforming - 20) / 10);
                            parkaGhost.setScaleX(size);
                            parkaGhost.setScaleY(size);
                            parkaGhost.setScaleZ(size);
                        } else {
                            parkaGhost.setScaleX(1f);
                            parkaGhost.setScaleY(1f);
                            parkaGhost.setScaleZ(1f);
                        }
                        parkaGhost.setRotY((-Transforming - 1) / 6);
                        parkaGhost.setRotX((-Transforming - 1) / 15);

                    } else {
                        parkaGhost.setRotX(0);
                        parkaGhost.setRotY(0);
                        parkaGhost.setScaleX(1f);
                        parkaGhost.setScaleY(1f);
                        parkaGhost.setScaleZ(1f);
                        parkaGhost.setPosZ(0);
                        parkaGhost.setPosX(0);
                        parkaGhost.setPosY(0);
                    }
                }


                GeoBone wizard_circle = getAnimationProcessor().getBone("wizard_circle");
                if (wizard_circle != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle.setScaleX(1.1f);
                        wizard_circle.setScaleY(1.1f);
                        wizard_circle.setScaleZ(1.1f);

                        wizard_circle.setPosX(Transforming - 10);
                        wizard_circle.setHidden(false);
                    } else {
                        wizard_circle.setHidden(true);
                        wizard_circle.setPosX(0);
                    }
                }
                GeoBone wizard_circle2 = getAnimationProcessor().getBone("wizard_circle2");
                if (wizard_circle2 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle2.setScaleX(1.1f);
                        wizard_circle2.setScaleY(1.1f);
                        wizard_circle2.setScaleZ(1.1f);

                        wizard_circle2.setPosX(30 - Transforming);
                        wizard_circle2.setHidden(false);
                    } else {
                        wizard_circle2.setHidden(true);
                        wizard_circle2.setPosX(0);
                    }
                }
                GeoBone wizard_circle3 = getAnimationProcessor().getBone("wizard_circle3");
                if (wizard_circle3 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle3.setScaleX(1.1f);
                        wizard_circle3.setScaleY(1.1f);
                        wizard_circle3.setScaleZ(1.1f);

                        wizard_circle3.setPosY(35 - Transforming);
                        wizard_circle3.setHidden(false);
                    } else {
                        wizard_circle3.setHidden(true);
                        wizard_circle3.setPosY(0);
                    }
                }
                GeoBone wizard_circle4 = getAnimationProcessor().getBone("wizard_circle4");
                if (wizard_circle4 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle4.setScaleX(1.1f);
                        wizard_circle4.setScaleY(1.1f);
                        wizard_circle4.setScaleZ(1.1f);

                        wizard_circle4.setPosY(Transforming);
                        wizard_circle4.setHidden(false);
                    } else {
                        wizard_circle4.setHidden(true);
                        wizard_circle4.setPosY(0);
                    }
                }
                GeoBone wizard_circle5 = getAnimationProcessor().getBone("wizard_circle5");
                if (wizard_circle5 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle5.setScaleX(1.1f);
                        wizard_circle5.setScaleY(1.1f);
                        wizard_circle5.setScaleZ(1.1f);
                        wizard_circle5.setPosX(2.5f);
                        wizard_circle5.setPosZ(30 - Transforming);
                        wizard_circle5.setHidden(false);
                    } else {
                        wizard_circle5.setHidden(true);
                        wizard_circle5.setPosZ(0);
                    }
                }

                GeoBone wizard_circle6 = getAnimationProcessor().getBone("wizard_circle6");
                if (wizard_circle6 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle6.setScaleX(1.1f);
                        wizard_circle6.setScaleY(1.1f);
                        wizard_circle6.setScaleZ(1.1f);
                        wizard_circle6.setPosZ(Transforming);
                        wizard_circle6.setHidden(false);
                    } else {
                        wizard_circle6.setHidden(true);
                        wizard_circle6.setPosY(0);
                    }
                }

                GeoBone wizard_circle7 = getAnimationProcessor().getBone("wizard_circle7");
                if (wizard_circle7 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle7.setScaleX(1.1f);
                        wizard_circle7.setScaleY(1.1f);
                        wizard_circle7.setScaleZ(1.1f);
                        wizard_circle7.setPosZ(25 - Transforming);
                        wizard_circle7.setRotY(-Transforming / 3);
                        wizard_circle7.setHidden(false);
                    } else {
                        wizard_circle7.setHidden(true);
                        wizard_circle7.setPosZ(0);
                    }
                }

                GeoBone wizard_circle8 = getAnimationProcessor().getBone("wizard_circle8");
                if (wizard_circle8 != null) {
                    if (RangerChangerItem.isTransforming(RIDER)) {
                        wizard_circle8.setScaleX(1.1f);
                        wizard_circle8.setScaleY(1.1f);
                        wizard_circle8.setScaleZ(1.1f);
                        wizard_circle8.setRotX(Transforming / 2);
                        wizard_circle8.setPosY(Transforming);
                        wizard_circle8.setHidden(false);
                    } else {
                        wizard_circle8.setHidden(true);
                        wizard_circle8.setPosY(0);
                    }
                }

                GeoBone headKick = getAnimationProcessor().getBone("headKick");
                GeoBone headKickRemove = getAnimationProcessor().getBone("headKickRemove");
                GeoBone rightArmKick = getAnimationProcessor().getBone("rightArmKick");
                GeoBone rightArmKickRemove = getAnimationProcessor().getBone("rightArmKickRemove");
                GeoBone leftArmKick = getAnimationProcessor().getBone("leftArmKick");
                GeoBone leftArmKickRemove = getAnimationProcessor().getBone("leftArmKickRemove");
                GeoBone rightLegKick = getAnimationProcessor().getBone("rightLegKick");
                GeoBone rightLegKickRemove = getAnimationProcessor().getBone("rightLegKickRemove");
                GeoBone leftLegKick = getAnimationProcessor().getBone("leftLegKick");
                GeoBone leftLegKickRemove = getAnimationProcessor().getBone("leftLegKickRemove");
                GeoBone bodyKick = getAnimationProcessor().getBone("bodyKick");
                GeoBone bodyKickRemove = getAnimationProcessor().getBone("bodyKickRemove");

                boolean isKicking = RIDER.getAttribute(CHANGE_KICK_MODEL).getValue() == 1;
                if (headKick != null) {
                    headKick.setHidden(!isKicking);
                }
                if (headKickRemove != null) {
                    headKickRemove.setHidden(isKicking);
                }
                if (rightArmKick != null) {
                    rightArmKick.setHidden(!isKicking);
                }
                if (rightArmKickRemove != null) {
                    rightArmKickRemove.setHidden(isKicking);
                }
                if (leftArmKick != null) {
                    leftArmKick.setHidden(!isKicking);
                }
                if (leftArmKickRemove != null) {
                    leftArmKickRemove.setHidden(isKicking);
                }
                if (leftLegKick != null) {
                    leftLegKick.setHidden(!isKicking);
                }
                if (leftLegKickRemove != null) {
                    leftLegKickRemove.setHidden(isKicking);
                }
                if (rightLegKick != null) {
                    rightLegKick.setHidden(!isKicking);
                }
                if (rightLegKickRemove != null) {
                    rightLegKickRemove.setHidden(isKicking);
                }
                if (bodyKick != null) {
                    bodyKick.setHidden(!isKicking);
                }
                if (bodyKickRemove != null) {
                    bodyKickRemove.setHidden(isKicking);
                }

                GeoBone joker = getAnimationProcessor().getBone("joker");
                if (joker != null) {
                    if (isKicking) {
                        joker.setPosY(-5);
                        joker.setPosX(2);
                    } else {
                        joker.setPosY(0);
                        joker.setPosX(0);
                    }
                }

                if (joker != null) {
                    if (isKicking) {
                        joker.setPosY(-5);
                        joker.setPosX(2);
                    } else {
                        joker.setPosY(0);
                        joker.setPosX(0);
                    }
                }

                GeoBone WingsOut = getAnimationProcessor().getBone("WingsOut");
                GeoBone WingsOutRemove = getAnimationProcessor().getBone("WingsOutRemove");

                boolean areWingsOut = RIDER.getAttribute(WINGS_OUT).getValue() == 1;

                if (WingsOut != null) {
                    WingsOut.setHidden(!areWingsOut);
                }
                if (WingsOutRemove != null) {
                    WingsOutRemove.setHidden(areWingsOut);
                }

            if (front_fork != null) {
                front_fork.setRotY(ball);
            }
            if (front_fork2 != null) {
                front_fork2.setRotY(ball);
            }

            if (f_wheel != null) {
                f_wheel.setRotX(wheel);
            }
            if (f_wheel2 != null) {
                f_wheel2.setRotX(wheel);
            }
            if (b_wheel != null) {
                b_wheel.setRotX(wheel);
            }
            if (poop_ball_vice != null) {
                poop_ball_vice.setRotX(wheel);
                poop_ball_vice.setRotZ(ball);
            }
        }
    }
}
}