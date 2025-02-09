package lumien.custommainmenu.gui;

import java.util.List;
import lumien.custommainmenu.configuration.elements.Button;
import lumien.custommainmenu.lib.StringReplacer;
import lumien.custommainmenu.lib.textures.ITexture;
import lumien.custommainmenu.util.GlStateManager;
import lumien.custommainmenu.util.LogicUtil;
import lumien.custommainmenu.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GuiCustomButton extends GuiButton {
    public Button b;
    ITexture texture;
    int normalText;
    int hoverText;
    boolean hovered;

    public GuiCustomButton(int buttonId, Button b) {
        super(buttonId, b.posX, b.posY, b.width, b.height, I18n.format((String) b.text.get(), (Object[])
                new Object[0]));
        this.texture = b.texture;
        this.normalText = b.normalTextColor;
        this.hoverText = b.hoverTextColor;
        this.b = b;
    }

    public void drawTooltip(Minecraft mc, int mouseX, int mouseY) {
        FontRenderer fontrenderer = mc.fontRenderer;
        if (this.hovered && this.b.tooltip != null) {
            this.drawHoveringText(mc, LogicUtil.getTooltip(this.b.tooltip.get()), mouseX, mouseY, fontrenderer);
        }
    }

    public void drawButton(Minecraft mc, int mouseX, int mouseY) {
        if (this.visible) {
            boolean newHovered;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (this.b.name.equals("language") && this.texture == null) {
                mc.getTextureManager().bindTexture(GuiButton.buttonTextures);
                boolean hovering = mouseX >= this.xPosition
                        && mouseY >= this.yPosition
                        && mouseX < this.xPosition + this.width
                        && mouseY < this.yPosition + this.height;
                int k = 106;
                if (hovering) {
                    k += this.height;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, k, this.width, this.height);
                return;
            }
            FontRenderer fontrenderer = mc.fontRenderer;
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            boolean bl = newHovered = mouseX >= this.xPosition
                    && mouseY >= this.yPosition
                    && mouseX < this.xPosition + this.width
                    && mouseY < this.yPosition + this.height;
            if (newHovered && !this.hovered && this.b.hoverSound != null) {
                Minecraft.getMinecraft().getSoundHandler().playSound((ISound) PositionedSoundRecord.func_147674_a(
                        (ResourceLocation) new ResourceLocation(this.b.hoverSound), (float) 1.0f));
            }
            this.hovered = newHovered;
            int k = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            if (this.texture != null) {
                this.texture.bind();
                RenderUtil.drawPartialImage(
                        this.xPosition,
                        this.yPosition,
                        0,
                        (k - 1) * this.b.imageHeight,
                        this.b.width,
                        this.b.height,
                        this.b.imageWidth,
                        this.b.imageHeight);
            } else {
                mc.getTextureManager().bindTexture(buttonTextures);
                this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
                this.drawTexturedModalRect(
                        this.xPosition + this.width / 2,
                        this.yPosition,
                        200 - this.width / 2,
                        46 + k * 20,
                        this.width / 2,
                        this.height);
            }
            this.mouseDragged(mc, mouseX, mouseY);
            int l = this.normalText;
            if (this.packedFGColour != 0) {
                l = this.packedFGColour;
            } else if (!this.enabled) {
                l = 10526880;
            } else if (this.hovered) {
                l = this.hoverText;
            }
            this.drawCenteredString(
                    fontrenderer,
                    this.hovered
                            ? I18n.format(
                                    (String) StringReplacer.replacePlaceholders(this.b.hoverText.get()),
                                    (Object[]) new Object[0])
                            : I18n.format((String) StringReplacer.replacePlaceholders(this.b.text.get()), (Object[])
                                    new Object[0]),
                    this.xPosition + this.width / 2,
                    this.yPosition + (this.height - 8) / 2,
                    l,
                    this.b.shadow);
        }
    }

    protected void drawHoveringText(Minecraft mc, List<String> textLines, int x, int y, FontRenderer font) {
        if (!textLines.isEmpty()) {
            int width = mc.currentScreen.width;
            int height = mc.currentScreen.height;
            GlStateManager.disableDepth();
            int k = 0;
            for (String s : textLines) {
                int l = font.getStringWidth(s);
                if (l <= k) continue;
                k = l;
            }
            int j2 = x + 12;
            int k2 = y - 12;
            int i1 = 8;
            if (textLines.size() > 1) {
                i1 += 2 + (textLines.size() - 1) * 10;
            }
            if (j2 + k > width) {
                j2 -= 28 + k;
            }
            if (k2 + i1 + 6 > height) {
                k2 = this.height - i1 - 6;
            }
            this.zLevel = 300.0f;
            int j1 = -267386864;
            this.drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
            this.drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
            int k1 = 1347420415;
            int l1 = (k1 & 0xFEFEFE) >> 1 | k1 & 0xFF000000;
            this.drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
            this.drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
            this.drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);
            for (int i2 = 0; i2 < textLines.size(); ++i2) {
                String s1 = (String) textLines.get(i2);
                font.drawStringWithShadow(s1, j2, k2, -1);
                if (i2 == 0) {
                    k2 += 2;
                }
                k2 += 10;
            }
            this.zLevel = 0.0f;
            GlStateManager.enableDepth();
        }
    }

    public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color, boolean shadow) {
        if (shadow) {
            fontRendererIn.drawStringWithShadow(text, x - fontRendererIn.getStringWidth(text) / 2, y, color);
        } else {
            fontRendererIn.drawString(text, x - fontRendererIn.getStringWidth(text) / 2, y, color, false);
        }
    }

    public void func_146113_a(SoundHandler soundHandlerIn) {
        if (this.b.pressSound != null) {
            soundHandlerIn.playSound((ISound) PositionedSoundRecord.func_147674_a(
                    (ResourceLocation) new ResourceLocation(this.b.pressSound), (float) 1.0f));
        } else {
            super.func_146113_a(soundHandlerIn);
        }
    }
}
