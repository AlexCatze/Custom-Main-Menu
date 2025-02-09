package lumien.custommainmenu.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.nio.FloatBuffer;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

@SideOnly(value = Side.CLIENT)
public class GlStateManager {
    private static AlphaState alphaState;
    private static BooleanState lightingState;
    private static BooleanState[] lightState;
    private static ColorMaterialState colorMaterialState;
    private static BlendState blendState;
    private static DepthState depthState;
    private static FogState fogState;
    private static CullState cullState;
    private static PolygonOffsetState polygonOffsetState;
    private static ColorLogicState colorLogicState;
    private static TexGenState texGenState;
    private static ClearState clearState;
    private static StencilState stencilState;
    private static BooleanState normalizeState;
    private static int activeTextureUnit;
    private static TextureState[] textureState;
    private static int activeShadeModel;
    private static BooleanState rescaleNormalState;
    private static ColorMask colorMaskState;
    private static Color colorState;
    private static Viewport viewportState;
    private static final String __OBFID = "CL_00002558";

    public static void pushAttrib() {
        GL11.glPushAttrib((int) 8256);
    }

    public static void popAttrib() {
        GL11.glPopAttrib();
    }

    public static void disableAlpha() {
        GL11.glDisable((int) 3008);
    }

    public static void enableAlpha() {
        GL11.glEnable((int) 3008);
    }

    public static void alphaFunc(int p_179092_0_, float p_179092_1_) {
        GL11.glAlphaFunc((int) p_179092_0_, (float) p_179092_1_);
    }

    public static void enableLighting() {
        GL11.glEnable((int) 2896);
    }

    public static void disableLighting() {
        GL11.glDisable((int) 2896);
    }

    public static void disableDepth() {
        GL11.glDisable((int) 2929);
    }

    public static void enableDepth() {
        GL11.glEnable((int) 2929);
    }

    public static void depthFunc(int p_179143_0_) {
        GL11.glDepthFunc((int) p_179143_0_);
    }

    public static void depthMask(boolean p_179132_0_) {
        GL11.glDepthMask((boolean) p_179132_0_);
    }

    public static void disableBlend() {
        GL11.glDisable((int) 3042);
    }

    public static void enableBlend() {
        GL11.glEnable((int) 3042);
    }

    public static void blendFunc(int p_179112_0_, int p_179112_1_) {
        GL11.glBlendFunc((int) p_179112_0_, (int) p_179112_1_);
    }

    public static void tryBlendFuncSeparate(int p_179120_0_, int p_179120_1_, int p_179120_2_, int p_179120_3_) {
        OpenGlHelper.glBlendFunc((int) p_179120_0_, (int) p_179120_1_, (int) p_179120_2_, (int) p_179120_3_);
    }

    public static void enableCull() {
        GL11.glEnable((int) 2884);
    }

    public static void disableCull() {
        GL11.glDisable((int) 2884);
    }

    public static void cullFace(int p_179107_0_) {
        GL11.glCullFace((int) p_179107_0_);
    }

    public static void setActiveTexture(int p_179138_0_) {
        OpenGlHelper.setActiveTexture((int) p_179138_0_);
    }

    public static void enableTexture2D() {
        GL11.glEnable((int) 3553);
    }

    public static void disableTexture2D() {
        GL11.glDisable((int) 3553);
    }

    public static int generateTexture() {
        return GL11.glGenTextures();
    }

    public static void bindTexture(int p_179144_0_) {
        GL11.glBindTexture((int) 3553, (int) p_179144_0_);
    }

    public static void enableNormalize() {
        GL11.glEnable((int) 2977);
    }

    public static void disableNormalize() {
        GL11.glDisable((int) 2977);
    }

    public static void shadeModel(int p_179103_0_) {
        GL11.glShadeModel((int) p_179103_0_);
    }

    public static void viewport(int p_179083_0_, int p_179083_1_, int p_179083_2_, int p_179083_3_) {
        GL11.glViewport((int) p_179083_0_, (int) p_179083_1_, (int) p_179083_2_, (int) p_179083_3_);
    }

