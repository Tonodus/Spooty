package io.github.tonodus.spooty.api.state;

import io.github.tonodus.spooty.api.Player;

/**
 * The State for players waiting for the game to start.
 *
 * Adding this to a player with the {@ink NormalState} or the {@link NotPlayingAnymoreState} will cause in a runtime exception.
 */
public class WaitForBeginState implements State {
    @Override
    public final String getId() {
        return "spooty.normalPlaying";
    }

    @Override
    public final void onAdd(Player player) {
        StateManager sm = player.getGame().getMinigame().getStateManager();
        if (player.is(sm.getNotPlayingAnymore())) {
            throw new IllegalStateException("Cannot set WaitForBegin to player with state NotPlayingAnymore!");
        }
        if (player.is(sm.getNormal())) {
            throw new IllegalStateException("Cannot set WaitForBegin to player with state Normal!");
        }

        onAdd0(player);
    }

    /**
     * For extending classes only.
     * @see #onAdd(Player)
     */
    protected void onAdd0(Player player) {

    }
}
