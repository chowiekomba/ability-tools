package chowie.abilitytools;

import chowie.abilitytools.item.ModItemGroups;
import chowie.abilitytools.item.ModItems;
import chowie.abilitytools.util.*;
import chowie.abilitytools.util.timers.AftershockTimer;
import chowie.abilitytools.util.timers.FireStickItemTimer;
import chowie.abilitytools.util.timers.FreezeStickItemTimer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbilityTools implements ModInitializer {
	public static final String MOD_ID = "ability-tools";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Registering " + MOD_ID);

		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModDataComponents.register();
		ModSounds.registerModSounds();
		FreezeStickItemTimer.register();
		FireStickItemTimer.register();
		AftershockTimer.register();
	}
}