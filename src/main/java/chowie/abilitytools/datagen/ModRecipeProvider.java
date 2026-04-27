package chowie.abilitytools.datagen;

import chowie.abilitytools.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                shaped(RecipeCategory.COMBAT, ModItems.SPEEDY_SWORD)
                        .pattern(" L ")
                        .pattern("NLN")
                        .pattern(" F ")
                        .define('L', Items.LEATHER)
                        .define('N', Items.GOLD_NUGGET)
                        .define('F', Items.FEATHER)
                        .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MULTI_SWORD)
                        .pattern(" I ")
                        .pattern("RIR")
                        .pattern(" S ")
                        .define('I', Items.IRON_INGOT)
                        .define('R', Items.IRON_SWORD)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.IRON_SWORD), has(Items.IRON_SWORD))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ROID_RAGE_SWORD)
                        .pattern(" G ")
                        .pattern(" R ")
                        .pattern(" S ")
                        .define('G', Items.GLASS)
                        .define('R', Items.RED_MUSHROOM)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.RED_MUSHROOM), has(Items.RED_MUSHROOM))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.EXPERIENCE_AXE)
                        .pattern(" II")
                        .pattern(" EI")
                        .pattern(" S ")
                        .define('I', Items.IRON_INGOT)
                        .define('E', Items.EXPERIENCE_BOTTLE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.EXPERIENCE_BOTTLE), has(Items.EXPERIENCE_BOTTLE))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.GROUND_SLAM_DAGGER)
                        .pattern("   ")
                        .pattern("  I")
                        .pattern(" S ")
                        .define('I', Items.IRON_BLOCK)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ROID_RAGE_GUN)
                        .pattern("   ")
                        .pattern("IIF")
                        .pattern("I  ")
                        .define('I', Items.IRON_BLOCK)
                        .define('F', Items.FIRE_CHARGE)
                        .unlockedBy(getHasName(Items.FIRE_CHARGE), has(Items.FIRE_CHARGE))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDER_SWORD)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" B ")
                        .define('E', Items.ENDER_PEARL)
                        .define('B', Items.BREEZE_ROD)
                        .unlockedBy(getHasName(Items.BREEZE_ROD), has(Items.BREEZE_ROD))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.HEAL_SWORD)
                        .pattern(" R ")
                        .pattern(" I ")
                        .pattern(" S ")
                        .define('R', Items.ROSE_BUSH)
                        .define('I', Items.IRON_INGOT)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.ROSE_BUSH), has(Items.ROSE_BUSH))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.GROUP_HEAL_SWORD)
                        .pattern(" R ")
                        .pattern(" E ")
                        .pattern(" B ")
                        .define('R', Items.ROSE_BUSH)
                        .define('E', Items.REDSTONE)
                        .define('B', Items.BLAZE_ROD)
                        .unlockedBy(getHasName(Items.ROSE_BUSH), has(Items.ROSE_BUSH))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.LIGHTNING_STICK)
                        .pattern(" L ")
                        .pattern("LBL")
                        .pattern(" L ")
                        .define('L', Items.LAPIS_LAZULI)
                        .define('B', Items.BLAZE_ROD)
                        .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MONEY_SWORD)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .define('E', Items.EMERALD_BLOCK)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.EMERALD_BLOCK), has(Items.EMERALD_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.JUMP_SWORD)
                        .pattern(" W ")
                        .pattern(" W ")
                        .pattern(" S ")
                        .define('W', Items.WIND_CHARGE)
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.FREEZE_STICK)
                        .pattern("  P")
                        .pattern(" P ")
                        .pattern("P  ")
                        .define('P', Items.PACKED_ICE)
                        .unlockedBy(getHasName(Items.PACKED_ICE), has(Items.PACKED_ICE))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.FIRE_STICK)
                        .pattern("  L")
                        .pattern(" L ")
                        .pattern("L  ")
                        .define('L', Items.LAVA_BUCKET)
                        .unlockedBy(getHasName(Items.LAVA_BUCKET), has(Items.LAVA_BUCKET))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.FAST_BOW)
                        .pattern("TS ")
                        .pattern("G S")
                        .pattern("TS ")
                        .define('S', Items.STICK)
                        .define('T', Items.STRING)
                        .define('G', Items.GOLD_NUGGET)
                        .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ROID_RAGE_BOW)
                        .pattern("SN ")
                        .pattern("S N")
                        .pattern("SN ")
                        .define('S', Items.STRING)
                        .define('N', Items.NETHERRACK)
                        .unlockedBy(getHasName(Items.NETHERRACK), has(Items.NETHERRACK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.END_BOW)
                        .pattern("SP ")
                        .pattern("S P")
                        .pattern("SP ")
                        .define('S', Items.STRING)
                        .define('P', Items.ENDER_PEARL)
                        .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.TNT_BOW)
                        .pattern("ST ")
                        .pattern("S T")
                        .pattern("ST ")
                        .define('S', Items.STRING)
                        .define('T', Items.TNT)
                        .unlockedBy(getHasName(Items.TNT), has(Items.TNT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.AFTERSHOCK_BOW)
                        .pattern("ST ")
                        .pattern("S T")
                        .pattern("ST ")
                        .define('S', Items.STRING)
                        .define('T', Items.DAYLIGHT_DETECTOR)
                        .unlockedBy(getHasName(Items.DAYLIGHT_DETECTOR), has(Items.DAYLIGHT_DETECTOR))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MULTI_BOW)
                        .pattern("SB ")
                        .pattern("S B")
                        .pattern("SB ")
                        .define('S', Items.STRING)
                        .define('B', Items.BOW)
                        .unlockedBy(getHasName(Items.BOW), has(Items.BOW))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.EXPERIENCE_PICKAXE)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('S', Items.STICK)
                        .define('E', Items.EXPERIENCE_BOTTLE)
                        .unlockedBy(getHasName(Items.EXPERIENCE_BOTTLE), has(Items.EXPERIENCE_BOTTLE))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.SOUL_PICKAXE)
                        .pattern("SSS")
                        .pattern(" G ")
                        .pattern(" G ")
                        .define('G', Items.GOLD_INGOT)
                        .define('S', Items.SOUL_SAND)
                        .unlockedBy(getHasName(Items.SOUL_SAND), has(Items.SOUL_SAND))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.PROGRESSIVE_PICKAXE)
                        .pattern("IDI")
                        .pattern(" S ")
                        .pattern(" E ")
                        .define('I', Items.IRON_INGOT)
                        .define('D', Items.DIAMOND)
                        .define('S', Items.STICK)
                        .define('E', Items.ENDER_PEARL)
                        .unlockedBy(getHasName(Items.ENDER_PEARL), has(Items.ENDER_PEARL))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SPEEDY_HELMET)
                        .pattern("HHH")
                        .pattern("H H")
                        .pattern("   ")
                        .define('H', Items.HAY_BLOCK)
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SPEEDY_CHESTPLATE)
                        .pattern("H H")
                        .pattern("HHH")
                        .pattern("HHH")
                        .define('H', Items.HAY_BLOCK)
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SPEEDY_LEGGINGS)
                        .pattern("HHH")
                        .pattern("H H")
                        .pattern("H H")
                        .define('H', Items.HAY_BLOCK)
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.SPEEDY_BOOTS)
                        .pattern("H H")
                        .pattern("H H")
                        .pattern("   ")
                        .define('H', Items.HAY_BLOCK)
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MINER_HELMET)
                        .pattern("CRC")
                        .pattern("C C")
                        .pattern("   ")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('R', Items.RESIN_BLOCK)
                        .unlockedBy(getHasName(Items.RESIN_BLOCK), has(Items.RESIN_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MINER_CHESTPLATE)
                        .pattern("R R")
                        .pattern("CCC")
                        .pattern("CCC")
                        .define('R', Items.RESIN_BLOCK)
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .unlockedBy(getHasName(Items.RESIN_BLOCK), has(Items.RESIN_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MINER_LEGGINGS)
                        .pattern("CCC")
                        .pattern("C C")
                        .pattern("C C")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .unlockedBy(getHasName(Items.COBBLED_DEEPSLATE), has(Items.COBBLED_DEEPSLATE))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.MINER_BOOTS)
                        .pattern("C C")
                        .pattern("R R")
                        .pattern("   ")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('R', Items.RESIN_BLOCK)
                        .unlockedBy(getHasName(Items.RESIN_BLOCK), has(Items.RESIN_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.FORTUNE_HELMET)
                        .pattern("CDC")
                        .pattern("A A")
                        .pattern("   ")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('D', Items.DIAMOND)
                        .define('A', Items.ANDESITE)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.FORTUNE_CHESTPLATE)
                        .pattern("C C")
                        .pattern("CDC")
                        .pattern("AAA")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('D', Items.DIAMOND)
                        .define('A', Items.ANDESITE)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.FORTUNE_LEGGINGS)
                        .pattern("AAA")
                        .pattern("D D")
                        .pattern("C C")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('D', Items.DIAMOND)
                        .define('A', Items.ANDESITE)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.FORTUNE_BOOTS)
                        .pattern("C C")
                        .pattern("D D")
                        .pattern("   ")
                        .define('C', Items.COBBLED_DEEPSLATE)
                        .define('D', Items.DIAMOND)
                        .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "AbilityToolsModRecipeProvider";
    }
}
