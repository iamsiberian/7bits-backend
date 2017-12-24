package it.sevenbits.formatter.statemachine.formatter;

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
public class CommandRepository implements ICommandRepository, IPut<ICommand> {

    private /*final*/ Map<Pair<State, String>, ICommand> commands/* = new HashMap<>()*/;

    /**
     * The basic constructor that initializes the command map
     */
    CommandRepository() {
        commands = new HashMap<>();
        /*
        commands.put(new Pair<>(new State("start"), "space"), (token, context) -> {
                });
        commands.put(new Pair<>(new State("start"), "spaces"), (token, context) -> {
                });
        commands.put(new Pair<>(new State("start"), "newline"), (token, context) -> {
                });
        commands.put(new Pair<>(new State("start"), null), (token, context) -> {
            context.writeIndent();
            context.writeLexeme(token.getLexeme());
        });
        commands.put(new Pair<>(new State("start"), "openbrace"), (token, context) -> {
            context.writeIndent();
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
            context.increaseCountLevel();
        });
        commands.put(new Pair<>(new State("start"), "closebrace"), (token, context) -> {
            context.decreaseCountLevel();
            context.writeIndent();
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        });
        commands.put(new Pair<>(new State("start"), "onelinecomment"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("start"), "openmultilinecomment"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("start"), "closemultilinecomment"), (token, context) -> {
        });
        commands.put(new Pair<>(new State("start"), "quotemark"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("start"), "for"), (token, context) ->
                context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("default"), null), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "semicolon"), (token, context) -> {
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        });
        commands.put(new Pair<>(new State("default"), "newline"), (token, context) -> {
        });
        commands.put(new Pair<>(new State("default"), "openbrace"), (token, context) -> {
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
            context.increaseCountLevel();
        });
        commands.put(new Pair<>(new State("default"), "closebrace"), (token, context) -> {
            context.writeNewLine();
            context.decreaseCountLevel();
            context.writeIndent();
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        });
        commands.put(new Pair<>(new State("default"), "onelinecomment"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "openmultilinecomment"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "closemultilinecomment"), (token, context) ->{
        });
        commands.put(new Pair<>(new State("default"), "quotemark"), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "for"), (token, context) ->
                context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("writeonelinecomment"), null), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("writeonelinecomment"), "newline"), (token, context) -> {
                context.writeNewLine();
        });

        commands.put(new Pair<>(new State("writemulticomment"), "closemultilinecomment"), (token, context) -> {
                context.writeLexeme(token.getLexeme());
                context.writeNewLine();
                });
        commands.put(new Pair<>(new State("writemulticomment"), null), (token, context) ->
                context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("stringliteral"), null), (token, context) ->
                context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("for"), null), (token, context) ->
                context.writeLexeme(token.getLexeme()));
        */
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
    public void put(State state, String tokenName, ICommand command) {
        commands.put(new Pair<>(state, tokenName), command);
    }
}
