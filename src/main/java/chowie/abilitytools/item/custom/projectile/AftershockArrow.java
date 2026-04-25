package chowie.abilitytools.item.custom.projectile;

import chowie.abilitytools.util.timers.AftershockTimer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jspecify.annotations.Nullable;

public class AftershockArrow extends Arrow {
    LivingEntity entityOwner;

    public AftershockArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(level, owner, pickupItemStack, firedFromWeapon);
        this.entityOwner = owner;
    }

    @Override
    protected void onHit(HitResult hitResult) {

        if (hitResult.getType() == HitResult.Type.ENTITY) {
            EntityHitResult entityHitResult = (EntityHitResult)hitResult;
            Entity entityHit = entityHitResult.getEntity();

            if (entityHit instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, (4 * 20)));
                AftershockTimer.INSTANCE.setTimer(livingEntity, (4 * 20));
            }
        }

        super.onHit(hitResult);
    }
}
