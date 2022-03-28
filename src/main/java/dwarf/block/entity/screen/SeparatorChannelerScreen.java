package dwarf.block.entity.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import dwarf.DwarfMain;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SeparatorChannelerScreen extends HandledScreen<SeparatorChannelerScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(DwarfMain.MODID, "textures/gui/da");

    public SeparatorChannelerScreen(SeparatorChannelerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    protected void init(){
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1f,1f,1f,1f);
        RenderSystem.setShaderTexture(0,TEXTURE);
        int x = (width - backgroundWidth)/2;
        int y = (height - backgroundHeight)/2;
        drawTexture(matrices,x,y,0,0,backgroundWidth,backgroundHeight);
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta){
        renderBackground(matrices);
        super.render(matrices,mouseX,mouseY,delta);
        drawMouseoverTooltip(matrices,mouseX,mouseY);
    }
}
