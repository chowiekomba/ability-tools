package chowie.abilitytools.item.custom.projectile;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.Nullable;

public class EndArrow extends Arrow {
    LivingEntity entityOwner;

    public EndArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(level, owner, pickupItemStack, firedFromWeapon);
        this.entityOwner = owner;
    }

    @Override
    protected void onHit(HitResult hitResult) {
        if (entityOwner instanceof ServerPlayer serverPlayer) {
            serverPlayer.teleportTo(this.getX(), this.getY(), this.getZ());
        }

        super.onHit(hitResult);
    }
}
