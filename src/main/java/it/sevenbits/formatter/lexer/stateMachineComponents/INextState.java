package it.sevenbits.formatter.lexer.stateMachineComponents;

public interface INextState {
    State nextState(State state, Character character);
}
