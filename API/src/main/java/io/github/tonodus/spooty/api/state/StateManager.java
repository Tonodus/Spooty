package io.github.tonodus.spooty.api.state;

public interface StateManager {
    /**
     * @see io.github.tonodus.spooty.api.state.SpectatingState
     * @return the SpectatingState
     */
    SpectatingState getSpectating();

    /**
     * @see io.github.tonodus.spooty.api.state.NormalState
     * @return the SpectatingState
     */
    NormalState getNormal();

    /**
     * @see io.github.tonodus.spooty.api.state.WaitForBeginState
     * @return the SpectatingState
     */
    WaitForBeginState getWaitForBegin();

    /**
     * @see io.github.tonodus.spooty.api.state.NotPlayingAnymoreState
     * @return the SpectatingState
     */
    NotPlayingAnymoreState getNotPlayingAnymore();


    /**
     * Registers the given state to this StateManager.
     * @param state the state to register
     * @throws IllegalArgumentException if the state's id is already in use
     */
    void registerState(State state) throws IllegalArgumentException;

    /**
     * Returns the instance of the given state.
     * @param stateType the type of the state
     * @return the instance of the state
     * @throws IllegalArgumentException if this type hasn't be registered to this StateManager
     */
    State getState(Class<? extends State> stateType) throws IllegalArgumentException;
}
