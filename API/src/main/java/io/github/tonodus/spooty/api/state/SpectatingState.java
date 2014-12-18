package io.github.tonodus.spooty.api.state;

import io.github.tonodus.spooty.api.Player;

/**
 * The State for spectating players.
 *
 * Adding this to a player will remove the {@link NormalState}.
 * Adding this to a player with the {@link NotPlayingAnymoreState} will cause in a runtime exception.
 */
public class SpectatingState implements State {
    @Override
    public final String getId() {
        return "spooty.normalPlaying";
    }

    @Override
    public final void onAdd(Player player) {
        StateManager sm = player.getGame().getMinigame().getStateManager();
        if (player.is(sm.getNotPlayingAnymore())) {
            throw new IllegalStateException("Cannot set NormalState to player with state NotPlayingAnymore!");
        }
        player.removeState(sm.getNormal());

        onAdd0(player);
    }

    /**
     * For extending classes only.
     * @see #onAdd(Player)
     */
    protected void onAdd0(Player player) {

    }
}
