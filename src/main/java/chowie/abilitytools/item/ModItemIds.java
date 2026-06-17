package chowie.abilitytools.item;

import chowie.abilitytools.AbilityTools;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {

    public static final ResourceKey<Item> speedySword = create("speedy_sword");
    public static final ResourceKey<Item> multiSword = create("multi_sword");
    public static final ResourceKey<Item> roidRageSword = create("roid_rage_sword");
    public static final ResourceKey<Item> experienceAxe = create("experience_axe");
    public static final ResourceKey<Item> groundSlamDagger = create("ground_slam_dagger");
    public static final ResourceKey<Item> roidRageGun = create("roid_rage_gun");
    public static final ResourceKey<Item> enderSword = create("ender_sword");
    public static final ResourceKey<Item> healSword = create("heal_sword");
    public static final ResourceKey<Item> groupHealSword = create("group_heal_sword");
    public static final ResourceKey<Item> lightningStick = create("lightning_stick");
    public static final ResourceKey<Item> moneySword = create("money_sword");
    public static final ResourceKey<Item> jumpSword = create("jump_sword");
    public static final ResourceKey<Item> iceGun = create("ice_gun");
    public static final ResourceKey<Item> freezeStick = create("freeze_stick");
    public static final ResourceKey<Item> fireStick = create("fire_stick");
    public static final ResourceKey<Item> fastBow = create("fast_bow");
    public static final ResourceKey<Item> roidRageBow = create("roid_rage_bow");
    public static final ResourceKey<Item> endBow = create("end_bow");
    public static final ResourceKey<Item> tntBow = create("tnt_bow");
    public static final ResourceKey<Item> aftershockBow = create("aftershock_bow");
    public static final ResourceKey<Item> multiBow = create("multi_bow");
    public static final ResourceKey<Item> experiencePickaxe = create("experience_pickaxe");
    public static final ResourceKey<Item> soulPickaxe = create("soul_pickaxe");
    public static final ResourceKey<Item> progressivePickaxe = create("progressive_pickaxe");
    public static final ResourceKey<Item> speedyHelmet = create("speedy_helmet");
    public static final ResourceKey<Item> speedyChestplate = create("speedy_chestplate");
    public static final ResourceKey<Item> speedyLeggings = create("speedy_leggings");
    public static final ResourceKey<Item> speedyBoots = create("speedy_boots");
    public static final ResourceKey<Item> minerHelmet = create("miner_helmet");
    public static final ResourceKey<Item> minerChestplate = create("miner_chestplate");
    public static final ResourceKey<Item> minerLeggings = create("miner_leggings");
    public static final ResourceKey<Item> minerBoots = create("miner_boots");
    public static final ResourceKey<Item> fortuneHelmet = create("fortune_helmet");
    public static final ResourceKey<Item> fortuneChestplate = create("fortune_chestplate");
    public static final ResourceKey<Item> fortuneLeggings = create("fortune_leggings");
    public static final ResourceKey<Item> fortuneBoots = create("fortune_boots");

    private static ResourceKey<Item> create(final String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, name));
    }
}
