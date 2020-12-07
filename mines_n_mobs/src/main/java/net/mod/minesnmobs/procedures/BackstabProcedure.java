package net.mod.minesnmobs.procedures;

import net.mod.minesnmobs.MinesNMobsModElements;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;

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
		
		Entity entity = (Entity) dependencies.get("entity");
		//player
		Entity sourceentity = (Entity) dependencies.get("player");
		CompoundNBT playerData = sourceentity.getPersistentData();
		//get and set the yaw values
		int pYaw = 0;
		pYaw = (int) sourceentity.rotationYaw;
		int mYaw = 0;
		mYaw = (int) entity.rotationYaw;
		//compare the yaws for backstab
		if(Math.abs(pYaw - mYaw) <= 30) {
			//backstab and print the yaw diff
			if (playerData.getString("class").equals("rogue")){
				//MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				//if (mcserv != null) mcserv.getPlayerList().sendMessage(new StringTextComponent(": IS ROGUE 1 player Yaw: " + pYaw + " monster yaw: " + mYaw ));
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
			}//end if
		}
		else if((pYaw < 20 || pYaw > 340) && (mYaw < 20 || mYaw > 340)) {
			//backstab and print the yaw diff / values
			if (playerData.getString("class").equals("rogue")){
				//MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				//if (mcserv != null) mcserv.getPlayerList().sendMessage(new StringTextComponent(": IS ROGUE 2 player Yaw: " + pYaw + " monster yaw: " + mYaw ));
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
			}//end if
		}//end elif
		
	}
}
