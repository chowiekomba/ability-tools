package chowie.abilitytools.item.custom.sword;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class SpeedySwordItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(29.0F);

    public SpeedySwordItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.speedy_sword.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.speedy_sword.tooltip2"));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        player.swing(hand);
        player.addEffect(new MobEffectInstance(MobEffects.SPEED, (25 * 20),4,true,false, false));
        level.playSound(null, new BlockPos((int) player.getX(),(int) player.getY(),(int) player.getZ()), SoundEvents.APPLY_EFFECT_BAD_OMEN, SoundSource.PLAYERS,
                1.0f, 4.0f);
        cooldown.apply(player.getItemInHand(hand), player);
        return super.use(level, player, hand);
    }
}
