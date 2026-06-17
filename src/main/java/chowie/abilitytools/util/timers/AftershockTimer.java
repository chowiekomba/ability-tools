package chowie.abilitytools.util.timers;

import chowie.abilitytools.AbilityTools;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import org.jspecify.annotations.NonNull;

import java.util.HashMap;
import java.util.Map;

public class AftershockTimer implements ServerTickEvents.EndTick {
    public static AftershockTimer INSTANCE = new AftershockTimer();
    private final Map<LivingEntity, Long> entityMap = new HashMap<>();

    public void setTimer(LivingEntity livingEntity, long ticksUntilFrozen) {
        entityMap.put(livingEntity, ticksUntilFrozen);
    }

    @Override
    public void onEndTick(@NonNull MinecraftServer server) {
        for (LivingEntity entity : entityMap.keySet()) {
            entityMap.compute(entity, (_, l) -> l - 1);
        }
        for (LivingEntity entity : entityMap.keySet()) {
            long l = entityMap.get(entity);

            if (l % 20 == 0 && l != 0) {
                if (entity.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SCULK_SOUL, false, true, entity.getX(),
                            entity.getY() + 1, entity.getZ(), 5, 0, 0, 0, 0);
                }
            }

            if (l <= 0) {
                if (entity.level() instanceof ServerLevel serverLevel) {
                    entity.hurtServer(serverLevel, entity.damageSources().generic(), 4);
                }
            }
        }
        entityMap.keySet().removeIf(i -> entityMap.get(i) <= 0);
    }

    public static void register() {
        AbilityTools.LOGGER.info("Registering AftershockTimer for " + AbilityTools.MOD_ID);
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
