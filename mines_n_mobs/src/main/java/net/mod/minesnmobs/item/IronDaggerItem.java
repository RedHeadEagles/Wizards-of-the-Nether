
package net.mod.minesnmobs.item;

import net.mod.minesnmobs.procedures.BackstabProcedure;
import net.mod.minesnmobs.MinesNMobsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import java.util.Map;
import java.util.HashMap;

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
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				//double x = entity.getPosX();
				//double y = entity.getPosY();
				//double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					//Add player to dependencies
					$_dependencies.put("player", sourceentity);
					BackstabProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("iron_dagger"));
	}
}
