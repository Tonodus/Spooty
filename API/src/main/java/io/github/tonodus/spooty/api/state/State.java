package io.github.tonodus.spooty.api.state;

import io.github.tonodus.spooty.api.Player;

public interface State {
    /**
     * Gets the unique id of this state.
     * @return the unique id
     */
    String getId();

    default boolean equals(State other) {
        return other != null && other.getId() != null && other.getId().equals(getId());
    }

    /**
     * Called when this state is added to the given player.
     * @param player the player this state is added to
     */
    default void onAdd(Player player) {
    }

    /**
     * Called when this state is removed from the given player.
     * NOTE: this might not be called, if the player doesn't lose this state until the minigame ends, the player
     * quit etc.
     * @param player the player this state is removed from
     */
    default void onRemove(Player player) {
    }
}
