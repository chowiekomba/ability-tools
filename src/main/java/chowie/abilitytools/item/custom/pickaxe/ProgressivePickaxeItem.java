package chowie.abilitytools.item.custom.pickaxe;

import chowie.abilitytools.util.ModDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ProgressivePickaxeItem extends Item {
    public ProgressivePickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity owner) {

        if (!itemStack.has(ModDataComponents.BLOCKS_MINED)) {
            itemStack.set(ModDataComponents.BLOCKS_MINED, 1);
        } else {
            itemStack.set(ModDataComponents.BLOCKS_MINED, itemStack.get(ModDataComponents.BLOCKS_MINED) + 1);
        }
        int blocksMined = itemStack.get(ModDataComponents.BLOCKS_MINED);
        if (blocksMined % 100 == 0) {
            float multiplier = blocksMined / 100f;
            Tool currentTool = itemStack.get(DataComponents.TOOL);

            List<Tool.Rule> newRules = currentTool.rules().stream()
                    .map(rule -> rule.speed().isPresent() ?
                            new Tool.Rule(rule.blocks(), Optional.of(rule.speed().get() + multiplier), rule.correctForDrops())
                            : rule)
                    .toList();

            Tool newTool = new Tool(newRules, currentTool.defaultMiningSpeed(), currentTool.damagePerBlock(), currentTool.canDestroyBlocksInCreative());
            itemStack.set(DataComponents.TOOL, newTool);
        }


        return super.mineBlock(itemStack, level, state, pos, owner);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if (!itemStack.has(ModDataComponents.BLOCKS_MINED)) {
            itemStack.set(ModDataComponents.BLOCKS_MINED, 0);
        }
        builder.accept(Component.literal("Blocks mined: §6" + itemStack.get(ModDataComponents.BLOCKS_MINED) + "§r"));
        builder.accept(Component.translatable("item.ability-tools.progressive_pickaxe.tooltip"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
