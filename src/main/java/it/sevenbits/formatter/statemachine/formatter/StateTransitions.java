package it.sevenbits.formatter.statemachine.formatter;

import it.sevenbits.formatter.statemachine.IPut;
import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 *
 * @author Minyukhin Ilya
 */
public class StateTransitions implements IStateTransitions, IPut<String, State> {

    private Map<Pair<State, String>, State> transitions;

    /**
     * The basic constructor which creates an instance of the class
     */
    StateTransitions() {
        transitions = new HashMap<>();
    }

    @Override
    public State getNextState(final State state, final IToken token) {
        State nextState = transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState = transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }

    @Override
    public void put(final State state, final String tokenName, final State nextState) {
        transitions.put(new Pair<>(state, tokenName), nextState);
    }
}
