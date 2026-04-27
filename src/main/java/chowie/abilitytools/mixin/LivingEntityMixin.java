package chowie.abilitytools.mixin;

import chowie.abilitytools.AbilityTools;
import chowie.abilitytools.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static chowie.abilitytools.util.MixinUtil.hasFullSetOfArmor;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

	@Inject(at = @At("HEAD"), method = "detectEquipmentUpdates")
	private void applyArmorBuffs(CallbackInfo ci) {
		LivingEntity livingEntity = (LivingEntity) (Object) this;
		AttributeInstance movementSpeed = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);
		AttributeInstance blockBreakSpeed = livingEntity.getAttribute(Attributes.BLOCK_BREAK_SPEED);

		if (hasFullSetOfArmor(livingEntity, ModItems.SPEEDY_HELMET, ModItems.SPEEDY_CHESTPLATE, ModItems.SPEEDY_LEGGINGS,
				ModItems.SPEEDY_BOOTS)) {
			if (movementSpeed != null && !movementSpeed.hasModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_movement_speed"))) {
				movementSpeed.addPermanentModifier(new AttributeModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_movement_speed"),
						0.1, AttributeModifier.Operation.ADD_VALUE));
				if (livingEntity instanceof ServerPlayer serverPlayer) {
					serverPlayer.sendSystemMessage(Component.translatable("item.ability-tools.speedy_armor.notification"));
				}
			}
		} else if (movementSpeed != null && movementSpeed.hasModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_movement_speed"))) {
			movementSpeed.removeModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_movement_speed"));
		}

		if (hasFullSetOfArmor(livingEntity, ModItems.MINER_HELMET, ModItems.MINER_CHESTPLATE, ModItems.MINER_LEGGINGS,
				ModItems.MINER_BOOTS)) {
			if (blockBreakSpeed != null && !blockBreakSpeed.hasModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_block_break_speed"))) {
				blockBreakSpeed.addPermanentModifier(new AttributeModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_block_break_speed"),
						3, AttributeModifier.Operation.ADD_VALUE));
				if (livingEntity instanceof ServerPlayer serverPlayer) {
					serverPlayer.sendSystemMessage(Component.translatable("item.ability-tools.miner_armor.notification"));
				}
			}
		} else if (blockBreakSpeed != null && blockBreakSpeed.hasModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_block_break_speed"))) {
			blockBreakSpeed.removeModifier(Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "armor_block_break_speed"));
		}

		if (hasFullSetOfArmor(livingEntity, ModItems.FORTUNE_HELMET, ModItems.FORTUNE_CHESTPLATE, ModItems.FORTUNE_LEGGINGS,
				ModItems.FORTUNE_BOOTS) && livingEntity instanceof ServerPlayer serverPlayer) {
			serverPlayer.sendSystemMessage(Component.translatable("item.ability-tools.speedy_armor.notification"));
		}
	}
}