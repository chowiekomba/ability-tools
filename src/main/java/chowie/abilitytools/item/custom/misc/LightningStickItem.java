package chowie.abilitytools.item.custom.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class LightningStickItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(5.0F);
    double radius = 10;
    double lightningStrikes = 8;

    public LightningStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.lightning_stick.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.lightning_stick.tooltip2"));
        builder.accept(Component.translatable("item.ability-tools.lightning_stick.tooltip3"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        BlockPos centerPos = player.blockPosition();

        if (level.isClientSide()) {
            return super.use(level, player, hand);
        }

        for (int i = 0; i < lightningStrikes; i++) {
            double angle = (i / lightningStrikes) * 2 * Math.PI;
            double xOffset = Math.cos(angle) * radius;
            double zOffset = Math.sin(angle) * radius;

            BlockPos posOfLightning = centerPos.offset((int) xOffset, 0, (int) zOffset);

            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            lightningBolt.setPos(posOfLightning.getCenter());
            level.addFreshEntity(lightningBolt);
            level.playSound(null, posOfLightning, SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS);
        }

        player.swing(hand);

        cooldown.apply(player.getItemInHand(hand), player);

        return super.use(level, player, hand);
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        if (attacker.level().isClientSide()) {
            super.hurtEnemy(itemStack, mob, attacker);
            return;
        }

        LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, attacker.level());
        lightningBolt.setPos(mob.blockPosition().getCenter());
        attacker.level().addFreshEntity(lightningBolt);
        attacker.level().playSound(null, mob.getOnPos(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.PLAYERS);

        super.hurtEnemy(itemStack, mob, attacker);
    }
}
