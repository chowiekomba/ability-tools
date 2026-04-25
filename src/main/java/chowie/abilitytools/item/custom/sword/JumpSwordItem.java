package chowie.abilitytools.item.custom.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Consumer;

public class JumpSwordItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(29.0F);

    public JumpSwordItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.jump_sword.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.jump_sword.tooltip2"));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        List<Entity> entitiesToDamage = level.getEntities(player, AABB.ofSize(player.position(), 5, 5, 5));

        if (!level.isClientSide()) {
            entitiesToDamage.forEach(i -> {
                if (i instanceof LivingEntity entity) {
                    entity.hurtServer((ServerLevel) level, entity.damageSources().generic(), 4.0f);
                    entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 255));
                }
            });
        }

        player.push(0, 1.3, 0);

        player.setIgnoreFallDamageFromCurrentImpulse(true, new Vec3(player.getX(), player.getY() - 1000,
                player.getZ()));

        player.swing(hand);
        cooldown.apply(player.getItemInHand(hand), player);
        return super.use(level, player, hand);
    }
}
