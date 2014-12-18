package io.github.tonodus.spooty.api;

import java.util.Collection;

/**
 * A (running) instance of a minigame.
 * @param <M> the minigame's type
 */
public interface MinigameInstance<M extends Minigame> {
    /**
     * Gets the minigame type this Minigame is based on.
     * @return the type of this minigame
     */
    M getMinigame();

    /**
     * Gets a player associated with this minigame.
     * Note: players might be spectating or otherwise not involved in the current game.
     * @return an unmodifiable collection containing all players
     */
    Collection<Player> getAllPlayers();
}
