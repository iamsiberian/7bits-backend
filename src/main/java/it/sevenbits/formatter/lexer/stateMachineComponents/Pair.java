package it.sevenbits.formatter.lexer.stateMachineComponents;

public class Pair {
    private State state;
    private Character character;

    public Pair(final State state, final Character character) {
        this.state = state;
        this.character = character;
    }

    public State getState() {
        return state;
    }

    public Character getCharacter() {
        return character;
    }
}
