package io.github.tonodus.spooty.api;

import io.github.tonodus.spooty.api.kit.KitManager;
import io.github.tonodus.spooty.api.state.StateManager;
import io.github.tonodus.spooty.api.team.TeamManager;

/**
 * Represents a type of minigame.
 * For an actual instance of a running minigame (with players playing and so on) see {@ink MinigameInstance}
 */
public interface Minigame {
    /**
     * Gets the id of this minigame. MUST be unique even across plugins.
     * @return the unique id of this minigame
     */
    String getId();

    /**
     * Gets the name of this minigame. Can be same for multiple minigames,
     * however this is not recommended.
     * @return the name of this minigame
     */
    String getName();

    /**
     * Gets a {@link TeamManager} for this minigame, or null if this minigame does not support teams.
     * The server owner may set up teams.
     * @return the TeamManager of this minigame or null
     */
    default TeamManager getTeamManager() {
        return null;
    }

    /**
     * Gets a {@Link KitManager} for this minigame, or null if this minigame does not support kits.
     * @return the KitManager of this minigame or null
     */
    default KitManager getKitManager() {
        return null;
    }

    /**
     * Gets the StateManager for this minigame.
     * @return the StateManager
     */
    StateManager getStateManager();

    /**
     * Called when a new instance of this minigame type is created.
     * @param instance the new minigame instance
     */
    default void onInstanceCreated(MinigameInstance<?> instance) {
    }
}
