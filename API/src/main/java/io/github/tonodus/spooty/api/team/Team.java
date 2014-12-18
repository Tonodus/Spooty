package io.github.tonodus.spooty.api.team;

import io.github.tonodus.spooty.api.Player;
import io.github.tonodus.spooty.api.gameidentifier.GameIdentifier;
import org.spongepowered.api.text.message.Message;

import java.util.Collection;

/**
 * Represents a team
 */
public interface Team {
    /**
     * Returns all players in this team.
     * @return a (probably unmodifiable) collection of all players
     */
    Collection<Player> getPlayers();

    /**
     * Adds the player to this team.
     * @param player the player to add
     */
    void addPlayer(Player player);

    /**
     * Removes the player from this team.
     *
     * Note: This might be called automatically, f.e. if a player quite the server.
     * @param player the player to remove
     */
    void removePlayer(Player player);

    /**
     * Returns the name of this team.
     * @return the name
     */
    Message<?> getName();

    /**
     * Sets the name of this team.
     * @param name the new name
     */
    void setName(Message<?> name);

    /**
     * Gets a (hopefully) unique identifier of this team.
     * @return the identifier of this team
     */
    default GameIdentifier getTeamIdentifier() {
        return GameIdentifier.none();
    }
}
