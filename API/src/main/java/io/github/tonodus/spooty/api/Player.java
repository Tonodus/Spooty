package io.github.tonodus.spooty.api;

import io.github.tonodus.spooty.api.kit.Kit;
import io.github.tonodus.spooty.api.state.State;

import java.util.Collection;

/**
 * Represents a player participating a minigame
 */
public interface Player {
    /**
     * Gets the player entity associated with this player.
     * @return the sponge player
     */
    org.spongepowered.api.entity.player.Player getEntity();

    /**
     * Gets the game this player is currently playing.
     * @return the minigame instance the player is currently in
     */
    MinigameInstance<?> getGame();

    /**
     * Get all stats of this player. F.e {@link io.github.tonodus.spooty.api.state.State#spectating}.
     * @return a unmodifiable collection of all states
     */
    Collection<State> getState();

    /**
     * Returns whether or not a player has the given state.
     * @param state the state to look up
     * @return true if the player has this state, false otherwise
     */
    boolean is(State state);

    /**
     * Adds the given state to this player.
     * @param state the state to add
     * @return true if the player hasn't the state before, false otherwise
     * @throws java.lang.IllegalArgumentException if the state hasn't been registered to the minigame's {@link StateManager}.
     */
    boolean addState(State state) throws IllegalArgumentException;

    /**
     * Removes the given state from this player.
     * @param state the state to remove
     * @return true if the player has the state before, false otherwise
     * @throws java.lang.IllegalArgumentException if the state hasn't been registered to the minigame's {@link StateManager}.
     */
    boolean removeState(State state) throws IllegalArgumentException;

    /**
     * Checks whether a player has the given kit.
     * @param kit the kit to look up
     * @return true if the player has the given kit, false otherwise
     */
    default boolean hasKit(Class<? extends Kit> kit) {
        return getGame().getMinigame().getKitManager().hasKit(this, kit);
    }

    /**
     * Gets the kit of the player or null, if the player doesn't have this type of kit.
     * @param kit the type of the kit
     * @param <K> the type of the kit
     * @return the instance of the kit or null
     */
    default <K extends Kit> K getKit(Class<K> kit) {
        return getGame().getMinigame().getKitManager().getKit(this, kit);
    }
}
