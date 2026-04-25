package chowie.abilitytools.item.custom.sword;

import chowie.abilitytools.util.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
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


public class GroupHealSwordItem extends Item {
    private final UseCooldown cooldown = new UseCooldown(10.0F);

    public GroupHealSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.group_heal_sword.tooltip"));
        builder.accept(Component.translatable("item.ability-tools.group_heal_sword.tooltip2"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {

        List<Entity> entitiesToHeal = level.getEntities(null, AABB.ofSize(Vec3.atLowerCornerOf(player.getOnPos()), 5.0, 5.0, 5.0));

        for (Entity entity : entitiesToHeal) {
            if (entity instanceof Player player1) {
                player1.heal(6.0f);
            }
        }

        level.playSound(null, player.getOnPos(), ModSounds.HEAL, SoundSource.PLAYERS);

        cooldown.apply(player.getItemInHand(hand), player);

        player.swing(hand);

        return super.use(level, player, hand);
    }
}
