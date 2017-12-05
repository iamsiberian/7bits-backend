package it.sevenbits.formatter.lexer.stateMachineComponents;

import it.sevenbits.formatter.lexer.stateMachineComponents.commands.Default;
import it.sevenbits.formatter.lexer.stateMachineComponents.commands.ICommand;
import it.sevenbits.formatter.lexer.stateMachineComponents.commands.WriteSlash;
import it.sevenbits.formatter.lexer.stateMachineComponents.commands.WriteWhiteSpaces;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository {
    private Map<Pair, ICommand> hashMap;

    public CommandRepository() {
        hashMap = new HashMap<>();

        hashMap.put(new Pair(new State("StartLexeme"), '/'), new WriteSlash());
        hashMap.put(new Pair(new State("Slash"), '/'), new WriteSlash());
        hashMap.put(new Pair(new State("Slash"), '*'), new WriteSlash());

        hashMap.put(new Pair(new State("StartLexeme"), '*'), new WriteSlash());
        hashMap.put(new Pair(new State("Slash"), '/'), new WriteSlash());

        hashMap.put(new Pair(new State("StartLexeme"), ' '), new WriteWhiteSpaces());
        hashMap.put(new Pair(new State("StartLexeme"), ' '), new WriteWhiteSpaces());
    }

    public ICommand getCommand(final State state, final Character character) {
        Pair pair = new Pair(state, character);

        if (hashMap.containsKey(pair)) {
            return hashMap.get(pair);
        }
        return  new Default();
    }
}
