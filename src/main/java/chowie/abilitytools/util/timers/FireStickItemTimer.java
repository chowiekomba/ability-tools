package chowie.abilitytools.util.timers;

import chowie.abilitytools.AbilityTools;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FireStickItemTimer implements ServerTickEvents.EndTick {
    public static FireStickItemTimer INSTANCE = new FireStickItemTimer();
    private final Map<ServerPlayer, Tuple<Long, Vec3>> playerMap = new HashMap<>();

    private final double radius = 5;
    private final double times = 100;



    public void setTimer(ServerPlayer player, long ticksUntilFrozen) {
        playerMap.put(player, new Tuple<>(ticksUntilFrozen, player.position()));
    }

    @Override
    public void onEndTick(MinecraftServer server) {
        for (ServerPlayer player : playerMap.keySet()) {
            long l = playerMap.get(player).getA();
            playerMap.put(player, new Tuple<>(playerMap.get(player).getA() - 1, playerMap.get(player).getB()));
            Vec3 posOfParticle = playerMap.get(player).getB();
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
                List<Entity> list = player.level().getEntities(player, AABB.ofSize(playerMap.get(player).getB(),
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
        AbilityTools.LOGGER.info("Registering FireStickItem for " + AbilityTools.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
