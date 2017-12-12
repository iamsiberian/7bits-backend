package it.sevenbits.formatter.statemachine;

/**
 * Class defining the state of a finite automaton
 *
 * @author Minyukhin Ilya
 */
public final class State {

    private final String name;

    /**
     * A basic constructor that creates an instance of a class with this state name
     * @param name state name
     */
    public State(final String name) {
        this.name = name;
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

        return name.equals(state.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
