package chowie.abilitytools.item.custom.projectile;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.Nullable;

public class TntArrow extends Arrow {
    LivingEntity entityOwner;

    public TntArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(level, owner, pickupItemStack, firedFromWeapon);
        this.entityOwner = owner;
    }

    @Override
    protected void onHit(HitResult hitResult) {

        this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1f, Level.ExplosionInteraction.MOB);

        super.onHit(hitResult);
    }
}
