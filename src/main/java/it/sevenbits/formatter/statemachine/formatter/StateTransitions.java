package it.sevenbits.formatter.statemachine.formatter;

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
public class StateTransitions implements IStateTransitions, IPut<State> {

    private /*final*/ Map<Pair<State, String>, State> transitions/* = new HashMap<>()*/;

    /**
     * The basic constructor that initializes the states map
     */
    StateTransitions() {
        transitions = new HashMap<>();
        /*
        transitions.put(new Pair<>(new State("start"), "space"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "spaces"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "newline"), new State("start"));
        transitions.put(new Pair<>(new State("start"), null), new State("default"));
        transitions.put(new Pair<>(new State("start"), "openbrace"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "closebrace"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "onelinecomment"), new State("writeonelinecomment"));
        transitions.put(new Pair<>(new State("start"), "openmultilinecomment"), new State("writemulticomment"));
        transitions.put(new Pair<>(new State("start"), "closemultilinecomment"), new State("start"));
        transitions.put(new Pair<>(new State("start"), "quotemark"), new State("stringliteral"));
        transitions.put(new Pair<>(new State("start"), "for"), new State("for"));

        transitions.put(new Pair<>(new State("default"), null), new State("default"));
        transitions.put(new Pair<>(new State("default"), "newline"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "closemultilinecomment"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "onelinecomment"), new State("writeonelinecomment"));
        transitions.put(new Pair<>(new State("default"), "semicolon"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "openbrace"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "closebrace"), new State("start"));
        transitions.put(new Pair<>(new State("default"), "openmultilinecomment"), new State("writemulticomment"));
        transitions.put(new Pair<>(new State("default"), "quotemark"), new State("stringliteral"));
        transitions.put(new Pair<>(new State("default"), "for"), new State("for"));

        transitions.put(new Pair<>(new State("writeonelinecomment"), null), new State("writeonelinecomment"));
        transitions.put(new Pair<>(new State("writeonelinecomment"), "newline"), new State("start"));

        transitions.put(new Pair<>(new State("writemulticomment"), "closemultilinecomment"), new State("start"));
        transitions.put(new Pair<>(new State("writemulticomment"), null), new State("writemulticomment"));

        transitions.put(new Pair<>(new State("stringliteral"), "quotemark"), new State("default"));
        transitions.put(new Pair<>(new State("stringliteral"), null), new State("stringliteral"));

        transitions.put(new Pair<>(new State("for"), "closebracket"), new State("default"));
        transitions.put(new Pair<>(new State("for"), null), new State("for"));
*/
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
    public void put(State state, String tokenName, State nextState) {
        transitions.put(new Pair<>(state, tokenName),nextState);
    }
}
