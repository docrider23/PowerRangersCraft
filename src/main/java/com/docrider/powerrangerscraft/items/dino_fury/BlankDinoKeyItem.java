package com.docrider.powerrangerscraft.items.dino_fury;

import com.docrider.powerrangerscraft.items.others.BaseItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlankDinoKeyItem extends BaseItem {

	public static final List<Item> DINO_KEY = new ArrayList<Item>();
	
	public BlankDinoKeyItem(Properties prop) {
		
		super(prop);
	}

	private Item getDinoKeyDrop(Item item) {
		
		Random generator = new Random();
		
		int rand = generator.nextInt(DINO_KEY.size());
		
		return DINO_KEY.get(rand);
	}
	
	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int i, boolean flag) {
		
		if (entity instanceof Player) {
			
			Player playerIn = ((Player)entity);
			Item ryusoul = getDinoKeyDrop(itemstack.getItem());

			if (!world.isClientSide()) {
				
				playerIn.drop(new ItemStack (ryusoul), true);
				
				itemstack.shrink(1);
			}
		}
	}
}
