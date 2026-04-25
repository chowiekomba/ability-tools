package chowie.abilitytools.item;

import chowie.abilitytools.AbilityTools;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;


public class ModItemGroups {

    public static final CreativeModeTab ABILITY_TOOLS_WEAPONS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "ability_tools_weapons"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SPEEDY_SWORD))
                    .title(Component.translatable("itemgroup.ability-tools.ability_tools_weapons"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.SPEEDY_SWORD);
                        entries.accept(ModItems.MULTI_SWORD);
                        entries.accept(ModItems.ROID_RAGE_SWORD);
                        entries.accept(ModItems.GROUND_SLAM_DAGGER);
                        entries.accept(ModItems.ENDER_SWORD);
                        entries.accept(ModItems.ROID_RAGE_GUN);
                        entries.accept(ModItems.HEAL_SWORD);
                        entries.accept(ModItems.GROUP_HEAL_SWORD);
                        entries.accept(ModItems.MONEY_SWORD);
                        entries.accept(ModItems.JUMP_SWORD);
                        entries.accept(ModItems.ICE_GUN);
                        entries.accept(ModItems.FAST_BOW);
                        entries.accept(ModItems.ROID_RAGE_BOW);
                        entries.accept(ModItems.END_BOW);
                        entries.accept(ModItems.TNT_BOW);
                        entries.accept(ModItems.AFTERSHOCK_BOW);
                        entries.accept(ModItems.MULTI_BOW);
                        entries.accept(ModItems.SPEEDY_HELMET);
                        entries.accept(ModItems.SPEEDY_CHESTPLATE);
                        entries.accept(ModItems.SPEEDY_LEGGINGS);
                        entries.accept(ModItems.SPEEDY_BOOTS);
                        entries.accept(ModItems.MINER_HELMET);
                        entries.accept(ModItems.MINER_CHESTPLATE);
                        entries.accept(ModItems.MINER_LEGGINGS);
                        entries.accept(ModItems.MINER_BOOTS);
                        entries.accept(ModItems.FORTUNE_HELMET);
                        entries.accept(ModItems.FORTUNE_CHESTPLATE);
                        entries.accept(ModItems.FORTUNE_LEGGINGS);
                        entries.accept(ModItems.FORTUNE_BOOTS);
                    }).build());

    public static final CreativeModeTab ABILITY_TOOLS_TOOLS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "ability_tools_tools"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SOUL_PICKAXE))
                    .title(Component.translatable("itemgroup.ability-tools.ability_tools_tools"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModItems.EXPERIENCE_AXE);
                        entries.accept(ModItems.LIGHTNING_STICK);
                        entries.accept(ModItems.FREEZE_STICK);
                        entries.accept(ModItems.FIRE_STICK);
                        entries.accept(ModItems.EXPERIENCE_PICKAXE);
                        entries.accept(ModItems.SOUL_PICKAXE);
                        entries.accept(ModItems.PROGRESSIVE_PICKAXE);
                    }).build());

    public static void registerModItemGroups() {
        AbilityTools.LOGGER.info("Registering mod item groups for " + AbilityTools.MOD_ID);
    }
}
