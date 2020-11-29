package net.mod.minesnmobs.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.registries.ObjectHolder;
import net.mod.minesnmobs.MinesNMobsModElements;
import net.mod.minesnmobs.gui.ClassSelectionScreen;

@MinesNMobsModElements.ModElement.Tag
public class ClassSelectorItem extends MinesNMobsModElements.ModElement {
	@ObjectHolder("mines_n_mobs:class_selector")
	public static final Item block = null;
	public ClassSelectorItem(MinesNMobsModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new Item(new Item.Properties().maxStackSize(1).group(ItemGroup.MISC)) {
			@Override
			public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
				ITextComponent i = new StringTextComponent("Select your class:");
				Minecraft.getInstance().displayGuiScreen(new ClassSelectionScreen(i, playerIn));
				return ActionResult.resultPass(ItemStack.EMPTY);
			   }
		}.setRegistryName("class_selector"));
	}
	
}
