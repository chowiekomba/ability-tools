package chowie.abilitytools.item.custom.pickaxe;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class ExperiencePickaxeItem extends Item {
    public ExperiencePickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity owner) {

        if (state.getBlock() instanceof DropExperienceBlock && ThreadLocalRandom.current().nextInt(1, 5 + 1) == 1) {
            level.addFreshEntity(new ExperienceOrb(level, pos.getX(), pos.getY(), pos.getZ(), 10));
        }

        return super.mineBlock(itemStack, level, state, pos, owner);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.experience_pickaxe.tooltip"));
    }
}
