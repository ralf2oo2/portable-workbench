package ralf2oo2.portableworkbench.client.gui.screen;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;
import ralf2oo2.portableworkbench.screen.PortableWorkbenchScreenHandler;

public class PortableWorkbenchScreen extends HandledScreen {
    public PortableWorkbenchScreen(PlayerInventory playerInventory, World world) {
        super(new PortableWorkbenchScreenHandler(playerInventory, world));
    }

    @Override
    public void removed() {
        this.container.onClosed(this.minecraft.player);
    }

    @Override
    protected void drawForeground() {
        this.textRenderer.draw("Crafting", 28, 6, 4210752);
        this.textRenderer.draw("Inventory", 8, this.backgroundHeight - 96 + 2, 4210752);
    }

    @Override
    protected void drawBackground(float tickDelta) {
        int var2 = this.minecraft.textureManager.getTextureId("/gui/crafting.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.textureManager.bindTexture(var2);
        int var3 = (this.width - this.backgroundWidth) / 2;
        int var4 = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(var3, var4, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
