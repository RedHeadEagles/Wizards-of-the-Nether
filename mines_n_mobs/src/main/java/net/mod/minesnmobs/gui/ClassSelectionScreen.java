package net.mod.minesnmobs.gui;

import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;

public class ClassSelectionScreen extends Screen {
	
	public ClassSelectionScreen(ITextComponent titleIn) {
		super(titleIn);
	}

	protected void init()
	{
		this.addButtons();
	}
	
	private void addButtons()
	{
		this.addButton(new Button(this.width / 2 - 102, this.height / 4, 204, 20, "Fighter", (p_213063_1_) -> {
         this.minecraft.displayGuiScreen(new ConfirmOpenLinkScreen((p_213064_1_) -> {
            if (p_213064_1_) {
               Util.getOSType().openURI("https://google.com");
            }

            this.minecraft.displayGuiScreen(this);
         }, "https://google.com", true));
        }));
		this.addButton(new Button(this.width / 2 - 102, this.height / 4 + 32, 204, 20, "Cleric", (p_213063_1_) -> {
	         this.minecraft.displayGuiScreen(new ConfirmOpenLinkScreen((p_213064_1_) -> {
	            if (p_213064_1_) {
	               Util.getOSType().openURI("https://google.com");
	            }

	            this.minecraft.displayGuiScreen(this);
	         }, "https://google.com", true));
	    }));
		this.addButton(new Button(this.width / 2 - 102, this.height / 4 + 64, 204, 20, "Rogue", (p_213063_1_) -> {
	         this.minecraft.displayGuiScreen(new ConfirmOpenLinkScreen((p_213064_1_) -> {
	            if (p_213064_1_) {
	               Util.getOSType().openURI("https://google.com");
	            }

	            this.minecraft.displayGuiScreen(this);
	         }, "https://google.com", true));
	      }));
	}

	public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
		this.renderBackground();
        this.drawCenteredString(this.font, this.title.getFormattedText(), this.width / 2, 10, 16777215);
		super.render(p_render_1_, p_render_2_, p_render_3_);
	}
}
