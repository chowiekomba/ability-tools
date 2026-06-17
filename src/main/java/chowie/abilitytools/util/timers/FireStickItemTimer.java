package chowie.abilitytools.util.timers;

import chowie.abilitytools.AbilityTools;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FireStickItemTimer implements ServerTickEvents.EndTick {
    public static FireStickItemTimer INSTANCE = new FireStickItemTimer();
    private final Map<ServerPlayer, Pair<Long, Vec3>> playerMap = new HashMap<>();

    public void setTimer(ServerPlayer player, long ticksUntilFrozen) {
        playerMap.put(player, new Pair<>(ticksUntilFrozen, player.position()));
    }

    @Override
    public void onEndTick(@NonNull MinecraftServer server) {
        final double radius = 5;
        final double times = 100;
        for (ServerPlayer player : playerMap.keySet()) {
            long l = playerMap.get(player).getFirst();
            playerMap.put(player, new Pair<>(playerMap.get(player).getFirst() - 1, playerMap.get(player).getSecond()));
            Vec3 posOfParticle = playerMap.get(player).getSecond();
            if (player.level() instanceof ServerLevel serverLevel) {
                for (int i = (int) times; i > 0; i--) {
                    double angle = (i / times) * 2 * Math.PI;
                    double xOffset = Math.cos(angle) * radius;
                    double zOffset = Math.sin(angle) * radius;
                    serverLevel.sendParticles(ParticleTypes.SCULK_SOUL, false, true, posOfParticle.x() + xOffset, posOfParticle.y(),
                            posOfParticle.z() + zOffset, 1, 0, 0, 0, 0);
                }
            }

            if (l % 20 == 0 && l != 0) {
                List<Entity> list = player.level().getEntities(player, AABB.ofSize(playerMap.get(player).getSecond(),
                        10, 10, 10));

                list.forEach(i -> {
                    if (i instanceof LivingEntity entity) {
                        if (entity.level() instanceof ServerLevel serverLevel) {
                            entity.hurtServer(serverLevel, entity.damageSources().generic(), 2.0f);
                        }
                    }
                });
            }

            if (l == 0L) {
                playerMap.remove(player);
            }
        }
    }

    public static void register() {
        AbilityTools.LOGGER.info("Registering FireStickItemTimer for " + AbilityTools.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
