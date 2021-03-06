package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.IPut;
import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 *
 * @author Minyukhin Ilya
 */
public class StateTransitions implements IStateTransitions, IPut<Character, State> {
    private Map<Pair<State, Character>, State> transitions;

    /**
     * The basic constructor that initializes the states map
     */
    StateTransitions() {
        transitions = new HashMap<>();
    }

    @Override
    public State nextState(final State state, final char c) {
        State nextState = transitions.get(new Pair<>(state, c));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }

    @Override
    public void put(final State state, final Character currentSymbol, final State nextState) {
        transitions.put(new Pair<>(state, currentSymbol), nextState);
    }
}
