package fuzs.bagofholding.handler;

import fuzs.bagofholding.registry.ModRegistry;
import net.minecraft.server.level.ServerPlayer;

public class PlayerRespawnHandler {
    public void onPlayerClone(ServerPlayer oldPlayer, ServerPlayer newPlayer, boolean alive) {
        if (alive) return;
        ModRegistry.BAG_PERSEVERANCE_CAPABILITY.maybeGet(oldPlayer).ifPresent(capability -> {
            capability.restoreAfterRespawn(newPlayer);
        });
    }
}
