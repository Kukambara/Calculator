package com.teamdev.arseniuk;

public interface StateAcceptor<State extends Enum, Context extends StateMachineContext<State, Context>> {
    public boolean isAcceptableState(Context context, State state) throws Exception;
}
