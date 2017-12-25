package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.IPut;
import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is a repository of commands that are generated based on the current state and the character that was read
 *
 * @author Minyukhin Ilya
 */
public class CommandRepository implements ICommandRepository, IPut<Character, ICommand> {
    private Map<Pair<State, Character>, ICommand> commands;

    /**
     * The basic constructor which creates an instance of the class
     */
    CommandRepository() {
        commands = new HashMap<>();
    }

    @Override
    public ICommand getCommand(final State state, final char c) {
        ICommand command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }

    @Override
    public void put(final State state, final Character currentSymbol, final ICommand command) {
        commands.put(new Pair<>(state, currentSymbol), command);
    }

}
