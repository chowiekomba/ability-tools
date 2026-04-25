package chowie.abilitytools.datagen;

import chowie.abilitytools.item.ModItems;
import chowie.abilitytools.item.custom.armor.FortuneArmorMaterial;
import chowie.abilitytools.item.custom.armor.MinerArmorMaterial;
import chowie.abilitytools.item.custom.armor.SpeedyArmorMaterial;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.SPEEDY_SWORD)
                .add(ModItems.ROID_RAGE_SWORD)
                .add(ModItems.MULTI_SWORD)
                .add(ModItems.SPEEDY_SWORD)
                .add(ModItems.ENDER_SWORD)
                .add(ModItems.HEAL_SWORD)
                .add(ModItems.GROUP_HEAL_SWORD)
                .add(ModItems.GROUND_SLAM_DAGGER)
                .add(ModItems.MONEY_SWORD)
                .add(ModItems.JUMP_SWORD);

        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.EXPERIENCE_PICKAXE)
                .add(ModItems.SOUL_PICKAXE)
                .add(ModItems.PROGRESSIVE_PICKAXE);

        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.EXPERIENCE_AXE);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.FAST_BOW)
                .add(ModItems.ROID_RAGE_BOW)
                .add(ModItems.END_BOW)
                .add(ModItems.TNT_BOW)
                .add(ModItems.AFTERSHOCK_BOW)
                .add(ModItems.MULTI_BOW);

        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.SPEEDY_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.SPEEDY_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.SPEEDY_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.SPEEDY_BOOTS);

        valueLookupBuilder(SpeedyArmorMaterial.REPAIRS_SPEEDY_ARMOR)
                .add(Items.HAY_BLOCK);

        valueLookupBuilder(MinerArmorMaterial.REPAIRS_MINER_ARMOR)
                .add(Items.COAL)
                .add(Items.EMERALD);

        valueLookupBuilder(FortuneArmorMaterial.REPAIRS_FORTUNE_ARMOR)
                .add(Items.TUFF)
                .add(Items.DIAMOND);

        valueLookupBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
                .add(ModItems.SPEEDY_HELMET)
                .add(ModItems.SPEEDY_CHESTPLATE)
                .add(ModItems.SPEEDY_LEGGINGS)
                .add(ModItems.SPEEDY_BOOTS);
    }
}
