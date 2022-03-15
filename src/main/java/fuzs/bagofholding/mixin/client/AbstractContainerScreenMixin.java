package fuzs.bagofholding.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.bagofholding.api.client.ContainerScreenEvents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin<T extends AbstractContainerMenu> extends Screen {
    protected AbstractContainerScreenMixin(Component component) {
        super(component);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderLabels(Lcom/mojang/blaze3d/vertex/PoseStack;II)V", shift = At.Shift.AFTER))
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks, CallbackInfo callbackInfo) {
        ContainerScreenEvents.DRAW_FOREGROUND.invoker().onDrawForeground((AbstractContainerScreen<?>) (Object) this, poseStack, mouseX, mouseY);
    }
}
