package chowie.abilitytools.item.custom.sword;

import chowie.abilitytools.util.ModSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class GroundSlamDaggerItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(45.0F);

    public GroundSlamDaggerItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.punch_sword.tooltip"));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Vec3 clickedBlockPos = context.getClickLocation();
        Player player = context.getPlayer();
        AABB aabb = AABB.ofSize(clickedBlockPos, 10.0, 10.0, 10.0);
        List<Entity> list = context.getLevel().getEntities(player, aabb);

        for (int i = 0; i < 50; i++) {
            context.getLevel().addParticle(ParticleTypes.CRIT, clickedBlockPos.x(), clickedBlockPos.y(), clickedBlockPos.z(),
                    ThreadLocalRandom.current().nextDouble(-1.0, 1.0),
                    ThreadLocalRandom.current().nextDouble(-1.0, 1.0),
                    ThreadLocalRandom.current().nextDouble(-1.0, 1.0));
        }

        for (Entity entity : list) {
            if (entity instanceof LivingEntity livingEntity) {
                if (context.getLevel() instanceof ServerLevel serverLevel) {
                    livingEntity.hurtServer(serverLevel, livingEntity.damageSources().generic(), (float) (livingEntity.getHealth() / 1.5));
                }
            }
        }

        context.getLevel().playSound(null, context.getPlayer().getOnPos(), ModSounds.GROUND_IMPACT, SoundSource.PLAYERS);

        player.swing(context.getHand());
        cooldown.apply(context.getItemInHand(), context.getPlayer());
        return super.useOn(context);
    }
}
