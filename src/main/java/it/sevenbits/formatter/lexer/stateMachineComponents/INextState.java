package it.sevenbits.formatter.lexer.stateMachineComponents;

public interface INextState {
    public State nextState(State state, Character character);
}
