package net.mod.minesnmobs.procedures;

import net.mod.minesnmobs.MinesNMobsModElements;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinesNMobsModElements.ModElement.Tag
public class BackstabProcedure extends MinesNMobsModElements.ModElement {
	public BackstabProcedure(MinesNMobsModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Backstab!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)
				/ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)) <= 0.25)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 250);
		}
	}
}
