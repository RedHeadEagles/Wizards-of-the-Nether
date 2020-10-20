
package net.mod.minesnmobs.item;

import net.mod.minesnmobs.MinesNMobsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

@MinesNMobsModElements.ModElement.Tag
public class IronDaggerItem extends MinesNMobsModElements.ModElement {
	@ObjectHolder("mines_n_mobs:iron_dagger")
	public static final Item block = null;
	public IronDaggerItem(MinesNMobsModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 1.9999999999999996f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 6;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.IRON_INGOT, (int) (1)));
			}
		}, 3, -1.5f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("iron_dagger"));
	}
}
