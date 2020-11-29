package net.mod.minesnmobs.procedures;

import net.mod.minesnmobs.MinesNMobsModElements;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.lang.Math;

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
		//mob hit
		Entity entity = (Entity) dependencies.get("entity");
		//player
		Entity sourceentity = (Entity) dependencies.get("player");
		//get and set the yaw values
		int pYaw = 0;
		pYaw = (int) sourceentity.rotationYaw;
		int mYaw = 0;
		mYaw = (int) entity.rotationYaw;
		//compare the yaws for backstab
		if(Math.abs(pYaw - mYaw) <= 30) {
			//backstab and print the yaw diff
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null) mcserv.getPlayerList().sendMessage(new StringTextComponent("player Yaw: " + pYaw + " monster yaw: " + mYaw ));
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
		}
		else if((pYaw < 20 || pYaw > 340) && (mYaw < 20 || mYaw > 340)) {
			//backstab and print the yaw diff / values
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null) mcserv.getPlayerList().sendMessage(new StringTextComponent("player Yaw: " + pYaw + " monster yaw: " + mYaw ));
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
		}//end elif
		
	}
}
