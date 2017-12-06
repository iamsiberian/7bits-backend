package it.sevenbits.formatter.lexer.stateMachineComponents;

public class State {
    private String name;

    public State(final String name) {
        this.name = name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        State state = (State) o;

        return name != null ? name.equals(state.name) : state.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
