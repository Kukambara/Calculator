package com.teamdev.arseniuk;

public interface StateMachineContext<State extends Enum, Context extends StateMachineContext<State, Context>> {

    public TransitionMatrix<State> getTransitionMatrix();

    public StateAcceptor<State, Context> getAcceptor();

}
