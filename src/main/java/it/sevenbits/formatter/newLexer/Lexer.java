package it.sevenbits.formatter.newLexer;

import it.sevenbits.formatter.State;
import it.sevenbits.formatter.io.exceptions.ReaderException;
import it.sevenbits.formatter.io.interfaces.IReader;
import it.sevenbits.formatter.io.string.StringReader;
import it.sevenbits.formatter.token.IToken;
import it.sevenbits.formatter.token.Token;

/**
 * Class Lexer is intended for reading lexemes
 *
 * @author Minyukhin Ilya
 */
public class Lexer implements ILexer, IContext {

    private final IReader reader;
    private String tokenName;
    private StringBuilder tokenLexeme;
    private ICommandRepository commands;
    private IStateTransitions transitions;
    private StringBuilder postponeBuffer = new StringBuilder();

    /**
     * The basic constructor that calls the private constructor
     * and passes into it the argument class that implements iReader interface
     *
     * @param reader class that implements iReader interface
     * @throws ReaderException if an error occurred
     */
    public Lexer(final IReader reader) throws ReaderException {
        this(reader, new CommandRepository(), new StateTransitions());
    }

    /**
     * The constructor initializes instance of a class
     *
     * @param reader class that implements iReader interface
     * @param commands class that implements ICommandRepository interface
     * @param transitions class that implements IStateTransitions interface
     */
    private Lexer(final IReader reader, final ICommandRepository commands, final IStateTransitions transitions) {
        this.reader = reader;
        this.commands = commands;
        this.transitions = transitions;
    }

    @Override
    public IToken readToken() throws ReaderException {
        tokenLexeme = new StringBuilder();

        State state = new State("default");

        IReader postponeReader = new StringReader(postponeBuffer.toString());
        while (postponeReader.hasNext() && state != null) {
            state = step(postponeReader , state, this);
        }
        postponeBuffer.setLength(0);

        while (reader.hasNext() && state != null) {
            state = step(reader, state, this);
        }

        return new Token(tokenName, tokenLexeme.toString());
    }

    @Override
    public boolean hasNextToken() throws ReaderException {
        return postponeBuffer.length() > 0 || reader.hasNext();
    }

    private State step(final IReader iReader, final State state, final IContext context) throws ReaderException {
        try {
            char c = iReader.readNext();
            ICommand command = commands.getCommand(state, c);
            command.execute(c, this);
            return transitions.nextState(state, c);
        } catch (ReaderException e) {
            throw new ReaderException("ReaderException in Lexer.step(State state, IReader iReader)", e);
        }
    }

    @Override
    public void appendLexeme(final char c) {
        tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);
    }
}
