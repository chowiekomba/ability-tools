package chowie.abilitytools.util.timers;

import chowie.abilitytools.AbilityTools;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Tuple;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreezeStickItemTimer implements ServerTickEvents.EndTick {
    public static FreezeStickItemTimer INSTANCE = new FreezeStickItemTimer();
    private final Map<ServerPlayer, Tuple<Long, Vec3>> playerMap = new HashMap<>();

    private final double radius = 3;
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
                    serverLevel.sendParticles(ParticleTypes.END_ROD, false, true, posOfParticle.x() + xOffset, posOfParticle.y(),
                            posOfParticle.z() + zOffset, 1, 0, 0, 0, 0);
                }
            }

            if (l == 0L) {

                List<Entity> list = player.level().getEntities(player, AABB.ofSize(playerMap.get(player).getB(),
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
        AbilityTools.LOGGER.info("Registering FreezeStickItem for " + AbilityTools.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
