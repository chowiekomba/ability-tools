package chowie.abilitytools.item.custom.pickaxe;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.function.Consumer;

public class SoulPickaxeItem extends Item {
    public SoulPickaxeItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos pos, LivingEntity owner) {
        if (level instanceof ServerLevel serverLevel) {
            if (state.is(ConventionalBlockTags.ORES)) {
                List<Entity> entityList = level.getEntities(owner, AABB.ofSize(owner.getOnPos().getCenter(), 50, 50, 50));

                entityList.forEach(i -> {
                    if (!(i instanceof LivingEntity)) {
                        entityList.remove(i);
                    }
                });

                int bonus = entityList.size() / 2;
                List<ItemStack> lootTable = Block.getDrops(state, serverLevel, pos, null);
                    lootTable.forEach(j -> {
                        j.setCount(bonus);
                        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), j));
                    });
            }
        }


        return super.mineBlock(itemStack, level, state, pos, owner);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.soul_pickaxe.tooltip"));
    }
}
