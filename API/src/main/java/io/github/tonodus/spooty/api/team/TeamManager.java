package io.github.tonodus.spooty.api.team;

import io.github.tonodus.spooty.api.Player;

import java.util.Collection;

/**
 * A manager for teams.
 */
public interface TeamManager {
    /**
     * Returns a (probably unmodifiable) collection of {@link Team Teams} for the given players.
     * @param players the player that must be divided in teams
     * @return a (probably unmodifiable) collection of {@link Team Teams}
     */
    Collection<Team> buildTeams(Collection<Player> players);
}
