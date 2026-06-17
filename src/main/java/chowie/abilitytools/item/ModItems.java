package chowie.abilitytools.item;

import chowie.abilitytools.AbilityTools;
import chowie.abilitytools.item.custom.armor.FortuneArmorMaterial;
import chowie.abilitytools.item.custom.armor.MinerArmorMaterial;
import chowie.abilitytools.item.custom.armor.SpeedyArmorMaterial;
import chowie.abilitytools.item.custom.bow.*;
import chowie.abilitytools.item.custom.axe.ExperienceAxeItem;
import chowie.abilitytools.item.custom.misc.*;
import chowie.abilitytools.item.custom.pickaxe.ExperiencePickaxeItem;
import chowie.abilitytools.item.custom.pickaxe.ProgressivePickaxeItem;
import chowie.abilitytools.item.custom.pickaxe.SoulPickaxeItem;
import chowie.abilitytools.item.custom.sword.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    public static final Item SPEEDY_SWORD = registerItem(ModItemIds.speedySword, SpeedySwordItem::new, new Item.Properties()
            .sword(ToolMaterial.GOLD, 3.0F, -2.4F));

    public static final Item MULTI_SWORD = registerItem(ModItemIds.multiSword, MultiSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.NETHERITE, 3.0F, -2.4F));

    public static final Item ROID_RAGE_SWORD = registerItem(ModItemIds.roidRageSword, RoidRageSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.WOOD, 0.0F, -2.4F));

    public static final Item EXPERIENCE_AXE = registerItem(ModItemIds.experienceAxe, ExperienceAxeItem::new, new Item.Properties()
            .axe(ToolMaterial.IRON, 5.0F, -3.0F));

    public static final Item GROUND_SLAM_DAGGER = registerItem(ModItemIds.groundSlamDagger, GroundSlamDaggerItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 2.0F, -2.0F));

    public static final Item ROID_RAGE_GUN = registerItem(ModItemIds.roidRageGun, RoidRageGunItem::new, new Item.Properties());

    public static final Item ENDER_SWORD = registerItem(ModItemIds.enderSword, EnderSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 3.0F, -2.4F));

    public static final Item HEAL_SWORD = registerItem(ModItemIds.healSword, HealSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 3.0F, -2.4F));

    public static final Item GROUP_HEAL_SWORD = registerItem(ModItemIds.groupHealSword, GroupHealSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 3.0F, -2.4F));

    public static final Item LIGHTNING_STICK = registerItem(ModItemIds.lightningStick, LightningStickItem::new, new Item.Properties());

    public static final Item MONEY_SWORD = registerItem(ModItemIds.moneySword, MoneySwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 1.0F, -2.4F));

    public static final Item JUMP_SWORD = registerItem(ModItemIds.jumpSword, JumpSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 3.0F, -2.4F));

    public static final Item ICE_GUN = registerItem(ModItemIds.iceGun, IceGunItem::new, new Item.Properties());

    public static final Item FREEZE_STICK = registerItem(ModItemIds.freezeStick, FreezeStickItem::new, new Item.Properties());

    public static final Item FIRE_STICK = registerItem(ModItemIds.fireStick, FireStickItem::new, new Item.Properties());

    public static final Item FAST_BOW = registerItem(ModItemIds.fastBow, FastBowItem::new, new Item.Properties());

    public static final Item ROID_RAGE_BOW = registerItem(ModItemIds.roidRageBow, RoidRageBowItem::new, new Item.Properties());

    public static final Item END_BOW = registerItem(ModItemIds.endBow, EndBowItem::new, new Item.Properties());

    public static final Item TNT_BOW = registerItem(ModItemIds.tntBow, TntBowItem::new, new Item.Properties());

    public static final Item AFTERSHOCK_BOW = registerItem(ModItemIds.aftershockBow, AftershockBowItem::new, new Item.Properties());

    public static final Item MULTI_BOW = registerItem(ModItemIds.multiBow, MultiBowItem::new, new Item.Properties());

    public static final Item EXPERIENCE_PICKAXE = registerItem(ModItemIds.experiencePickaxe, ExperiencePickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON, 1, -2.8f));

    public static final Item SOUL_PICKAXE = registerItem(ModItemIds.soulPickaxe, SoulPickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON, 1, -2.8f));

    public static final Item PROGRESSIVE_PICKAXE = registerItem(ModItemIds.progressivePickaxe, ProgressivePickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.DIAMOND, 1, -2.8f));

    public static final Item SPEEDY_HELMET = registerItem(ModItemIds.speedyHelmet, Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(SpeedyArmorMaterial.BASE_DURABILITY)));

    public static final Item SPEEDY_CHESTPLATE = registerItem(ModItemIds.speedyChestplate, Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(SpeedyArmorMaterial.BASE_DURABILITY)));

    public static final Item SPEEDY_LEGGINGS = registerItem(ModItemIds.speedyLeggings, Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(SpeedyArmorMaterial.BASE_DURABILITY)));

    public static final Item SPEEDY_BOOTS = registerItem(ModItemIds.speedyBoots, Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(SpeedyArmorMaterial.BASE_DURABILITY)));

    public static final Item MINER_HELMET = registerItem(ModItemIds.minerHelmet, Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(MinerArmorMaterial.BASE_DURABILITY)));

    public static final Item MINER_CHESTPLATE = registerItem(ModItemIds.minerChestplate, Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(MinerArmorMaterial.BASE_DURABILITY)));

    public static final Item MINER_LEGGINGS = registerItem(ModItemIds.minerLeggings, Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(MinerArmorMaterial.BASE_DURABILITY)));

    public static final Item MINER_BOOTS = registerItem(ModItemIds.minerBoots, Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(MinerArmorMaterial.BASE_DURABILITY)));

    public static final Item FORTUNE_HELMET = registerItem(ModItemIds.fortuneHelmet, Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.HELMET)
            .durability(ArmorType.HELMET.getDurability(FortuneArmorMaterial.BASE_DURABILITY)));

    public static final Item FORTUNE_CHESTPLATE = registerItem(ModItemIds.fortuneChestplate, Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.CHESTPLATE)
            .durability(ArmorType.CHESTPLATE.getDurability(FortuneArmorMaterial.BASE_DURABILITY)));

    public static final Item FORTUNE_LEGGINGS = registerItem(ModItemIds.fortuneLeggings, Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.LEGGINGS)
            .durability(ArmorType.LEGGINGS.getDurability(FortuneArmorMaterial.BASE_DURABILITY)));

    public static final Item FORTUNE_BOOTS = registerItem(ModItemIds.fortuneBoots, Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.BOOTS)
            .durability(ArmorType.BOOTS.getDurability(SpeedyArmorMaterial.BASE_DURABILITY)));

    private static <T extends Item> T registerItem(final ResourceKey<Item> id, final Function<Item.Properties, T> itemFactory, final Item.Properties properties) {
		T item = itemFactory.apply(properties.setId(id));

		return Registry.register(BuiltInRegistries.ITEM, id, item);
	}

    public static void registerModItems() {
        AbilityTools.LOGGER.info("Registering Mod Items for " + AbilityTools.MOD_ID);
    }
}
