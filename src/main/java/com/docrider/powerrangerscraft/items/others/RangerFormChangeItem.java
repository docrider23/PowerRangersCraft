package com.docrider.powerrangerscraft.items.others;


import com.google.common.collect.Lists;
import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import com.docrider.powerrangerscraft.items.OtherItems;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.GeckoLibCache;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RangerFormChangeItem extends BaseItem {

    private String FORM_NAME;
    private int Slot =1;
    private int OffhandSlot=10;
    private Boolean Offhand = false;

    private List<MobEffectInstance> potionEffectList;
    private int BELT;
    private List<Item> NEEDITEM = new ArrayList<Item>();
    protected String RANGER_NAME;
    protected String OVERRIDE_RANGER_NAME;

    private String BELT_TEX;
    private Boolean IS_GLOWING = false;
    private Boolean IS_BELT_GLOWING = false;
    private Boolean HAS_STATIC_WINGS = false;
    private String UPDATED_BELT_MODEL;
    private String UPDATED_MODEL;
    private String FLYING_MODEL;
    private String UPDATED_MODEL_ANIMATION;
    private Boolean SET_PLAYER_MODEL_INVISIBLE = false;
    private Boolean SET_SHOW_FACE = false;
    private Boolean SET_SHOW_UNDER = false;

    private Boolean A1 = false;

    private Boolean FLYING_TEXT = false;
    private Item SHIFT_ITEM = Items.APPLE;
    private Item SWITCH_ITEM;
    private Boolean RESET_FORM = false;
    private Boolean RESET_FORM_MAIN = false;

    private Boolean SET_TO_ARMOR_FORM = false;

    private List<RangerFormChangeItem> alternative = new ArrayList<RangerFormChangeItem>();
    private RangerFormChangeItem alsoChange1stSlot;
    private RangerFormChangeItem alsoChange2ndSlot;
    private RangerFormChangeItem alsoChange3rdSlot;
    private RangerFormChangeItem alsoChange4thSlot;
    private RangerFormChangeItem alsoChange5thSlot;

    private Boolean hasIncompatibleForms = false;
    private List<RangerFormChangeItem> incompatibleForms= new ArrayList<RangerFormChangeItem>();

    public String[] compatibilityList= new String[] {""};
    public List<Item> needItemList = new ArrayList<Item>();

    private Boolean NEED_BASE_FORM = false;
    private RangerFormChangeItem NEED_FORM_SLOT_1;
    private RangerFormChangeItem NEED_FORM_SLOT_2;
    private RangerFormChangeItem NEED_FORM_SLOT_3;
    private RangerFormChangeItem NEED_FORM_SLOT_4;

    private int timeoutDuration=0;
    private int lockDuration=0;
    private RangerFormChangeItem REVERT_FORM;

    private Boolean IGNORE_BELT_TEXT = false;

    private int Store_num =1;

    public RangerFormChangeItem(Properties properties, int belt, String formName, String rangername, String beltTex, MobEffectInstance... effects) {
        super( properties);

        potionEffectList = Lists.newArrayList(effects);
        FORM_NAME = formName;
        BELT_TEX = beltTex;
        BELT = belt;
        RANGER_NAME = rangername;
    }


    public List<MobEffectInstance> getPotionEffectList() {
        return potionEffectList;
    }

    public int getSlot() {
        return Slot;
    }

    public int getBelt() {
        return BELT;
    }

    public String getFormName(Boolean isFlaying) {
        return (isFlaying&FLYING_TEXT ? FORM_NAME+"_wing" : FORM_NAME);
    }

    public String getRangerName(String name) {
        return (OVERRIDE_RANGER_NAME!=null ? OVERRIDE_RANGER_NAME : name);
    }

    public Boolean getRESET_FORM(){return RESET_FORM;}

    public Item getSHIFT_ITEM(){return SHIFT_ITEM;}

    public RangerFormChangeItem getAlsoChange2ndSlot(){return alsoChange2ndSlot;}

    public String getBeltTex() {
        return BELT_TEX;
    }

    public List<RangerFormChangeItem> getAlternative () {
        return alternative;
    }


    public Boolean getIgnoreOverrideBeltText() {
        return IGNORE_BELT_TEXT;
    }

    public String get_Belt_Model() {
        return (UPDATED_BELT_MODEL!=null ? UPDATED_BELT_MODEL : "geo/rangerbelt.geo.json");
    }

    public String get_Model(String rangerName) {
        if (UPDATED_MODEL!=null) return UPDATED_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+getRangerName(rangerName)+FORM_NAME+".geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? "geo/"+getRangerName(rangerName)+FORM_NAME+".geo.json" : (get_Has_Static_Wings() ? "rangerwing.geo.json" : "ranger.geo.json"));
    }

    public String get_Animation(String rangerName) {
        if (UPDATED_MODEL_ANIMATION!=null) return "animations/"+UPDATED_MODEL_ANIMATION;
        ResourceLocation FORM_ANIM = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "animations/"+getRangerName(rangerName)+FORM_NAME+".animation.json");
        return (GeckoLibCache.getBakedAnimations().get(FORM_ANIM)!=null ? "animations/"+getRangerName(rangerName)+FORM_NAME+".animation.json" : "animations/ranger.animation.json");
    }

    public Boolean get_Show_Face() {
        return SET_SHOW_FACE;
    }

    public Boolean get_Show_under() {
        return SET_SHOW_UNDER;
    }

    public Boolean get_Is_Glowing() {
        return IS_GLOWING;
    }

    public Boolean get_a1() {
        return A1;
    }

    public Boolean get_Is_Belt_Glowing() {
        return IS_BELT_GLOWING;
    }

    public Boolean get_Has_Static_Wings() {
        return HAS_STATIC_WINGS;
    }

    public int get_Stored_num() {
        return Store_num;
    }

    public String get_FlyingModel(String rangerName) {
        if (FLYING_MODEL!=null) return FLYING_MODEL;
        ResourceLocation FORM_MODEL = ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "geo/"+getRangerName(rangerName)+FORM_NAME+"_wing.geo.json");
        return (GeckoLibCache.getBakedModels().get(FORM_MODEL)!=null ? getRangerName(rangerName)+FORM_NAME+"_wing.geo.json" : "rangerwingbelt.geo.json");
    }
    public Boolean HasWingsIfFlying() {
        return FLYING_TEXT;
    }

    public RangerFormChangeItem AddIncompatibleForm(Item item) {
        incompatibleForms.add((RangerFormChangeItem) item);
       hasIncompatibleForms=true;
        return this;
    }

    public RangerFormChangeItem alsoChange1stSlot(Item item) {
        alsoChange1stSlot=  (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange2ndSlot(Item item) {
        alsoChange2ndSlot=  (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange3rdSlot(Item item) {
        alsoChange3rdSlot=  (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange4thSlot(Item item) {
        alsoChange4thSlot=  (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem alsoChange5thSlot(Item item) {
        alsoChange5thSlot=  (RangerFormChangeItem) item;
        return this;
    }

    public RangerFormChangeItem ChangeRangerName(String name) {
        OVERRIDE_RANGER_NAME=name;
        return this;
    }

    public RangerFormChangeItem ChangeModel(String model) {
        UPDATED_MODEL=model;
        return this;
    }

    public RangerFormChangeItem ChangeAnimation(String animation) {
        UPDATED_MODEL_ANIMATION=animation;
        return this;
    }
    public RangerFormChangeItem SetPalyerModelInvisible() {
        SET_PLAYER_MODEL_INVISIBLE = true;
        return this;
    }

    public RangerFormChangeItem SetShowFace() {
        SET_SHOW_FACE = true;
        return this;
    }
    public RangerFormChangeItem SetShowUnder() {
        SET_SHOW_UNDER = true;
        return this;
    }

    public RangerFormChangeItem ChangeBeltModel(String model) {
        UPDATED_BELT_MODEL=model;
        return this;
    }

    public RangerFormChangeItem ChangeSlot(int slot) {
        Slot=slot;
        return this;
    }

    public int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public int getLockDuration() {
        return this.lockDuration;
    }

    public RangerFormChangeItem getRevertForm() {
        return this.REVERT_FORM;
    }

    public RangerFormChangeItem hasTimeout(int timeout, int lock, RangerFormChangeItem revertsTo) {
        timeoutDuration = timeout;
        lockDuration = lock;
        REVERT_FORM = revertsTo;
        return this;
    }

    public RangerFormChangeItem AddNum(int num) {
        Store_num=num;
        return this;
    }
    public RangerFormChangeItem SetOffhandSlot(int slot) {
        OffhandSlot=slot;
        Offhand=true;
        return this;
    }

    public RangerFormChangeItem hasFlyingWings(@Nullable String model) {
        FLYING_TEXT=true;
        if (model!=null) FLYING_MODEL=model;
        return this;
    }

    public RangerFormChangeItem addAlternative(Item item) {
        alternative.add((RangerFormChangeItem) item);
        return this;
    }

    public RangerFormChangeItem ResetFormToBase() {
        RESET_FORM=true;
        return this;
    }
    public RangerFormChangeItem ResetFormToBaseIfMain() {
        RESET_FORM_MAIN=true;
        return this;
    }
    public RangerFormChangeItem SetFormToArmor() {
        SET_TO_ARMOR_FORM=true;
        return this;
    }

    public RangerFormChangeItem IsGlowing() {
        IS_GLOWING=true;
        return this;
    }

    public RangerFormChangeItem IsA1() {
        A1=true;
        return this;
    }

    public RangerFormChangeItem IsBeltGlowing() {
        IS_BELT_GLOWING=true;
        return this;
    }

    public RangerFormChangeItem hasStaticWings() {
        HAS_STATIC_WINGS=true;
        return this;
    }

    public RangerFormChangeItem needBaseForm() {
     NEED_BASE_FORM=true;
        return this;
    }

    public RangerFormChangeItem ignoreOverrideBeltText() {
        IGNORE_BELT_TEXT =true;
        return this;
    }

    public RangerFormChangeItem addNeedForm(Item  item) {
    NEED_FORM_SLOT_1=((RangerFormChangeItem)item);
        return this;
    }
    public RangerFormChangeItem addNeedForm(Item  item, int slot) {

        if (slot==1)NEED_FORM_SLOT_1=((RangerFormChangeItem)item);
        else if (slot==2)NEED_FORM_SLOT_2=((RangerFormChangeItem)item);
        else if (slot==3)NEED_FORM_SLOT_3=((RangerFormChangeItem)item);
        else if (slot==4)NEED_FORM_SLOT_4=((RangerFormChangeItem)item);
        return this;
    }

    public RangerFormChangeItem addNeedItem(Item item) {
        NEEDITEM.add(item);
        return this;
    }

    public RangerFormChangeItem addShiftForm(Item item) {
        SHIFT_ITEM=item;
        return this;
    }

    public RangerFormChangeItem addSwitchForm(Item item) {
        SWITCH_ITEM=item;
        return this;
    }

    public RangerFormChangeItem AddNeedItemList(List<Item> NEED_ITEM) {
        needItemList=NEED_ITEM;
        return this;
    }

    public RangerFormChangeItem AddCompatibilityList(String[] List) {
        compatibilityList=List;
        return this;
    }


    public Boolean iscompatible(RangerChangerItem belt) {
        if (belt.Rider==RANGER_NAME) return true;
        for (String str : compatibilityList) {
            if (str==belt.Rider) return true;
        }
        ItemStack itemstack=new ItemStack(belt);
        return itemstack.is(ItemTags.create(ResourceLocation.fromNamespaceAndPath(PowerRangersCraftCore.MODID, "form_change_item/works_with/" +RANGER_NAME+FORM_NAME)));
    }

	public boolean inventoryOrHolderContains(Player player, Item item) {
		NonNullList<ItemStack> inv = NonNullList.create();
		inv.addAll(player.getInventory().items);
		inv.addAll(player.getInventory().armor);
		inv.add(player.getInventory().offhand.getFirst());

		if (player.getInventory().countItem(item)!=0) return true;
		else for (int i = 0; i < inv.size(); i++) {
			if (inv.get(i).has(DataComponents.CONTAINER)) {
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.CONTAINER).nonEmptyItems()) if (stack.getItem() == item) return true;
			} else if (inv.get(i).has(DataComponents.BUNDLE_CONTENTS))
				for (ItemStack stack : inv.get(i).getComponents().get(DataComponents.BUNDLE_CONTENTS).items()) if (stack.getItem() == item) return true;
		}
		return false;
	}

        public Boolean CanChange(Player player,RangerChangerItem belt, ItemStack stack) {

        if (this == OtherItems.BLANK_FORM.get()) {
            return true;
        }
        if(hasIncompatibleForms) {
            for (int i = 0; i < incompatibleForms.size(); i++)
            {
                if (incompatibleForms.get(i)==RangerChangerItem.get_Form_Item(stack, 1)){
                    return false;
                }
            }
        }

            if(!iscompatible(belt)) {
            return false;
        }
        if ( !NEEDITEM.isEmpty()) {
            for (Item item : NEEDITEM)
            {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        if (NEED_BASE_FORM )if (RangerChangerItem.get_Form_Item(stack, 1)!=belt.Base_Form_Item)return false;
        if (NEED_FORM_SLOT_1!=null )if (RangerChangerItem.get_Form_Item(stack, 1)!=NEED_FORM_SLOT_1)return false;
        if (NEED_FORM_SLOT_2!=null )if (RangerChangerItem.get_Form_Item(stack, 2)!=NEED_FORM_SLOT_2)return false;
        if (NEED_FORM_SLOT_3!=null )if (RangerChangerItem.get_Form_Item(stack, 3)!=NEED_FORM_SLOT_3)return false;
        if (NEED_FORM_SLOT_4!=null )if (RangerChangerItem.get_Form_Item(stack, 4)!=NEED_FORM_SLOT_4)return false;

        if  (!needItemList.isEmpty()) {
            for (Item item : needItemList)
            {
                if (!inventoryOrHolderContains(player, item)) return false;
            }
        }
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

         if (BELT.getItem() instanceof RangerChangerItem belt) {

                if (SHIFT_ITEM instanceof RangerFormChangeItem & player.isShiftKeyDown()) {
                    ((RangerFormChangeItem)SHIFT_ITEM).use(level, player, usedHand);
                }
                else if (CanChange(player,belt,BELT)) {
                    if (RESET_FORM)RangerChangerItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    if (RESET_FORM_MAIN&belt.Rider==RANGER_NAME)RangerChangerItem.reset_Form_Item(player.getItemBySlot(EquipmentSlot.FEET));
                    if (alsoChange1stSlot !=null)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange1stSlot, 1);
                    if (alsoChange2ndSlot !=null)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange2ndSlot, 2);
                    if (alsoChange3rdSlot !=null)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange3rdSlot, 3);
                    if (alsoChange4thSlot !=null)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange4thSlot, 4);

                    //if (SET_TO_ARMOR_FORM)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),belt.Armor_Form_Item, 1);

                    int SLOT = Slot;
                    if (usedHand==InteractionHand.OFF_HAND&Offhand)SLOT = OffhandSlot;

                    if (SWITCH_ITEM!=null&RangerChangerItem.get_Form_Item(player.getItemBySlot(EquipmentSlot.FEET), SLOT)==this) RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),SWITCH_ITEM, SLOT);
                    else RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),this, SLOT);
                    if (alsoChange5thSlot !=null)RangerChangerItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),alsoChange5thSlot, 5);

                }else if(!alternative.isEmpty()){

                    for (int i = 0; i < alternative.size(); i++)
                    {
                        RangerFormChangeItem alternativeItem_form_change = alternative.get(i);
                        alternativeItem_form_change.use(level, player, usedHand);
                    }
                }
            }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());

    }

    public void OnTransformation(ItemStack itemstack, LivingEntity entity) {
        if (timeoutDuration != 0) {
            if (entity instanceof Player player && !player.isCreative()) player.getCooldowns().addCooldown(this, this.lockDuration);
        }
        if (entity.level() instanceof ServerLevel sl) {
            sl.sendParticles(ParticleTypes.GUST,
                    entity.getX(), entity.getY() + 1.0,
                    entity.getZ(), 1, 0, 0, 0, 1);
        }
    }


    public void OnRiderKickHit(ItemStack itemstack, LivingEntity pLivingEntity, LivingEntity enemy) {
    }
}
