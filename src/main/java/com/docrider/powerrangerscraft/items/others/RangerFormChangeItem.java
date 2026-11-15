package com.docrider.powerrangerscraft.items.others;


import com.google.common.collect.Lists;
import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.OtherItems;
import com.docrider.powerrangerscraft.world.attribute.PRCAttributes;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.cache.GeckoLibCache;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RangerFormChangeItem extends BaseItem {
    private String formName;
    private int slot = 1;
    private int offhandSlot = 10;
    private Boolean offhand = false;

    private List<MobEffectInstance> potionEffectList;
    private List<Item> needItem = new ArrayList<>();
    protected String riderName;
    protected String overrideRangerName;

    private String beltTex;
    private Boolean isGlowing = false;
    private Boolean isBeltGlowing = false;
    private Boolean hasStaticWings = false;
    private String updatedBeltModel;
    private String updatedModel;
    private String flyingModel;
    private Boolean setShowFace = false;
    private Boolean setShowUnder = false;
    private Boolean setShowPlayer = false;

    private Boolean useWalk = false;
    private Boolean useBike = false;
    private Boolean hasCape = false;


    private Boolean A1 = false;
    private Boolean SD = false;

    private Boolean flyingText = false;
    private Item shiftItem;
    private Item switchItem;
    private Boolean resetForm = false;
    private Boolean resetToMainForm = false;
    private Boolean attackForm = false;

    private Boolean isGold = false;
    private Boolean snowWalk = false;

    private Boolean setToArmorForm = false;

    private List<RangerFormChangeItem> alternative = new ArrayList<>();
    private RangerFormChangeItem alsoChange1stSlot;
    private RangerFormChangeItem alsoChange2ndSlot;
    private RangerFormChangeItem alsoChange3rdSlot;
    private RangerFormChangeItem alsoChange4thSlot;
    private RangerFormChangeItem alsoChange5thSlot;

    private RangerFormChangeItem alsoUpdateOld;

    private Boolean hasIncompatibleForms = false;
    private List<RangerFormChangeItem> incompatibleForms = new ArrayList<>();

    public String[] compatibilityList = new String[]{""};
    public List<Item> needItemList = new ArrayList<>();

    private Boolean needBaseForm = false;
    private RangerFormChangeItem needFormSlot1;
    private RangerFormChangeItem needFormSlot2;
    private RangerFormChangeItem needFormSlot3;
    private RangerFormChangeItem needFormSlot4;
    private RangerFormChangeItem needFormSlot5;

    private int timeoutDuration = 0;
    private int lockDuration = 0;
    private RangerFormChangeItem revertForm;

    private Boolean ignoreBeltText = false;

    private int storeNum = 1;

    private String slotOneAbility = "";
    private int slotOneAbilityPriority = 0;
    private String slotTwoAbility = "";
    private int slotTwoAbilityPriority = 0;

    private String glidingPosition = "";
    private String flyingPosition = "";

    private String modifiedPosition = "";
    private String modifiedPositionLayer = "postion_1";
    private List<String> modifiedPositionConditions;


    private Double formDelay = 30d;
    private Double henshinTick = 30d;

    public RangerFormChangeItem(Properties properties, String formName, String riderName, String beltTex, MobEffectInstance... effects) {
        super(properties);

        potionEffectList = Lists.newArrayList(effects);
        this.formName = formName;
        this.beltTex = beltTex;
        this.riderName = riderName;
    }


    public List<MobEffectInstance> getPotionEffectList() {
        return potionEffectList;
    }

    public int getSlot() {
        return slot;
    }

    public String getFormName(Boolean isFlying) {
        return (isFlying & flyingText ? formName + "_wing" : formName);
    }

    public String getRangerName(String name) {
        return (overrideRangerName != null ? overrideRangerName : name);
    }

    public RangerFormChangeItem getAlsoChange2ndSlot(){return alsoChange2ndSlot;}

    public String getBeltTex() {
        return beltTex;
    }

    public Double getFormDelay() {
        return formDelay;
    }

    public Double getHenshinTick() {
        return henshinTick;
    }

    public List<RangerFormChangeItem> getAlternative() {
        return alternative;
    }


    public Boolean getIgnoreOverrideBeltText() {
        return ignoreBeltText;
    }

    public String getBeltModel() {
        return (updatedBeltModel!=null ? updatedBeltModel : "geo/rangerbelt.geo.json");
    }

    public String getModel(String riderName) {
        if (updatedModel != null) {
            return updatedModel;
        }
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo" + getRangerName(riderName) + formName + ".geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRangerName(riderName) + formName + ".geo.json" : (getHasStaticWings() ? "rangerwing.geo.json" : "ranger.geo.json"));
    }

    public Boolean getShowFace() {
        return setShowFace;
    }

    public Boolean getShowUnder() {
        return setShowUnder;
    }

    public Boolean getShowPlayer() {
        return setShowPlayer;
    }

    public Boolean getA1() {
        return A1;
    }

    public Boolean getSD() {
        return SD;
    }

    public String getSlotOneAbility() {
        return slotOneAbility.toLowerCase();
    }

    public int getSlotOneAbilityPriotiy() {
        return slotOneAbilityPriority;
    }

    public String getSlotTwoAbility() {
        return slotTwoAbility.toLowerCase();
    }

    public int getSlotTwoAbilityPriority() {
        return slotTwoAbilityPriority;
    }

    public Boolean getHasCape() {
        return hasCape;
    }

    public Boolean getIsBike() {
        return useBike;
    }

    public Boolean getIsBeltGlowing() {
        return isBeltGlowing;
    }

    public Boolean getIsGlowing() {
        return isGlowing;
    }

    public Boolean getHasStaticWings() {
        return hasStaticWings;
    }

    public Boolean getIsResetForm() {
        return resetForm;
    }

    public Boolean getIsResetFormMain() {
        return resetToMainForm;
    }

    public Boolean GetIsAttackForm() {
        return attackForm;
    }

    public Item getStiftItem() {
        return shiftItem;
    }

    public int getStoredNum() {
        return storeNum;
    }

    public String getFlyingModel(String riderName) {
        if (flyingModel != null) {
            return flyingModel;
        }
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/armor/" + getRangerName(riderName) + formName + "_wing.geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL) != null ? getRangerName(riderName) + formName + "_wing.geo.json" : "rider_plusbelt_and_wings.geo.json");
    }

    public Boolean hasWingsIfFlying() {
        return flyingText;
    }

    public RangerFormChangeItem addIncompatibleForm(Item item) {
        incompatibleForms.add((RangerFormChangeItem) item);
        hasIncompatibleForms = true;
        return this;
    }

    public RangerFormChangeItem alsoChange1stSlot(Item item) {
        alsoChange1stSlot = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange2ndSlot(Item item) {
        alsoChange2ndSlot = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange3rdSlot(Item item) {
        alsoChange3rdSlot = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange4thSlot(Item item) {
        alsoChange4thSlot = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange5thSlot(Item item) {
        alsoChange5thSlot = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem getAlsoUpdateOld(Item item) {
        alsoUpdateOld = (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem ChangeRangerName(String name) {
        overrideRangerName = name;
        return this;
    }

    public RangerFormChangeItem ChangeModel(String model) {
        updatedModel = model;
        return this;
    }

    public RangerFormChangeItem setShowFace() {
        setShowFace = true;
        return this;
    }

    public RangerFormChangeItem setShowUnder() {
        setShowUnder = true;
        return this;
    }

    public RangerFormChangeItem setShowPlayer() {
        setShowPlayer = true;
        return this;
    }

    public RangerFormChangeItem setFormDelay(double num) {
        formDelay = num;
        return this;
    }

    public RangerFormChangeItem setHenshinTick(double num) {
        henshinTick = num;
        return this;
    }

    public RangerFormChangeItem isGold() {
        isGold = true;
        return this;
    }

    public RangerFormChangeItem canSnowWalk() {
        snowWalk = true;
        return this;
    }

    public RangerFormChangeItem setSlotOneAbility(String abilityChange, int abilityPriority) {
        slotOneAbility = abilityChange.toLowerCase();
        slotOneAbilityPriority = abilityPriority;
        return this;
    }

    public RangerFormChangeItem setSlotTwoAbility(String abilityChange, int abilityPriority) {
        slotTwoAbility = abilityChange.toLowerCase();
        slotTwoAbilityPriority = abilityPriority;
        return this;
    }

    public String getGlidingPosition() {
        return glidingPosition;
    }

    public String getFlyingPosition() {
        return flyingPosition;
    }

    public String getModifiedPosition() {
        return modifiedPosition;
    }

    public String getModifiedPositionLayer() {
        return modifiedPositionLayer;
    }

    public List<String> getPositionModifierConditions() {
        return modifiedPositionConditions;
    }

    public RangerFormChangeItem setGlidingPosition(String poseName) {
        glidingPosition = poseName.toLowerCase();
        return this;
    }

    public RangerFormChangeItem setFlyingPosition(String poseName) {
        flyingPosition = poseName.toLowerCase();
        return this;
    }

    public RangerFormChangeItem setModifiedPosition(String poseName) {
        modifiedPosition = poseName.toLowerCase();
        return this;
    }

    public RangerFormChangeItem setModifiedPositionLayer(String positionLayer) {
        modifiedPositionLayer = positionLayer.toLowerCase();
        return this;
    }

    public RangerFormChangeItem setModifiedPositionConditions(String... conditions) {
        ArrayList<String> newConditions = new ArrayList<>();
        for (String condition : conditions) {
            if (!condition.isEmpty()) {
                condition = condition.toLowerCase();
            }
            newConditions.add(condition);
        }
        modifiedPositionConditions = newConditions;
        return this;
    }

    public RangerFormChangeItem ChangeBeltModel(String model) {
        updatedBeltModel = model;
        return this;
    }

    public RangerFormChangeItem ChangeSlot(int slot) {
        this.slot = slot;
        return this;
    }

    public int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public int getLockDuration() {
        return this.lockDuration;
    }

    public RangerFormChangeItem getRevertForm() {
        return this.revertForm;
    }

    public RangerFormChangeItem hasTimeout(int timeout, int lock, RangerFormChangeItem revertsTo) {
        timeoutDuration = timeout;
        lockDuration = lock;
        revertForm = revertsTo;
        return this;
    }

    public RangerFormChangeItem addNum(int num) {
        storeNum = num;
        return this;
    }

    public RangerFormChangeItem setOffhandSlot(int slot) {
        offhandSlot = slot;
        offhand = true;
        return this;
    }


    public RangerFormChangeItem hasFlyingWings(@Nullable String model) {
        flyingText = true;
        if (model != null) {
            flyingModel = model;
        }
        return this;
    }

    public RangerFormChangeItem addAlternative(Item item) {
        alternative.add((RangerFormChangeItem) item);
        return this;
    }

    public RangerFormChangeItem ResetFormToBase() {
        resetForm = true;
        return this;
    }

    public RangerFormChangeItem resetFormToBaseIfMain() {
        resetToMainForm = true;
        return this;
    }

    public RangerFormChangeItem isAttackForm() {
        attackForm = true;
        return this;
    }

    public RangerFormChangeItem setFormToArmor() {
        setToArmorForm = true;
        return this;
    }

    public RangerFormChangeItem isGlowing() {
        isGlowing = true;
        return this;
    }

    public RangerFormChangeItem hasCape() {
        hasCape = true;
        return this;
    }

    public RangerFormChangeItem isBike() {
        useBike = true;
        return this;
    }


    public RangerFormChangeItem isA1() {
        A1 = true;
        return this;
    }

    public RangerFormChangeItem hasSD() {
        SD = true;
        return this;
    }

    public RangerFormChangeItem IsBeltGlowing() {
        isBeltGlowing = true;
        return this;
    }

    public RangerFormChangeItem hasStaticWings() {
        hasStaticWings = true;
        return this;
    }

    public RangerFormChangeItem needBaseForm() {
        needBaseForm = true;
        return this;
    }

    public RangerFormChangeItem ignoreOverrideBeltText() {
        ignoreBeltText = true;
        return this;
    }

    public RangerFormChangeItem addNeedForm(Item item) {
        needFormSlot1 = ((RangerFormChangeItem) item);
        return this;
    }

    public RangerFormChangeItem addNeedForm(Item item, int slot) {

        if (slot == 1) {
            needFormSlot1 = ((RangerFormChangeItem) item);
        } else if (slot == 2) {
            needFormSlot2 = ((RangerFormChangeItem) item);
        } else if (slot == 3) {
            needFormSlot3 = ((RangerFormChangeItem) item);
        } else if (slot == 4) {
            needFormSlot4 = ((RangerFormChangeItem) item);
        } else if (slot == 5) {
            needFormSlot5 = ((RangerFormChangeItem) item);
        }
        return this;
    }

    public RangerFormChangeItem addNeedItem(Item item) {
        needItem.add(item);
        return this;
    }

    public RangerFormChangeItem addShiftForm(Item item) {
        shiftItem = item;
        return this;
    }

    public RangerFormChangeItem addSwitchForm(Item item) {
        switchItem = item;
        return this;
    }

    public RangerFormChangeItem addNeedItemList(List<Item> NEED_ITEM) {
        needItemList = NEED_ITEM;
        return this;
    }

    public RangerFormChangeItem addCompatibilityList(String[] List) {
        compatibilityList = List;
        return this;
    }


    public Boolean isCompatible(RangerChangerItem belt) {
        if (Objects.equals(belt.Rider, riderName)) {
            return true;
        }
        for (String str : compatibilityList) {
            if (Objects.equals(str, belt.Rider)) {
                return true;
            }
        }
        ItemStack itemStack = new ItemStack(belt);
        return itemStack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "form_change_item/works_with/" + riderName + formName)));
    }

    public Boolean checkGold() {
        return isGold;
    }

    public Boolean checkSnowWalk() {
        return snowWalk;
    }

    public boolean inventoryOrHolderContains(Player player, Item item) {
        NonNullList<ItemStack> inv = NonNullList.create();
        inv.addAll(player.getInventory().items);
        inv.addAll(player.getInventory().armor);
        inv.add(player.getInventory().offhand.getFirst());

        if (player.getInventory().countItem(item) != 0) {
            return true;
        } else {
            for (ItemStack itemStack : inv) {
                if (itemStack.has(DataComponents.CONTAINER)) {
                    for (ItemStack stack : itemStack.getComponents().get(DataComponents.CONTAINER).nonEmptyItems())
                        if (stack.getItem() == item) {
                            return true;
                        }
                } else if (itemStack.has(DataComponents.BUNDLE_CONTENTS)) {
                    for (ItemStack stack : itemStack.getComponents().get(DataComponents.BUNDLE_CONTENTS).items())
                        if (stack.getItem() == item) {
                            return true;
                        }
                }
            }
        }
        return false;
    }

    public Boolean canChange(Player player, RangerChangerItem belt, ItemStack stack) {

        if (this == OtherItems.BLANK_FORM.get()) {
            return true;
        }
        if (this.GetIsAttackForm() && Objects.requireNonNull(player.getAttribute(PRCAttributes.IS_TRANSFORMING)).getValue() != 0) {
            return false;
        }
        if (this.GetIsAttackForm() && !belt.isTransformed(player)) {
            return false;
        }


        if (hasIncompatibleForms) {
            for (RangerFormChangeItem incompatibleForm : incompatibleForms) {
                int num_forms = belt.Num_Base_Form_Item;
                for (int n = 0; n < num_forms; n++) {
                    if (incompatibleForm == RangerChangerItem.get_Form_Item(stack, n + 1)) {
                        return false;
                    }
                }
            }
        }
        if (!isCompatible(belt)) {
            return false;
        }
        if (!needItem.isEmpty()) {
            for (Item item : needItem) {
                if (!inventoryOrHolderContains(player, item)) {
                    return false;
                }
            }
        }
        if (needBaseForm) {
            if (RangerChangerItem.get_Form_Item(stack, 1) != belt.Base_Form_Item) {
                return false;
            }
        }
        if (needFormSlot1 != null) {
            if (RangerChangerItem.get_Form_Item(stack, 1) != needFormSlot1) {
                return false;
            }
        }
        if (needFormSlot2 != null) {
            if (RangerChangerItem.get_Form_Item(stack, 2) != needFormSlot2) {
                return false;
            }
        }
        if (needFormSlot3 != null) {
            if (RangerChangerItem.get_Form_Item(stack, 3) != needFormSlot3) {
                return false;
            }
        }
        if (needFormSlot4 != null) {
            if (RangerChangerItem.get_Form_Item(stack, 4) != needFormSlot4) {
                return false;
            }
        }
        if (needFormSlot5 != null) {
            if (RangerChangerItem.get_Form_Item(stack, 5) != needFormSlot5) {
                return false;
            }
        }
        if (!needItemList.isEmpty()) {
            for (Item item : needItemList) {
                if (!inventoryOrHolderContains(player, item)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemStack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if (!level.isClientSide() && !player.hasEffect(EffectCore.FORM_LOCK)) {
            if (BELT.getItem() instanceof RangerChangerItem belt) {
                if (shiftItem instanceof RangerFormChangeItem form && player.isShiftKeyDown()) {
                    shiftItem.use(level, player, usedHand);
                } else if (canChange(player, belt, BELT)) {
                    if (!player.isCreative()) {
                        player.getCooldowns().addCooldown(this, 60);
                        player.addEffect(new MobEffectInstance(EffectCore.FORM_LOCK, 20, 0, true, false));
                    }
                    int SLOT = slot;
                    if (resetForm) {
                        RangerChangerItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    }
                    if (resetToMainForm & Objects.equals(belt.Rider, riderName)) {
                        RangerChangerItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    }
                    if (alsoChange1stSlot != null) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange1stSlot, 1);
                    }
                    if (alsoChange2ndSlot != null) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange2ndSlot, 2);
                    }
                    if (alsoChange3rdSlot != null) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange3rdSlot, 3);
                    }
                    if (alsoChange4thSlot != null) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange4thSlot, 4);
                    }
                    if (alsoUpdateOld != null) {
                        RangerChangerItem.setOldFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoUpdateOld, SLOT);
                    }
                    if (setToArmorForm) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), belt.Armor_Form_Item, 1);
                    }

                    if (usedHand == InteractionHand.OFF_HAND & offhand) {
                        SLOT = offhandSlot;
                    }

                    if (switchItem != null & RangerChangerItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), SLOT) == this) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), switchItem, SLOT);
                    } else {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), this, SLOT);
                    }
                    if (alsoChange5thSlot != null) {
                        RangerChangerItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), alsoChange5thSlot, 5);
                    }

                } else if (!alternative.isEmpty()) {

                    for (RangerFormChangeItem alternativeItem_form_change : alternative) {
                        alternativeItem_form_change.use(level, player, usedHand);
                    }
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());

    }

    public void OnTransformation(ItemStack itemStack, LivingEntity entity) {
        if (timeoutDuration != 0) {
            if (!(entity instanceof ArmorStand)) {
                entity.addEffect(new MobEffectInstance(EffectCore.FORM_TIMEOUT, this.timeoutDuration, 0, true, false));
            }
            if (entity instanceof Player player && !player.isCreative()) {
                player.getCooldowns().addCooldown(this, this.lockDuration);
            }
        }
    }

    public void transformationEffect(ItemStack itemStack, LivingEntity entity) {
        if (entity.level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.GUST, entity.getX(), entity.getY() + 1.0, entity.getZ(), 1, 0, 0, 0, 1);
        }
    }

    public void transformationEffect(ItemStack itemStack, LivingEntity entity, Double tick) {
        if (tick == 30) {
            transformationEffect(itemStack, entity);
        }
        if (tick == 1) {
            RangerChangerItem.updateOldFormItem(itemStack);
        }
    }

    public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
    }
}