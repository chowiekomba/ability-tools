package chowie.abilitytools.util;

import chowie.abilitytools.AbilityTools;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final SoundEvent GUNSHOT = registerSound("gunshot");

    public static final SoundEvent GROUND_IMPACT = registerSound("ground_impact");

    public static final SoundEvent HEAL = registerSound("heal");

    public static final SoundEvent CHACHING = registerSound("chaching");

    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.fromNamespaceAndPath(AbilityTools.MOD_ID, id);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void registerModSounds() {
        AbilityTools.LOGGER.info("Registering Mod Sounds for " + AbilityTools.MOD_ID);
    }
}
