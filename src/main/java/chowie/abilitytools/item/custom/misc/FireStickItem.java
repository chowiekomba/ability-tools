package chowie.abilitytools.item.custom.misc;

import chowie.abilitytools.util.timers.FireStickItemTimer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

public class FireStickItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(30.0F);

    public FireStickItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.fire_stick.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.fire_stick.tooltip2"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        if (player instanceof ServerPlayer serverPlayer) {
            FireStickItemTimer.INSTANCE.setTimer(serverPlayer, 5 * 20);
        }

        cooldown.apply(player.getItemInHand(hand), player);

        level.playSound(null, player.getOnPos(), SoundEvents.FIREWORK_ROCKET_BLAST_FAR, SoundSource.PLAYERS);

        player.swing(hand);

        return super.use(level, player, hand);
    }


}
