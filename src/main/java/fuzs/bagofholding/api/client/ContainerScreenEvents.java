package fuzs.bagofholding.api.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public final class ContainerScreenEvents {
    public static final Event<DrawForeground> DRAW_FOREGROUND = EventFactory.createArrayBacked(DrawForeground.class, callbacks -> (AbstractContainerScreen<?> screen, PoseStack poseStack, int mouseX, int mouseY) -> {
        for (DrawForeground callback : callbacks) {
            callback.onDrawForeground(screen, poseStack, mouseX, mouseY);
        }
    });

    /**
     * called after foreground elements have been drawn, but before the dragged stack and any tooltips are
     */
    @FunctionalInterface
    public interface DrawForeground {
        void onDrawForeground(AbstractContainerScreen<?> screen, PoseStack poseStack, int mouseX, int mouseY);
    }
}
