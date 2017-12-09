package it.sevenbits.formatter.outdated.lexer.stateMachineComponents;

public interface INextState {
    State nextState(State state, Character character);
}
