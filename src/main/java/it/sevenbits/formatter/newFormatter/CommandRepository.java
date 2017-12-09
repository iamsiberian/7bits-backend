package it.sevenbits.formatter.newFormatter;

import it.sevenbits.formatter.Pair;
import it.sevenbits.formatter.State;
import it.sevenbits.formatter.token.IToken;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is a repository of commands that are generated based on the current state and the token that was read
 *
 * @author Minyukhin Ilya
 */
public class CommandRepository implements ICommandRepository {

    private final Map<Pair<State, String>, ICommand> commands = new HashMap<>();

    /**
     * The basic constructor that initializes the command map
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), "char"), (token, context) -> context.writeLexeme(token.getLexeme()));
    }

    @Override
    public ICommand getCommand(final State state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }
}
