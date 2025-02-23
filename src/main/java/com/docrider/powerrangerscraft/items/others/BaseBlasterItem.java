package com.docrider.powerrangerscraft.items.others;

import com.docrider.powerrangerscraft.items.MMPRItems;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.docrider.powerrangerscraft.PowerRangersCraftCore;
import com.docrider.powerrangerscraft.effect.EffectCore;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlasterItem extends BowItem {

	private final float attackDamage;
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;

	private Item RepairItem = MMPRItems.MMPR_LOGO.get();
	private Item ChangerItem = MMPRItems.MMPR_LOGO.get();

	private Boolean LFB = false;
	private int LFBB = 1;
	private Boolean SFB = false;
	private Boolean EP = false;
	private Boolean WS = false;
	private Boolean CK = false;
	private Boolean DFB = false;
	private Boolean Changer = false;
	private Boolean Charged = false;
	
	public BaseBlasterItem(Tier toolTier, int Atk, float Spd, Properties prop) {
		super(prop.durability(toolTier.getUses()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, Atk, Spd)));
		this.attackDamage = (float)Atk;
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		this.defaultModifiers = builder.build();

	}

	public float getDamage() {
		return this.attackDamage;
	}

	public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof Player player) {
			ItemStack itemstack = new ItemStack(Items.ARROW, 1);
			itemstack.set(DataComponents.INTANGIBLE_PROJECTILE, Unit.INSTANCE);

			List<ItemStack> list = draw(stack, itemstack, player);
			if (level instanceof ServerLevel) {
				if (Changer && player.getItemBySlot(EquipmentSlot.FEET)==ItemStack.EMPTY) {
					player.setItemSlot(EquipmentSlot.FEET, new ItemStack(ChangerItem));
					if (player.getItemBySlot(EquipmentSlot.OFFHAND).getItem() instanceof RangerFormChangeItem) player.getItemBySlot(EquipmentSlot.OFFHAND).getItem().use(level, player, InteractionHand.OFF_HAND);
				}
				ServerLevel serverlevel = (ServerLevel)level;
				if (!list.isEmpty()) {

					Vec3 vec3 = player.getLookAngle();
					if (SFB){
						SmallFireball smallfireball = new SmallFireball(player.level(), player, vec3.normalize());
						smallfireball.setPos(smallfireball.getX(), player.getY(0.5) + 0.5, smallfireball.getZ());
						player.level().addFreshEntity(smallfireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (LFB){
						LargeFireball largefireball = new LargeFireball(player.level(), player, vec3.normalize(),LFBB);
						largefireball.setPos(largefireball.getX(), player.getY(0.5) + 0.5, largefireball.getZ());
						player.level().addFreshEntity(largefireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (DFB) {
						DragonFireball dragonfireball = new DragonFireball(player.level(), player, vec3.normalize());
						dragonfireball.setPos(dragonfireball.getX(), player.getY(0.5D) + 0.5D, dragonfireball.getZ());
						player.level().addFreshEntity(dragonfireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (CK) {
						ThrownEgg fireball = new ThrownEgg(player.level(),player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.setDeltaMovement( fireball.getDeltaMovement().add(vec3.x*3, vec3.y*3, vec3.z*3));
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}else if (WS) {
						WitherSkull fireball = new WitherSkull(player.level(), player,vec3.normalize());
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}
					else if (EP) {
						ThrownEnderpearl fireball = new ThrownEnderpearl(player.level(),player);
						fireball.setPos(fireball.getX(), player.getY(0.5D) + 0.5D, fireball.getZ());
						fireball.setDeltaMovement( fireball.getDeltaMovement().add(vec3.x*3, vec3.y*3, vec3.z*3));
						player.level().addFreshEntity(fireball);
						stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(player.getUsedItemHand()));
					}
					else if (Charged) {
						if (get_mode(stack)<30) set_mode(stack,get_mode(stack)+1);
						else if (get_mode(stack)==30) {
							player.addEffect(new MobEffectInstance(EffectCore.EXPLOSIONSHOT, 40, 2,true,false));
						}

						this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, 3, 1.0F, true, (LivingEntity)null);
					}

					else this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, 3, 1.0F, true, (LivingEntity)null);
				}
				level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.BLAZE_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
				player.awardStat(Stats.ITEM_USED.get(this));
			}
		}

	}

	@Override
	protected void shootProjectile(LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target) {
		projectile.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		boolean flag = !player.getProjectile(itemstack).isEmpty();
		InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, level, player, hand, flag);

		if (ret != null) return ret;
		else {
			player.startUsingItem(hand);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		return true;
	}

	public int getDefaultProjectileRange() {
		return 30;
	}

	public BaseBlasterItem ChangeRepairItem(Item item) {
		RepairItem = item;
		return this;
	}

	public boolean isValidRepairItem(ItemStack p_40392_, ItemStack p_40393_) {
		return p_40393_.getItem()== RepairItem;
	}

	public BaseBlasterItem IsSwordGun() {
		PowerRangersCraftCore.SWORD_GUN_ITEM.add(this);
		return this;
	}

	public BaseBlasterItem IsChargeWeapon() {
		PowerRangersCraftCore.CHARGED_WEAPON.add(this);
		Charged = true;
		return this;
	}

	public BaseBlasterItem setProjectileLargeFireball(int blast) {
		LFB=true;
		LFBB=blast;
		return this;
	}
	public BaseBlasterItem setProjectileDragonFireball() {
		DFB=true;
		return this;
	}
	public BaseBlasterItem setProjectileFireball() {
		SFB=true;
		return this;
	}

	public BaseBlasterItem setProjectileWitherSkull() {
		WS=true;
		return this;
	}
	public BaseBlasterItem setProjectileEnderpearl() {
		EP=true;
		return this;
	}
	public BaseBlasterItem setProjectileEgg() {
		CK=true;
		return this;
	}
	public BaseBlasterItem AddToTabList(List<Item> TabList) {
		TabList.add(this);
		return this;
	}

	public BaseBlasterItem isChanger(Item item) {
		ChangerItem = item;
		Changer = true;
		return this;
	}

	public static void set_mode(ItemStack itemstack, int flag)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) {
			itemstack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
		}
		CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
		tag.putInt("item_mode", flag);
	}

	public static int get_mode (ItemStack itemstack)
	{
		if (!itemstack.getComponents().has(DataComponents.CUSTOM_DATA)) return  0;
		else{
			CompoundTag tag = itemstack.get(DataComponents.CUSTOM_DATA).getUnsafe();
			return tag.getInt("item_mode");
		}
	}

	public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
		return createAttributes(tier, (float)attackDamage, attackSpeed);
	}
	public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}

}