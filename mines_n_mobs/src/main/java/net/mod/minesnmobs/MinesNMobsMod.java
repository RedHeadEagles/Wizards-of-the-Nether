package net.mod.minesnmobs;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.potion.Effect;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.mod.minesnmobs.item.ClassSelectorItem;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.biome.Biome;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.StringTextComponent;

import java.util.function.Supplier;

import org.lwjgl.glfw.GLFW;

@Mod("mines_n_mobs")
public class MinesNMobsMod {
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("mines_n_mobs", "mines_n_mobs"),
			() -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	private PlayerEntity entityPlayer;
	private Boolean loaded = false;

	public MinesNMobsModElements elements;
	public MinesNMobsMod() {
		elements = new MinesNMobsModElements();
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
		MinecraftForge.EVENT_BUS.register(this);
	}

	private void init(FMLCommonSetupEvent event) {
		elements.getElements().forEach(element -> element.init(event));
		register();
	}

	@SubscribeEvent
	public void serverLoad(FMLServerStartingEvent event) {
		elements.getElements().forEach(element -> element.serverLoad(event));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		elements.getElements().forEach(element -> element.clientLoad(event));
	}

	@SubscribeEvent
	public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event)
	{
		loaded = true;
		entityPlayer = event.getPlayer();
		CompoundNBT playerData = event.getPlayer().getPersistentData();
		if(!playerData.contains("first")) {
			event.getPlayer().sendMessage(new StringTextComponent(event.getPlayer().getName().getString() + " Adding item to inventory"));
			event.getPlayer().inventory.addItemStackToInventory(new ItemStack(ClassSelectorItem.block));
			playerData.putBoolean("first", true);
		}
		else{
			playerData.putBoolean("first", true);

			if (playerData.getString("class").equals("cleric")){
				entityPlayer.sendMessage(new StringTextComponent(entityPlayer.getName().getString() + "giving player regen because they are a cleric"));
				entityPlayer.addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 1000000, (int) 1));
			}//end if
			if (playerData.getString("class").equals("fighter")){
				entityPlayer.sendMessage(new StringTextComponent(entityPlayer.getName().getString() + "giving player resist because they are a fighter"));
				event.getPlayer().addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1000000, (int) 1));
			}//end if
		}//end else
	}//end onPlayerJoin

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(elements.getBlocks().stream().map(Supplier::get).toArray(Block[]::new));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(elements.getItems().stream().map(Supplier::get).toArray(Item[]::new));
	}

	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event) {
		event.getRegistry().registerAll(elements.getBiomes().stream().map(Supplier::get).toArray(Biome[]::new));
	}

	@SubscribeEvent
	public void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(elements.getEntities().stream().map(Supplier::get).toArray(EntityType[]::new));
	}

	@SubscribeEvent
	public void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
		event.getRegistry().registerAll(elements.getEnchantments().stream().map(Supplier::get).toArray(Enchantment[]::new));
	}

	@SubscribeEvent
	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		elements.registerSounds(event);
	}

	public KeyBinding special;

	public void register()
	{
		special = new KeyBinding("key.mines_n_mobs.special", 86, "key.categories.gameplay");
	}

	@SubscribeEvent
	public void playerLoad(PlayerEvent.LoadFromFile event){
		entityPlayer = event.getPlayer();
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		if (!loaded) return;

		CompoundNBT playerData = entityPlayer.getPersistentData();

		if(special.isPressed())
		{
			entityPlayer.sendMessage(new StringTextComponent("" + playerData.getString("class")));
			if (playerData.getString("class").equals("cleric")){
				entityPlayer.sendMessage(new StringTextComponent(entityPlayer.getName().getString() + " giving player Regen because they are a Cleric"));
				entityPlayer.addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 1000000, (int) 1));
			}
			else if (playerData.getString("class").equals("fighter")){
				entityPlayer.sendMessage(new StringTextComponent(entityPlayer.getName().getString() + " giving player Resistance because they are a Fighter"));
				entityPlayer.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1000000, (int) 1));
			}
			else if (playerData.getString("class").equals("rogue")){
				entityPlayer.sendMessage(new StringTextComponent(entityPlayer.getName().getString() + " giving player Invis because they are a Rogue"));
				entityPlayer.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 1000000, (int) 1));
			}
		}
	}
}
