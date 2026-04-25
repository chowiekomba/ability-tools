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
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Properties;
import java.util.function.Function;

public class ModItems {

    public static final Item SPEEDY_SWORD = registerItem("speedy_sword", SpeedySwordItem::new, new Item.Properties()
            .sword(ToolMaterial.GOLD, 3.0F, -2.4F));

    public static final Item MULTI_SWORD = registerItem("multi_sword", MultiSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.NETHERITE, 3.0F, -2.4F));

    public static final Item ROID_RAGE_SWORD = registerItem("roid_rage_sword", RoidRageSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.WOOD, 0.0F, -2.4F));

    public static final Item EXPERIENCE_AXE = registerItem("experience_axe", ExperienceAxeItem::new, new Item.Properties()
            .axe(ToolMaterial.IRON, 5.0F, -3.0F));

    public static final Item GROUND_SLAM_DAGGER = registerItem("ground_slam_dagger", GroundSlamDaggerItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 2.0F, -2.0F));

    public static final Item ROID_RAGE_GUN = registerItem("roid_rage_gun", RoidRageGunItem::new, new Item.Properties());

    public static final Item ENDER_SWORD = registerItem("ender_sword", EnderSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 3.0F, -2.4F));

    public static final Item HEAL_SWORD = registerItem("heal_sword", HealSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 3.0F, -2.4F));

    public static final Item GROUP_HEAL_SWORD = registerItem("group_heal_sword", GroupHealSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 3.0F, -2.4F));

    public static final Item LIGHTNING_STICK = registerItem("lightning_stick", LightningStickItem::new, new Item.Properties());

    public static final Item MONEY_SWORD = registerItem("money_sword", MoneySwordItem::new, new Item.Properties()
            .sword(ToolMaterial.DIAMOND, 1.0F, -2.4F));

    public static final Item JUMP_SWORD = registerItem("jump_sword", JumpSwordItem::new, new Item.Properties()
            .sword(ToolMaterial.IRON, 3.0F, -2.4F));

    public static final Item ICE_GUN = registerItem("ice_gun", IceGunItem::new, new Item.Properties());

    public static final Item FREEZE_STICK = registerItem("freeze_stick", FreezeStickItem::new, new Item.Properties());

    public static final Item FIRE_STICK = registerItem("fire_stick", FireStickItem::new, new Item.Properties());

    public static final Item FAST_BOW = registerItem("fast_bow", FastBowItem::new, new Item.Properties());

    public static final Item ROID_RAGE_BOW = registerItem("roid_rage_bow", RoidRageBowItem::new, new Item.Properties());

    public static final Item END_BOW = registerItem("end_bow", EndBowItem::new, new Item.Properties());

    public static final Item TNT_BOW = registerItem("tnt_bow", TntBowItem::new, new Item.Properties());

    public static final Item AFTERSHOCK_BOW = registerItem("aftershock_bow", AftershockBowItem::new, new Item.Properties());

    public static final Item MULTI_BOW = registerItem("multi_bow", MultiBowItem::new, new Item.Properties());

    public static final Item EXPERIENCE_PICKAXE = registerItem("experience_pickaxe", ExperiencePickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON, 1, -2.8f));

    public static final Item SOUL_PICKAXE = registerItem("soul_pickaxe", SoulPickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.IRON, 1, -2.8f));

    public static final Item PROGRESSIVE_PICKAXE = registerItem("progressive_pickaxe", ProgressivePickaxeItem::new,
            new Item.Properties().pickaxe(ToolMaterial.DIAMOND, 1, -2.8f));

    public static final Item SPEEDY_HELMET = registerItem("speedy_helmet", Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.HELMET).durability(SpeedyArmorMaterial.BASE_DURABILITY));

    public static final Item SPEEDY_CHESTPLATE = registerItem("speedy_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(SpeedyArmorMaterial.BASE_DURABILITY));

    public static final Item SPEEDY_LEGGINGS = registerItem("speedy_leggings", Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.LEGGINGS).durability(SpeedyArmorMaterial.BASE_DURABILITY));

    public static final Item SPEEDY_BOOTS = registerItem("speedy_boots", Item::new, new Item.Properties()
            .humanoidArmor(SpeedyArmorMaterial.INSTANCE, ArmorType.BOOTS).durability(SpeedyArmorMaterial.BASE_DURABILITY));

    public static final Item MINER_HELMET = registerItem("miner_helmet", Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.HELMET).durability(MinerArmorMaterial.BASE_DURABILITY));

    public static final Item MINER_CHESTPLATE = registerItem("miner_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(MinerArmorMaterial.BASE_DURABILITY));

    public static final Item MINER_LEGGINGS = registerItem("miner_leggings", Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.LEGGINGS).durability(MinerArmorMaterial.BASE_DURABILITY));

    public static final Item MINER_BOOTS = registerItem("miner_boots", Item::new, new Item.Properties()
            .humanoidArmor(MinerArmorMaterial.INSTANCE, ArmorType.BOOTS).durability(MinerArmorMaterial.BASE_DURABILITY));

    public static final Item FORTUNE_HELMET = registerItem("fortune_helmet", Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.HELMET).durability(FortuneArmorMaterial.BASE_DURABILITY));

    public static final Item FORTUNE_CHESTPLATE = registerItem("fortune_chestplate", Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(FortuneArmorMaterial.BASE_DURABILITY));

    public static final Item FORTUNE_LEGGINGS = registerItem("fortune_leggings", Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.LEGGINGS).durability(FortuneArmorMaterial.BASE_DURABILITY));

    public static final Item FORTUNE_BOOTS = registerItem("fortune_boots", Item::new, new Item.Properties()
            .humanoidArmor(FortuneArmorMaterial.INSTANCE, ArmorType.BOOTS).durability(FortuneArmorMaterial.BASE_DURABILITY));

    private static <T extends Item> Item registerItem(
            String name,
            Function<Item.Properties, T> itemFactory,
            Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier
                .fromNamespaceAndPath(AbilityTools.MOD_ID, name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        AbilityTools.LOGGER.info("Registering Mod Items for " + AbilityTools.MOD_ID);
    }
}
