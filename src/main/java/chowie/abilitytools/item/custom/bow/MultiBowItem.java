package chowie.abilitytools.item.custom.bow;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class MultiBowItem extends BowItem {
    public MultiBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.multi_bow.tooltip"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public boolean releaseUsing(final ItemStack itemStack, final Level level, final LivingEntity entity, final int remainingTime) {
        if (!(entity instanceof Player player)) {
            return false;
        } else {
            for (int i = 0; i < 4; i++) {
                ItemStack projectile = player.getProjectile(itemStack);
                if (projectile.count() < 3 && !player.hasInfiniteMaterials()) {
                    return false;
                } else {
                    int timeHeld = this.getUseDuration(itemStack, entity) - remainingTime;
                    float pow = getPowerForTime(timeHeld);
                    if (pow < 0.1) {
                        return false;
                    } else {
                        List<ItemStack> firedProjectiles = draw(itemStack, projectile, player);
                        if (level instanceof ServerLevel serverLevel && !firedProjectiles.isEmpty()) {
                            this.shoot(serverLevel, player, player.getUsedItemHand(), itemStack, firedProjectiles, pow * 3.0F, 5.0F, pow == 1.0F, null);
                        }

                        level.playSound(
                                null,
                                player.getX(),
                                player.getY(),
                                player.getZ(),
                                SoundEvents.ARROW_SHOOT,
                                SoundSource.PLAYERS,
                                1.0F,
                                1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + pow * 0.5F
                        );
                        player.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        boolean foundProjectile = !player.getProjectile(itemStack).isEmpty();
        if (!player.hasInfiniteMaterials() && !foundProjectile) {
            return InteractionResult.FAIL;
        } else if (!player.hasInfiniteMaterials() && player.getProjectile(itemStack).count() < 3) {
            return  InteractionResult.FAIL;
        }
        player.startUsingItem(hand);
        return InteractionResult.CONSUME;
    }
}
