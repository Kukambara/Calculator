package com.teamdev.arseniuk;

/**
 * Created by dmytro on 10/23/14.
 */
public interface StateAcceptor<State extends Enum, Context extends StateMachineContext<State, Context>> {
    public boolean isAcceptableState(Context context, State state);
}
