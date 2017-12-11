package it.sevenbits.formatter.statemachine.lexer;

import it.sevenbits.formatter.statemachine.Pair;
import it.sevenbits.formatter.statemachine.State;

import java.util.HashMap;
import java.util.Map;

/**
 * The class is a repository of commands that are generated based on the current state and the character that was read
 *
 * @author Minyukhin Ilya
 */
public class CommandRepository implements ICommandRepository {
    private final Map<Pair<State, Character>, ICommand> commands = new HashMap<>();

    /**
     * The basic constructor that initializes the command map
     */
    CommandRepository() {
        commands.put(new Pair<>(new State("default"), null),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("char"); });
        commands.put(new Pair<>(new State("default"), ';'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("semicolon"); });
        commands.put(new Pair<>(new State("default"), '\n'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("newline"); });

        commands.put(new Pair<>(new State("default"), '{'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openbracket"); });
        commands.put(new Pair<>(new State("default"), '}'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("closebracket"); });

        commands.put(new Pair<>(new State("default"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("space"); });
        commands.put(new Pair<>(new State("spacing"), ' '),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("spaces"); });
        commands.put(new Pair<>(new State("spacing"), null),
                (c, context) -> {
                    context.appendPostpone(c); });

        commands.put(new Pair<>(new State("default"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); });
        commands.put(new Pair<>(new State("slash"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("onelinecomment"); });
        commands.put(new Pair<>(new State("onelinecomment"), null),
                (c, context) -> {
                    context.appendPostpone(c); });

        commands.put(new Pair<>(new State("slash"), '*'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("openmultilinecomment"); });
        commands.put(new Pair<>(new State("openmultilinecomment"), null),
                (c, context) -> {
                    context.appendPostpone(c); });
        commands.put(new Pair<>(new State("default"), '*'),
                (c, context) -> {
                    context.appendLexeme(c); });
        commands.put(new Pair<>(new State("star"), '/'),
                (c, context) -> {
                    context.appendLexeme(c); context.setTokenName("closemultilinecomment"); });
        commands.put(new Pair<>(new State("closemultilinecomment"), null),
                (c, context) -> {
                    context.appendPostpone(c); });
    }

    @Override
    public ICommand getCommand(final State state, final char c) {
        ICommand command = commands.get(new Pair<>(state, c));
        if (command == null) {
            command = commands.get(new Pair<>(state, (Character) null));
        }
        return command;
    }
}
