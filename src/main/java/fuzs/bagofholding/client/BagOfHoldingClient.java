package fuzs.bagofholding.client;

import fuzs.bagofholding.api.client.ContainerScreenEvents;
import fuzs.bagofholding.client.gui.screens.inventory.BagItemScreen;
import fuzs.bagofholding.client.gui.screens.inventory.tooltip.ClientContainerItemTooltip;
import fuzs.bagofholding.client.handler.SlotOverlayHandler;
import fuzs.bagofholding.registry.ModRegistry;
import fuzs.bagofholding.world.inventory.tooltip.ContainerItemTooltip;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public class BagOfHoldingClient implements ClientModInitializer {
    public static void onConstructMod() {
        registerHandlers();
    }

    private static void registerHandlers() {
        SlotOverlayHandler slotOverlayHandler = new SlotOverlayHandler();
        ContainerScreenEvents.DRAW_FOREGROUND.register(slotOverlayHandler::onDrawForeground);
    }

    public static void onClientSetup() {
        TooltipComponentCallback.EVENT.register((TooltipComponent data) -> {
            if (data.getClass() == ContainerItemTooltip.class) return new ClientContainerItemTooltip((ContainerItemTooltip) data);
            return null;
        });
        ScreenRegistry.register(ModRegistry.LEATHER_BAG_OF_HOLDING_MENU_TYPE, BagItemScreen::new);
        ScreenRegistry.register(ModRegistry.IRON_BAG_OF_HOLDING_MENU_TYPE, BagItemScreen::new);
        ScreenRegistry.register(ModRegistry.GOLDEN_BAG_OF_HOLDING_MENU_TYPE, BagItemScreen::new);
    }

    @Override
    public void onInitializeClient() {
        onConstructMod();
        onClientSetup();
    }
}
