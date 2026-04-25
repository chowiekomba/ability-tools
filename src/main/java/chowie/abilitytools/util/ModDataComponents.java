package chowie.abilitytools.util;

import chowie.abilitytools.AbilityTools;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ModDataComponents {

    public static final DataComponentType<Long> ROID_RAGE_USED_LAST = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "roid_rage_used_last"),
            DataComponentType.<Long>builder().persistent(Codec.LONG).build()
    );

    public static final DataComponentType<Integer> BLOCKS_MINED = Registry.register(
            BuiltInRegistries.DATA_COMPONENT_TYPE,
            Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, "blocks_mined"),
            DataComponentType.<Integer>builder().persistent(Codec.INT).build()
    );

    public static void register() {

    }
}
