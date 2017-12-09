package it.sevenbits.formatter.outdated.lexer.stateMachineComponents;

import it.sevenbits.formatter.outdated.lexer.stateMachineComponents.commands.*;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private final Map<Pair, ICommand> hashMap;

    public CommandRepository() {
        hashMap = new HashMap<>();

        hashMap.put(new Pair(new State("StartLexeme"), '/'), new WriteSlash());
        hashMap.put(new Pair(new State("Slash"), '/'), new WriteComment());
        hashMap.put(new Pair(new State("Slash"), '*'), new WriteComment());

        hashMap.put(new Pair(new State("StartLexeme"), '*'), new WriteSlash());
        hashMap.put(new Pair(new State("Slash"), '/'), new WriteComment());
/*
        hashMap.put(new Pair(new State("StartLexeme"), ' '), new WriteWhiteSpaces());
        hashMap.put(new Pair(new State("StartLexeme"), ' '), new WriteWhiteSpaces());
        */
    }

    public ICommand getCommand(final State state, final Character character) {
        Pair pair = new Pair(state, character);

        if (hashMap.containsKey(pair)) {
            return hashMap.get(pair);
        }
        return  new Default();
    }
}
