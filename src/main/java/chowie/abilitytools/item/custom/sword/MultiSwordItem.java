package chowie.abilitytools.item.custom.sword;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.function.Consumer;

public class MultiSwordItem extends Item {

    public MultiSwordItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.multi_sword.tooltip"));
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        List<Entity> entitiesToDamage = attacker.level().getEntities(attacker, AABB.ofSize(mob.position(), 5, 5, 5));

        for (int i = 0; i < 2 && !entitiesToDamage.isEmpty();) {
            if (entitiesToDamage.getFirst() instanceof LivingEntity entity) {
                entity.hurtServer((ServerLevel) attacker.level(), mob.damageSources().generic(), 3.0F);
                i++;
            }

            entitiesToDamage.removeFirst();
        }

        attacker.level().playSound(null, attacker.getOnPos(), SoundEvents.WOLF_ARMOR_DAMAGE, SoundSource.PLAYERS,
                0.4f, 0.74f);

        super.hurtEnemy(itemStack, mob, attacker);
    }
}
