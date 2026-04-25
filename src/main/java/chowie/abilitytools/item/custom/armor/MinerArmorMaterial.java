package chowie.abilitytools.item.custom.armor;

import chowie.abilitytools.AbilityTools;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class MinerArmorMaterial {
    public static final int BASE_DURABILITY = 30;

    public static final ResourceKey<EquipmentAsset> MINER_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID,
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "miner"));

    public static final TagKey<Item> REPAIRS_MINER_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(),
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "repairs_miner_armor"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 3,
                    ArmorType.CHESTPLATE, 7,
                    ArmorType.LEGGINGS, 6,
                    ArmorType.BOOTS, 3
            ),
            8,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            1.0f,
            0.0f,
            REPAIRS_MINER_ARMOR,
            MINER_ARMOR_MATERIAL_KEY
    );
}
