package io.github.tonodus.spooty.api.state;

import io.github.tonodus.spooty.api.Player;

/**
 * The State for player's that won't play ever in this minigame instance.
 *
 * Adding this to a player will remove the {@link NormalState} and the {@link WaitForBeginState} state.
 */
public class NotPlayingAnymoreState implements State {
    @Override
    public final String getId() {
        return "spooty.notPlayingAnymore";
    }

    @Override
    public final void onAdd(Player player) {
        StateManager sm = player.getGame().getMinigame().getStateManager();
        player.removeState(sm.getNormal());
        player.removeState(sm.getWaitForBegin());

        onAdd0(player);
    }

    /**
     * For extending classes only.
     * @see #onAdd(Player)
     */
    protected void onAdd0(Player player) {

    }
}
