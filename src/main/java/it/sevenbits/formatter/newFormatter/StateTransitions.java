package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.Pair;
import it.sevenbits.formatter.State;
import it.sevenbits.formatter.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 *
 * @author Minyukhin Ilya
 */
public class StateTransitions implements IStateTransitions {

    private final Map<Pair<State, String>, State> transitions = new HashMap<>();

    /**
     * The basic constructor that initializes the states map
     */
    public StateTransitions() {
        transitions.put(new Pair<>(new State("default"), "char"), new State("default"));

    }

    @Override
    public State getNextState(final State state, final IToken token) {
        State nextState = transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }
}
