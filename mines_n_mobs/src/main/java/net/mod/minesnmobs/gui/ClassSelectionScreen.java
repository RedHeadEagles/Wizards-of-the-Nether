package net.mod.minesnmobs.gui;

import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.mod.minesnmobs.item.ClassSelectorItem;

public class ClassSelectionScreen extends Screen {
	private final PlayerEntity player;
	
	public ClassSelectionScreen(ITextComponent titleIn, PlayerEntity playerIn) {
		super(titleIn);
		player = playerIn;
	}

	protected void init()
	{
		this.addButtons();
	}
	
	private void addButtons()
	{
		this.addButton(new Button(this.width / 2 - 102, this.height / 4, 204, 20, "Fighter", (p_213063_1_) -> {
			CompoundNBT playerData = player.getPersistentData();
			if(!playerData.contains("class"))
			{
				playerData.putString("class", "fighter");
				player.sendMessage(new StringTextComponent(player.getName().getString() + " class set to Fighter"));
			}
			this.onClose();
        }));
		this.addButton(new Button(this.width / 2 - 102, this.height / 4 + 32, 204, 20, "Cleric", (p_213063_1_) -> {
			CompoundNBT playerData = player.getPersistentData();
			if(!playerData.contains("class"))
			{
				playerData.putString("class", "cleric");
				player.sendMessage(new StringTextComponent(player.getName().getString() + " class set to Cleric"));
			}
			this.onClose();
	    }));
		this.addButton(new Button(this.width / 2 - 102, this.height / 4 + 64, 204, 20, "Rogue", (p_213063_1_) -> {
			CompoundNBT playerData = player.getPersistentData();
			if(!playerData.contains("class"))
			{
				playerData.putString("class", "rogue");
				player.sendMessage(new StringTextComponent(player.getName().getString() + " class set to Rogue"));
			}
			this.onClose();
	      }));
	}

	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
        this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, 10, 16777215);
		super.render(p_render_1_, p_render_2_, p_render_3_);
	}
}
