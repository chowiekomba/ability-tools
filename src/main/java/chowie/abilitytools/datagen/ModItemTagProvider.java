package chowie.abilitytools.datagen;

import chowie.abilitytools.item.ModItemIds;
import chowie.abilitytools.item.custom.armor.FortuneArmorMaterial;
import chowie.abilitytools.item.custom.armor.MinerArmorMaterial;
import chowie.abilitytools.item.custom.armor.SpeedyArmorMaterial;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(ItemTags.SWORDS)
                .add(ModItemIds.speedySword)
                .add(ModItemIds.roidRageSword)
                .add(ModItemIds.multiSword)
                .add(ModItemIds.speedySword)
                .add(ModItemIds.enderSword)
                .add(ModItemIds.healSword)
                .add(ModItemIds.groupHealSword)
                .add(ModItemIds.groundSlamDagger)
                .add(ModItemIds.moneySword)
                .add(ModItemIds.jumpSword);

        builder(ItemTags.PICKAXES)
                .add(ModItemIds.experiencePickaxe)
                .add(ModItemIds.soulPickaxe)
                .add(ModItemIds.progressivePickaxe);

        builder(ItemTags.AXES)
                .add(ModItemIds.experienceAxe);

        builder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItemIds.fastBow)
                .add(ModItemIds.roidRageBow)
                .add(ModItemIds.endBow)
                .add(ModItemIds.tntBow)
                .add(ModItemIds.aftershockBow)
                .add(ModItemIds.multiBow);

        builder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItemIds.speedyHelmet)
                .add(ModItemIds.fortuneHelmet)
                .add(ModItemIds.minerHelmet);

        builder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItemIds.speedyChestplate)
                .add(ModItemIds.fortuneChestplate)
                .add(ModItemIds.minerChestplate);

        builder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItemIds.speedyLeggings)
                .add(ModItemIds.fortuneLeggings)
                .add(ModItemIds.minerLeggings);

        builder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItemIds.speedyBoots)
                .add(ModItemIds.fortuneBoots)
                .add(ModItemIds.minerBoots);

        builder(SpeedyArmorMaterial.REPAIRS_SPEEDY_ARMOR)
                .add(BlockItemIds.HAY_BLOCK);

        builder(MinerArmorMaterial.REPAIRS_MINER_ARMOR)
                .add(ItemIds.COAL)
                .add(ItemIds.EMERALD);

        builder(FortuneArmorMaterial.REPAIRS_FORTUNE_ARMOR)
                .add(BlockItemIds.TUFF)
                .add(ItemIds.DIAMOND);

        builder(ItemTags.PIGLIN_SAFE_ARMOR)
                .add(ModItemIds.speedyHelmet)
                .add(ModItemIds.speedyChestplate)
                .add(ModItemIds.speedyLeggings)
                .add(ModItemIds.speedyBoots);
    }
}
