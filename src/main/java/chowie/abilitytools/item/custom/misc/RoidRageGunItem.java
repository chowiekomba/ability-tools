package chowie.abilitytools.item.custom.misc;

import chowie.abilitytools.util.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.hurtingprojectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.component.UseCooldown;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class RoidRageGunItem extends ProjectileWeaponItem {
    private final UseCooldown cooldown = new UseCooldown(0.1F);
    float knockbackAmount = 0.2f;

    public RoidRageGunItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NonNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return itemStack -> itemStack.is(ItemTags.CREEPER_DROP_MUSIC_DISCS);
    }

    @Override
    public int getDefaultProjectileRange() {
        return 0;
    }

    @Override
    public void appendHoverText(@NonNull ItemStack itemStack, @NonNull TooltipContext context, @NonNull TooltipDisplay display,
                                Consumer<Component> builder, @NonNull TooltipFlag tooltipFlag) {
        builder.accept(Component.translatable("item.ability-tools.roid_rage_gun.tooltip"));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    @Override
    protected void shootProjectile(@NonNull LivingEntity shooter, Projectile projectileEntity, int index, float power,
                                   float uncertainty, float angle, @Nullable LivingEntity targetOverride) {
        projectileEntity.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, power, uncertainty);
        shooter.level().addFreshEntity(projectileEntity);
    }

    @Override
    public @NonNull InteractionResult use(@NonNull Level level, Player player, @NonNull InteractionHand hand) {
        double x = player.getX() + player.getLookAngle().x;
        double z = player.getZ() + player.getLookAngle().z;

        shootProjectile(player, new SmallFireball(level, x, player.getY() + 1, z, player.getHeadLookAngle()), 0, 4, 1,
                (float) player.getLookAngle().y(), null);

        player.push(
                Mth.sin(player.getYRot() * (float) (Math.PI / 180.0)) * knockbackAmount, 0.1, -Mth.cos(player.getYRot() * (float) (Math.PI / 180.0)) * knockbackAmount
        );

        level.playSound(null, player.getOnPos(), ModSounds.GUNSHOT, SoundSource.PLAYERS);

        cooldown.apply(player.getItemInHand(hand), player);

        return super.use(level, player, hand);
    }
}