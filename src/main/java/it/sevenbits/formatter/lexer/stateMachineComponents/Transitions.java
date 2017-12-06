package it.sevenbits.formatter.lexer.stateMachineComponents;

import java.util.HashMap;
import java.util.Map;

public class Transitions implements INextState {
    private Map<Pair, State> hashMap;

    public Transitions() {

        hashMap = new HashMap<>();
        /*
        hashMap.put(new Pair(new State("StartLexeme"), ';'), new State("EndLexeme"));

        hashMap.put(new Pair(new State("StartLexeme"),'\n'), new State("EndLexeme"));

        hashMap.put(new Pair(new State("StartLexeme"),' '), new State("WriteWhiteSpaces"));
        hashMap.put(new Pair(new State("WriteWhiteSpaces"),' '), new State("WriteWhiteSpaces"));
*/
        hashMap.put(new Pair(new State("StartLexeme"),' '), new State("EndLexeme"));
/*
        hashMap.put(new Pair(new State("StartLexeme"),'{'), new State("EndLexeme"));
        hashMap.put(new Pair(new State("StartLexeme"),'}'), new State("EndLexeme"));
*/
        hashMap.put(new Pair(new State("StartLexeme"), '/'), new State("Slash"));
        hashMap.put(new Pair(new State("Slash"), '/'), new State("EndLexeme"));
        hashMap.put(new Pair(new State("Slash"), '*'), new State("EndLexeme"));

        hashMap.put(new Pair(new State("StartLexeme"), '*'), new State("Slash"));
        hashMap.put(new Pair(new State("Slash"), '*'), new State("EndLexeme"));
    }

    @Override
    public State nextState(State state, Character character) {
        Pair pair = new Pair(state, character);
        /*
        for (Map.Entry<Pair, State> entry : hashMap.entrySet()){
            if (entry.getKey().equals(pair)) {
                return entry.getValue();
            }
        }
        return new State("emptyState");
        */
        if (hashMap.containsKey(pair)) {
            return hashMap.get(pair);
        }
        return new State("EndLexeme");
    }
}
