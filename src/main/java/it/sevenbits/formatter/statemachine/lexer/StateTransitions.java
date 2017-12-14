package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class defining transitions between states
 *
 * @author Minyukhin Ilya
 */
public class StateTransitions implements IStateTransitions, IPut<State> {
    private/* final */Map<Pair<State, Character>, State> transitions/* = new HashMap<>()*/;

    /**
     * The basic constructor that initializes the states map
     */
    StateTransitions() {
        /*
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        states.put(new Pair<>(new State("default"), '/'), new State("slash"));
        states.put(new Pair<>(new State("slash"), '/'), new State("onelinecomment"));
        states.put(new Pair<>(new State("slash"), '*'), new State("openmultilinecomment"));

        states.put(new Pair<>(new State("default"), '*'), new State("star"));
        states.put(new Pair<>(new State("star"), '/'), new State("closemultilinecomment"));
        */

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
    public void put(State state, Character character, State state2) {
        transitions.put(new Pair<>(state, character), state2);
    }
}
