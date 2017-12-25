package it.sevenbits.formatter.statemachine.formatter;

import it.sevenbits.formatter.statemachine.IPut;
import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;
import it.sevenbits.formatter.statemachine.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is a repository of commands that are generated based on the current state and the token that was read
 *
 * @author Minyukhin Ilya
 */
public class CommandRepository implements ICommandRepository, IPut<String, ICommand> {

    private Map<Pair<State, String>, ICommand> commands;

    /**
     * The basic constructor which creates an instance of the class
     */
    CommandRepository() {
        commands = new HashMap<>();
    }

    @Override
    public ICommand getCommand(final State state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }

    @Override
    public void put(final State state, final String tokenName, final ICommand command) {
        commands.put(new Pair<>(state, tokenName), command);
    }
}
