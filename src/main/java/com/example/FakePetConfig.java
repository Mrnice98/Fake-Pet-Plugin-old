package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("FakePetPlugin")
public interface FakePetConfig extends Config
{
	@ConfigItem(
		keyName = "pet",
		name = "Pick Pet",
		description = "Pick pet"
	)
	default PetData pet()
	{
		return PetData.ABYSSAL_ORPHAN;
	}

	@ConfigItem(
			keyName = "filter",
			name = "Filter",
			description = "Filter",
			hidden = true
	)
	default boolean filter()
	{
		return true;
	}

	@ConfigItem(
			keyName = "showFavs",
			name = "Show Favs",
			description = "Show Favs",
			hidden = true
	)
	default boolean showFavs()
	{
		return true;
	}

	@ConfigItem(
			keyName = "favorites",
			name = "Favorites",
			description = "favorites",
			hidden = true
	)
	default String favorites()
	{
		return "<Abyssal Orphan><Hellpuppy><Tangleroot><Noon>";
	}

}