    public static void colorMask(boolean p_179135_0_, boolean p_179135_1_, boolean p_179135_2_, boolean p_179135_3_) {
        GL11.glColorMask((boolean) p_179135_0_, (boolean) p_179135_1_, (boolean) p_179135_2_, (boolean) p_179135_3_);
    }

    public static void clearDepth(double p_179151_0_) {
        GL11.glClearDepth((double) p_179151_0_);
    }

    public static void clearColor(float p_179082_0_, float p_179082_1_, float p_179082_2_, float p_179082_3_) {
        GL11.glClearColor((float) p_179082_0_, (float) p_179082_1_, (float) p_179082_2_, (float) p_179082_3_);
    }

    public static void clear(int p_179086_0_) {
        GL11.glClear((int) p_179086_0_);
    }

    public static void matrixMode(int p_179128_0_) {
        GL11.glMatrixMode((int) p_179128_0_);
    }

    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }

    public static void pushMatrix() {
        GL11.glPushMatrix();
    }

    public static void popMatrix() {
        GL11.glPopMatrix();
    }

    public static void getFloat(int p_179111_0_, FloatBuffer p_179111_1_) {
        GL11.glGetFloat((int) p_179111_0_, (FloatBuffer) p_179111_1_);
    }

    public static void ortho(
            double p_179130_0_,
            double p_179130_2_,
            double p_179130_4_,
            double p_179130_6_,
            double p_179130_8_,
            double p_179130_10_) {
        GL11.glOrtho(
                (double) p_179130_0_,
                (double) p_179130_2_,
                (double) p_179130_4_,
                (double) p_179130_6_,
                (double) p_179130_8_,
                (double) p_179130_10_);
    }

    public static void rotate(float p_179114_0_, float p_179114_1_, float p_179114_2_, float p_179114_3_) {
        GL11.glRotatef((float) p_179114_0_, (float) p_179114_1_, (float) p_179114_2_, (float) p_179114_3_);
    }

    public static void scale(float p_179152_0_, float p_179152_1_, float p_179152_2_) {
        GL11.glScalef((float) p_179152_0_, (float) p_179152_1_, (float) p_179152_2_);
    }

    public static void scale(double p_179139_0_, double p_179139_2_, double p_179139_4_) {
        GL11.glScaled((double) p_179139_0_, (double) p_179139_2_, (double) p_179139_4_);
    }

    public static void translate(float p_179109_0_, float p_179109_1_, float p_179109_2_) {
        GL11.glTranslatef((float) p_179109_0_, (float) p_179109_1_, (float) p_179109_2_);
    }

    public static void translate(double p_179137_0_, double p_179137_2_, double p_179137_4_) {
        GL11.glTranslated((double) p_179137_0_, (double) p_179137_2_, (double) p_179137_4_);
    }

    public static void multMatrix(FloatBuffer p_179110_0_) {
        GL11.glMultMatrix((FloatBuffer) p_179110_0_);
    }

    public static void color(float p_179131_0_, float p_179131_1_, float p_179131_2_, float p_179131_3_) {
        GL11.glColor4f((float) p_179131_0_, (float) p_179131_1_, (float) p_179131_2_, (float) p_179131_3_);
    }

    public static void color(float p_179124_0_, float p_179124_1_, float p_179124_2_) {
        GlStateManager.color(p_179124_0_, p_179124_1_, p_179124_2_, 1.0f);
    }

    public static void resetColor() {
        GlStateManager.colorState.alpha = -1.0f;
        GlStateManager.colorState.blue = -1.0f;
        GlStateManager.colorState.green = -1.0f;
        GlStateManager.colorState.red = -1.0f;
    }

    public static void callList(int p_179148_0_) {
        GL11.glCallList((int) p_179148_0_);
    }

    static {
        int var0;
        alphaState = new AlphaState(null);
        lightingState = new BooleanState(2896);
        lightState = new BooleanState[8];
        colorMaterialState = new ColorMaterialState(null);
        blendState = new BlendState(null);
        depthState = new DepthState(null);
        fogState = new FogState(null);
        cullState = new CullState(null);
        polygonOffsetState = new PolygonOffsetState(null);
        colorLogicState = new ColorLogicState(null);
        texGenState = new TexGenState(null);
        clearState = new ClearState(null);
        stencilState = new StencilState(null);
        normalizeState = new BooleanState(2977);
        activeTextureUnit = 0;
        textureState = new TextureState[8];
        activeShadeModel = 7425;
        rescaleNormalState = new BooleanState(32826);
        colorMaskState = new ColorMask(null);
        colorState = new Color();
        viewportState = new Viewport(null);
        for (var0 = 0; var0 < 8; ++var0) {
            GlStateManager.lightState[var0] = new BooleanState(16384 + var0);
        }
        for (var0 = 0; var0 < 8; ++var0) {
            GlStateManager.textureState[var0] = new TextureState(null);
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class Viewport {
        public int x = 0;
        public int y = 0;
        public int width = 0;
        public int height = 0;
        private static final String __OBFID = "CL_00002538";

        private Viewport() {}

        Viewport(SwitchTexGen p_i46251_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class TextureState {
        public BooleanState texture2DState = new BooleanState(3553);
        public int textureName = 0;
        private static final String __OBFID = "CL_00002539";

        private TextureState() {}

        TextureState(SwitchTexGen p_i46252_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class TexGenState {
        public TexGenCoord field_179064_a = new TexGenCoord(8192, 3168);
        public TexGenCoord field_179062_b = new TexGenCoord(8193, 3169);
        public TexGenCoord field_179063_c = new TexGenCoord(8194, 3170);
        public TexGenCoord field_179061_d = new TexGenCoord(8195, 3171);
        private static final String __OBFID = "CL_00002540";

        private TexGenState() {}

        TexGenState(SwitchTexGen p_i46253_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class TexGenCoord {
        public BooleanState field_179067_a;
        public int field_179065_b;
        public int field_179066_c = -1;
        private static final String __OBFID = "CL_00002541";

        public TexGenCoord(int p_i46254_1_, int p_i46254_2_) {
            this.field_179065_b = p_i46254_1_;
            this.field_179067_a = new BooleanState(p_i46254_2_);
        }
    }

    @SideOnly(value = Side.CLIENT)
    public static enum TexGen {
        S,
        T,
        R,
        Q;

        private static final String __OBFID = "CL_00002542";
    }

    @SideOnly(value = Side.CLIENT)
    static final class SwitchTexGen {
        static final int[] field_179175_a = new int[TexGen.values().length];
        private static final String __OBFID = "CL_00002557";

        SwitchTexGen() {}

        static {
            try {
                SwitchTexGen.field_179175_a[TexGen.S.ordinal()] = 1;
            } catch (NoSuchFieldError var4) {
                // empty catch block
            }
            try {
                SwitchTexGen.field_179175_a[TexGen.T.ordinal()] = 2;
            } catch (NoSuchFieldError var3) {
                // empty catch block
            }
            try {
                SwitchTexGen.field_179175_a[TexGen.R.ordinal()] = 3;
            } catch (NoSuchFieldError var2) {
                // empty catch block
            }
            try {
                SwitchTexGen.field_179175_a[TexGen.Q.ordinal()] = 4;
            } catch (NoSuchFieldError var1) {
                // empty catch block
            }
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class StencilState {
        public StencilFunc field_179078_a = new StencilFunc(null);
        public int field_179076_b = -1;
        public int field_179077_c = 7680;
        public int field_179074_d = 7680;
        public int field_179075_e = 7680;
        private static final String __OBFID = "CL_00002543";

        private StencilState() {}

        StencilState(SwitchTexGen p_i46256_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class StencilFunc {
        public int field_179081_a = 519;
        public int field_179079_b = 0;
        public int field_179080_c = -1;
        private static final String __OBFID = "CL_00002544";

        private StencilFunc() {}

        StencilFunc(SwitchTexGen p_i46257_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class PolygonOffsetState {
        public BooleanState field_179044_a = new BooleanState(32823);
        public BooleanState field_179042_b = new BooleanState(10754);
        public float field_179043_c = 0.0f;
        public float field_179041_d = 0.0f;
        private static final String __OBFID = "CL_00002545";

        private PolygonOffsetState() {}

        PolygonOffsetState(SwitchTexGen p_i46258_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class FogState {
        public BooleanState field_179049_a = new BooleanState(2912);
        public int field_179047_b = 2048;
        public float field_179048_c = 1.0f;
        public float field_179045_d = 0.0f;
        public float field_179046_e = 1.0f;
        private static final String __OBFID = "CL_00002546";

        private FogState() {}

        FogState(SwitchTexGen p_i46259_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class DepthState {
        public BooleanState depthTest = new BooleanState(2929);
        public boolean maskEnabled = true;
        public int depthFunc = 513;
        private static final String __OBFID = "CL_00002547";

        private DepthState() {}

        DepthState(SwitchTexGen p_i46260_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class CullState {
        public BooleanState field_179054_a = new BooleanState(2884);
        public int field_179053_b = 1029;
        private static final String __OBFID = "CL_00002548";

        private CullState() {}

        CullState(SwitchTexGen p_i46261_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class ColorMaterialState {
        public BooleanState field_179191_a = new BooleanState(2903);
        public int field_179189_b = 1032;
        public int field_179190_c = 5634;
        private static final String __OBFID = "CL_00002549";

        private ColorMaterialState() {}

        ColorMaterialState(SwitchTexGen p_i46262_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class ColorMask {
        public boolean field_179188_a = true;
        public boolean field_179186_b = true;
        public boolean field_179187_c = true;
        public boolean field_179185_d = true;
        private static final String __OBFID = "CL_00002550";

        private ColorMask() {}

        ColorMask(SwitchTexGen p_i46263_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class ColorLogicState {
        public BooleanState field_179197_a = new BooleanState(3058);
        public int field_179196_b = 5379;
        private static final String __OBFID = "CL_00002551";

        private ColorLogicState() {}

        ColorLogicState(SwitchTexGen p_i46264_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class Color {
        public float red = 1.0f;
        public float green = 1.0f;
        public float blue = 1.0f;
        public float alpha = 1.0f;
        private static final String __OBFID = "CL_00002552";

        public Color() {}

        public Color(float p_i46265_1_, float p_i46265_2_, float p_i46265_3_, float p_i46265_4_) {
            this.red = p_i46265_1_;
            this.green = p_i46265_2_;
            this.blue = p_i46265_3_;
            this.alpha = p_i46265_4_;
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class ClearState {
        public double field_179205_a = 1.0;
        public Color field_179203_b = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        public int field_179204_c = 0;
        private static final String __OBFID = "CL_00002553";

        private ClearState() {}

        ClearState(SwitchTexGen p_i46266_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class BooleanState {
        private final int capability;
        private boolean currentState = false;
        private static final String __OBFID = "CL_00002554";

        public BooleanState(int p_i46267_1_) {
            this.capability = p_i46267_1_;
        }

        public void setDisabled() {
            this.setState(false);
        }

        public void setEnabled() {
            this.setState(true);
        }

        public void setState(boolean p_179199_1_) {
            if (p_179199_1_ != this.currentState) {
                this.currentState = p_179199_1_;
                if (p_179199_1_) {
                    GL11.glEnable((int) this.capability);
                } else {
                    GL11.glDisable((int) this.capability);
                }
            }
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class BlendState {
        public BooleanState field_179213_a = new BooleanState(3042);
        public int field_179211_b = 1;
        public int field_179212_c = 0;
        public int field_179209_d = 1;
        public int field_179210_e = 0;
        private static final String __OBFID = "CL_00002555";

        private BlendState() {}

        BlendState(SwitchTexGen p_i46268_1_) {
            this();
        }
    }

    @SideOnly(value = Side.CLIENT)
    static class AlphaState {
        public BooleanState field_179208_a = new BooleanState(3008);
        public int field_179206_b = 519;
        public float field_179207_c = -1.0f;
        private static final String __OBFID = "CL_00002556";

        private AlphaState() {}

        AlphaState(SwitchTexGen p_i46269_1_) {
            this();
        }
    }
}
