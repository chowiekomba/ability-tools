package chowie.abilitytools.item.custom.sword;

import chowie.abilitytools.util.ModDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class RoidRageSwordItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(25.0F);

    public RoidRageSwordItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.roid_rage_sword.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.roid_rage_sword.tooltip2"));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.getItemInHand(hand).set(ModDataComponents.ROID_RAGE_USED_LAST, level.getGameTime() + (5 * 20));
        level.playSound(null, player.getOnPos(), SoundEvents.PIGLIN_ANGRY, SoundSource.PLAYERS, 1.0f, 0.5f);
        cooldown.apply(player.getItemInHand(hand), player);
        player.swing(hand);
        return super.use(level, player, hand);
    }

    @Override
    public float getAttackDamageBonus(Entity victim, float damage, DamageSource damageSource) {
        if (damageSource.getDirectEntity() instanceof Player player) {
            ItemStack stack = player.getMainHandItem();
            Long usedLast = stack.get(ModDataComponents.ROID_RAGE_USED_LAST);

            if (usedLast != null && player.level().getGameTime() < usedLast) {
                victim.level().playSound(null, victim.getOnPos(), SoundEvents.ANVIL_HIT, SoundSource.HOSTILE, 1.0f, 0.5f);
                return 25.0F;
            }
        }

        return super.getAttackDamageBonus(victim, damage, damageSource);
    }
}
