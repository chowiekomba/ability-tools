package chowie.abilitytools.mixin;

import chowie.abilitytools.item.ModItems;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

import static chowie.abilitytools.util.MixinUtil.hasFullSetOfArmor;

@Mixin(ServerPlayerGameMode.class)
public abstract class ServerPlayerGameModeMixin {

    @Shadow
    protected ServerLevel level;

    @Final
    @Shadow
    protected ServerPlayer player;

    @Inject(method = "destroyBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/Block;playerDestroy(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/item/ItemStack;)V"))
    private void applyFortune(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (hasFullSetOfArmor(player, ModItems.FORTUNE_HELMET, ModItems.FORTUNE_CHESTPLATE, ModItems.FORTUNE_LEGGINGS,
                ModItems.FORTUNE_BOOTS) && level.getBlockState(pos).is(ConventionalBlockTags.ORES)) {
            List<ItemStack> lootTable = Block.getDrops(level.getBlockState(pos), level, pos, null);
            lootTable.forEach(j -> {
                j.setCount(2);
                level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), j));
            });
        }
    }
}
