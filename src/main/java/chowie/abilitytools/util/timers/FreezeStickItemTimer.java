package chowie.abilitytools.util.timers;

import chowie.abilitytools.AbilityTools;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreezeStickItemTimer implements ServerTickEvents.EndTick {
    public static FreezeStickItemTimer INSTANCE = new FreezeStickItemTimer();
    private final Map<ServerPlayer, Pair<Long, Vec3>> playerMap = new HashMap<>();

    public void setTimer(ServerPlayer player, long ticksUntilFrozen) {
        playerMap.put(player, new Pair<>(ticksUntilFrozen, player.position()));
    }

    @Override
    public void onEndTick(@NonNull MinecraftServer server) {
        final double radius = 3;
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
                    serverLevel.sendParticles(ParticleTypes.END_ROD, false, true, posOfParticle.x() + xOffset, posOfParticle.y(),
                            posOfParticle.z() + zOffset, 1, 0, 0, 0, 0);
                }
            }

            if (l == 0L) {

                List<Entity> list = player.level().getEntities(player, AABB.ofSize(playerMap.get(player).getSecond(),
                        6, 6, 6));

                list.forEach(entity -> {
                    if (entity instanceof LivingEntity entity1) {
                        entity1.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 10 * 20, 255));
                        entity1.level().playSound(null, entity1.getOnPos(), SoundEvents.SLIME_ATTACK, SoundSource.PLAYERS);
                    }
                });

                playerMap.remove(player);
            }
        }
    }

    public static void register() {
        AbilityTools.LOGGER.info("Registering FreezeStickItemTimer for " + AbilityTools.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
