package codes.jonzay.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.client.gui.DrawContext;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(at = @At("TAIL"), method = "render")
	private void onRender(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.getSession() != null) {
            String username = client.getSession().getUsername();
			String prefixText = "Logged in as: ";
			String fullText = prefixText + username;
			int fullTextWidth = client.textRenderer.getWidth(fullText);
            int x = (context.getScaledWindowWidth() - fullTextWidth) / 2;
            int y = 10;
            context.drawTextWithShadow(client.textRenderer, Text.literal(prefixText).append(Text.literal(username).formatted(Formatting.GREEN)), x, y, 0xFFFFFF);
        } else {
			String displayedText = "No valid user session detected";
			int fullTextWidth = client.textRenderer.getWidth(displayedText);
            int x = (context.getScaledWindowWidth() - fullTextWidth) / 2;
            int y = 10;
            context.drawTextWithShadow(client.textRenderer, Text.of(displayedText), x, y, 0xFFFFFF);
		}
    }
}