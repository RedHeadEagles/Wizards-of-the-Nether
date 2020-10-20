
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
public class DiamondDaggerItem extends MinesNMobsModElements.ModElement {
	@ObjectHolder("mines_n_mobs:diamond_dagger")
	public static final Item block = null;
	public DiamondDaggerItem(MinesNMobsModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1561;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.DIAMOND, (int) (1)));
			}
		}, 3, 1f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("diamond_dagger"));
	}
}
