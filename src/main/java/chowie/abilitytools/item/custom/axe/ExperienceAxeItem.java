package chowie.abilitytools.item.custom.axe;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ExperienceAxeItem extends Item {

    public ExperienceAxeItem(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.experience_axe.tooltip"));
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity mob, LivingEntity attacker) {

        attacker.level().addFreshEntity(new ExperienceOrb(attacker.level(), mob.getX(), mob.getY(), mob.getZ(),
                (int) (Math.random() * 10)));

        attacker.level().playSound(null, attacker.getOnPos(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS,
                1.0f, 2.0f);

        super.hurtEnemy(itemStack, mob, attacker);
    }
}
