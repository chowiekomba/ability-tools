package chowie.abilitytools.util;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

public class MixinUtil {

    public static boolean hasFullSetOfArmor(LivingEntity entity, Item head, Item chest, Item legs, Item feet) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).is(head) &&
                entity.getItemBySlot(EquipmentSlot.CHEST).is(chest) &&
                entity.getItemBySlot(EquipmentSlot.LEGS).is(legs) &&
                entity.getItemBySlot(EquipmentSlot.FEET).is(feet);
    }
}
