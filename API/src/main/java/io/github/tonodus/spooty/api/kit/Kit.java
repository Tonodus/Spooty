package io.github.tonodus.spooty.api.kit;

import io.github.tonodus.spooty.api.Player;

/**
 * A kit is an addition a player can have.
 * Server owners may set limitation to kits or request fees for using them.
 */
public interface Kit {
    /**
     * Gets the unique id of this kit.
     * @return the unique id.
     */
    String getId();

    /**
     * Returns whether this kit clashes with another kit.
     * @param other the other kit
     * @return true if a player can't have both kits, false otherwise
     */
    boolean clashesWith(Kit other);

    /**
     * Returns whether this kit should be saved along for the player.
     * If so, it will be added to the player automatically if available in it's next minigame round.
     *
     * Note: a server owner may restrict this function
     * @param player the player to check
     * @return true if it should be saved for the player, false otherwise
     */
    default boolean shouldSave(Player player) {
        return false;
    }

    /**
     * Called when the given player has chosen this kit.
     * @param player the player who has chosen this kit
     * @return true if the kit can be added, false otherwise
     */
    default boolean onChosen(Player player) {
        return true;
    }

    /**
     * Called when a player unchooses this kit, f.e. when choosing a clashing other kit.
     * @param player the player unchoosing this kit
     * @return true if the action is permit, false otherwise
     */
    default boolean onUnchosen(Player player) {
        return true;
    }

    /**
     * Returns whether this kit can be given to the given player.
     *
     * Note: server owners may restrict kits to certain player.
     * Note: check for money etc. is done before by the implementation of this API. No need to do that yourself.
     * @param player the player
     * @return false if the player may choose this kit, true if not
     */
    default boolean clashesWith(Player player) {
        return false;
    }

    default boolean equals(Kit other) {
        return other != null && other.getId() != null && other.getId().equals(getId());
    }
}
