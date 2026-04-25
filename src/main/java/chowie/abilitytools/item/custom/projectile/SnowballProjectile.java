package chowie.abilitytools.item.custom.projectile;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class SnowballProjectile extends Snowball {
    public SnowballProjectile(Level level, double x, double y, double z, ItemStack itemStack) {
        super(level, x, y, z, itemStack);
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        Entity entity = hitResult.getEntity();
        int damage = 5;
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), damage);
        if (entity instanceof LivingEntity entity1) {
            entity1.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 1, 1));
        }
    }
}
