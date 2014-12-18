package io.github.tonodus.spooty.api.kit;

import io.github.tonodus.spooty.api.Player;

import java.util.Collection;

/**
 * A manager for {@link Kit Kits}.
 */
public interface KitManager {
    /**
     * Gets all available kits.
     * @return a probably unmodifiable collection of all available kits.
     */
    Collection<Kit> getAllKits();

    /**
     * Checks whether a player has the given kit.
     * @param player the player to fetch the kit from
     * @param kit the kit to look up
     * @return true if the player has the given kit, false otherwise
     */
    boolean hasKit(Player player, Class<? extends Kit> kit);

    /**
     * Gets the kit of the player or null, if the player doesn't have this type of kit.
     *  @param player the player to fetch the kit from
     * @param kit the type of the kit
     * @param <K> the type of the kit
     * @return the instance of the kit or null
     */
    <K extends Kit> K getKit(Player player, Class<K> kit);
}
