package it.sevenbits.formatter.lexer.stateMachineComponents;

import java.util.HashMap;
import java.util.Map;

public class Transitions implements INextState {
    private Map<Pair, State> hashMap;

    public Transitions() {

        hashMap = new HashMap<>();
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
        hashMap.put(new Pair(new State(""),''), new State(""));
    }


    @Override
    public State nextState(State state, Character character) {
        Pair pair = new Pair(state, character);
        for (Map.Entry<Pair, State> entry : hashMap.entrySet()){
            if (entry.getKey().equals(pair)) {
                return entry.getValue();
            }
        }
        return new State("emptyState");
    }
}
