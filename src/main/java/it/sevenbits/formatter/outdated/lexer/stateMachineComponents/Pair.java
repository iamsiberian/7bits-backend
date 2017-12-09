package it.sevenbits.formatter.outdated.lexer.stateMachineComponents;

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

    // переопределить методы hashCode & equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (state != null ? !state.equals(pair.state) : pair.state != null) return false;
        return !(character != null ? !character.equals(pair.character) : pair.character != null);
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (character != null ? character.hashCode() : 0);
        return result;
    }
}
