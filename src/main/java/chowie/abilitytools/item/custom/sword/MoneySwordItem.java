package chowie.abilitytools.item.custom.sword;

import chowie.abilitytools.util.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class MoneySwordItem extends Item {

    public MoneySwordItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.money_sword.tooltip"));
    }

    @Override
    public float getAttackDamageBonus(Entity victim, float damage, DamageSource damageSource) {
        if (damageSource.getDirectEntity() instanceof Player player) {
            return player.experienceLevel * 0.25f;
        }

        return super.getAttackDamageBonus(victim, damage, damageSource);
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {
        attacker.level().playSound(null, mob.getOnPos(), ModSounds.CHACHING, SoundSource.PLAYERS);
        super.hurtEnemy(itemStack, mob, attacker);
    }
}
