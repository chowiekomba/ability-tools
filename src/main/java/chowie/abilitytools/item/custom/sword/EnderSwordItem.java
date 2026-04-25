package chowie.abilitytools.item.custom.sword;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
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

public class EnderSwordItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(5.0F);
    float knockbackAmount = 1.5f;

    public EnderSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.ender_sword.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.ender_sword.tooltip2"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        float rotation = (float) player.getHeadLookAngle().y();

        if (rotation < 0.1f && !level.isEmptyBlock(new BlockPos((int) player.getX(),(int) player.getY() - 1,(int) player.getZ()))) {
            rotation = 0.1f;
        }

        player.push(
                -Mth.sin(player.getYRot() * (float) (Math.PI / 180.0)) * knockbackAmount, rotation, Mth.cos(player.getYRot() * (float) (Math.PI / 180.0)) * knockbackAmount
        );

        player.addEffect(new MobEffectInstance(MobEffects.SPEED, (3 * 20),2,true,false, false));

        cooldown.apply(player.getItemInHand(hand), player);

        player.swing(hand);

        return super.use(level, player, hand);
    }
}
