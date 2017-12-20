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
    private /*final*/ Map<Pair<State, Character>, State> transitions/* = new HashMap<>()*/;

    /**
     * The basic constructor that initializes the states map
     */
    StateTransitions() {
/*
        transitions.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        transitions.put(new Pair<>(new State("spacing"), ' '), new State("spacing"));

        transitions.put(new Pair<>(new State("default"), '/'), new State("slash"));
        transitions.put(new Pair<>(new State("slash"), '/'), new State("onelinecomment"));
        transitions.put(new Pair<>(new State("slash"), '*'), new State("openmultilinecomment"));

        transitions.put(new Pair<>(new State("default"), '*'), new State("star"));
        transitions.put(new Pair<>(new State("star"), '/'), new State("closemultilinecomment"));

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
    public void put(final State state, final Character character, final State state2) {
        transitions.put(new Pair<>(state, character), state2);
    }
}
